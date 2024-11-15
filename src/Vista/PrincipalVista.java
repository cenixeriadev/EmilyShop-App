//PrincipalVista
/*
package Vista;

import java.awt.*;
import javax.swing.*;

public class PrincipalVista extends JFrame {
    // Barra de menú y menús
    JLabel lblimagennike, lblimagenadidas,lblimagenquelind,lblimagenpuma,lblimagenmarcas,  lblimagenreebok,lblilogoempresa2;
    JLabel lblbienvenida,lblmensaje1,lblmensaje6;
    JMenuBar menuBar;
    JMenu usuarioMenu, inventarioMenu, ventasMenu, reporteMenu, cerrarMenu;
    
    JMenuItem gestionUsuario;
    JMenuItem registrarProducto, gestionarInventario;
    JMenuItem registrarVenta, gestionarVentas, generarBoleta;
    JMenuItem reporteDia, reporteSemana, reporteMes;
    JMenuItem cerrarSesion;
    
    JPanel panelprincipal;

    public PrincipalVista() {
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
        ImageIcon imageIcon5 = new ImageIcon("nike.jpeg");
        Image img5 = imageIcon5.getImage(); 
        Image newImg5 = img5.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagennike = new JLabel(new ImageIcon(newImg5));
        lblimagennike.setBounds(0,0,190,70);  
        add(lblimagennike);
        
        ImageIcon imageIcon6 = new ImageIcon("adidas.jpeg");
        Image img6 = imageIcon6.getImage(); 
        Image newImg6 = img6.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagenadidas = new JLabel(new ImageIcon(newImg6));
        lblimagenadidas.setBounds(190,0,190,70);  
        add(lblimagenadidas);
        
        ImageIcon imageIcon7 = new ImageIcon("quelind.jpeg");
        Image img7 = imageIcon7.getImage(); 
        Image newImg7 = img7.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagenquelind = new JLabel(new ImageIcon(newImg7));
        lblimagenquelind.setBounds(380,0,190,70);  
        add(lblimagenquelind);
        
        ImageIcon imageIcon8 = new ImageIcon("puma.jpeg");
        Image img8 = imageIcon8.getImage(); 
        Image newImg8 = img8.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagenpuma = new JLabel(new ImageIcon(newImg8));
        lblimagenpuma.setBounds(570,0,190,70);  
        add(lblimagenpuma);
        
        ImageIcon imageIcon10 = new ImageIcon("reebok.jpeg");
        Image img10 = imageIcon10.getImage(); 
        Image newImg10 = img10.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagenreebok = new JLabel(new ImageIcon(newImg10));
        lblimagenreebok.setBounds(760,0,190,70);  
        add(lblimagenreebok);
        
        ImageIcon imageIcon11 = new ImageIcon("irun.jpeg");
        Image img11 = imageIcon11.getImage(); 
        Image newImg11 = img11.getScaledInstance(190, 70, Image.SCALE_SMOOTH); 
        lblimagenreebok = new JLabel(new ImageIcon(newImg11));
        lblimagenreebok.setBounds(950,0,190,70);  
        add(lblimagenreebok);
        
        //---------------Imagenes parte abajo---------------
        ImageIcon imageIcon9 = new ImageIcon("marcas.jpeg");
        Image img9 = imageIcon9.getImage(); 
        Image newImg9 = img9.getScaledInstance(760, 190, Image.SCALE_SMOOTH); 
        lblimagenmarcas = new JLabel(new ImageIcon(newImg9));
        lblimagenmarcas.setBounds(0,580,760,190);  
        add(lblimagenmarcas);
        
        ImageIcon imageIcon12 = new ImageIcon("marcas2.jpeg");
        Image img12 = imageIcon12.getImage(); 
        Image newImg12 = img12.getScaledInstance(380, 190, Image.SCALE_SMOOTH); 
        lblimagenmarcas = new JLabel(new ImageIcon(newImg12));
        lblimagenmarcas.setBounds(760,580,380,190);  
        add(lblimagenmarcas);
        
        //-----------panel bienvenido----------
        panelprincipal = new PanelConImagenFondo4("nuevofondo4.jpeg");
        panelprincipal.setBounds(0,70,1140,540);
        //panel2.setBackground(new Color(240, 240, 240));
        panelprincipal.setLayout(null);
        add(panelprincipal);

        
        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("BIENVENIDO \n USUARIO");
        lblbienvenida.setBounds(290,150,580,60);
        lblbienvenida.setForeground(Color.LIGHT_GRAY); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 45)); // Estilo de fuente
        panelprincipal.add(lblbienvenida);
        
        lblmensaje1= new JLabel("Seleccione la opcion que desea realizar");
        lblmensaje1.setBounds(390,160,580,150);
        lblmensaje1.setForeground(Color.LIGHT_GRAY); // Color del texto
        lblmensaje1.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Estilo de fuente
        panelprincipal.add(lblmensaje1);
        
        lblmensaje6= new JLabel("Calzados Emily´s");
        lblmensaje6.setBounds(480,470,300,30);
        lblmensaje6.setForeground(Color.LIGHT_GRAY); // Color del texto
        lblmensaje6.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Estilo de fuente
        panelprincipal.add(lblmensaje6);
       
        ImageIcon imageIcon13 = new ImageIcon("nuevologo.png");
        Image img13 = imageIcon13.getImage(); 
        Image newImg13 = img13.getScaledInstance(230, 230, Image.SCALE_SMOOTH); 
        lblilogoempresa2 = new JLabel(new ImageIcon(newImg13));
        lblilogoempresa2.setBounds(430,260,230,230);  
        panelprincipal.add(lblilogoempresa2);
    }

    public static void main(String[] args) {
        PrincipalVista ventana3 = new PrincipalVista();
        ventana3.setVisible(true);
    }
}

//Clase para establecer una imagen de fondo en el panel

class PanelConImagenFondo4 extends JPanel {
    private Image imagenFondo;

    public PanelConImagenFondo4(String rutaImagen) {
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}


*/
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrincipalVista extends JFrame {
    // Barra de menú y menús
    JLabel lblimagennike, lblimagenadidas, lblimagenquelind, lblimagenpuma, lblimagenmarcas, lblimagenreebok,lblimagenirun, lblilogoempresa2;
    JLabel lblbienvenida, lblmensaje1, lblmensaje6;
    JMenuBar menuBar;
    JMenu usuarioMenu, inventarioMenu, ventasMenu, reporteMenu, cerrarMenu;

    JMenuItem gestionUsuario;
    JMenuItem registrarProducto, gestionarInventario;
    JMenuItem registrarVenta, gestionarVentas, generarBoleta;
    JMenuItem reporteDia, reporteSemana, reporteMes;
    JMenuItem cerrarSesion;

    JPanel panelprincipal;

    public PrincipalVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        // -------Crear la barra de menú-------------
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(15, 33, 47));

        // Menú Usuario
        usuarioMenu = new JMenu("    USUARIO    ");
        usuarioMenu.setForeground(Color.WHITE);
        usuarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
        gestionUsuario = new JMenuItem("Gestionar Usuario");
        gestionUsuario.setFont(new Font("Arial", Font.BOLD, 17));
        usuarioMenu.add(gestionUsuario);

        // Menú Inventario
        inventarioMenu = new JMenu("    INVENTARIO    ");
        inventarioMenu.setForeground(Color.WHITE);
        inventarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
        registrarProducto = new JMenuItem(" Registrar Producto  ");
        registrarProducto.setFont(new Font("Arial", Font.BOLD, 17));
        gestionarInventario = new JMenuItem(" Gestionar Inventario  ");
        gestionarInventario.setFont(new Font("Arial", Font.BOLD, 17));
        inventarioMenu.add(registrarProducto);
        inventarioMenu.add(gestionarInventario);

        // Menú Ventas
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

        // Menú Reporte General
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

        // Agregar los menús a la barra de menú
        menuBar.add(usuarioMenu);
        menuBar.add(inventarioMenu);
        menuBar.add(ventasMenu);
        menuBar.add(reporteMenu);
        menuBar.add(cerrarMenu);
        setJMenuBar(menuBar);

        // Imágenes superiores
        lblimagennike = createImageLabel("src/Recursos/nike.jpeg", 190, 70, 0, 0);
        lblimagenadidas = createImageLabel("src/Recursos/adidas.jpeg", 190, 70, 190, 0);
        lblimagenquelind = createImageLabel("src/Recursos/quelind.jpeg", 190, 70, 380, 0);
        lblimagenpuma = createImageLabel("src/Recursos/puma.jpeg", 190, 70, 570, 0);
        lblimagenreebok = createImageLabel("src/Recursos/reebok.jpeg", 190, 70, 760, 0);
        lblimagenirun = createImageLabel("src/Recursos/irun.jpeg", 190, 70, 950, 0);

        add(lblimagennike);
        add(lblimagenadidas);
        add(lblimagenquelind);
        add(lblimagenpuma);
        add(lblimagenreebok);
        add(lblimagenirun);

        // Imágenes inferiores
        lblimagenmarcas = createImageLabel("src/Recursos/marcas.jpeg", 760, 190, 0, 580);
        JLabel lblimagenmarcas2 = createImageLabel("src/Recursos/marcas2.jpeg", 380, 190, 760, 580);

        add(lblimagenmarcas);
        add(lblimagenmarcas2);

        // Panel principal con imagen de fondo
        panelprincipal = new JPanel() {
            private final Image imagenFondo = new ImageIcon("src/Recursos/nuevofondo5.jpeg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelprincipal.setBounds(0, 70, 1140, 540);
        panelprincipal.setLayout(null);
        add(panelprincipal);

        // Componentes del panel principal
        lblbienvenida = createLabel("BIENVENIDO \n USUARIO", 290, 150, 580, 60, Color.LIGHT_GRAY, 45);
        lblmensaje1 = createLabel("Seleccione la opción que desea realizar", 390, 160, 580, 150, Color.LIGHT_GRAY, 20);
        lblmensaje6 = createLabel("Calzados Emily´s", 480, 470, 300, 30, Color.LIGHT_GRAY, 16);
        lblilogoempresa2 = createImageLabel("src/Recursos/nuevologo.png", 230, 230, 430, 260);

        panelprincipal.add(lblbienvenida);
        panelprincipal.add(lblmensaje1);
        panelprincipal.add(lblmensaje6);
        panelprincipal.add(lblilogoempresa2);
    }
    public JMenuItem getRegistrarProducto(){
        return registrarProducto;
    }
    public JMenuItem getGestionarInventario(){
        return gestionarInventario;
    }
    public JMenuItem getRegistrarVenta(){
        return registrarVenta;
    }
    public JMenuItem getGenerarBoleta(){
        return generarBoleta;
    }
    public JMenuItem getGestionarVentas(){
        return gestionarVentas;
    }
    public JMenuItem getReporteDia(){
        return reporteDia;
    }
    public JMenuItem getReporteSemana(){
        return reporteSemana;
    }
    public JMenuItem getReporteMes(){
        return reporteMes;
    }
    public JMenuItem getCerrarSesion(){
        return cerrarSesion;
    }
    public JMenuItem getGestionUsuario(){
        return gestionUsuario;
    }
    public JPanel getPanelprincipal(){
        return panelprincipal;
    }
    // Método auxiliar para crear JLabels de imágenes
    private JLabel createImageLabel(String imagePath, int width, int height, int x, int y) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(x, y, width, height);
        return label;
    }

    // Método auxiliar para crear JLabels de texto
    private JLabel createLabel(String text, int x, int y, int width, int height, Color color, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(color);
        label.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
        return label;
    }

    public static void main(String[] args) {
        PrincipalVista ventana3 = new PrincipalVista();
        ventana3.setVisible(true);
    }

}
