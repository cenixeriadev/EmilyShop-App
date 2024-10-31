package Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import Modelo.inventario;
import Modelo.inventarioDAO;


public class FrInventarios_Vista extends JFrame {
    public JLabel lblInventarioReporte, lblDatos;
    public DefaultTableModel modelo;
    public JTable tablaInventario;
    public JScrollPane barraTablaInventario;
    public JButton btnvolver;
    String titulos [] = {"Talla" , "Modelo" , "Color" , "Precio"};
    ArrayList <inventario> listaInventario =  new ArrayList<>();
    inventario objInventario ;
    inventarioDAO objInventarioDAO  = new inventarioDAO();


    public FrInventarios_Vista() {
        initComponents();
        //objInventarioDAO = new inventarioDAO();
        //CargarDatos();

    }
    public void initComponents(){
        setTitle("REPORTE DE INVENTARIO");
        setSize(600,600);
        setLocation(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        //-------------------------------------
        lblInventarioReporte = new JLabel("INVENTARIO REPORTES");
        lblInventarioReporte.setFont(new java.awt.Font("Arial",Font.BOLD,18));
        lblInventarioReporte.setBounds(127,-20,300,100);
        lblInventarioReporte.setForeground(Color.BLACK);
        getContentPane().add(lblInventarioReporte);
        lblDatos = new JLabel("DATOS");
        lblDatos.setForeground(Color.BLACK);
        lblDatos.setBounds(210,11,100,100);
        getContentPane().add(lblDatos);
        //--------------------------------------
        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(384,331,100,30);
        btnvolver.setForeground(Color.white);
        btnvolver.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(btnvolver);

        tablaInventario = new JTable();
        modelo = new DefaultTableModel(null, titulos);
        tablaInventario.setModel(modelo);
        barraTablaInventario = new JScrollPane(tablaInventario);
        barraTablaInventario.setBounds(74,70,325,250);
        barraTablaInventario.setViewportView(tablaInventario);
        getContentPane().add(barraTablaInventario);
        //------------------------------------
        //    talla modelo color  precio

    }
    public static void main(String[] args) {
        FrInventarios_Vista fi = new FrInventarios_Vista();
        fi.setVisible(true);
    }
    public JButton getBtnVolver(){
        return btnvolver;
    }
}

