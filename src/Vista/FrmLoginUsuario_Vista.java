package Vista;

import javax.swing.*;
import java.awt.*;

public class FrmLoginUsuario_Vista extends JFrame {
    //private  final Color color3 = new Color(32, 201, 151);
    private  final Color color3 = new Color(160, 239, 89);
    private  final Color color4 = new Color(133, 229, 190);


    // Panel para el fondo
    private class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();

            GradientPaint gp = new GradientPaint(0, 0, color3, 0,h , color4 , true);
            //g2d.setPaint(gp);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }

    JLabel lb1Usuario, lb1Mensaje, lb1Password, TitleFrame;
    JTextField txtUsuario;
    JPasswordField txtPassword;
    JButton btnEntrar, btnSalir;
    JLabel logoLabel; // Para el logo

    public FrmLoginUsuario_Vista() {
        setLocation(400, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setUndecorated(true);

        // Usa un JPanel con el fondo de gradiente
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);

        // Cargar la imagen del logo
        //----------------------------------------------------------------------------------------
        ImageIcon logoIcon = new ImageIcon("src/Recursos/Login.png"); // Ruta del logo
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar imagen
        logoIcon = new ImageIcon(logoImage); // Crear un nuevo ImageIcon redimensionado
        this.setType(Type.NORMAL); // Hacer el frame modal
        //--------------------------------------------------------------------------------------
        // Agregar el logo al JLabel
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(250, 10, 100, 100); // Posición y tamaño del logo
        gradientPanel.add(logoLabel); // Añadir logo al panel

        TitleFrame = new JLabel("LOGIN");
        TitleFrame.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        TitleFrame.setBounds(260, 120, 200, 30); // Mover el título un poco más abajo
        gradientPanel.add(TitleFrame);

        lb1Usuario = new JLabel("Usuario: ");
        lb1Usuario.setBounds(210, 160, 100, 30);
        lb1Usuario.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        gradientPanel.add(lb1Usuario);//+50 : x

        lb1Password = new JLabel("Password: ");
        lb1Password.setBounds(200, 200, 100, 30);
        lb1Password.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        gradientPanel.add(lb1Password);

        lb1Mensaje = new JLabel();
        lb1Mensaje.setBounds(200, 350, 300, 30);
        gradientPanel.add(lb1Mensaje);
        //--------------------------------------------------------------------------------------
        txtUsuario = new JTextField();
        txtUsuario.setBounds(280, 160, 100, 30);
        gradientPanel.add(txtUsuario);

        //--------------------------------------------------------------------------------------
        txtPassword = new JPasswordField();
        txtPassword.setBounds(280, 200, 100, 30);
        gradientPanel.add(txtPassword);
        //--------------------------------------------------------------------------------------
        ImageIcon entrarIcon =  new ImageIcon("src/Recursos/Key.png");
        Image  entrarimage =  entrarIcon.getImage().getScaledInstance(30 , 30 ,Image.SCALE_SMOOTH);
        entrarIcon = new ImageIcon(entrarimage); // Crear un nuevo ImageIcon redimensionado
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(150, 300, 110, 40);
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //btnEntrar.setBackground(new Color(47, 158, 68));
        btnEntrar.setForeground(Color.BLACK);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setIcon(entrarIcon);
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));// Cambiar el cursor a mano para el botón entrar
        gradientPanel.add(btnEntrar);
        ImageIcon salirIcon =  new ImageIcon("src/Recursos/salir.png");
        Image salirimage = salirIcon.getImage().getScaledInstance( 40, 40, Image.SCALE_SMOOTH);
        salirIcon = new ImageIcon(salirimage); // Crear un nuevo ImageIcon redimensionado
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(310, 300, 110, 40);
        btnSalir.setBorder(BorderFactory.createEmptyBorder());
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //btnSalir.setBackground(new Color(255, 107, 107));
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setFocusPainted(false);
         // Cambiar el cursor a mano para el botón salir
        btnSalir.setIcon(salirIcon);
        gradientPanel.add(btnSalir);
        //--------------------------------------------------------------------------------------


        // Añadir el panel con el gradiente al frame
        setContentPane(gradientPanel);
    }
    public JButton getbtnSalir(){
        return btnSalir;
    }
    public JButton getbtnEntrar(){
        return btnEntrar;
    }
    public JTextField getTxtUsuario(){
        return txtUsuario;
    }
    public JPasswordField getTxtPassword(){
        return txtPassword;
    }

}


