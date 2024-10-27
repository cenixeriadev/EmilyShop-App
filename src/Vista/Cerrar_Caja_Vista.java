package Vista;
import javax.swing.*; 
import java.awt.*; 

public class Cerrar_Caja_Vista extends JFrame {
    JLabel lblCierredeCaja, lblDatos; 
    JScrollPane jsbarra;
    JTextArea txtarea; 
    JButton btnvolver; 
    public Cerrar_Caja_Vista(){
        setTitle("CIERRE DE CAJA");
        setLayout(null);
        setSize(600,600); 
        setLocation(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //-------------------------------------
        lblCierredeCaja = new JLabel("REPORTE FINAL DEL DIA"); 
        lblCierredeCaja.setFont(new java.awt.Font("Arial",Font.BOLD,18));
        lblCierredeCaja.setBounds(127,-20,300,100);
        lblCierredeCaja.setForeground(Color.BLACK);
        add(lblCierredeCaja); 
        lblDatos = new JLabel("DATOS"); 
        lblDatos.setForeground(Color.BLACK);
        lblDatos.setBounds(210,11,100,100);
        add(lblDatos); 
        //--------------------------------------
        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(384,331,100,30); 
        btnvolver.setForeground(Color.white);
        btnvolver.setBackground(Color.LIGHT_GRAY);
        add(btnvolver); 
        //------------------------------------
        txtarea = new JTextArea(200,200); 
        txtarea.setEditable(false);
        jsbarra = new JScrollPane(); 
        jsbarra.setBounds(74,70,325,250);
        jsbarra.setViewportView(txtarea); 
        add(jsbarra);
    }  
    public JButton getbtnvolver(){
        return btnvolver; 
    }
    public JTextArea gettxtArea(){
        return txtarea; 
    }
}
