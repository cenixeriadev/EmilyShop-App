//clase boton personalizado
package Utilitario;
import javax.swing.*;
import java.awt.*;

public class BotonPersonalizado extends JButton {

    private Color colorFondo;

    public BotonPersonalizado(String texto, String icono, Color colorFondo) {
        super(texto);
        this.colorFondo = colorFondo != null ? colorFondo : new Color(35, 53, 67); // Color predeterminado si no se pasa uno
        setContentAreaFilled(false); // Evitar fondo estándar del botón
        setFocusPainted(false);      // Quitar efecto de foco
        setBorderPainted(false);    // Quitar borde predeterminado
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);

        // Configurar icono si se proporciona
        if (icono != null) {
            ImageIcon iconoOriginal = new ImageIcon(icono);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(imagenEscalada));
            setHorizontalTextPosition(SwingConstants.RIGHT);
            setVerticalTextPosition(SwingConstants.CENTER);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Cambiar color según el estado (presionado o no)
        g2d.setColor(getModel().isPressed() ? colorFondo.darker() : colorFondo);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

        // Dibujar borde redondeado
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 50, 50);

        super.paintComponent(g);
    }
}