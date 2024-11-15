package Controlador;

import Modelo.Modelo_Login;
import Vista.*;

import javax.swing.*;
import java.awt.*;



public class Menu_Principal_Controlador {
    private final PrincipalVista menu;
    private  JPanel mainPanel;
    private  CardLayout cardLayout;
    public Menu_Principal_Controlador(PrincipalVista menu) {
        this.menu = menu;
        Iniciar();
    }
    private void Iniciar(){
        gestionUsuarioVista Usuariovist = new gestionUsuarioVista();
        gestioninventarioVista Inventariovist = new gestioninventarioVista();
        registroInventarioVista Registrovist = new registroInventarioVista();
        registroVentaVista RegsitroVentas = new registroVentaVista();
        GestionarVentasVista gestionarVentas = new GestionarVentasVista();


        JPanel gestionarV = gestionarVentas.getPanelusuario();
        JPanel registropa = Registrovist.getPanelusuario();
        JPanel inventariopa = Inventariovist.getPanelInventario();
        JPanel usuariopa = Usuariovist.getPanelusuario();
        JPanel registrovent = RegsitroVentas.getPanelregistroventas();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        JPanel menupr = menu.getPanelprincipal();
        mainPanel.add(menupr , "MenuPrincipal");
        mainPanel.add(usuariopa , "GestionUsuario");
        mainPanel.add(inventariopa , "GestionInventario");
        mainPanel.add(registropa , "RegistroInventario");
        mainPanel.add(registrovent, "RegistroVentas");
        mainPanel.add(gestionarV , "GestionarVentas");

        menu.add(mainPanel ,BorderLayout.CENTER);

        menu.getGestionUsuario().addActionListener(_-> {
            cardLayout.show(mainPanel, "GestionUsuario");
            Usuariovist.getBtneliminar().addActionListener(_-> {
                JOptionPane.showMessageDialog(null , "xD");
            });


        });
        //Asignar los eventos de los botones
        menu.getRegistrarProducto().addActionListener(_ -> {
            cardLayout.show(mainPanel, "RegistroInventario");
        });
        menu.getGestionarInventario().addActionListener(_ -> {
            cardLayout.show(mainPanel, "GestionInventario");
        });
        menu.getRegistrarVenta().addActionListener(_ -> {
           cardLayout.show(mainPanel , "RegistroVentas");
        });
        menu.getGestionarVentas().addActionListener(_ -> {
            cardLayout.show(mainPanel, "GestionarVentas");
        });
        menu.getCerrarSesion().addActionListener(_ -> {
            menu.dispose();
            LoginVista vista = new LoginVista();
            Modelo_Login modelologin = new Modelo_Login();
            new FrmLoginUsuario_Controlador(vista, modelologin);
            vista.setVisible(true);

        });


    }
}
