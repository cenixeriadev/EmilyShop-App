package Modelo;

import Controlador.Controlador_Menu_Principal;
import Vista.interfaz_Menu_Principal;
import javax.swing.*;

public class Modelo_Login {
    public interfaz_Menu_Principal Entrar(JFrame ventana ,JTextField txtUsuario  , JPasswordField txtPassword) {

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
                interfaz_Menu_Principal obj = new interfaz_Menu_Principal();
                Controlador_Menu_Principal mod  = new Controlador_Menu_Principal(obj);
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
