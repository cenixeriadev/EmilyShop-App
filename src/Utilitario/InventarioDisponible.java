package Utilitario;

import java.sql.*;

import Modelo.inventario;

import javax.swing.*;
import java.util.ArrayList;


public class InventarioDisponible {

    public static ArrayList<inventario> listarInventarioDisponible(String talla, String color, String codigo) {
        ArrayList<inventario> listaInventario = new ArrayList<>();
        Connection cn;
        PreparedStatement ps ;
        ResultSet rs ;
        try {
            cn = ConexionBD.getConexionBD();
            StringBuilder query = new StringBuilder("SELECT * FROM inventario WHERE 1=1");
            if (talla != null && !talla.equals("Seleccionar una talla")) {
                query.append(" AND talla = ?");
            }
            if(codigo != null && !codigo.isEmpty()){
                query.append(" AND codigo = ?");
            }
            if(color != null && !color.equals("Seleccionar un color")) {
                query.append(" AND color = ?");
            }
            ps = cn.prepareStatement(query.toString());

            int paramIndex = 1;
            if (talla != null && !talla.equals("Seleccionar una talla")) {
                ps.setInt(paramIndex++, Integer.parseInt(talla));
            }
            if (codigo != null && !codigo.isEmpty()) {
                ps.setString(paramIndex++, codigo);
            }
            if (color != null && !color.equals("Seleccionar un color")) {
                ps.setString(paramIndex++, color);
            }

            rs = ps.executeQuery();

            // Procesar resultados
            while (rs.next()) {
                inventario objInventario = new inventario();
                objInventario.setMarca(rs.getString("marca"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setId_inventario(rs.getInt("id_inventario"));
                objInventario.setPrecio_venta(rs.getDouble("precio_venta"));
                objInventario.setStock(rs.getInt("stock"));
                listaInventario.add(objInventario);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null , "Error inesperado en la bd"); // Manejo de excepciones
        }
        return listaInventario;
    }



}
