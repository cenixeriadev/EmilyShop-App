package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class gestioninventarioVista extends JFrame {
    // Barra de menú y menús
    JLabel lblimagennike, lblimagenadidas,lblimagenquelind,lblimagenpuma,lblimagenmarcas,  lblimagenreebok,lblilogoempresa2;
    JLabel lblbienvenida,lblmensaje1,lblmensaje6;
//    JMenuBar menuBar;
//    JMenu usuarioMenu, inventarioMenu, ventasMenu, reporteMenu, cerrarMenu;
//
//    JMenuItem gestionUsuario;
//    JMenuItem registrarProducto, gestionarInventario;
//    JMenuItem registrarVenta, gestionarVentas, generarBoleta;
//    JMenuItem reporteDia, reporteSemana, reporteMes;
//    JMenuItem cerrarSesion;
    
    JPanel panelusuario;
    
    JTable tablaInventario;
    DefaultTableModel modeloInventario;
    
    JLabel lblmodelo, lblcodigo, lblcosto, lbltalla, lblcolor;
    JTextField txtmodelo, txtcodigo, txtcosto, txttalla, txtcolor;
    
    JButton btneliminar, btnactualizar;
    
    public gestioninventarioVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        // -------Crear la barra de menú-------------
//        menuBar = new JMenuBar();
//        menuBar.setBackground(new Color(15, 33, 47));
       
        // ----------------Menú Usuario-------------
//        usuarioMenu = new JMenu("    USUARIO    ");
//        usuarioMenu.setForeground(Color.WHITE);
//        usuarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
//        gestionUsuario = new JMenuItem(" Gestionar Usuario  ");
//        gestionUsuario.setFont(new Font("Arial", Font.BOLD, 17));
//        usuarioMenu.add(gestionUsuario);
//
//        // ---------------Menú Inventario-------------
//        inventarioMenu = new JMenu("    INVENTARIO    ");
//        inventarioMenu.setForeground(Color.WHITE);
//        inventarioMenu.setFont(new Font("Arial", Font.BOLD, 20));
//        registrarProducto = new JMenuItem(" Registrar Producto  ");
//        registrarProducto.setFont(new Font("Arial", Font.BOLD, 17));
//        gestionarInventario = new JMenuItem(" Gestionar Inventario  ");
//        gestionarInventario.setFont(new Font("Arial", Font.BOLD, 17));
//        inventarioMenu.add(registrarProducto);
//        inventarioMenu.add(gestionarInventario);
//
//        // ----------------Menú Ventas------------
//        ventasMenu = new JMenu("    VENTAS    ");
//        ventasMenu.setForeground(Color.WHITE);
//        ventasMenu.setFont(new Font("Arial", Font.BOLD, 20));
//        registrarVenta = new JMenuItem(" Registrar Venta");
//        registrarVenta.setFont(new Font("Arial", Font.BOLD, 17));
//        gestionarVentas = new JMenuItem(" Gestionar Ventas");
//        gestionarVentas.setFont(new Font("Arial", Font.BOLD, 17));
//        generarBoleta = new JMenuItem(" Generar Boleta");
//        generarBoleta.setFont(new Font("Arial", Font.BOLD, 17));
//        ventasMenu.add(registrarVenta);
//        ventasMenu.add(gestionarVentas);
//        ventasMenu.add(generarBoleta);
//
//        //--------------- Menú Reporte General---------------
//        reporteMenu = new JMenu("    REPORTE GENERAL    ");
//        reporteMenu.setForeground(Color.WHITE);
//        reporteMenu.setFont(new Font("Arial", Font.BOLD, 20));
//        reporteDia = new JMenuItem(" Reporte del Día");
//        reporteDia.setFont(new Font("Arial", Font.BOLD, 17));
//        reporteSemana = new JMenuItem(" Reporte de la Semana");
//        reporteSemana.setFont(new Font("Arial", Font.BOLD, 17));
//        reporteMes = new JMenuItem(" Reporte del Mes");
//        reporteMes.setFont(new Font("Arial", Font.BOLD, 17));
//        reporteMenu.add(reporteDia);
//        reporteMenu.add(reporteSemana);
//        reporteMenu.add(reporteMes);
//
//        cerrarMenu = new JMenu("    CERRAR SESIÓN    ");
//        cerrarMenu.setForeground(Color.WHITE);
//        cerrarMenu.setFont(new Font("Arial", Font.BOLD, 20));
//        cerrarSesion = new JMenuItem(" Cerrar   ");
//        cerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
//        cerrarMenu.add(cerrarSesion);
//
//        // ----------Agregar los menús a la barra de menú----------
//        menuBar.add(usuarioMenu);
//        menuBar.add(inventarioMenu);
//        menuBar.add(ventasMenu);
//        menuBar.add(reporteMenu);
//        menuBar.add(cerrarMenu);

        // Establecer la barra de menú en el JFrame
//        setJMenuBar(menuBar);
        
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
        panelusuario = new PanelDegradadoAzul6();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);
        
        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("GESTION DE INVENTARIO");
        lblbienvenida.setBounds(360,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);

        modeloInventario = new DefaultTableModel(new String[]{"Modelo", "Codigo", "Talla", "Color","P. Costo"}, 0);
        tablaInventario = new JTable(modeloInventario);

        
        tablaInventario.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablaInventario.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablaInventario.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablaInventario.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablaInventario.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablaInventario.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        scrollPane.setBounds(600, 140, 500, 340);
        panelusuario.add(scrollPane);
        
        modeloInventario.addRow(new Object[]{"Nike", "101", "40", "Blanco","90"});
        modeloInventario.addRow(new Object[]{"Adidas", "301", "37", "Negro","75"});
        modeloInventario.addRow(new Object[]{"Puma", "201", "38", "Plomo","60"});
        modeloInventario.addRow(new Object[]{"Nike", "101", "41", "Blanco-Negro","160"});
        modeloInventario.addRow(new Object[]{"Quelind", "401", "36", "Rosado","95"});

        lblmodelo=new JLabel("Modelo");
        lblmodelo.setForeground(Color.WHITE);
        lblmodelo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblmodelo.setBounds(115,140,140,30);
        panelusuario.add(lblmodelo);
        
        txtmodelo= new JTextField();
        txtmodelo.setBounds(215,140,200,30);
        panelusuario.add(txtmodelo);
        
        lblcodigo=new JLabel("Codigo");
        lblcodigo.setForeground(Color.WHITE);
        lblcodigo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcodigo.setBounds(115,180,140,30);
        panelusuario.add(lblcodigo);
        
        txtcodigo= new JTextField();
        txtcodigo.setBounds(215,180,200,30);
        panelusuario.add(txtcodigo);
        
        lbltalla= new JLabel("Talla");
        lbltalla.setForeground(Color.WHITE);
        lbltalla.setFont(new Font("Times New Roman", Font.BOLD,20));
        lbltalla.setBounds(115,220,140,30);
        panelusuario.add(lbltalla);
        
        txttalla= new JTextField();
        txttalla.setBounds(215,220,200,30);
        panelusuario.add(txttalla);

        
        lblcolor= new JLabel("Color");
        lblcolor.setForeground(Color.WHITE);
        lblcolor.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcolor.setBounds(115,260,140,30);
        panelusuario.add(lblcolor);
        
        txtcolor= new JTextField();
        txtcolor.setBounds(215,260,200,30);
        panelusuario.add(txtcolor);

        lblcosto=new JLabel("P. Costo");
        lblcosto.setForeground(Color.WHITE);
        lblcosto.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcosto.setBounds(115,300,140,30);
        panelusuario.add(lblcosto);
        
        txtcosto= new JTextField();
        txtcosto.setBounds(215,300,200,30);
        panelusuario.add(txtcosto);
        
        btnactualizar = new JButton("Actualizar");
        btnactualizar.setBounds(80,360,140,40);
        panelusuario.add(btnactualizar);
       
        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(300,360,140,40);
        panelusuario.add(btneliminar);
        
        /*
        ImageIcon imageIcon13 = new ImageIcon("logoempresacirculo.png");
        Image img13 = imageIcon13.getImage(); 
        Image newImg13 = img13.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 
        lblilogoempresa2 = new JLabel(new ImageIcon(newImg13));
        lblilogoempresa2.setBounds(440,260,200,200);  
        panelusuario.add(lblilogoempresa2);
*/
        
    }
    public JPanel getPanelInventario(){
        return panelusuario;
    }

    public static void main(String[] args) {
        gestioninventarioVista ventana4 = new gestioninventarioVista();
        ventana4.setVisible(true);
    }
}

class PanelDegradadoAzul6 extends JPanel {
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

