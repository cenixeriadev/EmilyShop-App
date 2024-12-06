package Modelo;

import Utilitario.ConexionBD;

import java.sql.*;
import java.util.ArrayList;


public class carrito {
    private int id_carrito;
    private int id_cliente;
    private int id_inventario;
    private int cantidad ;
    private double precio_unitario;
    private double subtotal;
    private Timestamp fecha_agregado;
    public void setIdProducto(int idproducto) {
        this.id_carrito = idproducto;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    public int getIdProducto() {
        return id_carrito;
    }
    public int getId_cliente() {
        return id_cliente;
    }




    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<carrito> listaProducto = null;
    carrito objProducto = null;



    public ArrayList<carrito> listarProductos(){
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            listaProducto = new ArrayList<>();
            while(rs.next()){
                objProducto = new carrito();
                objProducto.setIdProducto(rs.getInt("idproducto"));
                objProducto.setId_cliente(rs.getInt("idInventario"));
                objProducto.setModel(rs.getString("modelo"));
                objProducto.setColor(rs.getString("color"));
                objProducto.setCodigo(rs.getString("codigo"));
                objProducto.setTalla(rs.getInt("talla"));

                listaProducto.add(objProducto);
            }
            return listaProducto;
        }catch(Exception e){
            System.out.println("Error al listar productos: " + e.getMessage());
            return null;
        }
    }
    public int ObtenerIdProducto(int idinventario){
        int id;
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT idproducto FROM producto where idinventario = ?;");
            ps.setInt(1, idinventario);
            rs = ps.executeQuery();
            // Mueve el cursor a la primera fila de resultados
            rs.next();
            // Ahora es seguro leer el valor de "idproducto"
            id = rs.getInt("idproducto");
            cn.close();
            ps.close();
            return id;
        } catch(SQLException e) {
            System.out.println("Error al obtener id producto: " + e.getMessage());
            return 0;
        }
    }
    public int AgregarProducto(carrito producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO producto (idinventario, modelo, color, codigo, talla ) VALUES (?,?,?,?,?)");
            ps.setInt(1, producto.getId_cliente());
            ps.setString(2, producto.getModel());
            ps.setString(3, producto.getColor());
            ps.setString(4, producto.getCodigo());
            ps.setInt(5, producto.getTalla());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }
    public int ModificarProducto(carrito producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("UPDATE producto SET idinventario=?, modelo=?, color=?, codigo=?, talla=? WHERE idproducto=?");
            ps.setInt(1, producto.getId_cliente());
            ps.setString(2, producto.getModel());
            ps.setString(3, producto.getColor());
            ps.setString(4, producto.getCodigo());
            ps.setInt(5, producto.getTalla());
            ps.setInt(6, producto.getIdProducto());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }
    public int EliminarProducto(int idProducto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM producto WHERE idproducto=?");
            ps.setInt(1, idProducto);
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }

}
