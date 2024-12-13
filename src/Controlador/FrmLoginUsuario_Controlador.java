package Controlador;
import Modelo.LoginObserver;
import Utilitario.PantallaCarga;
import Modelo.Modelo_Login;
import Vista.LoginVista;
import Vista.PrincipalVista;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class FrmLoginUsuario_Controlador implements LoginObserver{
    private final LoginVista login ;
    private final Modelo_Login modelo;
    public FrmLoginUsuario_Controlador(LoginVista login , Modelo_Login modelo) {
        this.login = login;
        this.modelo = modelo;
        modelo.addObserver(this);
        Iniciar();

    }
    private void Iniciar(){
        try {
            login.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "login");
            login.getRootPane().getActionMap().put("login", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleLogin();
                }
            });


            login.getbtnInicio().addActionListener(_ -> {
                handleLogin();
            });
        }catch (Exception e){
            JOptionPane.showMessageDialog(null , "Ocurrio un error inesperado : " + e.getMessage());
        }

    }
    private void removerObserver(){
        modelo.removeObserver(this);
    }
    private void  handleLogin() {
        String inputUsername =  login.getTxtusuario().getText();
        String password = new String(login.getTxtContra().getText());
        modelo.validarCredenciales(inputUsername, password);

    }
    @Override
    public void loginExitoso(String nombre_Usuario) {
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
                removerObserver();
                PrincipalVista vista = new PrincipalVista(nombre_Usuario);
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
