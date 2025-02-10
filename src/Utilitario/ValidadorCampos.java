
package  Utilitario;
import javax.swing.*;
import java.util.regex.Pattern;

public class ValidadorCampos {

    public static  boolean validacion(JTextField campo , String patron) {
        return Pattern.matches(patron, campo.getText());
    }
}
