package Modelo;

import java.sql.*;

import Utilitario.ConexionBD;

import java.util.ArrayList;


public class ventas {

    private int id_venta;
    private int id_cliente;
    private Timestamp fecha_venta;
    private double total_venta;
    private String metodo_pago;

    public void setId_venta(int id_venta) {this.id_venta = id_venta;}
    public void setId_cliente(int id_cliente) {this.id_cliente = id_cliente;}
    public void setFecha_venta(Timestamp fecha_venta) {this.fecha_venta = fecha_venta;}
    public void setTotal_venta(double total_venta) {this.total_venta = total_venta;}
    public void setMetodo_pago(String metodo_pago) {this.metodo_pago = metodo_pago;}

    public int getIdVenta(){return id_venta;}
    public int getId_cliente(){return id_cliente;}
    public Timestamp getFecha_venta(){return fecha_venta;}
    public double getTotal_venta(){return total_venta;}
    public String getMetododepago(){return metodo_pago;}


    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<ventas> listaVentas = null;
    ArrayList<inventario> listaInventarioD = null;
    ventas objVentas = null;
    inventario objInventarioD = null;


    public ArrayList<inventario> listarInventarioDisponible(String talla, String color, String codigo) {
        ArrayList<inventario> listaInventarioD = new ArrayList<>();
        try {
            Connection cn = ConexionBD.getConexionBD();
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
            PreparedStatement ps = cn.prepareStatement(query.toString());

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

            ResultSet rs = ps.executeQuery();

            // Procesar resultados
            while (rs.next()) {
                inventario objInventario = new inventario();
                objInventario.setMarca(rs.getString("marca"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setId_inventario(rs.getInt("id_inventario"));
                objInventario.setPrecio_compra(rs.getInt("precio_compra"));
                listaInventarioD.add(objInventario);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return listaInventarioD;
    }


    public int AgregarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO ventas (id_cliente,metodo_pago, total_venta) VALUES (?,?,?);");
            ps.setInt(1, Venta.getId_cliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setDouble(3, Venta.getTotal_venta());
            estado =  ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error : " + e.getMessage());
            return  estado;
        }
        return estado;

    }
    public int EditarVentas(ventas Venta){
        int estado = 0;
        try{
            cn  = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE ventas SET id_cliente=?, metodo_pago=?, total_venta=? WHERE id_venta=?");
            ps.setInt(1, Venta.getId_cliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setDouble(4, Venta.getTotal_venta());
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
            ps = cn.prepareStatement("DELETE FROM ventas WHERE id_venta=?");
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


}
