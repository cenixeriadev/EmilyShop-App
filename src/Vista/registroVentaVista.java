
package Vista;

import Utilitario.PanelDegradadoAzul;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class registroVentaVista extends JFrame {

    // Barra de menú y menús
    JLabel lblbienvenida, lblbuscar, lblcodigo2 ,lblprecioventa;

    
    JPanel panelregistroventas;
    
    JComboBox<String> cbbcolor, cbbtallas, cbbmetodo;
    
    JTable tablaInventario,tablacarrito;
    DefaultTableModel modeloInventario,modelocarrito;
    
    JLabel lblmetodo, lblcarrito,lblcliente,lbltelefono;
    JTextField txtcliente,txtcodigo2,txttelefono , txtprecioventa;
    
    JButton btnregistrar,btnbuscar,btneliminar ,btnCarrito;
    
    public registroVentaVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        

        //-----------panel ventas----------
        panelregistroventas = new PanelDegradadoAzul();
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

        lblprecioventa = new JLabel("P. de venta:  ");
        lblprecioventa.setForeground(Color.WHITE);
        lblprecioventa.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblprecioventa.setBounds(65,220,200,30);
        panelregistroventas.add(lblprecioventa);

        txtprecioventa = new JTextField("");
        txtprecioventa.setBounds(185,220,200,30);
        panelregistroventas.add(txtprecioventa);
        
        lblmetodo=new JLabel("M. de Pago:");
        lblmetodo.setForeground(Color.WHITE);
        lblmetodo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblmetodo.setBounds(65,260,140,30);
        panelregistroventas.add(lblmetodo);
        
        cbbmetodo = new JComboBox<>(new String[]{"Seleccione metodo",  "Yape", "IZIPAY", "Plin", "Efectivo","Transferencia"});
        cbbmetodo.setBounds(185, 260, 200, 30);
        panelregistroventas.add(cbbmetodo);
        
       
        lblcarrito=new JLabel("TOTAL DE PRODUCTOS EN CARRITO");
        lblcarrito.setForeground(Color.WHITE);
        lblcarrito.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcarrito.setBounds(65,310,400,30);
        panelregistroventas.add(lblcarrito);
        
        // --------------tabla carrito--------------
        
        modelocarrito = new DefaultTableModel(new String[]{"Modelo", "Codigo", "Talla", "Color","Precio","M. Pago","Telefono"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablacarrito = new JTable(modelocarrito);

        
        tablacarrito.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablacarrito.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablacarrito.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablacarrito.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablacarrito.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablacarrito.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tablacarrito.getTableHeader().setReorderingAllowed(false);
        tablacarrito.getTableHeader().setEnabled(false);
        
        JScrollPane scrollPane = new JScrollPane(tablacarrito);
        scrollPane.setBounds(30, 360, 600, 200);
        panelregistroventas.add(scrollPane);
        
        // ----- busqueda de producto----------
        lblbuscar=new JLabel("BUSCAR DISPONIBILIDAD DE PRODUCTO");
        lblbuscar.setBounds(700,120,500,40);
        lblbuscar.setForeground(Color.WHITE);
        lblbuscar.setFont(new Font("Times new roman", Font.BOLD, 20));
        panelregistroventas.add(lblbuscar);
        
        cbbcolor = new JComboBox<>(new String[]{"Seleccionar un color",  "Blanco", "Azul", "Negro", "Rosado","Plomo", "Negro-Blanco", "Blanco-Negro", "Beige"});
        cbbcolor.setBounds(700, 210, 170, 30);
        panelregistroventas.add(cbbcolor);
        
        cbbtallas = new JComboBox<>(new String[]{"Seleccionar una talla",  "35", "36", "37", "38","39", "40", "41", "42"});
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
            
        
        // -----------Boton Boleta------------

        btnbuscar = crearBotonPersonalizado("Buscar", "src/Recursos/buscar.png");
        btnbuscar.setBounds(920,180,150,40); // Ajustar posición y tamaño
        panelregistroventas.add(btnbuscar);

        btnCarrito = crearBotonPersonalizado("Añadir al carrito", "src/Recursos/carrito.png");
        btnCarrito.setBounds(440, 140, 200, 50); // Ajustar posición y tamaño
        panelregistroventas.add(btnCarrito);

        btnregistrar = crearBotonPersonalizado("Registrar", "src/Recursos/registrar.png");
        btnregistrar.setBounds(440, 200, 200, 50); // Ajustar posición y tamaño
        panelregistroventas.add(btnregistrar);

        btneliminar = crearBotonPersonalizado("Eliminar", "src/Recursos/tachito.png");
        btneliminar.setBounds(440, 260, 200, 50); // Ajustar posición y tamaño
        panelregistroventas.add(btneliminar);

        
        // --------------tabla buscar producto--------------
        modeloInventario = new DefaultTableModel(new String[]{"Modelo", "Codigo", "Talla", "Color"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaInventario = new JTable(modeloInventario);

        
        tablaInventario.setBackground( new Color(255, 182, 193)); // Fondo rosa claro
        tablaInventario.setSelectionBackground(new Color(219, 112, 147)); // Fondo palo rosa para fila seleccionada
        tablaInventario.setSelectionForeground(Color.WHITE); // Texto azul marino para fila seleccionada
        //Configuración del encabezado de la tabla
        tablaInventario.getTableHeader().setBackground(new Color(25, 43, 57)); // Azul marino
        tablaInventario.getTableHeader().setForeground(Color.WHITE); // Color de texto blanco
        tablaInventario.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tablaInventario.getTableHeader().setReorderingAllowed(false);
        tablaInventario.getTableHeader().setEnabled(false);
        
        JScrollPane scrollPane2 = new JScrollPane(tablaInventario);
        scrollPane2.setBounds(700, 290, 400, 240);
        panelregistroventas.add(scrollPane2);

        
        
       
    }
    public JPanel getPanelregistroventas(){
        return panelregistroventas;
    }
    public JButton getBtnregistrar(){
        return btnregistrar;
    }
    public JButton getBtneliminar(){
        return btneliminar;
    }
    public JButton getBtnCarrito(){
        return btnCarrito;
    }
    public JComboBox<String> getCbbcolor(){
        return cbbcolor;
    }
    public JComboBox<String> getCbbtallas(){
        return cbbtallas;
    }
    public JButton getBtnbuscar(){
        return btnbuscar;
    }
    public JTable getTablacarrito(){
        return tablacarrito;
    }
    public JTable getTablaInventario(){
        return tablaInventario;
    }
    public DefaultTableModel getModeloInventario(){
        return modeloInventario;
    }
    public DefaultTableModel getModelocarrito(){
        return modelocarrito;
    }
    public JTextField getTxtcodigo2(){
        return txtcodigo2;
    }
    public JTextField getTxttelefono(){
        return txttelefono;
    }
    public JTextField getTxtcliente(){
        return txtcliente;
    }
    public JComboBox<String> getCbbmetodo(){
        return cbbmetodo;
    }
    public JTextField getTxtprecioventa(){return txtprecioventa;}
    public JComboBox<String> getTalla(){return cbbtallas;}
    public JComboBox<String> getColor(){return cbbcolor;}
    private JButton crearBotonPersonalizado(String texto, String icono) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Cambiar color según el estado (presionado o no)
                g2d.setColor(getModel().isPressed() ? new Color(200, 200, 200) : new Color(35, 53, 67));//255, 182, 193
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

                // Dibujar borde redondeado
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 50, 50);

                super.paintComponent(g);
            }
        };

        // Configuración básica del botón
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setForeground(Color.WHITE);
        boton.setContentAreaFilled(false); // Evitar fondo estándar del botón
        boton.setFocusPainted(false);      // Quitar efecto de foco
        boton.setBorderPainted(false);    // Quitar borde predeterminado

        // Configurar icono si se proporciona
        if (icono != null) {
            ImageIcon iconoOriginal = new ImageIcon(icono);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(imagenEscalada));
            boton.setHorizontalTextPosition(SwingConstants.RIGHT);
            boton.setVerticalTextPosition(SwingConstants.CENTER);
        }

        return boton;
    }

}

   
