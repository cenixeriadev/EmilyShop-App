package Controlador;

import Utilitario.Limpieza;
import Vista.*;
import Modelo.*;

import javax.swing.*;
import java.awt.*;

public class  Menu_Principal_Controlador {
    private final PrincipalVista menu;
    private final JPanel mainPanel;
    private final CardLayout cardLayout;

    private final GestionarVentasVista gestionarVentas = new GestionarVentasVista();
    private final registroInventarioVista registroInventario = new registroInventarioVista();
    private final gestionUsuarioVista gestionUsuario = new gestionUsuarioVista();
    private final registroVentaVista registroVenta = new registroVentaVista();
    private final gestioninventarioVista gestionInventario = new gestioninventarioVista();
    private final ReporteVista reporteVista = new ReporteVista();

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
        mainPanel.add(reporteVista.getPanelUsuario() , "ReporteGeneral");


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

        new ControladorReportes(reporteVista);

    }

    private void configurarMenu() {
        // Configurar las acciones del menú principal
        menu.getCrearUsuario().addActionListener(e->{
            RegistroUsuarioVista crearUsuarioVista = new RegistroUsuarioVista();
            Modelo_CrearUsuario modeloCrearUsuario = new Modelo_CrearUsuario(crearUsuarioVista);

            new ControladorCrearUsuario(crearUsuarioVista , modeloCrearUsuario);
            crearUsuarioVista.setVisible(true);
        });
        menu.getGestionUsuario().addActionListener(e -> {
            gestionInventario.getTablaInventario().clearSelection();
            registroVenta.getTablacarrito().clearSelection();
            registroVenta.getTablaInventario().clearSelection();
            Limpieza.LimpiarCampos(gestionInventario.getTxtCodigo(), gestionInventario.getTxtColor(), gestionInventario.getTxtModelo(), gestionInventario.getTxtCosto(), gestionInventario.getTxtTalla() ,gestionInventario.getTxtCantidad());
            mostrarVista("GestionUsuario");
        });
        menu.getGestionarInventario().addActionListener(e ->{
            registroVenta.getTablacarrito().clearSelection();
            registroVenta.getTablaInventario().clearSelection();
            gestionUsuario.getTablaUsuario().clearSelection();
            Limpieza.LimpiarCampos(gestionUsuario.getTxtnombre(), gestionUsuario.getTxttelefono(), gestionUsuario.getTxtusuario());
            mostrarVista("GestionInventario");
        });
        menu.getRegistrarVenta().addActionListener(e ->{
            gestionInventario.getTablaInventario().clearSelection();
            gestionUsuario.getTablaUsuario().clearSelection();
            mostrarVista("RegistroVentas");
        });
        menu.getRegistrarProducto().addActionListener(e -> mostrarVista("RegistroInventario"));
        menu.getReporte().addActionListener(e -> mostrarVista("ReporteGeneral"));
        menu.getGestionarVentas().addActionListener(e->{
            mostrarVista("GestionarVentas");
        });
        menu.getCerrarSesion().addActionListener(e -> {
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

