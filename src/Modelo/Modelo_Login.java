package Modelo;

import Controlador.Menu_Principal_Controlador;
import Vista.Menu_Principal_Vista;
import javax.swing.*;

public class Modelo_Login {
    public Menu_Principal_Vista Entrar(JFrame ventana , JTextField txtUsuario  , JPasswordField txtPassword) {

        String[] usu = {"Ivan", "Armando", "Julio", "Karin", "Anthony"};
        String[] cla = {"131313", "139319", "49983894", "8589895", "00012319"};
        String usuario = txtUsuario.getText();
        String clave = new String(txtPassword.getPassword());

        if (usuario.isEmpty() && clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña!");
            txtUsuario.requestFocus();
        } else if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario!");
            txtUsuario.setText("");
            txtPassword.setText("");
            txtUsuario.requestFocus();
        } else if (clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese contraseña!");
            txtUsuario.setText("");
            txtPassword.setText("");
            txtUsuario.requestFocus();

        } else {
            boolean estado = false;
            for (int i = 0; i < usu.length; i++) {
                if (usu[i].equals(usuario) && cla[i].equals(clave)) {
                    estado = true;
                    break;
                }
            }
            if (estado) {
                Menu_Principal_Vista obj = new Menu_Principal_Vista();
                Menu_Principal_Controlador mod  = new Menu_Principal_Controlador(obj);
                obj.setVisible(true);
                ventana.dispose();
                return obj;
                //this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Clave o contraseña incorrectos");
                txtUsuario.setText("");
                txtPassword.setText("");
                txtUsuario.requestFocus();

            }
        }

        return null;
    }
}
