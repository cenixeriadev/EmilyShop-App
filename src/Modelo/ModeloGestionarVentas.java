package Modelo;

import Vista.GestionarVentasVista;
import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ModeloGestionarVentas {
    private final GestionarVentasVista vista;
    ArrayList<ventas> listaVentas = new ArrayList<>();
    ArrayList<producto> listaProductos = new ArrayList<>();
    //ventas objVentas;
    ventas objVentas = new ventas();
    producto objProducto = new producto();
    inventario objInventario = new inventario();
    public ModeloGestionarVentas(GestionarVentasVista vista){
        this.vista = vista;
    }
    public void cargarDatos(){
        // TODO: Implement this method
        DefaultTableModel modelo = vista.getModeloInventario();
        // Implement your code here
        int i = 0;
        listaVentas = objVentas.listarVentas();
        modelo.setNumRows(listaVentas.size());
        for(ventas objVentas : listaVentas){
            modelo.setValueAt(objVentas.getCliente(), i, 0);
            modelo.setValueAt(objVentas.getCodigo(), i, 1);
            modelo.setValueAt(objVentas.getMetododepago(), i, 5);
            modelo.setValueAt(objVentas.getPrecio(), i, 6);
            modelo.setValueAt(objVentas.getHoraventa(), i, 7);
            modelo.setValueAt(objVentas.getTelefono(), i, 8); //aqui luego poner un boton de ver detalles
            i++;
        }
        vista.getTablaInventario().setModel(modelo);
    }
}