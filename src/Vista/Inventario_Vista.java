package Vista;

import javax.swing.*;
import java.awt.*;

public class Inventario_Vista extends JFrame {
    JLabel lblinventario,lblcodigo,lblmodelo,lbltalla,lblmensaje, lblcolor,lblprecio;
    JTextField txtcodigo,txtcolor,txtprecio;
    JButton btnregistrar, btnreporte, btnvolver;
    public ButtonGroup groupTallas = new ButtonGroup();
    JComboBox<String> cbmodelo;
    JPanel panelTallas;


    public Inventario_Vista() {
        initComponents();

    }
    public void initComponents(){
        setTitle("INVENTARIO...");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lblinventario= new JLabel("INVENTARIO");
        lblinventario.setFont(new Font("Times New Roman",Font.BOLD,30));
        lblinventario.setBounds(200,20,300,35);
        add(lblinventario);

        lblmodelo=new JLabel("MODELO");
        lblmodelo.setBounds(30,60,100,30);
        add(lblmodelo);

        lblprecio = new JLabel("PRECIO ");
        lblprecio.setBounds(230,60,100,30);
        add(lblprecio);

        lblcodigo=new JLabel("CODIGO");
        lblcodigo.setBounds(30,100,100,30);
        add(lblcodigo);

        lblcolor = new JLabel("COLOR");
        lblcolor.setBounds(230,100,100,30);
        add(lblcolor);

        lbltalla=new JLabel("TALLA");
        lbltalla.setBounds(30,140,100,30);
        add(lbltalla);

        lblmensaje = new JLabel("");
        lblmensaje.setBounds(120, 290, 300, 20);
        lblmensaje.setForeground(Color.RED);
        add(lblmensaje);



        cbmodelo= new JComboBox<>();
        cbmodelo.setBounds(120,60,100,30);
        cbmodelo.addItem("");
        cbmodelo.addItem("Nike");
        cbmodelo.addItem("Addidas");
        cbmodelo.addItem("Quellin");
        cbmodelo.addItem("I-Run");
        add(cbmodelo);


        txtcodigo=new JTextField();
        txtcodigo.setBounds(120,100,100,30);
        add(txtcodigo);

        txtcolor = new JTextField();
        txtcolor.setBounds(280,100,100,30);
        add(txtcolor);

        txtprecio = new JTextField();
        txtprecio.setBounds(280,60,100,30);
        add(txtprecio);

        panelTallas = new JPanel(new GridLayout(3, 3, 10, 10));
        panelTallas.setBounds(120, 140, 200, 100);
        add(panelTallas);

        String[] tallas = {"35", "36", "37", "38", "39", "40", "41", "42", "43"};
        //ButtonGroup groupTallas = new ButtonGroup();

        for (String talla : tallas) {
            JToggleButton btnTalla = new JToggleButton(talla);
            btnTalla.setActionCommand(talla);
            groupTallas.add(btnTalla);
            panelTallas.add(btnTalla);
        }

        btnregistrar=new JButton("REGISTRAR");
        btnregistrar.setBounds(30,260,100,30);
        add(btnregistrar);

        btnreporte= new JButton("REPORTE");
        btnreporte.setBounds(140,260,100,30);
        add(btnreporte);


        btnvolver= new JButton("VOLVER");
        btnvolver.setBounds(460,370,100,30);
        add(btnvolver);






    }

    public JTextField getTxtprecio(){return  txtprecio;}
    public  JTextField getTxtcolor(){return  txtcolor;}
    public JTextField getTxtcodigo(){return  txtcodigo;}
    public ButtonGroup getGrupotallas(){return groupTallas;}
    public JComboBox<String> getOpcion(){ return cbmodelo;}
    public JButton getBtnregistrar(){
        return  btnregistrar;
    }
    public JButton getBtnreporte(){
        return  btnreporte;
    }
    public JButton getBtnvolver(){
        return  btnvolver;
    }




}
