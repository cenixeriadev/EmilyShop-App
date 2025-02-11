
package Vista;

import Utilitario.ManagerPath;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class RegistroUsuarioVista extends JFrame {
    JPanel panel1, panel2;
    JLabel  lblimagen3, lblimagen4,lblimagen5,lblimagen6
            ,lblcrearusuario;
    JTextField txtusuario, txtcontra,txtnombre,txttelefono;
    
    JButton btncrear;

    public RegistroUsuarioVista() {
        setSize(600, 500);
        setTitle("Login-Ventas-Inventario");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        // Cambiar panel1 para que use una imagen de fondo
        panel1 = new PanelConImagenFondo(ManagerPath.getRuta("fondoadidas.jpeg")); // Cambia la ruta a la de tu imagen
        panel1.setBounds(0, 0, 250, 500);
        panel1.setLayout(null);
        add(panel1);

        panel2 = new PanelConImagenFondo2(ManagerPath.getRuta("nuevofondo3.jpeg"));
        panel2.setBounds(250, 0, 350, 500);
        panel2.setBackground(new Color(240, 240, 240));
        panel2.setLayout(null);
        add(panel2);
        
        ImageIcon imageIcon3 = new ImageIcon(ManagerPath.getRuta("nuevousuario.png"));
        Image img3 = imageIcon3.getImage(); // Convertir a Image
        Image newImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen3 = new JLabel(new ImageIcon(newImg3)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen3.setBounds(30, 230, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen3);

        ImageIcon imageIcon4 = new ImageIcon(ManagerPath.getRuta("nuevocandado.png"));
        Image img4 = imageIcon4.getImage(); // Convertir a Image
        Image newImg4 = img4.getScaledInstance(50, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen4 = new JLabel(new ImageIcon(newImg4)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen4.setBounds(30, 280, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen4);
        
        ImageIcon imageIcon5 = new ImageIcon(ManagerPath.getRuta("nombre.png"));
        Image img5 = imageIcon5.getImage(); // Convertir a Image
        Image newImg5 = img5.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen5 = new JLabel(new ImageIcon(newImg5)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen5.setBounds(30, 130, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen5);
        
        ImageIcon imageIcon6 = new ImageIcon(ManagerPath.getRuta("telefono.png"));
        Image img6 = imageIcon6.getImage(); // Convertir a Image
        Image newImg6 = img6.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Redimensionar la imagen
        lblimagen6 = new JLabel(new ImageIcon(newImg6)); // Crear un nuevo ImageIcon con la imagen redimensionada
        lblimagen6.setBounds(30, 180, 40, 40);  // Establecer las nuevas dimensiones
        panel2.add(lblimagen6);
        
        
        lblcrearusuario=new JLabel(" CREAR USUARIO ");
        lblcrearusuario.setBounds(60,50,250,40);
        lblcrearusuario.setForeground(Color.LIGHT_GRAY);
        lblcrearusuario.setFont(new Font ("Arial",Font.BOLD,25));
        panel2.add(lblcrearusuario);
        
        
        txtusuario = crearCampoTexto("  Ingrese usuario", 230);
        panel2.add(txtusuario);
        
        txtcontra = crearCampoTexto("  Ingrese contraseña", 280);
        panel2.add(txtcontra);
        
        txtnombre=crearCampoTexto("  Ingrese Nombre y apellido", 130);
        panel2.add(txtnombre);
        
        txttelefono=crearCampoTexto("   Ingrese Numero de Telefono", 180);
        panel2.add(txttelefono);

        
        btncrear = crearBoton();
        panel2.add(btncrear);

    }
    public JTextField getTxtusuario(){
        return txtusuario;
    }
    public JTextField getTxtcontra(){
        return txtcontra;
    }
    public JTextField getTxtnombre(){
        return txtnombre;
    }
    public JTextField getTxttelefono(){
        return txttelefono;
    }
    public JButton getBtncrear(){
        return btncrear;
    }

    private JTextField crearCampoTexto(String placeholder, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(70, y, 240, 40);
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        textField.setForeground(Color.WHITE);
        new Placeholder(textField, placeholder);
        return textField;
    }

    private JButton crearBoton() {
        JButton button = new JButton("CREAR");
        button.setBounds(90, 345, 130, 40);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorder(new LineBorder(Color.WHITE, 2, true)); // Borde con esquinas redondeadas
        button.setFocusPainted(false);
        return button;
    }

}

// Clase para establecer una imagen de fondo en el panel
class PanelConImagenFondo2 extends JPanel {
    private final Image imagenFondo;

    public PanelConImagenFondo2(String rutaImagen) {
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}

// Clase para manejar los placeholders en los JTextField

