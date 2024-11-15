package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class gestioninventarioVista extends JFrame {
    // Barra de menú y menús
    JLabel lblbienvenida;
    
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
        

        
    }
    public JPanel getPanelInventario(){
        return panelusuario;
    }
    public JButton getBtneliminar(){
        return btneliminar;
    }
    public JButton getBtnactualizar(){
        return btnactualizar;
    }
    public JTable getTablaInventario(){
        return tablaInventario;
    }
    public DefaultTableModel getModeloInventario(){
        return modeloInventario;
    }
    public JTextField getTxtCosto(){
        return txtcosto;
    }
    public JTextField getTxtColor(){
        return txtcolor;
    }
    public JTextField getTxtTalla(){
        return txttalla;
    }
    public JTextField getTxtModelo(){
        return txtmodelo;
    }
    public JTextField getTxtCodigo(){
        return txtcodigo;
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

