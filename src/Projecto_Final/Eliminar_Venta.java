package Projecto_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;

public class Eliminar_Venta extends JFrame implements ActionListener {
    JLabel lbleliminar, lblcodigo, lblventa, lbltalla, lblresultado;
    JTextField txtcod, txtvent;
    JButton btnadd, btneliminar, btnvolver;
    JComboBox ctalla;

    public Eliminar_Venta() {

        setSize(600, 600);
        //setLocation(600, 250);
        setTitle("ELiminar Venta");
        setFont(new Font("Arial", Font.CENTER_BASELINE | Font.BOLD, 15));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lbleliminar = new JLabel("ELIMINAR VENTA");
        lbleliminar.setFont(new Font("Arial", Font.BOLD, 24));
        lbleliminar.setBounds(130, 30, 300, 30);
        add(lbleliminar);

        lblcodigo = new JLabel("CÓDIGO");
        lblcodigo.setFont(new Font("Arial", Font.CENTER_BASELINE, 19));
        lblcodigo.setBounds(80, 100, 98, 20);
        lblcodigo.setOpaque(true);
        lblcodigo.setHorizontalAlignment(JLabel.CENTER);
        lblcodigo.setBackground(Color.GREEN);
        add(lblcodigo);

        lblventa = new JLabel("#VENTA");
        lblventa.setFont(new Font("Arial", Font.CENTER_BASELINE, 19));
        lblventa.setBounds(80, 140, 98, 20);
        lblventa.setOpaque(true);
        lblventa.setHorizontalAlignment(JLabel.CENTER);
        lblventa.setBackground(Color.GREEN);
        add(lblventa);

        lbltalla = new JLabel("TALLAS");
        lbltalla.setFont(new Font("Arial", Font.CENTER_BASELINE, 19));
        lbltalla.setBounds(80, 180, 98, 20);
        lbltalla.setOpaque(true);
        lbltalla.setHorizontalAlignment(JLabel.CENTER);
        lbltalla.setBackground(Color.GREEN);
        add(lbltalla);

        lblresultado = new JLabel("--");
        lblresultado.setFont(new Font("Arial", Font.CENTER_BASELINE, 19));
        lblresultado.setBounds(100, 270, 300, 20);
        lblresultado.setHorizontalAlignment(JLabel.CENTER);
        lblresultado.setForeground(Color.RED);
        add(lblresultado);

        txtcod = new JTextField("");
        txtcod.setBounds(200, 100, 150, 20);
        add(txtcod);

        txtvent = new JTextField("");
        txtvent.setBounds(200, 140, 150, 20);
        add(txtvent);

        btnadd = new JButton("ADD");
        btnadd.setOpaque(true);
        btnadd.setHorizontalAlignment(JButton.CENTER);
        btnadd.setBackground(Color.GRAY);
        btnadd.setForeground(Color.WHITE);
        btnadd.setBounds(250, 180, 60, 20);
        btnadd.addActionListener(this);
        add(btnadd);

        btneliminar = new JButton("ELIMINAR");
        btneliminar.setFont(new Font("Arial", Font.CENTER_BASELINE | Font.BOLD, 22));
        btneliminar.setBounds(160, 220, 150, 30);
        btneliminar.setOpaque(true);
        btneliminar.setForeground(Color.WHITE);
        btneliminar.setBackground(Color.RED);
        btneliminar.setHorizontalAlignment(JButton.CENTER);
        btneliminar.addActionListener(this);
        add(btneliminar);

        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(380, 320, 90, 20);
        btnvolver.setOpaque(true);
        btnvolver.setBackground(Color.GRAY);
        btnvolver.setForeground(Color.WHITE);
        btnvolver.addActionListener(this);
        btnvolver.setHorizontalAlignment(JButton.CENTER);
        add(btnvolver);

        ctalla = new JComboBox();
        ctalla.setBounds(200, 180, 50, 20);
        ctalla.addItem("");
        ctalla.addItem("34");
        ctalla.addItem("35");
        ctalla.addItem("36");
        ctalla.addItem("37");
        ctalla.addItem("38");
        ctalla.addItem("39");
        ctalla.addItem("42");
        ctalla.addItem("41");
        ctalla.addItem("42");
        ctalla.addItem("43");
        add(ctalla);


    }


    public static void main(String[] args) {
        Eliminar_Venta ventana = new Eliminar_Venta();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btneliminar) {
            mensajeelimi();
        }
        else if(e.getSource()==btnvolver){
            new Menu_Principal();
            this.dispose();


        }
    }

    public void mensajeelimi() {
        String codigo = txtcod.getText();
        String venta = txtvent.getText();
        if (codigo.length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su codigo por favor");
        }
        if (venta.length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su numero de venta por favor");
        } else {
            lblresultado.setText("Venta Eliminada correctamente");
        }
    }
}