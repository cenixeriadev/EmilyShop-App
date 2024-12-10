package Modelo;

import Utilitario.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Modelo_Reporte_Ventas {
    Connection cn  = null;
    PreparedStatement pt = null;
    ResultSet rs = null ;
    private ArrayList<Modelo_Reporte_Ventas> listaRventas;
    private Modelo_Reporte_Ventas Rventas;
    private String Dia;
    private double ventasEfectivo;
    private double VentasTarjeta ;
    private double ventasYape;
    private double VentasTotales;
    private String codigo ;
    private String marca ;
    private int cantidad;
    private String metodo_pago;
    private double precio_venta;
    private String fechaVenta;



    public String getDia() {
        return Dia;
    }
    public void setDia(String dia) {
        Dia = dia;
    }
    public double getVentasEfectivo() {
        return ventasEfectivo;
    }
    public void setVentasEfectivo(double ventasEfectivo) {
        this.ventasEfectivo = ventasEfectivo;
    }
    public double getVentasTarjeta() {
        return VentasTarjeta;
    }
    public void setVentasTarjeta(double ventasTarjeta) {
        VentasTarjeta = ventasTarjeta;
    }

    public double getVentasYape() {
        return ventasYape;
    }
    public void setVentasYape(double ventasYape) {
        this.ventasYape = ventasYape;
    }
    public double getVentasTotales() {
        return VentasTotales;
    }
    public void setVentasTotales(double ventasTotales) {
        this.VentasTotales = ventasTotales;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    public double getPrecio_venta() {
        return precio_venta;
    }
    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    public String getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public ArrayList<Modelo_Reporte_Ventas> getTablasProductosVendidos(String fechaInicio, String fechaFinal){
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("""
                SELECT\s
                    i.codigo AS Código,
                    i.marca AS Marca,
                    d.cantidad AS Cantidad,
                    v.metodo_pago AS Método_de_Pago,
                    d.precio_unitario AS Precio_Venta,
                    DATE_FORMAT(v.fecha_venta, '%Y/%m/%d') AS Fecha_de_Venta
                FROM\s
                    ventas v
                INNER JOIN\s
                    detalle_ventas d ON v.id_venta = d.id_venta
                INNER JOIN\s
                    inventario i ON d.id_inventario = i.id_inventario
                WHERE v.fecha_venta BETWEEN ? AND ?
                ORDER BY\s
                    v.fecha_venta;
            """);
            pt.setString(1, fechaInicio);
            pt.setString(2, fechaFinal);
            rs = pt.executeQuery();
            while (rs.next()){
                Rventas = new Modelo_Reporte_Ventas();
                Rventas.setCodigo(rs.getString("Código"));
                Rventas.setMarca(rs.getString("Marca"));
                Rventas.setCantidad(rs.getInt("Cantidad"));
                Rventas.setMetodo_pago(rs.getString("Método_de_Pago"));
                Rventas.setPrecio_venta(rs.getDouble("Precio_Venta"));
                Rventas.setFechaVenta(rs.getString("Fecha_de_Venta"));
                listaRventas.add(Rventas);
            }
            pt.close();
            rs.close();
            cn.close();
            return listaRventas;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener las tablas de productos vendidos");
        }
        return  listaRventas;
    }


    public int cantidadVendida(String fechaInicio , String fechFinal){
        int total = 0;
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT SUM(d.cantidad) AS cantidadV FROM ventas v INNER JOIN detalle_ventas d on d.id_venta = v.id_venta WHERE v.fecha_venta BETWEEN ? AND ?;");
            pt.setString(1, fechaInicio);
            pt.setString(2, fechFinal);
            rs = pt.executeQuery();

            if(rs.next()){
                total =  rs.getInt("cantidadV");
            }
            pt.close();
            rs.close();
            cn.close();
            return total;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de ventas" + e.getMessage());
        }
        return  total;
    }
    public double MargenDeGanancia(String fechaInicio , String fechaFinal){
        double gananciaTotal = 0.00;
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("""
                    SELECT\s
                        SUM(v.total_venta - subquery.costo_total) AS utilidad
                    FROM\s
                        ventas v
                    INNER JOIN\s
                        (
                            SELECT\s
                                d.id_venta,\s
                                SUM(d.cantidad * i.precio_compra) AS costo_total
                            FROM\s
                                detalle_ventas d
                            INNER JOIN\s
                                inventario i ON d.id_inventario = i.id_inventario
                            GROUP BY\s
                                d.id_venta
                        ) AS subquery ON v.id_venta = subquery.id_venta
                    WHERE\s
                        v.fecha_venta BETWEEN ? AND ?;
                    """);
            pt.setString(1, fechaInicio);
            pt.setString(2, fechaFinal);
            rs = pt.executeQuery();

            if(rs.next()){
                gananciaTotal =  rs.getDouble("utilidad");
            }
            pt.close();
            rs.close();
            cn.close();
            return gananciaTotal;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener margen de ganancia" +e.getMessage());
        }
        return  gananciaTotal;
    }

    public ArrayList<Modelo_Reporte_Ventas> getTablaVentasMpago(String fechaInicio, String fechaFinal){
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("""
                    WITH RECURSIVE fechas AS (
                        SELECT ? AS fecha
                        UNION ALL
                        SELECT DATE_ADD(fecha, INTERVAL 1 DAY)
                        FROM fechas
                        WHERE fecha < ?
                    )
                    SELECT\s
                        f.fecha AS Dia,
                        COALESCE(SUM(CASE WHEN v.metodo_pago = 'Yape' THEN v.total_venta ELSE 0 END), 0) AS Ventas_Yape,
                        COALESCE(SUM(CASE WHEN v.metodo_pago = 'Efectivo' THEN v.total_venta ELSE 0 END), 0) AS Ventas_Efectivo,
                        COALESCE(SUM(CASE WHEN v.metodo_pago = 'Tarjeta' THEN v.total_venta ELSE 0 END), 0) AS Ventas_Tarjeta,
                        COALESCE(SUM(v.total_venta), 0) AS Ventas_Totales
                    FROM\s
                        fechas f
                    LEFT JOIN\s
                        ventas v ON DATE(v.fecha_venta) = f.fecha
                    GROUP BY\s
                        f.fecha
                    ORDER BY\s
                        f.fecha;
                    """);
            pt.setString(1, fechaInicio);
            pt.setString(2, fechaFinal);
            rs = pt.executeQuery();

            listaRventas = new ArrayList<>();
            while(rs.next()){
                Rventas = new Modelo_Reporte_Ventas();
                Rventas.setDia(rs.getString("Dia"));
                Rventas.setVentasYape(rs.getDouble("Ventas_Yape"));
                Rventas.setVentasEfectivo(rs.getDouble("Ventas_Efectivo"));
                Rventas.setVentasTarjeta(rs.getDouble("Ventas_Tarjeta"));
                Rventas.setVentasTotales(rs.getDouble("Ventas_Totales"));
                listaRventas.add(Rventas);
            }
            pt.close();
            rs.close();
            cn.close();
            return  listaRventas;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener datos de las ventas");
        }
        return  listaRventas;
    }

    public double TotalVentas(String fechaInicio ,String fechaFinal){
        int total = 0;
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT SUM(total_venta) FROM ventas WHERE fecha_venta<=? AND fecha_venta>=?");
            pt.setString(1, fechaFinal);
            pt.setString(2, fechaInicio);
            rs = pt.executeQuery();
            if(rs.next()){
                total =  rs.getInt(1);
            }
            pt.close();
            rs.close();
            cn.close();
            return total;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener total de ventas");
        }
        return total;
    }
    public int TotalProductos(){
        int total = 0;
        try{
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT COUNT(id_inventario) FROM inventario WHERE estado = ?;");
            pt.setString(1, "activo");
            rs = pt.executeQuery();
            if(rs.next()){
                total =  rs.getInt(1);
            }
            pt.close();
            rs.close();
            cn.close();
            return total;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener total de productos");
        }
        return total;
    }

}
