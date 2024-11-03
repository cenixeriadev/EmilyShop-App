package Modelo;
import Utilitario.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import Modelo.ventas;
public class ventasDAO {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet   rs = null;
    ArrayList<ventas> listaVentas = null;
    ventas objVentas = null;
    public ArrayList<ventas> listarVentas() {
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM ventas");
            rs = ps.executeQuery();
            listaVentas = new ArrayList<>();
            while (rs.next()) {
                objVentas = new ventas();
                objVentas.setCliente(rs.getString("producto"));
                objVentas.setMetododepago(rs.getString("cantidad"));
                objVentas.setPrecio(rs.getInt("precio"));
                objVentas.setHoraventa(rs.getDate("horaventa"));

                listaVentas.add(objVentas);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las ventas: " + e.getMessage());
        }
        return listaVentas;
    }
    public int AgregarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO ventas (cliente, metododepago, precio, horaventa) VALUES (?,?,?,?)");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            ps.setDate(4, Venta.getHoraventa());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al agregar la venta: " + e.getMessage());
        }
        return estado;

    }
    public int EditarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE ventas SET cliente=?, metododepago=?, precio=?, horaventa=? WHERE idventa=?");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            ps.setDate(4, Venta.getHoraventa());
            ps.setInt(5, Venta.getIdventas());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al editar la venta: " + e.getMessage());
        }
        return estado;
    }
    public int EliminarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM ventas WHERE idventa=?");
            ps.setInt(1, Venta.getIdventas());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al eliminar la venta: " + e.getMessage());
        }
        return estado;
    }
}
