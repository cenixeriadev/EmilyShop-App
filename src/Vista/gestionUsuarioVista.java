package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class gestionUsuarioVista extends JFrame {
    // Barra de menú y menús

    JLabel lblbienvenida;
    JMenuBar menuBar;
    JMenu usuarioMenu, inventarioMenu, ventasMenu, reporteMenu, cerrarMenu;
    
    JMenuItem gestionUsuario;
    JMenuItem registrarProducto, gestionarInventario;
    JMenuItem registrarVenta, gestionarVentas, generarBoleta;
    JMenuItem reporteDia, reporteSemana, reporteMes;
    JMenuItem cerrarSesion;
    
    JPanel panelusuario;
    
    JTable tablaUsuario;
    DefaultTableModel modeloUsuario;
    
    
    JLabel lblusuario, lblnombre, lbltelefono, lblcontra;
    JTextField txtusuario, txtnombre, txttelefono, txtcontra;
    
    JButton btneliminar, btnactualizar;
    
    public gestionUsuarioVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        // -------Crear la barra de menú-------------
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(15, 33, 47));
       
        // ----------------Menú Usuario-------------
        usuarioMenu = new JMenu("    USUARIO    ");
        usuarioMenu.setForeground(Color.WHITE);
        usuarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
        gestionUsuario = new JMenuItem(" Gestionar Usuario  ");
        gestionUsuario.setFont(new Font("Arial", Font.BOLD, 17));
        usuarioMenu.add(gestionUsuario);

        // ---------------Menú Inventario-------------
        inventarioMenu = new JMenu("    INVENTARIO    ");
        inventarioMenu.setForeground(Color.WHITE);
        inventarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
        registrarProducto = new JMenuItem(" Registrar Producto  ");
        registrarProducto.setFont(new Font("Arial", Font.BOLD, 17));
        gestionarInventario = new JMenuItem(" Gestionar Inventario  ");
        gestionarInventario.setFont(new Font("Arial", Font.BOLD, 17));
        inventarioMenu.add(registrarProducto);
        inventarioMenu.add(gestionarInventario);

        // ----------------Menú Ventas------------
        ventasMenu = new JMenu("    VENTAS    ");
        ventasMenu.setForeground(Color.WHITE);
        ventasMenu.setFont(new Font("Arial", Font.BOLD, 20));
        registrarVenta = new JMenuItem(" Registrar Venta");
        registrarVenta.setFont(new Font("Arial", Font.BOLD, 17));
        gestionarVentas = new JMenuItem(" Gestionar Ventas");
        gestionarVentas.setFont(new Font("Arial", Font.BOLD, 17));
        generarBoleta = new JMenuItem(" Generar Boleta");
        generarBoleta.setFont(new Font("Arial", Font.BOLD, 17));
        ventasMenu.add(registrarVenta);
        ventasMenu.add(gestionarVentas);
        ventasMenu.add(generarBoleta);

        //--------------- Menú Reporte General---------------
        reporteMenu = new JMenu("    REPORTE GENERAL    ");
        reporteMenu.setForeground(Color.WHITE);
        reporteMenu.setFont(new Font("Arial", Font.BOLD, 20));
        reporteDia = new JMenuItem(" Reporte del Día");
        reporteDia.setFont(new Font("Arial", Font.BOLD, 17));
        reporteSemana = new JMenuItem(" Reporte de la Semana");
        reporteSemana.setFont(new Font("Arial", Font.BOLD, 17));
        reporteMes = new JMenuItem(" Reporte del Mes");
        reporteMes.setFont(new Font("Arial", Font.BOLD, 17));
        reporteMenu.add(reporteDia);
        reporteMenu.add(reporteSemana);
        reporteMenu.add(reporteMes);
        
        cerrarMenu = new JMenu("    CERRAR SESIÓN    ");
        cerrarMenu.setForeground(Color.WHITE);
        cerrarMenu.setFont(new Font("Arial", Font.BOLD, 20));
        cerrarSesion = new JMenuItem(" Cerrar   ");
        cerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
        cerrarMenu.add(cerrarSesion);

        // ----------Agregar los menús a la barra de menú----------
        menuBar.add(usuarioMenu);
        menuBar.add(inventarioMenu);
        menuBar.add(ventasMenu);
        menuBar.add(reporteMenu);
        menuBar.add(cerrarMenu);

        // Establecer la barra de menú en el JFrame
        setJMenuBar(menuBar);
        
        // ----------Imagenes parte arriba---------

        
        //-----------panel bienvenido----------
        panelusuario = new PanelDegradadoAzul3();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);
        
        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("GESTION DE USUARIO");
        lblbienvenida.setBounds(360,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);

        modeloUsuario = new DefaultTableModel(new String[]{"Nombre", "Teléfono", "Usuario", "Contraseña"}, 0);
        tablaUsuario = new JTable(modeloUsuario);

        
        tablaUsuario.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablaUsuario.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablaUsuario.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablaUsuario.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablaUsuario.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablaUsuario.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        JScrollPane scrollPane = new JScrollPane(tablaUsuario);
        scrollPane.setBounds(600, 140, 500, 340);
        panelusuario.add(scrollPane);
        
        modeloUsuario.addRow(new Object[]{"Richard Aguilar", "987654321", "RAguilar", "123"});
        modeloUsuario.addRow(new Object[]{"Anthony Ramos", "987123456", "ARamos", "456"});
        modeloUsuario.addRow(new Object[]{"Sebastias Tieno", "987654987", "STieno", "789"});
        modeloUsuario.addRow(new Object[]{"Eduar Siquita", "986543210", "ESiquita", "123"});

        btnactualizar = new JButton("Actualizar");
        btnactualizar.setBounds(80,340,140,40);
        panelusuario.add(btnactualizar);
       
        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(300,340,140,40);
        panelusuario.add(btneliminar);
        
        lblnombre= new JLabel("Nombre y Apellido");
        lblnombre.setBounds(25,160,200,30);
        lblnombre.setForeground(Color.WHITE);
        lblnombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panelusuario.add(lblnombre);
        
        txtnombre= new JTextField("");
        txtnombre.setBounds(220,160,250,30);
        panelusuario.add(txtnombre);
        
        lbltelefono= new JLabel("Telefono");
        lbltelefono.setBounds(25,200,200,30);
        lbltelefono.setForeground(Color.WHITE);
        lbltelefono.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panelusuario.add(lbltelefono);
        
        txttelefono= new JTextField("");
        txttelefono.setBounds(220,200,250,30);
        panelusuario.add(txttelefono);

        lblusuario= new JLabel("Usuario");
        lblusuario.setBounds(25,240,200,30);
        lblusuario.setForeground(Color.WHITE);
        lblusuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panelusuario.add(lblusuario);
        
        txtusuario= new JTextField("");
        txtusuario.setBounds(220,240,250,30);
        panelusuario.add(txtusuario);
        
        lblcontra= new JLabel("Contraseña");
        lblcontra.setBounds(25,280,200,30);
        lblcontra.setForeground(Color.WHITE);
        lblcontra.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panelusuario.add(lblcontra);
        
        txtcontra= new JTextField("");
        txtcontra.setBounds(220,280,250,30);
        panelusuario.add(txtcontra);
        /*
        ImageIcon imageIcon13 = new ImageIcon("logoempresacirculo.png");
        Image img13 = imageIcon13.getImage(); 
        Image newImg13 = img13.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 
        lblilogoempresa2 = new JLabel(new ImageIcon(newImg13));
        lblilogoempresa2.setBounds(440,260,200,200);  
        panelusuario.add(lblilogoempresa2);
*/
        
    }
    public JPanel getPanelusuario(){
        return panelusuario;
    }

    public static void main(String[] args) {
        gestionUsuarioVista ventana4 = new gestionUsuarioVista();
        ventana4.setVisible(true);
    }
}

class PanelDegradadoAzul3 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Colores y posiciones para el degradado de tres colores
        Color[] colores = {new Color(25, 43, 57), new Color(60, 78, 92), new Color(25, 43, 57)};
        float[] posiciones = {0.0f, 0.5f, 1.0f}; // Posiciones relativas de cada color

        // Crear el degradado horizontal de derecha a izquierda
        LinearGradientPaint gradiente = new LinearGradientPaint(getWidth(), 0, 0, 0, posiciones, colores);
        
        g2d.setPaint(gradiente);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

