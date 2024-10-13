package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrInventarios_Vista extends JFrame {
    public JLabel lblInventarioReporte, lblDatos;
    public JTextArea txtarea;
    public JScrollPane jspbarra;
    public JButton btnvolver;
    public FrInventarios_Vista(){
        setTitle("REPORTE DE INVENTARIO");
        setSize(600,600);
        setLocation(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        //-------------------------------------
        lblInventarioReporte = new JLabel("INVENTARIO REPORTES");
        lblInventarioReporte.setFont(new java.awt.Font("Arial",Font.BOLD,18));
        lblInventarioReporte.setBounds(127,-20,300,100);
        lblInventarioReporte.setForeground(Color.BLACK);
        add(lblInventarioReporte);
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
        jspbarra = new JScrollPane();
        jspbarra.setBounds(74,70,325,250);
        jspbarra.setViewportView(txtarea);
        add(jspbarra);
    }
    public JButton getBtnVolver(){
        return btnvolver;
    }
}

