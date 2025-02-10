package Utilitario;
import org.mindrot.jbcrypt.BCrypt;

public class ValidationPassword {

    public static String encriptar(String contrasena) {
        // Genera un salt y aplica hashing a la contraseña
        return BCrypt.hashpw(contrasena, BCrypt.gensalt());
    }
    // Verifica la contraseña
    public static boolean verificar(String contrasenaIngresada, String hashAlmacenado) {
        // Compara la contraseña ingresada (en texto plano) con el hash almacenado
        return BCrypt.checkpw(contrasenaIngresada, hashAlmacenado);
    }
}
