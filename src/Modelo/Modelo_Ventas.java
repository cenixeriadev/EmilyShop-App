package Modelo;

import Vista.Venta_Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Modelo_Ventas implements MetodosVentas{
    private final Venta_Vista vista;
    ArrayList<inventario> listaDisponible = new ArrayList<>();
    ventas objVentas;
    ventasDAO objVentDAO = new ventasDAO();

    public Modelo_Ventas(Venta_Vista vista){
        this.vista = vista;
    }
    @Override
    public void CargarInventarioD(String talla) {
        DefaultTableModel model = vista.getModelo();
        int i = 0 ;
        listaDisponible = objVentDAO.listarInventarioDisponible(talla);
        model.setNumRows(listaDisponible.size());
        for(inventario objInventario : listaDisponible){
            model.setValueAt(objInventario.getModel(), i, 0);
            model.setValueAt(objInventario.getColor(), i, 1);
            model.setValueAt(objInventario.getCodigo(), i, 2);
            model.setValueAt(objInventario.getPrecioCosto(), i, 3);
            model.setValueAt(objInventario.getIdInventario() , i, 4);
            i++;
        }
        vista.getTablaCandidatos().setModel(model);
        // Implementar la logica para consultar el inventario
    }




}
