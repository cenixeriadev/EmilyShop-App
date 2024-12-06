package Modelo;

import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Modelo_RegistrarVentas {
    private final registroVentaVista vista;
    ArrayList<inventario> listaDisponible = new ArrayList<>();
    //ventas objVentas;
    ventas objVentas = new ventas();
    carrito objProducto = new carrito();
    inventario objInventario = new inventario();
    public Modelo_RegistrarVentas(registroVentaVista vista){
        this.vista = vista;
    }
    public void CargarInventarioD(String talla,String color ,String codigo) {
        DefaultTableModel model = vista.getModeloInventario();
        int i = 0 ;
        listaDisponible = objVentas.listarInventarioDisponible(talla , color ,codigo);
        model.setNumRows(listaDisponible.size());
        for(inventario objInventario : listaDisponible){
            model.setValueAt(objInventario.getMarca(), i, 0);
            model.setValueAt(objInventario.getCodigo(), i, 1);
            model.setValueAt(objInventario.getTalla(), i, 2);
            model.setValueAt(objInventario.getColor(), i, 3);
            i++;
        }
        vista.getTablaInventario().setModel(model);
    }
//    public ArrayList<carrito> RegistrarVenta(ArrayList<ventas> Ventas , ArrayList<Integer> inventarioConsumido) {
//        ArrayList<carrito> listaProductosVendidos = new ArrayList<carrito>();
//        for(ventas Venta : Ventas){
//            objVentas.AgregarVentas(Venta);
//        }
//        listaProductosVendidos = objProducto.listarProductos();
//        for(int id : inventarioConsumido){
//            int idproducto = objProducto.ObtenerIdProducto(id);
//            objProducto.EliminarProducto(idproducto);
//            objInventario.EliminarProducto(id);
//
//        }
//        return listaProductosVendidos;
//    }
//    public void Agregar_aCarrito(inventario inventario , String precio , String MetodoDePago , String telefono){
//        objProducto = new carrito();
//        objProducto.setCodigo(inventario.getCodigo());
//        objProducto.setId_cliente(inventario.getIdInventario());
//        objProducto.setColor(inventario.getColor());
//        objProducto.setModel(inventario.getMarca());
//        objProducto.setTalla(inventario.getTalla());
//        objProducto.AgregarProducto(objProducto);
//
//        DefaultTableModel modelo = vista.getModelocarrito();
//        Object[] fila = new Object[]{objProducto.getModel(), objProducto.getCodigo(), String.valueOf(objProducto.getTalla()), objProducto.getColor(), precio, MetodoDePago, telefono};
//        modelo.addRow(fila);
//        vista.getTablacarrito().setModel(modelo);
//    }

    public void LimpiarCampos(JTextField... campos) {
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }

}
