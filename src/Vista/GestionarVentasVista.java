package Vista;

import Utilitario.BotonPersonalizado;
import Utilitario.PanelDegradadoAzul;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionarVentasVista extends JFrame {
    JLabel lblbienvenida;


    JPanel panelusuario;

    JTable tablaInventario;
    DefaultTableModel modeloInventario;

    JLabel lblcliente, lbltelefono;
    JTextField  txttelefono, txtcliente;

    JButton btneliminar, btnbuscar;

    public GestionarVentasVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        panelusuario = new PanelDegradadoAzul();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);

        lblbienvenida= new JLabel("GESTIÓN DE VENTAS");
        lblbienvenida.setBounds(360,65,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);

        modeloInventario = new DefaultTableModel(new String[]{"id_detalle_venta", "id_venta", "id_cliente" , "Código", "Marca", "Color","Talla", "Cliente", "Teléfono" ,"M. Pago","Total V.", "Hora V."}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        tablaInventario = new JTable(modeloInventario);

        tablaInventario.getColumnModel().getColumn(0).setMinWidth(0); // id_detalle_venta
        tablaInventario.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaInventario.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaInventario.getColumnModel().getColumn(1).setMinWidth(0); // id_venta
        tablaInventario.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaInventario.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaInventario.getColumnModel().getColumn(2).setMinWidth(0); // id_cliente
        tablaInventario.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaInventario.getColumnModel().getColumn(2).setPreferredWidth(0);


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
        scrollPane.setBounds(420, 120, 690, 340);
        panelusuario.add(scrollPane);

        lblcliente= new JLabel("CLIENTE: ");
        lblcliente.setForeground(Color.white);
        lblcliente.setFont(new Font( " Comic Sans MS", Font.BOLD, 24));
        lblcliente.setBounds(80,180,200,30);
        panelusuario.add(lblcliente);


        txtcliente= new JTextField();
        txtcliente.setBounds(80,220,200,30);
        panelusuario.add(txtcliente);



        lbltelefono= new JLabel("TELÉFONO: ");
        lbltelefono.setForeground(Color.white);
        lbltelefono.setFont(new Font( " Comic Sans MS", Font.BOLD, 24));
        lbltelefono.setBounds(80,280,200,30);
        panelusuario.add(lbltelefono);


        txttelefono= new JTextField();
        txttelefono.setBounds(80,320,200,30);
        panelusuario.add(txttelefono);

        btneliminar = new BotonPersonalizado("Eliminar","src/Recursos/tachito.png",null);
        btneliminar.setBounds(150,410,160,40);
        btneliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btneliminar.setBackground(Color.red);
        panelusuario.add(btneliminar);

        btnbuscar = new BotonPersonalizado("Buscar","src/Recursos/buscar.png",null);
        btnbuscar.setBounds(250,260,150,40); // Ajustar posición y tamaño
        panelusuario.add(btnbuscar);


    }
    public JPanel getPanelusuario() {
        return panelusuario;
    }
    public JTable getTablaInventario() {
        return tablaInventario;
    }

    public JButton getBtneliminar(){
        return btneliminar;
    }
    public JButton getBtnbuscar(){return  btnbuscar;}
    public JTextField getTxttelefono(){
        return txttelefono;
    }
    public JTextField getTxtcliente(){
        return txtcliente;
    }
}

