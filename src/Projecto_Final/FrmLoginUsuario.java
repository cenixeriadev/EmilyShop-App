package Projecto_Final;

import Principal.FrmLoginAcceso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLoginUsuario extends JFrame implements ActionListener {
    private final Color color1 = Color.WHITE;
    private final Color color2 = Color.WHITE;

    // Panel para el fondo
    private class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }

    JLabel lb1Usuario, lb1Mensaje, lb1Password, TitleFrame;
    JTextField txtUsuario;
    JPasswordField txtPassword;
    JButton btnEntrar, btnSalir;
    JLabel logoLabel; // Para el logo

    public FrmLoginUsuario() {
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);

        // Usa un JPanel con el fondo de gradiente
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);

        // Cargar la imagen del logo
        ImageIcon logoIcon = new ImageIcon("src/Projecto_Final/icono.png"); // Ruta del logo
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar imagen
        logoIcon = new ImageIcon(logoImage); // Crear un nuevo ImageIcon redimensionado
        this.setType(Type.UTILITY); // Hacer el frame modal
        // Agregar el logo al JLabel
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(150, 10, 100, 100); // Posición y tamaño del logo
        gradientPanel.add(logoLabel); // Añadir logo al panel

        TitleFrame = new JLabel("LOGIN");
        TitleFrame.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        TitleFrame.setBounds(160, 120, 200, 30); // Mover el título un poco más abajo
        gradientPanel.add(TitleFrame);

        lb1Usuario = new JLabel("Usuario: ");
        lb1Usuario.setBounds(110, 160, 100, 30);
        lb1Usuario.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        gradientPanel.add(lb1Usuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(180, 160, 100, 30);
        gradientPanel.add(txtUsuario);

        lb1Password = new JLabel("Password: ");
        lb1Password.setBounds(100, 200, 100, 30);
        lb1Password.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        gradientPanel.add(lb1Password);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 200, 100, 30);
        gradientPanel.add(txtPassword);

        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 300, 100, 30);
        btnEntrar.addActionListener(this);
        gradientPanel.add(btnEntrar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(210, 300, 100, 30);
        btnSalir.addActionListener(this);
        gradientPanel.add(btnSalir);

        lb1Mensaje = new JLabel();
        lb1Mensaje.setBounds(200, 350, 300, 30);
        gradientPanel.add(lb1Mensaje);

        // Añadir el panel con el gradiente al frame
        setContentPane(gradientPanel);
    }

    public static void main(String[] args) {
        FrmLoginUsuario ventana = new FrmLoginUsuario();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            Entrar();
        } else if (e.getSource() == btnSalir) {
            Salir();
        }
    }

    public void Entrar() {
        String[] usu = {"Ivan", "Armando", "Julio", "Karin", "Anthony"};
        String[] cla = {"131313", "139319", "49983894", "8589895", "00012319"};
        String usuario = txtUsuario.getText();
        String clave = new String(txtPassword.getPassword());

        if (usuario.isEmpty() && clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña!!");
            txtUsuario.requestFocus();
        } else if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario!!");
            txtUsuario.requestFocus();
        } else if (clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese contraseña!!");
            txtUsuario.requestFocus();
        } else {
            boolean estado = false;
            for (int i = 0; i < usu.length; i++) {
                if (usu[i].equals(usuario) && cla[i].equals(clave)) {
                    estado = true;
                    break;
                }
            }
            if (estado) {
                FrmLoginAcceso.FrmPrincipal obj = new FrmLoginAcceso.FrmPrincipal();
                obj.setVisible(true);
                this.dispose();
            } else {
                lb1Mensaje.setText("ERROR !  CLAVE O  CONTRASEÑA INCORRECTOS!!");
                lb1Mensaje.setForeground(Color.red);
                txtUsuario.setText("");
                txtPassword.setText("");
                txtUsuario.requestFocus();
            }
        }
    }

    public void Salir() {
        this.dispose();
    }
}


