package Modelo;
import Utilitario.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
public class ventasDAO {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet   rs = null;
    ArrayList<ventas> listaVentas = null;
    ArrayList<inventario> listaInventarioD = null;
    ventas objVentas = null;
    inventario objInventarioD = null;
    public ArrayList<inventario> listarInventarioDisponible(String talla){
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT modelo , color , codigo , preciocosto , idinventario FROM inventario WHERE talla =?");
            ps.setInt(1, Integer.parseInt(talla));
            rs = ps.executeQuery();
            listaInventarioD = new ArrayList<>();
            while (rs.next()) {
                objInventarioD = new inventario();
                objInventarioD.setModel(rs.getString("modelo"));
                objInventarioD.setColor(rs.getString("color"));
                objInventarioD.setCodigo(rs.getString("codigo"));
                objInventarioD.setPrecioCosto(rs.getInt("preciocosto"));
                objInventarioD.setIdinventario(rs.getInt("idinventario"));
                listaInventarioD.add(objInventarioD);

            }
            rs.close();
            ps.close();
            cn.close();
        }catch(Exception e){
            System.out.println("Error al listar los modelos de la talla: " + e.getMessage());
            return null;
        }
        return listaInventarioD;

    }

    public ArrayList<ventas> listarVentas() {
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM ventas");
            rs = ps.executeQuery();
            listaVentas = new ArrayList<>();
            while (rs.next()) {
                objVentas = new ventas();
                objVentas.setIdventas(rs.getInt("idventas"));
                objVentas.setIdProducto(rs.getInt("idproducto"));
                objVentas.setCliente(rs.getString("cliente"));
                objVentas.setMetododepago(rs.getString("metododepago"));
                objVentas.setPrecio(rs.getInt("precio"));
                objVentas.setHoraventa(rs.getTimestamp("horaventa"));

                listaVentas.add(objVentas);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ventas: " + e.getMessage());
            return null;
        }
        return listaVentas;
    }
    public int AgregarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO ventas (cliente,metododepago, precio , codigo , idproducto) VALUES (?,?,?,? , ?);");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            //ps.setDate(4, Venta.getHoraventa());
            ps.setInt(4, Venta.getCodigo());
            ps.setInt(5,Venta.getIdProducto());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error : " + e.getMessage());
            return  estado;
        }
        return estado;

    }
    public int EditarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE ventas SET cliente=?, metododepago=?, precio=?, horaventa=? WHERE idventas=?");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            //ps.setDate(4, Venta.getHoraventa());
            ps.setInt(5, Venta.getIdVenta());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error : " + e.getMessage());
            return estado;
        }
        return estado;
    }
    public int EliminarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM ventas WHERE idventas=?");
            ps.setInt(1, Venta.getIdVenta());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error : " + e.getMessage());
            return  estado;
        }
        return estado;
    }
    public int actualizarInventario(int idinventario){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            PreparedStatement pr = null;
            pr =cn.prepareStatement("DELETE FROM producto WHERE  idinventario = ?;");
            ps = cn.prepareStatement("DELETE  FROM inventario WHERE idinventario = ?;");
            pr.setInt(1, idinventario);
            ps.setInt(1, idinventario);
            pr.executeUpdate();
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
            pr.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error : " + e.getMessage());
            return estado;
        }
        return estado;
    }
}
