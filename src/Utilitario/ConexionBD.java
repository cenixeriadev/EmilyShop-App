package Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection getConexionBD() {
        Connection Database = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = System.getenv("DOCKER_ENV")!=null? "jdbc:mysql://mysql:3306/tienda_de_zapatillas?useSSL=false&serverTimezone=UTC" : "jdbc:mysql://localhost:3306/tienda_de_zapatillas?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            Database = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL");

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos!");
        }
        return Database;
    }


}
