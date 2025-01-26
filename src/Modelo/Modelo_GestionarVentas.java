package Modelo;

import Utilitario.ConexionBD;
import Vista.GestionarVentasVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_GestionarVentas {
    GestionarVentasVista vista;
    public Modelo_GestionarVentas(GestionarVentasVista vista) {
        this.vista = vista;
    }

    public void ListarTabla(String nombre , String telefono){
        try {

            StringBuilder query = new StringBuilder("""
                        SELECT d.id_detalle_venta , d.id_venta , v.id_cliente , i.codigo, i.marca, i.color, i.talla, c.nombre_apellido AS cliente,\s
                               c.telefono, v.metodo_pago AS m_pago, v.total_venta AS total_v,\s
                               v.fecha_venta AS hora_v\s
                        FROM clientes c
                        INNER JOIN ventas v ON v.id_cliente = c.id_cliente
                        INNER JOIN detalle_ventas d ON v.id_venta = d.id_venta
                        INNER JOIN inventario i ON i.id_inventario = d.id_inventario
                        WHERE 1=1
                   \s""");

            if (!nombre.isEmpty()) {
                query.append(" AND c.nombre_apellido LIKE ?");
            }
            if (!telefono.isEmpty()) {
                query.append(" AND c.telefono = ?");
            }

            // Prepara el statement
            Connection cn = ConexionBD.getConexionBD();
            PreparedStatement ps = cn.prepareStatement(query.toString());

            int paramIndex = 1;
            if (!nombre.isEmpty()) {
                ps.setString(paramIndex++, "%" + nombre + "%");
            }
            if (!telefono.isEmpty()) {
                ps.setString(paramIndex++, telefono);
            }

            // Ejecutar y llenar JTable
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) vista.getTablaInventario().getModel();
            model.setRowCount(0); // Limpiar la tabla

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_detalle_venta"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("talla"),
                        rs.getString("cliente"),
                        rs.getString("telefono"),
                        rs.getString("m_pago"),
                        rs.getDouble("total_v"),
                        rs.getTimestamp("hora_v")
                });
            }
            cn.close();
            rs.close();
            ps.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al listar la tabla " + e.getMessage());
        }
    }
    public void eliminarDetalleVenta(int idDetalleVenta, int idVenta, int idCliente) throws SQLException {
        // Iniciar una transacción
        Connection cn  = ConexionBD.getConexionBD();
        cn.setAutoCommit(false);

        try {
            // Paso 1: Actualizar stock y eliminar el detalle de venta
            String getDetalleQuery = """
            SELECT id_inventario, cantidad\s
            FROM detalle_ventas\s
            WHERE id_detalle_venta = ?
           \s""";
            PreparedStatement getDetallePs = cn.prepareStatement(getDetalleQuery);
            getDetallePs.setInt(1, idDetalleVenta);
            ResultSet rs = getDetallePs.executeQuery();

            if (rs.next()) {
                int idInventario = rs.getInt("id_inventario");
                int cantidad = rs.getInt("cantidad");

                // Actualizar el stock
                String updateStockQuery = """
                UPDATE inventario\s
                SET stock = stock + ?\s
                WHERE id_inventario = ?
           \s""";
                PreparedStatement updateStockPs = cn.prepareStatement(updateStockQuery);
                updateStockPs.setInt(1, cantidad);
                updateStockPs.setInt(2, idInventario);
                updateStockPs.executeUpdate();

                // Cambiar estado a 'activo' si el stock > 0
                String updateEstadoQuery = """
                UPDATE inventario\s
                SET estado = 'activo'\s
                WHERE id_inventario = ? AND stock > 0
               \s""";
                PreparedStatement updateEstadoPs = cn.prepareStatement(updateEstadoQuery);
                updateEstadoPs.setInt(1, idInventario);
                updateEstadoPs.executeUpdate();
            }

            // Eliminar el detalle de venta
            String deleteDetalleQuery = """
            DELETE FROM detalle_ventas\s
            WHERE id_detalle_venta = ?
           \s""";
            PreparedStatement deleteDetallePs = cn.prepareStatement(deleteDetalleQuery);
            deleteDetallePs.setInt(1, idDetalleVenta);
            deleteDetallePs.executeUpdate();

            // Paso 2: Verificar si la venta tiene más detalles
            String checkDetallesQuery = """
            SELECT COUNT(*) AS detalles_restantes\s
            FROM detalle_ventas\s
            WHERE id_venta = ?
           \s""";
            PreparedStatement checkDetallesPs = cn.prepareStatement(checkDetallesQuery);
            checkDetallesPs.setInt(1, idVenta);
            ResultSet rsDetalles = checkDetallesPs.executeQuery();

            if (rsDetalles.next() && rsDetalles.getInt("detalles_restantes") == 0) {
                // Eliminar la venta
                String deleteVentaQuery = """
                    DELETE FROM ventas\s
                    WHERE id_venta = ?
                   \s""";

                PreparedStatement deleteVentaPs = cn.prepareStatement(deleteVentaQuery);
                deleteVentaPs.setInt(1, idVenta);
                deleteVentaPs.executeUpdate();

                // Paso 3: Verificar si el cliente tiene más ventas
                String checkVentasClienteQuery = """
                SELECT COUNT(*) AS ventas_restantes\s
                FROM ventas\s
                WHERE id_cliente = ?
               \s""";
                PreparedStatement checkVentasClientePs = cn.prepareStatement(checkVentasClienteQuery);
                checkVentasClientePs.setInt(1, idCliente);
                ResultSet rsCliente = checkVentasClientePs.executeQuery();

                if (rsCliente.next() && rsCliente.getInt("ventas_restantes") == 0) {
                    // Eliminar cliente
                    String deleteClienteQuery = """
                    DELETE FROM clientes\s
                    WHERE id_cliente = ?
                   \s""";
                    PreparedStatement deleteClientePs = cn.prepareStatement(deleteClienteQuery);
                    deleteClientePs.setInt(1, idCliente);
                    deleteClientePs.executeUpdate();
                }
            }

            // Confirmar transacción
            cn.commit();
        } catch (SQLException e) {
            // Revertir transacción en caso de error
            JOptionPane.showMessageDialog(null , "Error al eliminar venta!");
            cn.rollback();
            throw e;
        } finally {
            cn.setAutoCommit(true);
        }
    }



}
