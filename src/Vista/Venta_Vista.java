package Vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;


public class Venta_Vista extends JFrame  {

    // Componentes de la interfaz
    private final JTextField txtCliente;
    private final JTextField txtCodigo;
    private final JTextField txtPrecio;
    private final JTextField txtDescripcion;
    private final JComboBox<String> comboTalla ;
    private final JTextArea textAreaDatos;
    private final JButton btnRegistrar, btnConsulta, btnEliminar, btnVolver, btnAdd;
    JScrollPane scrollDatos , scrollTabla;
    public JTable tablaCandidatos;
    public DefaultTableModel modelo;
    String[] titulos = {"Modelo" , "Color" , "Codigo" , "Costo" , ""};


    public Venta_Vista() {
        setTitle("Ventas");
        setSize(1200, 700);
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
        JLabel lblTalla = new JLabel("TALLA:");
        lblTalla.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTalla.setBounds(50, 240, 50, 30);
        add(lblTalla);


        JLabel lblUltimaAccion = new JLabel();
        lblUltimaAccion.setBounds(50, 340, 300, 30);
        lblUltimaAccion.setForeground(Color.RED);
        add(lblUltimaAccion);
        //-------------------------------------------------------------------

        ImageIcon logoIcon = new ImageIcon("src/Recursos/icono.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(320, 20, 250, 250); // Posición y tamaño del log
        this.add(logoLabel);
        //--------------------------------------------------------------------------------

        txtCliente = new JTextField();
        txtCliente.setBounds(150, 50, 150, 30);
        add(txtCliente);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 90, 150, 30);
        add(txtCodigo);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 130, 150, 30);
        add(txtPrecio);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(150, 170, 150, 30);
        add(txtDescripcion);
        //-------------------------------------------------------------------------------

        comboTalla = new JComboBox<>(new String[]{"","35","36" , "37" ,"38" ,  "39", "40" , "41" , "42" ,  "43"});
        comboTalla.setBounds(110, 240, 50, 30);
        add(comboTalla);
        //--------------------------------------------------------------------------------

        textAreaDatos = new JTextArea(100, 100);
        textAreaDatos.setBounds(80, 350, 470, 300);
        textAreaDatos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDatos.setEditable(false);
        add(textAreaDatos);
        //----------------------------------------------------------------

        btnAdd = new JButton("AÑADIR");
        btnAdd.setBounds(360, 240, 100, 30);
        add(btnAdd);

        btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.setBounds(50, 300, 100, 30);
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.setForeground(Color.WHITE);
        add(btnRegistrar);

        btnConsulta = new JButton("CONSULTA");
        btnConsulta.setBounds(160, 300, 100, 30);
        add(btnConsulta);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(270, 300, 100, 30);
        btnEliminar.setBackground(Color.RED);
        btnEliminar.setForeground(Color.WHITE);
        add(btnEliminar);


        btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(470, 300, 100, 30);
        add(btnVolver);
        //----------------------------------------------------------------------------

        scrollDatos = new JScrollPane();
        scrollDatos.setBounds(80, 350, 470, 300);
        scrollDatos.setViewportView(textAreaDatos);
        add(scrollDatos);

        tablaCandidatos = new JTable();
        modelo = new DefaultTableModel(null , titulos);
        tablaCandidatos.getTableHeader().setReorderingAllowed(false);
        tablaCandidatos.getTableHeader().setEnabled(false);
        tablaCandidatos.setModel(modelo);

        TableColumn columnainvisible = tablaCandidatos.getColumnModel().getColumn(4);
        columnainvisible.setMinWidth(0);
        columnainvisible.setMaxWidth(0);
        columnainvisible.setPreferredWidth(0);


        scrollTabla = new JScrollPane(tablaCandidatos);
        scrollTabla.setBounds(700, 120, 420, 300);
        scrollTabla.setViewportView(tablaCandidatos);
        add(scrollTabla);


    }

    public JTable getTablaCandidatos(){
        return tablaCandidatos;
    }
    public DefaultTableModel getModelo(){
        return modelo;
    }

    public JButton getBtnConsulta() {
        return btnConsulta;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }


    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }
    public JButton getBtnAdd(){
        return btnAdd;
    }
    public JComboBox<String> getComboTalla(){return comboTalla;}
    public JTextArea getTextAreaDatos() {
        return textAreaDatos;
    }
    public JTextField getTextFieldDatos() {
        return txtCliente;
    }
    public JTextField getTxtPrecio() {
        return txtPrecio;
    }
    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }
}

