package Vista;

import Utilitario.BotonPersonalizado;
import Utilitario.ManagerPath;
import Utilitario.PanelDegradadoAzul;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class gestioninventarioVista extends JFrame {
    // Barra de menú y menús
    JLabel lblbienvenida;
    
    JPanel panelusuario;
    
    JTable tablaInventario;
    DefaultTableModel modeloInventario;
    
    JLabel lblmodelo, lblcodigo, lblcosto, lbltalla, lblcolor , lblCantidad , lblDescripcion;
    JTextField txtmodelo, txtcodigo, txtcosto, txttalla, txtcolor , txtcantidad, txtDescripcion;
    
    JButton btneliminar, btnactualizar;
    
    public gestioninventarioVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);
        //-----------panel bienvenido----------
        panelusuario = new PanelDegradadoAzul();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);
        
        //------------dentro de panel bienvenido----------
        lblbienvenida= new JLabel("GESTION DE INVENTARIO");
        lblbienvenida.setBounds(360,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);

        modeloInventario = new DefaultTableModel(new String[]{"Codigo", "Marca", "Talla", "Color","Cantidad" , "P. Venta"}, 0){
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
        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        scrollPane.setBounds(600, 140, 500, 340);
        panelusuario.add(scrollPane);

        lblmodelo=new JLabel("Marca");
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

        lblcosto=new JLabel("P. Venta");
        lblcosto.setForeground(Color.WHITE);
        lblcosto.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcosto.setBounds(115,300,140,30);
        panelusuario.add(lblcosto);
        
        txtcosto= new JTextField();
        txtcosto.setBounds(215,300,200,30);
        panelusuario.add(txtcosto);

        lblCantidad= new JLabel("Cantidad");
        lblCantidad.setForeground(Color.WHITE);
        lblCantidad.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblCantidad.setBounds(115,340,140,30);
        panelusuario.add(lblCantidad);

        txtcantidad= new JTextField();
        txtcantidad.setBounds(215,340,200,30);
        panelusuario.add(txtcantidad);

        lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblDescripcion.setBounds(115,380,140,30);
        panelusuario.add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(215 , 380 , 200, 30);
        panelusuario.add(txtDescripcion);

        btnactualizar = new BotonPersonalizado("Actualizar", ManagerPath.getRuta("actualizar.png"),null);
        btnactualizar.setBounds(80, 460, 200, 40);
        panelusuario.add(btnactualizar);
       
        btneliminar = new BotonPersonalizado("Eliminar",ManagerPath.getRuta("tachito.png"),null);
        btneliminar.setBounds(300,460,140,40);
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
    public JTextField getTxtCantidad(){
        return txtcantidad;
    }
    public JTextField getTxtDescripcion(){return txtDescripcion;}

}


