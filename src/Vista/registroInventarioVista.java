
package Vista;

import javax.swing.*;
import java.awt.*;

public class registroInventarioVista extends JFrame{

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
    
    JPanel panelusuario;
    
    JComboBox<String> cbbtalla, cbbcolor;
    
    JLabel lblmodelo, lblcodigo, lblcosto, lbltalla, lblcolor;
    JTextField txtmodelo, txtcodigo, txtcosto;
    
    JButton btnregistrar;
    
    public registroInventarioVista() {
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
        panelusuario = new PanelDegradadoAzul5();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);
        
        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("REGISTRO DE INVENTARIO");
        lblbienvenida.setBounds(355,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);
        
        lblmodelo=new JLabel("Modelo");
        lblmodelo.setForeground(Color.WHITE);
        lblmodelo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblmodelo.setBounds(415,140,140,30);
        panelusuario.add(lblmodelo);
        
        txtmodelo= new JTextField();
        txtmodelo.setBounds(515,140,200,30);
        panelusuario.add(txtmodelo);
        
        lblcodigo=new JLabel("Codigo");
        lblcodigo.setForeground(Color.WHITE);
        lblcodigo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcodigo.setBounds(415,180,140,30);
        panelusuario.add(lblcodigo);
        
        txtcodigo= new JTextField();
        txtcodigo.setBounds(515,180,200,30);
        panelusuario.add(txtcodigo);
        
        lbltalla= new JLabel("Talla");
        lbltalla.setForeground(Color.WHITE);
        lbltalla.setFont(new Font("Times New Roman", Font.BOLD,20));
        lbltalla.setBounds(415,220,140,30);
        panelusuario.add(lbltalla);
        
        cbbtalla = new JComboBox<>(new String[]{"  Seleccione una Talla",  "  35", "  36", "  37", "  38","  39", "  40", "  41", "  42"});
        cbbtalla.setBounds(515, 220, 200, 30);
        panelusuario.add(cbbtalla);
        
        lblcolor= new JLabel("Color");
        lblcolor.setForeground(Color.WHITE);
        lblcolor.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcolor.setBounds(415,260,140,30);
        panelusuario.add(lblcolor);
        
        cbbcolor = new JComboBox<>(new String[]{"  Seleccione un Color",  "  Blanco", "  Azul", "  Negro", "  Rosado","  Plomo", "  Negro-Blanco", "  Blanco-Negro", "  Beige"});
        cbbcolor.setBounds(515, 260, 200, 30);
        panelusuario.add(cbbcolor);
        
        lblcosto=new JLabel("P. Costo");
        lblcosto.setForeground(Color.WHITE);
        lblcosto.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcosto.setBounds(415,300,140,30);
        panelusuario.add(lblcosto);
        
        txtcodigo= new JTextField();
        txtcodigo.setBounds(515,300,200,30);
        panelusuario.add(txtcodigo);

        btnregistrar = new JButton("Registrar");
        btnregistrar.setBounds(490,360,140,40);
        panelusuario.add(btnregistrar);

       
    }
    public JPanel getPanelusuario(){
        return panelusuario;
    }

    public static void main(String[] args) {
        registroInventarioVista ventana5= new registroInventarioVista();
        ventana5.setVisible(true);
    }
}

class PanelDegradadoAzul5 extends JPanel {
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

   
