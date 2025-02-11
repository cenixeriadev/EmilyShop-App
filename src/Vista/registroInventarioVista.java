
package Vista;

import Utilitario.BotonPersonalizado;
import Utilitario.ManagerPath;
import Utilitario.PanelDegradadoAzul;

import javax.swing.*;
import java.awt.*;

public class registroInventarioVista extends JFrame{

    // Barra de menú y menús
    JLabel lblbienvenida;

    
    JPanel panelusuario;
    
    JComboBox<String> cbbtalla, cbbcolor;
    
    JLabel lblmarca, lblcodigo, lblcosto, lbltalla, lblcolor , lblcantidad , lblpventa , lbldescripcion;
    JTextField txtmarca, txtcodigo, txtcosto , txtpventa  ,  txtdescripcion;
    JSpinner spcantidad ;
    SpinnerNumberModel modelosp;
    JButton btnregistrar;
    
    public registroInventarioVista() {
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
        lblbienvenida= new JLabel("REGISTRO DE INVENTARIO");
        lblbienvenida.setBounds(355,75,580,60);
        lblbienvenida.setForeground(Color.WHITE); // Color del texto
        lblbienvenida.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblbienvenida);
        
        lblmarca =new JLabel("Marca");
        lblmarca.setForeground(Color.WHITE);
        lblmarca.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblmarca.setBounds(275,160,140,30);
        panelusuario.add(lblmarca);
        
        txtmarca = new JTextField();
        txtmarca.setBounds(375,160,200,30);
        panelusuario.add(txtmarca);
        
        lblcodigo=new JLabel("Código");
        lblcodigo.setForeground(Color.WHITE);
        lblcodigo.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcodigo.setBounds(275,200,140,30);
        panelusuario.add(lblcodigo);
        
        txtcodigo= new JTextField();
        txtcodigo.setBounds(375,200,200,30);
        panelusuario.add(txtcodigo);
        
        lbltalla= new JLabel("Talla");
        lbltalla.setForeground(Color.WHITE);
        lbltalla.setFont(new Font("Times New Roman", Font.BOLD,20));
        lbltalla.setBounds(275,240,140,30);
        panelusuario.add(lbltalla);
        
        cbbtalla = new JComboBox<>(new String[]{"Seleccione una Talla",  "35", "36", "37", "38","39", "40", "41", "42"});
        cbbtalla.setBounds(375, 240, 200, 30);
        panelusuario.add(cbbtalla);
        
        lblcolor= new JLabel("Color");
        lblcolor.setForeground(Color.WHITE);
        lblcolor.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcolor.setBounds(275,280,140,30);
        panelusuario.add(lblcolor);
        
        cbbcolor = new JComboBox<>(new String[]{"Seleccione un Color",  "Blanco", "Azul", "Negro", "Rosado","Plomo", "Negro-Blanco", "Blanco-Negro", "Beige"});
        cbbcolor.setBounds(375, 280, 200, 30);
        panelusuario.add(cbbcolor);
        
        lblcosto=new JLabel("P.Compra");
        lblcosto.setForeground(Color.WHITE);
        lblcosto.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcosto.setBounds(595,160,140,30);
        panelusuario.add(lblcosto);
        
        txtcosto= new JTextField();
        txtcosto.setBounds(695,160,200,30);
        panelusuario.add(txtcosto);

        lblpventa=new JLabel("P.Venta");
        lblpventa.setForeground(Color.WHITE);
        lblpventa.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblpventa.setBounds(595,200,140,30);
        panelusuario.add(lblpventa);

        txtpventa= new JTextField();
        txtpventa.setBounds(695,200,200,30);
        panelusuario.add(txtpventa);

        lblcantidad= new JLabel("Cantidad");
        lblcantidad.setForeground(Color.WHITE);
        lblcantidad.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcantidad.setBounds(595,240,140,30);
        panelusuario.add(lblcantidad);

        modelosp = new SpinnerNumberModel(1, 1, 100, 1);
        spcantidad = new JSpinner(modelosp);
        spcantidad.setBounds(695, 240, 100, 30);
        panelusuario.add(spcantidad);

        lbldescripcion= new JLabel("Descripción");
        lbldescripcion.setForeground(Color.WHITE);
        lbldescripcion.setFont(new Font("Times New Roman", Font.BOLD,20));
        lbldescripcion.setBounds(595,280,140,30);
        panelusuario.add(lbldescripcion);

        txtdescripcion = new JTextField();
        txtdescripcion.setBounds(695, 280, 200, 30);
        panelusuario.add(txtdescripcion);

        btnregistrar = new BotonPersonalizado("Registrar", ManagerPath.getRuta("registrar.png"),null);
        btnregistrar.setBounds(530,360,140,40);
        panelusuario.add(btnregistrar);

       
    }
    public JTextField getTxtdescripcion(){
        return txtdescripcion;
    }
    public JSpinner getSpcantidad(){return spcantidad;}
    public JTextField getTxtpventa(){return txtpventa;}
    public JPanel getPanelusuario(){
        return panelusuario;
    }
    public JButton getBtnregistrar(){
        return btnregistrar;
    }
    public JTextField getTxtmarca(){
        return txtmarca;
    }
    public JTextField getTxtcodigo(){
        return txtcodigo;
    }
    public JTextField getTxtcosto(){
        return txtcosto;
    }
    public JComboBox<String> getCbbtalla(){
        return cbbtalla;
    }
    public JComboBox<String> getCbbcolor(){
        return cbbcolor;
    }

}


   
