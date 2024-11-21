package Modelo;

import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Modelo_GestionarVentas{
    private final registroVentaVista vista;
    ArrayList<inventario> listaDisponible = new ArrayList<>();
    //ventas objVentas;
    ventas objVentas = new ventas();
    producto objProducto = new producto();
    inventario objInventario = new inventario();
    public Modelo_GestionarVentas(registroVentaVista vista){
        this.vista = vista;
    }
    public void CargarInventarioD(String talla,String color ,String codigo) {
        DefaultTableModel model = vista.getModeloInventario();
        int i = 0 ;
        listaDisponible = objVentas.listarInventarioDisponible(talla , color ,codigo);
        model.setNumRows(listaDisponible.size());
        for(inventario objInventario : listaDisponible){
            model.setValueAt(objInventario.getModel(), i, 0);
            model.setValueAt(objInventario.getCodigo(), i, 1);
            model.setValueAt(objInventario.getTalla(), i, 2);
            model.setValueAt(objInventario.getColor(), i, 3);
            i++;
        }
        vista.getTablaInventario().setModel(model);
    }
    public void RegistrarVenta(ArrayList<ventas> Ventas , ArrayList<Integer> inventarioConsumido) {

        for(ventas Venta : Ventas){
            objVentas.AgregarVentas(Venta);
        }
        for(int id : inventarioConsumido){
            int idproducto = objProducto.ObtenerIdProducto(id);
            objProducto.EliminarProducto(idproducto);
            objInventario.EliminarProducto(id);

        }
    }
    public void Agregar_aCarrito(inventario inventario , String precio , String MetodoDePago , String telefono){
        objProducto = new producto();
        objProducto.setCodigo(inventario.getCodigo());
        objProducto.setIdinventario(inventario.getIdInventario());
        objProducto.setColor(inventario.getColor());
        objProducto.setModel(inventario.getModel());
        objProducto.setTalla(inventario.getTalla());
        objProducto.AgregarProducto(objProducto);

        DefaultTableModel modelo = vista.getModelocarrito();
        Object[] fila = new Object[]{objProducto.getModel(), objProducto.getCodigo(), String.valueOf(objProducto.getTalla()), objProducto.getColor(), precio, MetodoDePago, telefono};
        modelo.addRow(fila);
        vista.getTablacarrito().setModel(modelo);
    }

    public void LimpiarCampos(JTextField... campos) {
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }

}
