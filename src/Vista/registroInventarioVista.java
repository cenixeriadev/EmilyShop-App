
package Vista;

import javax.swing.*;
import java.awt.*;

public class registroInventarioVista extends JFrame{

    // Barra de menú y menús
    JLabel lblbienvenida;

    
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
        
        cbbtalla = new JComboBox<>(new String[]{"Seleccione una Talla",  "35", "36", "37", "38","39", "40", "41", "42"});
        cbbtalla.setBounds(515, 220, 200, 30);
        panelusuario.add(cbbtalla);
        
        lblcolor= new JLabel("Color");
        lblcolor.setForeground(Color.WHITE);
        lblcolor.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcolor.setBounds(415,260,140,30);
        panelusuario.add(lblcolor);
        
        cbbcolor = new JComboBox<>(new String[]{"Seleccione un Color",  "Blanco", "Azul", "Negro", "Rosado","Plomo", "Negro-Blanco", "Blanco-Negro", "Beige"});
        cbbcolor.setBounds(515, 260, 200, 30);
        panelusuario.add(cbbcolor);
        
        lblcosto=new JLabel("P. Costo");
        lblcosto.setForeground(Color.WHITE);
        lblcosto.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblcosto.setBounds(415,300,140,30);
        panelusuario.add(lblcosto);
        
        txtcosto= new JTextField();
        txtcosto.setBounds(515,300,200,30);
        panelusuario.add(txtcosto);

        btnregistrar = new JButton("Registrar");
        btnregistrar.setBounds(490,360,140,40);
        panelusuario.add(btnregistrar);

       
    }
    public JPanel getPanelusuario(){
        return panelusuario;
    }
    public JButton getBtnregistrar(){
        return btnregistrar;
    }
    public JTextField getTxtmodelo(){
        return txtmodelo;
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

   
