package Projecto_Final;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class FrInventarios extends JFrame implements ActionListener{
    JLabel lblInventarioReporte, lblDatos;
    JTextArea txtarea;
    JScrollPane jspbarra;
    JButton btnvolver;
    public FrInventarios(){
        setTitle("REPORTE DE INVENTARIO");
        setSize(500,400);
        setLocation(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblInventarioReporte = new JLabel("INVENTARIO REPORTES");
        lblInventarioReporte.setFont(new java.awt.Font("Arial",Font.BOLD,18));
        lblInventarioReporte.setBounds(120,0,300,100);
        lblInventarioReporte.setForeground(Color.BLACK);
        add(lblInventarioReporte);

        lblDatos = new JLabel("DATOS");
        lblDatos.setBounds(200,48,100,100);
        add(lblDatos);

        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(384,331,100,30);
        btnvolver.addActionListener(this);
        btnvolver.setForeground(Color.white);
        btnvolver.setBackground(Color.LIGHT_GRAY);
        add(btnvolver);

        //Area de Texto y Barra de Desplazamiento
        txtarea = new JTextArea(200,200);
        txtarea.setBounds(84, 84, 300, 250);
        //Barra de desplzamiento
        jspbarra = new JScrollPane();
        jspbarra.setViewportView(txtarea);
        add(txtarea);
    }
    public static void main(String args[]) {
        FrInventarios ventana = new FrInventarios();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
