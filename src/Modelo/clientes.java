package Modelo;

import Utilitario.ConexionBD;
import javax.swing.*;
import java.sql.*;

public class clientes {
    private int id_cliente;
    private String nombre_apellido;
    private String telefono;
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public void setNombre(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getId_cliente(){return id_cliente;}
    public String getNombre_apellido(){return nombre_apellido;}
    public String getTelefono(){return telefono;}

    public int AgregarCliente(clientes objCliente) {
        int generatedId = -1;
        String sql = "INSERT INTO clientes (nombre_apellido, telefono) VALUES (?, ?)";

        try (Connection cn = ConexionBD.getConexionBD();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objCliente.getNombre_apellido());
            ps.setString(2, objCliente.getTelefono());

            // Ejecuta la consulta y verifica si tuvo éxito
            int estado = ps.executeUpdate();
            if (estado > 0) {
                // Obtiene la clave generada automáticamente
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la base de datos: " + e.getMessage());
        }
        return generatedId;
    }


}
