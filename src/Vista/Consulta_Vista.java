package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Venta_Controlador;
public class Consulta_Vista extends JFrame {
    public JLabel lblConsulta, lblcodigo, lblparencontrado;
    public  JComboBox cboopTalla;
    public  JTextField txtCod;
    public  JButton btnconsulta, btnvolver, btnBorrar;
    public Consulta_Vista(){
        setTitle("Consultar Producto");
        setSize(600,600);
        setLocation(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        //--------------------------------------
        lblConsulta = new JLabel("CONSULTA");
        lblConsulta.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        lblConsulta.setForeground(Color.BLACK);
        lblConsulta.setBounds(188,0,200,100);
        add(lblConsulta);
        lblcodigo = new JLabel("CODIGO");
        lblcodigo.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        lblcodigo.setBounds(100,37,200,125);
        lblcodigo.setForeground(Color.BLACK);
        lblcodigo.setBackground(Color.LIGHT_GRAY);
        add(lblcodigo);
        lblparencontrado = new JLabel("");
        lblparencontrado.setBounds(76,190,550,100);
        lblparencontrado.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        lblparencontrado.setForeground(Color.BLACK);
        add(lblparencontrado);
        //----------------------------------------
        txtCod = new JTextField();
        txtCod.setBounds(200,90,150,25);
        add(txtCod);
        //------------------------------------
        cboopTalla = new JComboBox();
        cboopTalla.setBounds(100,130,80,20);
        cboopTalla.setBackground(Color.LIGHT_GRAY);
        cboopTalla.setForeground(Color.WHITE);
        cboopTalla.addItem("TALLA");
        cboopTalla.addItem("35");
        cboopTalla.addItem("36");
        cboopTalla.addItem("37");
        cboopTalla.addItem("38");
        cboopTalla.addItem("39");
        cboopTalla.addItem("40");
        cboopTalla.addItem("41");
        cboopTalla.addItem("42");
        cboopTalla.addItem("43");
        add(cboopTalla);
        //------------------------------------
        btnconsulta = new JButton("CONSULTAR");
        btnconsulta.setBounds(110,170,120,30);
        btnconsulta.setBackground(Color.red);
        btnconsulta.setForeground(Color.white);
        add(btnconsulta);
        btnvolver = new JButton("VOLVER");
        btnvolver.setBounds(384,331,100,30);
        btnvolver.setForeground(Color.white);
        btnvolver.setBackground(Color.LIGHT_GRAY);
        add(btnvolver);
        //NUEVO BOTON BORRAR
        btnBorrar = new JButton("BORRAR");
        btnBorrar.setBounds(250,170,120,30);
        btnBorrar.setForeground(Color.white);
        btnBorrar.setBackground(Color.red);
        add(btnBorrar);
    }
    public static void main(String[] args){
        Consulta_Vista vista = new Consulta_Vista();
        vista.setVisible(true);
    }
    public JButton getbtnConsulta(){
        return btnconsulta;
    }
    public JButton getbtnBorrar(){
        return btnBorrar;
    }
    public JButton getbtnVolver(){
        return btnvolver;
    }
    public JTextField getTextCod(){
        return txtCod;
    }
    public JLabel getRespuesta(){
        return lblparencontrado;
    }
}


