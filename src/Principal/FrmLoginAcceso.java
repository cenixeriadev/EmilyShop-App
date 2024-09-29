package Principal;
import Projecto_Final.FrmLoginUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class FrmLoginAcceso extends JFrame  implements ActionListener
{   JLabel lblUsuario, lblclave,lblmsj;
    JTextField txtUsuario, txtClave;
    JButton btnEntrar, btnSalir;
    public FrmLoginAcceso()
    {  setSize(400,300);
        setLocation(500, 200);//me  permite  ubicar
        // el forkmulario  en la pantalla
        setTitle("Ventana de Acceso !!");
        setLayout(null);// dejar sin efecto la distribucion po
        //  defecto
        lblUsuario=new JLabel("Usuario : ");
        lblUsuario.setBounds(50,50,100,30);
        add(lblUsuario);

        lblclave=new JLabel("Password:");
        lblclave.setBounds(50,80,100,30);
        add(lblclave);

        txtUsuario=new JTextField();
        txtUsuario.setBounds(160,50,100,30);
        add(txtUsuario);

        txtClave=new JTextField();
        txtClave.setBounds(160,80,100,30);
        add(txtClave);
        btnEntrar=new JButton("Entrar");
        btnEntrar.setBounds(70,140,100,30);
        btnEntrar.addActionListener(this);
        add(btnEntrar);
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(220, 140,100,30);
        btnSalir.addActionListener(this);
        add(btnSalir);

        lblmsj=new JLabel("...................");
        lblmsj.setBounds(170,170,500,30);
        add(lblmsj);
    }
    public static void main(String[] args)
    {   FrmLoginAcceso ventana=new FrmLoginAcceso();
        ventana.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            //Entrar();
        }
        if (e.getSource() == btnSalir) {
            Salir();
        }
    }
    public void Salir(){
            this.dispose();// cerrar o esconder
    }

    public static class FrmPrincipal extends JFrame implements ActionListener {
        JMenuBar mb ;
        JMenu menu1 , menu2, menu3 , menu4;
        JMenuItem mi1_1, mi1_2 , mi1_3;
        JMenuItem mi2_1 , mi2_2 , mi2_3;
        public FrmPrincipal(){
            setLocation(500,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500,600);
            setTitle("Ventana Principal :v");
            setLayout(null);
            mb = new JMenuBar();
            setJMenuBar(mb);
            menu1 = new JMenu("Archivo");
            mb.add(menu1);
            mi1_1 = new JMenuItem ( "Grabar ");
            menu1.add(mi1_1);

            mi1_2 =  new JMenuItem("Grabar como");
            menu1.add(mi1_2);


            mi1_3 =  new JMenuItem("Salir");
            mi1_3.addActionListener(this);
            menu1.add(mi1_3);



        }
        public static void main(String[] args) {
            FrmLoginAcceso ventana= new FrmLoginAcceso();
            ventana.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==mi1_3){
                Salir();
            }
        }

        public void Salir(){
            this.dispose();
            FrmLoginUsuario ventanaLogin = new FrmLoginUsuario();
            setVisible(true);
        }

    }
}