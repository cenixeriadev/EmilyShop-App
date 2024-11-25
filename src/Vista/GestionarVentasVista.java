package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionarVentasVista extends JFrame {
    // Barra de menú y menús

    JLabel lblbienvenida;


    JPanel panelusuario;

    JTable tablaInventario;
    DefaultTableModel modeloInventario;

    JLabel lblcliente, lbltelefono;
    JTextField  txttelefono, txtcliente;

    JButton btneliminar, btnactualizar, btnbuscar;

    public GestionarVentasVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);
        // -------Crear la barra de menú-------------



        //-----------panel bienvenido----------
        panelusuario = new PanelDegradadoAzul62();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);

        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("GESTIÓN DE VENTAS");
        lblbienvenida.setBounds(360,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);

        modeloInventario = new DefaultTableModel(new String[]{"Cliente", "Código", "Modelo", "Color","Talla", "M. Pago"," Precio", "Hora V.", "Teléfono"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaInventario = new JTable(modeloInventario);


        tablaInventario.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablaInventario.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablaInventario.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablaInventario.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablaInventario.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablaInventario.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tablaInventario.getTableHeader().setReorderingAllowed(false);
        tablaInventario.getTableHeader().setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        scrollPane.setBounds(380, 140, 690, 340);
        panelusuario.add(scrollPane);

        lblcliente= new JLabel("CLIENTE: ");
        lblcliente.setForeground(Color.white);
        lblcliente.setFont(new Font( " Comic Sans MS", Font.BOLD, 24));
        lblcliente.setBounds(100,180,200,30);
        panelusuario.add(lblcliente);


        txtcliente= new JTextField();
        txtcliente.setBounds(100,220,200,30);
        panelusuario.add(txtcliente);



        lbltelefono= new JLabel("#TELÉFONO: ");
        lbltelefono.setForeground(Color.white);
        lbltelefono.setFont(new Font( " Comic Sans MS", Font.BOLD, 24));
        lbltelefono.setBounds(100,280,200,30);
        panelusuario.add(lbltelefono);


        txttelefono= new JTextField();
        txttelefono.setBounds(100,320,200,30);
        panelusuario.add(txttelefono);


        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(30,400,140,40);
        btnbuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnbuscar.setBackground(Color.green);
        panelusuario.add(btnbuscar);

        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(230,400,140,40);
        btneliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btneliminar.setBackground(Color.red);
        panelusuario.add(btneliminar);


        btnactualizar = new JButton("Actualizar");
        btnactualizar.setBounds(90,470,200,40);
        btnactualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnactualizar.setBackground(Color.CYAN);
        panelusuario.add(btnactualizar);


    }
    public JPanel getPanelusuario() {
        return panelusuario;
    }
    public JTable getTablaInventario() {
        return tablaInventario;
    }
    public DefaultTableModel getModeloInventario() {
        return modeloInventario;
    }
    public JButton getBtneliminar(){
        return btneliminar;
    }
    public JButton getBtnactualizar(){
        return btnactualizar;
    }
    public JButton getBtnbuscar(){
        return btnbuscar;
    }
    public static void main(String[] args){
        GestionarVentasVista ventana = new GestionarVentasVista();
        ventana.setVisible(true);
    }
}

class PanelDegradadoAzul62 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Colores y posiciones para el degradado de tres colores
        Color[] colores = {new Color(25, 43, 57), new Color(60, 78, 92), new Color(25, 43, 57)};
        float[] posiciones = {0.0f, 0.5f, 1.0f}; // Posiciones relativas de cada color

        // Crear el degradado horizontal de derecha a izquierda
        LinearGradientPaint gradiente = new LinearGradientPaint(getWidth(), 0, 0, 0, posiciones, colores);

        g2d.setPaint(gradiente);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}