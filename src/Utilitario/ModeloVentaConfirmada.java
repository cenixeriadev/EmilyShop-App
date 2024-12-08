package Utilitario;

import Modelo.clientes;

import javax.swing.*;
import java.sql.*;

public class ModeloVentaConfirmada {

    public static void VentaConfirmada(clientes cliente ,String metodoPago){
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
