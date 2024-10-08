package Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public Connection getConexionBD() {
        Connection cn = null;
        try {
            // Cargar el driver JDBC correcto
            Class.forName("com.mysql.jdbc.Driver");

            // Conectar a la base de datos (sin espacio en el nombre de usuario)
            String url = "jdbc:mysql://localhost:3306/inventario";
            String user = "root";  // Usuario root sin espacio
            String password = "";  // Cambia la contraseña si tienes una

            // Establecer la conexión
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return cn;
    }

    public static void main(String[] args) {
        ConexionBD objeto = new ConexionBD();
        objeto.getConexionBD();
    }
}
