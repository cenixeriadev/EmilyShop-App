package Vista;

import javax.swing.*;
import java.awt.*;

public class FrmLoginUsuario_Vista extends JFrame {
    private  final Color color3 = Color.CYAN;
    private  final Color color4 = Color.WHITE;


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
            //g2d.fillArc(0, 0,w,h,0,120);//arcos (trozos de circunferencias)
            //g2d.fillOval(0, 0,w,h);
            //g2d.fillRoundRect(0,0,w,h,30,120);
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


        // Usa un JPanel con el fondo de gradiente
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);

        // Cargar la imagen del logo
        //----------------------------------------------------------------------------------------
        ImageIcon logoIcon = new ImageIcon("src/Vista/icono.png"); // Ruta del logo
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
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(200, 300, 100, 30);
        //btnEntrar.addActionListener(this);
        gradientPanel.add(btnEntrar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(310, 300, 100, 30);
        //btnSalir.addActionListener(this);
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


