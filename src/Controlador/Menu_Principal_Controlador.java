package Controlador;

import Vista.*;
import Modelo.*;

import javax.swing.*;
import java.awt.*;

public class Menu_Principal_Controlador {
    private final PrincipalVista menu;
    private final JPanel mainPanel;
    private final CardLayout cardLayout;

    private final GestionarVentasVista gestionarVentas = new GestionarVentasVista();
    private final registroInventarioVista registroInventario = new registroInventarioVista();
    private final gestionUsuarioVista gestionUsuario = new gestionUsuarioVista();
    private final registroVentaVista registroVenta = new registroVentaVista();
    private final gestioninventarioVista gestionInventario = new gestioninventarioVista();

    public Menu_Principal_Controlador(PrincipalVista menu) {
        this.menu = menu;
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        inicializarVistas();       // Configurar las vistas en el CardLayout
        inicializarControladores(); // Configurar los controladores
        configurarMenu();          // Configurar los eventos del menú principal
    }

    private void inicializarVistas() {
        // Agregar paneles de las vistas al CardLayout
        mainPanel.add(menu.getPanelprincipal(), "MenuPrincipal");
        mainPanel.add(gestionUsuario.getPanelusuario(), "GestionUsuario");
        mainPanel.add(gestionInventario.getPanelInventario(), "GestionInventario");
        mainPanel.add(registroInventario.getPanelusuario(), "RegistroInventario");
        mainPanel.add(registroVenta.getPanelregistroventas(), "RegistroVentas");
        mainPanel.add(gestionarVentas.getPanelusuario(), "GestionarVentas");

        // Agregar el panel principal al marco principal
        menu.add(mainPanel, BorderLayout.CENTER);
    }

    private void inicializarControladores() {
        Modelo_GestionarUsuario modeloUsuario = new Modelo_GestionarUsuario(gestionUsuario);
        new ControladorGestionarUsuario(gestionUsuario, modeloUsuario);

        Modelo_Inventario modeloInventario = new Modelo_Inventario(gestionInventario);
        new ControladorInventario(gestionInventario, registroInventario , modeloInventario);

        Modelo_RegistrarVentas modeloRegistrarVentas = new Modelo_RegistrarVentas(registroVenta);
        new ControladorRegistrarVentas(registroVenta, modeloRegistrarVentas);


    }

    private void configurarMenu() {
        // Configurar las acciones del menú principal
        menu.getGestionUsuario().addActionListener(e -> mostrarVista("GestionUsuario"));
        menu.getGestionarInventario().addActionListener(e -> mostrarVista("GestionInventario"));
        menu.getRegistrarVenta().addActionListener(e -> mostrarVista("RegistroVentas"));
        menu.getRegistrarProducto().addActionListener(e -> mostrarVista("RegistroInventario"));
        menu.getCerrarSesion().addActionListener(_ -> {
            menu.dispose();
            LoginVista vista = new LoginVista();
            Modelo_Login modelologin = new Modelo_Login();
            new FrmLoginUsuario_Controlador(vista, modelologin);
            vista.setVisible(true);

        });
    }

    private void mostrarVista(String vista) {
        try {
            cardLayout.show(mainPanel, vista); // Cambiar a la vista especificada
        } catch (Exception e) {
            JOptionPane.showMessageDialog(menu, "Error al cargar la vista: " + vista, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

