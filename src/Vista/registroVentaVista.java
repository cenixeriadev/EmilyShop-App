
package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class registroVentaVista extends JFrame {

    // Barra de menú y menús
    JLabel lblimagennike, lblimagenadidas,lblimagenquelind,lblimagenpuma,lblimagenmarcas,  lblimagenreebok,lblilogoempresa2,lblboton;
    JLabel lblbienvenida, lblbuscar, lblcodigo2;

    
    JPanel panelregistroventas;
    
    JComboBox cbbcolor, cbbtallas, cbbmetodo;
    
    JTable tablaInventario,tablacarrito;
    DefaultTableModel modeloInventario,modelocarrito;
    
    JLabel lblmetodo, lblcarrito, lblventa, lbltalla, lblcolor,lblcliente,lblprecio,lbltelefono;
    JTextField txtmetodo, txtcodigo, txtcosto,txtcliente, txttalla, txtcolor,txtcodigo2,txtprecio,txttelefono;
    
    JButton btnregistrar,btnbuscar,btnadd,btnBoleta,btneliminar;
    
    public registroVentaVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        // -------Crear la barra de menú-------------
       
        // ----------------Menú Usuario-------------


        // Establecer la barra de menú en el JFrame
        
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
        
        //-----------panel ventas----------
        panelregistroventas = new PanelDegradadoAzul8();
        panelregistroventas.setBounds(0,70,1140,540);
        panelregistroventas.setLayout(null);
        add(panelregistroventas);
        
        //------------dentro de panel ventas----------
        lblbienvenida= new JLabel("REGISTRO DE VENTA");
        lblbienvenida.setBounds(355,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelregistroventas.add(lblbienvenida);
        
        
        lblcliente=new JLabel("Cliente:");
        lblcliente.setForeground(Color.WHITE);
        lblcliente.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcliente.setBounds(65,140,140,30);
        panelregistroventas.add(lblcliente);
        
        txtcliente=new JTextField("");
        txtcliente.setBounds(185,140,200,30);
        panelregistroventas.add(txtcliente);
        
        lbltelefono=new JLabel("Telefono:");
        lbltelefono.setForeground(Color.WHITE);
        lbltelefono.setFont(new Font("Times New Roman", Font.BOLD,20));
        lbltelefono.setBounds(65,180,140,30);
        panelregistroventas.add(lbltelefono);
        
        txttelefono=new JTextField("");
        txttelefono.setBounds(185,180,200,30);
        panelregistroventas.add(txttelefono);
        
        lblmetodo=new JLabel("M. de Pago:");
        lblmetodo.setForeground(Color.WHITE);
        lblmetodo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblmetodo.setBounds(65,220,140,30);
        panelregistroventas.add(lblmetodo);
        
        cbbmetodo = new JComboBox<>(new String[]{"  Seleccione metodo",  "  Yape", "  IZIPAY", "  Plin", "  Efectivo","  Transferencia"});
        cbbmetodo.setBounds(185, 220, 200, 30);
        panelregistroventas.add(cbbmetodo);
        
       
        lblcarrito=new JLabel("TOTAL DE PRODUCTOS EN CARRITO");
        lblcarrito.setForeground(Color.WHITE);
        lblcarrito.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcarrito.setBounds(65,310,400,30);
        panelregistroventas.add(lblcarrito);
        
        // --------------tabla carrito--------------
        
        modelocarrito = new DefaultTableModel(new String[]{"Modelo", "Codigo", "Talla", "Color","Precio","M. Pago","Telefono"}, 0);
        tablacarrito = new JTable(modelocarrito);

        
        tablacarrito.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablacarrito.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablacarrito.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablacarrito.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablacarrito.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablacarrito.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        JScrollPane scrollPane = new JScrollPane(tablacarrito);
        scrollPane.setBounds(30, 360, 600, 200);
        panelregistroventas.add(scrollPane);
        
        modelocarrito.addRow(new Object[]{"Nike", "101", "40", "Blanco","90","yape","955151725"});
        modelocarrito.addRow(new Object[]{"Adidas", "301", "37", "Negro","115","plin","564812145"});
        modelocarrito.addRow(new Object[]{"Puma", "201", "38", "Plomo","160","efectivo"});
        modelocarrito.addRow(new Object[]{"Nike", "101", "41", "Blanco-Negro","135","yape"});
        modelocarrito.addRow(new Object[]{"Quelind", "401", "36", "Rosado","120","plin"});
        
        btnregistrar = new JButton("Registrar Venta");
        btnregistrar.setBounds(450,260,140,35);
        panelregistroventas.add(btnregistrar);
        
        btneliminar= new JButton("Eliminar Producto");
        btneliminar.setBounds(450,305,140,35);
        panelregistroventas.add(btneliminar);
        
        // ----- busqueda de producto----------
        lblbuscar=new JLabel("BUSCAR DISPONIBILIDAD DE PRODUCTO");
        lblbuscar.setBounds(700,120,500,40);
        lblbuscar.setForeground(Color.WHITE);
        lblbuscar.setFont(new Font("Times new roman", Font.BOLD, 20));
        panelregistroventas.add(lblbuscar);
        
        cbbcolor = new JComboBox<>(new String[]{"  Seleccione un Color",  "  Blanco", "  Azul", "  Negro", "  Rosado","  Plomo", "  Negro-Blanco", "  Blanco-Negro", "  Beige"});
        cbbcolor.setBounds(700, 210, 170, 30);
        panelregistroventas.add(cbbcolor);
        
        cbbtallas = new JComboBox<>(new String[]{"  Seleccione una Talla",  "  35", "  36", "  37", "  38","  39", "  40", "  41", "  42"});
        cbbtallas.setBounds(700, 250, 170, 30);
        panelregistroventas.add(cbbtallas);
        
        lblcodigo2=new JLabel("Codigo:");
        lblcodigo2.setForeground(Color.WHITE);
        lblcodigo2.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcodigo2.setBounds(700,170,150,30);
        panelregistroventas.add(lblcodigo2);
        
        txtcodigo2= new JTextField();
        txtcodigo2.setBounds(770,170,100,30);
        panelregistroventas.add(txtcodigo2);
        
        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(920,180,150,40);
        panelregistroventas.add(btnbuscar);
            
        
        // -----------Boton Boleta------------
        
        ImageIcon imageIcon14 = new ImageIcon("src/Recursos/carrito2.png");
        Image img14 = imageIcon14.getImage();
        Image newImg14 = img14.getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        JButton btnBoleta = new JButton(new ImageIcon(newImg14));
        btnBoleta.setBounds(450, 130, 140, 120);  
        //btnBoleta.setBorderPainted(false);  // Quita el borde del botón
       //btnBoleta.setContentAreaFilled(false);  // Quita el fondo del botón
        panelregistroventas.add(btnBoleta);

        
        // --------------tabla buscar producto--------------
        modeloInventario = new DefaultTableModel(new String[]{"Modelo", "Codigo", "Talla", "Color"}, 0);
        tablaInventario = new JTable(modeloInventario);

        
        tablaInventario.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablaInventario.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablaInventario.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablaInventario.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablaInventario.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablaInventario.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        JScrollPane scrollPane2 = new JScrollPane(tablaInventario);
        scrollPane2.setBounds(700, 290, 400, 240);
        panelregistroventas.add(scrollPane2);
        
        modeloInventario.addRow(new Object[]{"Nike", "101", "40", "Blanco"});
        modeloInventario.addRow(new Object[]{"Adidas", "301", "37", "Negro"});
        modeloInventario.addRow(new Object[]{"Puma", "201", "38", "Plomo","60"});
        modeloInventario.addRow(new Object[]{"Nike", "101", "41", "Blanco-Negro"});
        modeloInventario.addRow(new Object[]{"Quelind", "401", "36", "Rosado"});
        
        
       
    }
    public JPanel getPanelregistroventas(){
        return panelregistroventas;
    }

    public static void main(String[] args) {
        registroVentaVista ventana5= new registroVentaVista();
        ventana5.setVisible(true);
    }
}

class PanelDegradadoAzul8 extends JPanel {
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

   
