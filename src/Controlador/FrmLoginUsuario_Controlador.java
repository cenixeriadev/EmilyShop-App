package Controlador;
import Modelo.LoginObserver;
import Utilitario.PantallaCarga;
import Vista.FrmLoginUsuario_Vista;
import Modelo.Modelo_Login;
import Vista.Menu_Principal_Vista;

import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FrmLoginUsuario_Controlador implements LoginObserver{
    private final FrmLoginUsuario_Vista login ;
    private final Modelo_Login modelo;
    public FrmLoginUsuario_Controlador(FrmLoginUsuario_Vista login , Modelo_Login modelo) {
        this.login = login;
        this.modelo = modelo;
        modelo.addObserver(this);
        Iniciar();

    }
    private void Iniciar(){
        try {
            login.getTxtUsuario().addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        handleLogin();
                        removerObserver();
                    }
                }
            });

            login.getTxtPassword().addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        handleLogin();
                        removerObserver();
                    }
                }
            });
            login.getbtnSalir().addActionListener(_ -> {
                removerObserver();
                login.dispose();
            });

            login.getbtnEntrar().addActionListener(_ -> {
                handleLogin();
                removerObserver();
            });
        }catch (Exception e){
            JOptionPane.showMessageDialog(null , "Ocurrio un error inesperado : " + e.getMessage());
        }

    }
    private void removerObserver(){
        modelo.removeObserver(this);
    }
    private void  handleLogin() {
        String inputUsername =  login.getTxtUsuario().getText();
        String password = new String(login.getTxtPassword().getPassword());
        modelo.validarCredenciales(inputUsername, password);

    }
    @Override
    public void loginExitoso() {
        PantallaCarga pantallaCarga = new PantallaCarga();
        pantallaCarga.setVisible(true);
        login.dispose();
        // Usar SwingWorker para realizar operaciones de carga en un hilo separado
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simular operaciones de carga
                Thread.sleep(500);

                return null;
            }

            @Override
            protected void done() {
                pantallaCarga.dispose();
                Menu_Principal_Vista vista = new Menu_Principal_Vista();
                new Menu_Principal_Controlador(vista);
                vista.setVisible(true);
            }
        };

        worker.execute();
    }

    @Override
    public void loginFallido(String message) {
        JOptionPane.showMessageDialog(null , message,"" ,  JOptionPane.ERROR_MESSAGE);

    }

}
