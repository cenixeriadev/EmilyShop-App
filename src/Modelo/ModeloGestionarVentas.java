package Modelo;

import Vista.GestionarVentasVista;

import java.util.ArrayList;

public class ModeloGestionarVentas {
    private final GestionarVentasVista vista;
    ArrayList<ventas> listaVentas = new ArrayList<>();
    ArrayList<carrito> listaProductos = new ArrayList<>();
    //ventas objVentas;
    ventas objVentas = new ventas();
    carrito objProducto = new carrito();
    inventario objInventario = new inventario();
    public ModeloGestionarVentas(GestionarVentasVista vista){
        this.vista = vista;
    }
    public void cargarDatos(){
        // TODO: Implement this method
//        DefaultTableModel modelo = vista.getModeloInventario();
//        // Implement your code here
//        int i = 0;
//        listaVentas = objVentas.listarVentas();
//        modelo.setNumRows(listaVentas.size());
//        for(ventas objVentas : listaVentas){
//            modelo.setValueAt(objVentas.getId_cliente(), i, 0);
//            modelo.setValueAt(objVentas.getCodigo(), i, 1);
//            modelo.setValueAt(objVentas.getMetododepago(), i, 5);
//            modelo.setValueAt(objVentas.getPrecio(), i, 6);
//            modelo.setValueAt(objVentas.getHoraventa(), i, 7);
//            modelo.setValueAt(objVentas.getTelefono(), i, 8); //aqui luego poner un boton de ver detalles
//            i++;
//        }
//        vista.getTablaInventario().setModel(modelo);
    }
}