
package Vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginVista extends JFrame {
    JPanel panel1, panel2;
    JLabel  lblimagen2, lblimagen3, lblimagen4;
    JTextField txtusuario, txtcontra;
    JButton btninicio, btnnuevo;

    public LoginVista() {
        setSize(600, 500);
        setTitle("Login-Ventas-Inventario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Cambiar panel1 para que use una imagen de fondo
        panel1 = new PanelConImagenFondo("src/Recursos/fondoadidas.jpeg"); // Cambia la ruta a la de tu imagen
        panel1.setBounds(0, 0, 250, 500);
        panel1.setLayout(null);
        add(panel1);

        panel2 = new PanelConImagenFondo2("src/Recursos/nuevofondo2.jpeg");
        panel2.setBounds(250, 0, 350, 500);
        //panel2.setBackground(new Color(240, 240, 240));
        panel2.setLayout(null);
        add(panel2);

        ImageIcon imageIcon2 = new ImageIcon("src/Recursos/nuevologo.png");
        Image img2 = imageIcon2.getImage(); // Convertir a Image
        Image newImg2 = img2.getScaledInstance(110, 110, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen2 = new JLabel(new ImageIcon(newImg2)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen2.setBounds(120,85, 110, 110);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen2);

        ImageIcon imageIcon3 = new ImageIcon("src/Recursos/nuevousuario.png");
        Image img3 = imageIcon3.getImage(); // Convertir a Image
        Image newImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen3 = new JLabel(new ImageIcon(newImg3)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen3.setBounds(30, 180, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen3);

        txtusuario = crearCampoTexto("  Ingrese usuario", 70, 180);
        panel2.add(txtusuario);

        ImageIcon imageIcon4 = new ImageIcon("src/Recursos/nuevocandado.png");
        Image img4 = imageIcon4.getImage(); // Convertir a Image
        Image newImg4 = img4.getScaledInstance(50, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen4 = new JLabel(new ImageIcon(newImg4)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen4.setBounds(30, 230, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen4);

        txtcontra = crearCampoTexto("  Ingrese contraseña", 70, 230);
        panel2.add(txtcontra);

        btninicio = crearBoton("INICIAR SESIÓN", 35, 300);
        
        panel2.add(btninicio);

        btnnuevo = crearBoton("CREAR CUENTA", 180, 300);
        panel2.add(btnnuevo);
    }
    public JButton getbtnInicio(){
        return btninicio;
    }
    public JButton getbtnNuevo(){
        return btnnuevo;
    }
    public JTextField getTxtusuario(){
        return txtusuario;
    }
    public JTextField getTxtContra(){
        return txtcontra;
    }

    private JTextField crearCampoTexto(String placeholder, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 240, 40);
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        textField.setForeground(Color.WHITE);
        new Placeholder(textField, placeholder);
        return textField;
    }

    private JButton crearBoton(String texto, int x, int y) {
        JButton button = new JButton(texto);
        button.setBounds(x, y, 130, 40);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorder(new LineBorder(Color.WHITE, 2, true)); // Borde con esquinas redondeadas
        button.setFocusPainted(false);
        return button;
    }

}

// Clase para establecer una imagen de fondo en el panel
class PanelConImagenFondo extends JPanel {
    private final Image imagenFondo;

    public PanelConImagenFondo(String rutaImagen) {
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}

// Clase para manejar los placeholders en los JTextField
class Placeholder implements FocusListener {
    private final JTextField textField;
    private final String placeholder;
    private boolean showingPlaceholder;

    public Placeholder(JTextField textField, String placeholder) {
        this.textField = textField;
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        textField.setText(placeholder);
        textField.setForeground(Color.LIGHT_GRAY);
        textField.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            textField.setText("");
            textField.setForeground(Color.WHITE);
            showingPlaceholder = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
            textField.setForeground(Color.LIGHT_GRAY);
            showingPlaceholder = true;
        }
    }
}
