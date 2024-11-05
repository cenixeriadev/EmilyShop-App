package Vista;
import Controlador.FrmInventarios_Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class FrInventarios_Vista extends JFrame {
    public JLabel lblInventarioReporte, lblDatos;
    public DefaultTableModel modelo;
    public JTable tablaInventario;
    public JScrollPane barraTablaInventario;
    public JButton btnvolver , btnActualizar ,btnEliminar;
    String[] titulos = {"Talla","Modelo" , "Color" , "Codigo" , "Precio" , ""};

    public FrInventarios_Vista() {
        initComponents();
    }

    public void initComponents(){
        setTitle("REPORTE DE INVENTARIO");
        setSize(500,500);
        setLocation(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //-------------------------------------
        lblInventarioReporte = new JLabel("INVENTARIO REPORTES");
        lblInventarioReporte.setFont(new java.awt.Font("Arial",Font.BOLD,18));
        lblInventarioReporte.setBounds(127,-20,300,100);
        lblInventarioReporte.setForeground(Color.BLACK);
        add(lblInventarioReporte);
        lblDatos = new JLabel("DATOS");
        lblDatos.setForeground(Color.BLACK);
        lblDatos.setBounds(210,11,100,100);
        add(lblDatos);
        //--------------------------------------
        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(320,331,100,30);
        btnvolver.setForeground(Color.BLACK);
        btnvolver.setBackground(Color.LIGHT_GRAY);
        add(btnvolver);
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(200 , 331 , 110,30);
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setBackground(Color.RED);
        add(btnEliminar);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(60 , 331 , 110 , 30);
        btnActualizar.setBackground(Color.GREEN);
        btnActualizar.setForeground(Color.BLACK);
        add(btnActualizar);

        tablaInventario = new JTable();
        modelo = new DefaultTableModel(null, titulos);
        tablaInventario.setModel(modelo);


        TableColumn columnainvisible = tablaInventario.getColumnModel().getColumn(5);
        columnainvisible.setMinWidth(0);
        columnainvisible.setMinWidth(0);
        columnainvisible.setPreferredWidth(0);

        barraTablaInventario = new JScrollPane(tablaInventario);
        barraTablaInventario.setBounds(74,70,325,250);
        barraTablaInventario.setViewportView(tablaInventario);
        add(barraTablaInventario);
        //------------------------------------
        //    talla modelo color  precio

    }
    public JButton getBtnEliminar() { return btnEliminar;}
    public JButton getBtnActualizar() {return btnActualizar;}
    public DefaultTableModel getModelo(){return modelo;}
    public JTable getTablaInventario(){
        return tablaInventario;
    }
    public JButton getBtnVolver(){
        return btnvolver;
    }
}

