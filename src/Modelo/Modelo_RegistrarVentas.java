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
        model.setRowCount(0);
        listaDisponible = objVentas.listarInventarioDisponible(talla , color ,codigo);
        for(inventario objInventario : listaDisponible){
            Object[] fila = {
                    objInventario.getCodigo(),
                    objInventario.getMarca(),
                    objInventario.getTalla(),
                    objInventario.getColor(),
                    objInventario.getPrecio_venta()

            };
            model.addRow(fila);
        }
        vista.getTablaInventario().setModel(model);
    }
    public void LimpiarCampos(JTextField... campos) {
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }
    }

}
