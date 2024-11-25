package Modelo;

import java.sql.*;

import Utilitario.ConexionBD;

import java.util.ArrayList;


public class ventas {

    private int idventas;
    private String  cliente;
    private String metododepago;
    private int precio;
    private Timestamp horaventa;
    private String codigo ;
    private String telefono;

    public void setCodigo(String codigo){this.codigo = codigo;}
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setHoraventa(Timestamp horaventa) {
        this.horaventa = horaventa;
    }
    public void setIdventas(int idventas){this.idventas = idventas;}
    public void setTelefono(String telefono){this.telefono = telefono;}

    public String getCodigo() { return codigo;}
    public int getIdVenta() {
        return idventas;}
    public String getCliente() {
        return cliente;
    }
    public String getMetododepago() {
        return metododepago;
    }
    public int getPrecio() {
        return precio;
    }
    public Timestamp getHoraventa() {
        return horaventa;
    }
    public String getTelefono(){return telefono;}
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
                objInventario.setModel(rs.getString("modelo"));
                objInventario.setCodigo(rs.getString("codigo"));
                objInventario.setTalla(rs.getInt("talla"));
                objInventario.setColor(rs.getString("color"));
                objInventario.setIdinventario(rs.getInt("idinventario"));
                objInventario.setPrecioCosto(rs.getInt("preciocosto"));
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


    public ArrayList<ventas> listarVentas() {
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM ventas");
            rs = ps.executeQuery();
            listaVentas = new ArrayList<>();
            while (rs.next()) {
                objVentas = new ventas();
                objVentas.setIdventas(rs.getInt("idventas"));
                objVentas.setCliente(rs.getString("cliente"));
                objVentas.setMetododepago(rs.getString("metododepago"));
                objVentas.setTelefono(rs.getString("telefono"));
                objVentas.setPrecio(rs.getInt("precio"));
                objVentas.setHoraventa(rs.getTimestamp("horaventa"));
                objVentas.setCodigo(rs.getString("codigo"));
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
            ps = cn.prepareStatement("INSERT INTO ventas (cliente,metododepago, precio  ,codigo , telefono) VALUES (?,?,?,?,?);");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            ps.setString(4, Venta.getCodigo());
            ps.setString(5, Venta.getTelefono());
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
            ps = cn.prepareStatement("UPDATE ventas SET cliente=?, metododepago=?, precio=? WHERE idventas=?");
            ps.setString(1, Venta.getCliente());
            ps.setString(2, Venta.getMetododepago());
            ps.setInt(3, Venta.getPrecio());
            ps.setInt(4, Venta.getIdVenta());
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


}
