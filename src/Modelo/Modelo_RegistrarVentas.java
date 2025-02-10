package Modelo;

import Utilitario.ConexionBD;
import Utilitario.InventarioDisponible;
import Vista.registroVentaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo_RegistrarVentas {
    private final registroVentaVista vista;
    ArrayList<inventario> listaDisponible = new ArrayList<>();
    public Modelo_RegistrarVentas(registroVentaVista vista){
        this.vista = vista;
    }
    public void CargarInventarioD(String talla,String color ,String codigo) {
        DefaultTableModel model = vista.getModeloInventario();
        model.setRowCount(0);
        listaDisponible = InventarioDisponible.listarInventarioDisponible(talla , color ,codigo);
        for(inventario objinventario : listaDisponible){
            if(objinventario.ObtenerEstado(objinventario).equals("activo")){
                Object[] fila = {
                        objinventario.getCodigo(),
                        objinventario.getMarca(),
                        objinventario.getTalla(),
                        objinventario.getColor(),
                        objinventario.getStock(),
                        objinventario.getPrecio_venta()
                };
                model.addRow(fila);
            }
        }
        vista.getTablaInventario().setModel(model);
    }
    public void VentaConfirmada(clientes cliente ,String metodoPago){
        try{
            Connection cn = ConexionBD.getConexionBD();
            CallableStatement stmt = cn.prepareCall("{CALL confirmar_venta(?, ?)}");
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, metodoPago);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venta realizada con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la venta" );
        }
    }


}
