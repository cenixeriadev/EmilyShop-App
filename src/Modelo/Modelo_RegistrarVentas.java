package Modelo;

import Utilitario.ConexionBD;
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
        Modelo_Inventario.AgregarInventario(model, listaDisponible, vista.getTablaInventario());
    }
    public void VentaConfirmada(clientes cliente ,String metodoPago){
        try{
            Connection cn = ConexionBD.getConexionBD();
            CallableStatement stmt = cn.prepareCall("{CALL confirmar_venta(?, ?)}");
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, metodoPago);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venta realzada con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la venta" );
        }
    }


}
