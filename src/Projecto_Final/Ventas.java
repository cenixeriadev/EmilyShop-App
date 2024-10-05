package Projecto_Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventas extends JFrame implements ActionListener {

    // Componentes de la interfaz
    private final JTextField txtCliente;
    private final JTextField txtCodigo;
    private final JTextField txtPrecio;
    private final JTextField txtDescripcion;
    private final JTextField txtCantidad;
    private final JComboBox<String> comboTalla;
    private final JTextArea textAreaDatos;
    private final JLabel lblUltimaAccion,logoLabel;
    private final JButton btnRegistrar, btnConsulta, btnEliminar, btnVolver , btnAdd;
    JScrollPane scrollDatos;
    public Ventas() {
        // Configuración de la ventana principal
        //setLocation(500,100);
        setTitle("Ventas");
        setSize(600, 700);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Creación de los componentes
        //--------------------------------------------------------------------------
        JLabel lblTitulo = new JLabel("VENTAS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(230, 10, 150, 30);
        add(lblTitulo);

        JLabel lblCliente = new JLabel("CLIENTE");
        lblCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCliente.setBounds(50, 50, 100, 30);
        add(lblCliente);

        JLabel lblCodigo = new JLabel("CODIGO");
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodigo.setBounds(50, 90, 100, 30);
        add(lblCodigo);

        JLabel lblPrecio = new JLabel("PRECIO");
        lblPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPrecio.setBounds(50, 130, 100, 30);
        add(lblPrecio);

        JLabel lblDescripcion = new JLabel("DESCRIPCION");
        lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDescripcion.setBounds(50, 170, 100, 30);
        add(lblDescripcion);

        JLabel lblCantidad = new JLabel("CANTIDAD");
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCantidad.setBounds(50, 210, 100, 30);
        add(lblCantidad);

        JLabel lblTalla = new JLabel("TALLA:");
        lblTalla.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTalla.setBounds(210, 210, 50, 30);
        add(lblTalla);

        lblUltimaAccion = new JLabel();
        lblUltimaAccion.setBounds(50, 340, 300, 30);
        lblUltimaAccion.setForeground(Color.RED);
        add(lblUltimaAccion);
        //-------------------------------------------------------------------

        ImageIcon logoIcon = new ImageIcon("src/Projecto_Final/icono.png");
        Image  logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(logoImage);
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(425, -20, 100, 100); // Posición y tamaño del log
        this.add(logoLabel);
        //--------------------------------------------------------------------------------

        txtCliente = new JTextField();
        txtCliente.setBounds(150, 50, 150, 30);
        add(txtCliente);

        txtCodigo = new JTextField("");
        txtCodigo.setBounds(150, 90, 150, 30);
        add(txtCodigo);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 130, 150, 30);
        add(txtPrecio);

        txtDescripcion = new JTextField("");
        txtDescripcion.setBounds(150, 170, 150, 30);
        add(txtDescripcion);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 210, 50, 30);
        add(txtCantidad);
        //--------------------------------------------------------------------------------

        comboTalla = new JComboBox<>(new String[]{" ","S", "M", "L", "XL"});
        comboTalla.setBounds(270, 210, 50, 30);
        add(comboTalla);
        //--------------------------------------------------------------------------------

        textAreaDatos = new JTextArea(100,100);
        textAreaDatos.setBounds(80, 350, 470, 300);
        textAreaDatos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDatos.setEditable(false);
        add(textAreaDatos);
        //----------------------------------------------------------------

        btnAdd = new JButton("AÑADIR");
        btnAdd.setBounds(300, 250, 100, 30);
        add(btnAdd);

        btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.setBounds(50, 300, 100, 30);
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.setForeground(Color.WHITE);
        add(btnRegistrar);

        btnConsulta = new JButton("CONSULTA");
        btnConsulta.setBounds(160, 300, 100, 30);
        btnConsulta.addActionListener(this);
        add(btnConsulta);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(270, 300, 100, 30);
        btnEliminar.setBackground(Color.RED);
        btnEliminar.setForeground(Color.WHITE);
        add(btnEliminar);


        btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(470, 300, 100, 30);
        btnVolver.addActionListener(this);
        add(btnVolver);
        //----------------------------------------------------------------------------

        scrollDatos = new JScrollPane();
        scrollDatos.setBounds(80, 350, 470, 300);
        scrollDatos.setViewportView(textAreaDatos);
        add(scrollDatos);
        //----------------------------------------------------------------

        // Acción para el botón de registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCliente.getText().isEmpty() || txtCodigo.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCantidad.getText().isEmpty() || (comboTalla.getSelectedIndex()==0)) {

                    JOptionPane.showMessageDialog(Ventas.this, "Debe llenar todos los campos");

                } else {
                    String cliente = txtCliente.getText();
                    String codigo = txtCodigo.getText();
                    String precio = txtPrecio.getText();
                    String descripcion = txtDescripcion.getText();
                    String cantidad = txtCantidad.getText();
                    String talla = (String) comboTalla.getSelectedItem();

                    textAreaDatos.append(cliente + "  " + codigo + "  " + precio + "  " + descripcion + "  " + cantidad + "  " + talla + "\n");
                    lblUltimaAccion.setText("Venta registrada correctamente");
                }
            }
        });

        // Acción para el botón de eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastEntry = textAreaDatos.getText().split("\n")[textAreaDatos.getLineCount() - 1];
                textAreaDatos.append(textAreaDatos.getText().replace(lastEntry, ""));
                lblUltimaAccion.setText("Última venta eliminada correctamente");
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolver) {
            new Menu_Principal();
            this.dispose();
        }
        else if(e.getSource()==btnConsulta){
            Consulta Consultation = new Consulta();
            Consultation.setVisible(true);
            this.dispose();
        }
    }
    public static void main(String[] args) {
        Ventas ventana = new Ventas();
        ventana.setVisible(true);
    }
}

