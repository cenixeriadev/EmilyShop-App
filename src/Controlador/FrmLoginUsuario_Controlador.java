package Controlador;
import Modelo.LoginObserver;
import Vista.FrmLoginUsuario_Vista;
import Modelo.Modelo_Login;
import Vista.Menu_Principal_Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmLoginUsuario_Controlador implements LoginObserver{
    private FrmLoginUsuario_Vista login ;
    private Modelo_Login modelo;
    public FrmLoginUsuario_Controlador(FrmLoginUsuario_Vista login , Modelo_Login modelo){
        this.login = login;
        this.modelo = modelo;
        modelo.addObserver(this);
        login.getTxtUsuario().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleLogin();
                }
            }
        });

        login.getTxtPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleLogin();
                }
            }
        });
        login.getbtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                login.dispose();
            }

        });

        login.getbtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();

            }
        });
    }
    private void  handleLogin() {
        String inputUsername =  login.getTxtUsuario().getText();
        String password = new String(login.getTxtPassword().getPassword());
        modelo.validarCredenciales(inputUsername, password);

    }
    @Override
    public void loginExitoso() {
        Menu_Principal_Vista vista = new Menu_Principal_Vista();
        new Menu_Principal_Controlador(vista);
        login.dispose();
        vista.setVisible(true);

    }

    @Override
    public void loginFallido(String message) {
        JOptionPane.showMessageDialog(null , message,"" ,  JOptionPane.ERROR_MESSAGE);

    }

}
