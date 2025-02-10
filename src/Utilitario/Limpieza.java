package Utilitario;

import javax.swing.*;

public class Limpieza {
    public static void LimpiarCampos(JTextField... campos) {
        for(JTextField campo : campos){
            campo.setText("");
            campo.requestFocus();
        }

    }
}
