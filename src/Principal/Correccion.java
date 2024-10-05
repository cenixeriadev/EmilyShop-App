package Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Correccion extends JFrame implements ActionListener{
    JButton btnprocesar , btnBorrar;
    JTextField  inputMinutos , inputObser;
    JTextArea resultado;
    JScrollPane weaResultado;
    JLabel txt1 , txt2 ;

    public int MinuTardanza  , PuntajeTotal , Bonificacion , NumeroObser ;
    public int PuntRendimiento = 0;
    public int PuntPuntualidad = 0 ;
    public Correccion(){
        setSize(800,800);
        setTitle("Problema 1");
        setLayout(null);
        setLocation(400,200);



        txt1 = new JLabel("Minutos de tardanza");
        txt1.setBounds(60,160,150,30);
        add(txt1);

        txt2 = new JLabel("Numero de observaciones");
        txt2.setBounds(50,200,150,30);
        add(txt2);

        inputMinutos = new JTextField();

        inputMinutos.setBounds(200,200,100,30);
        add(inputMinutos);
        inputObser = new JTextField();
        inputObser.setBounds(200 ,160 , 100,30);
        add(inputObser);



        resultado = new JTextArea();

        resultado.setBounds(100 , 300 , 300, 300);
        resultado.setEditable(false);

        resultado.setColumns(100);
        resultado.setRows(100);
        add(resultado);
        weaResultado = new JScrollPane();

        weaResultado.setBounds(100 , 300 , 300, 300);
        weaResultado.setViewportView(resultado);

        add(weaResultado);

        btnprocesar = new JButton("Procesar");
        btnprocesar.setBounds(300 ,160 , 100,30);
        btnprocesar.addActionListener(this);

        add(btnprocesar);
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(300,200,100,30);
        btnBorrar.addActionListener(this);

        add(btnBorrar);



    }



    @Override
    public void actionPerformed(ActionEvent e){
        try{


            if(e.getSource()==btnprocesar){
                Procesar();


            }else if(e.getSource()==btnBorrar){
                Borrar();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR");
        }





    }
    public static void main(String[] args) {
        // TODO code application logic here
        Correccion ventana = new Correccion();
        ventana.setVisible(true);
    }
    public void Procesar(){
        MinuTardanza = Integer.parseInt(inputMinutos.getText());
        NumeroObser = Integer.parseInt(inputObser.getText());
        if(MinuTardanza==0){
            PuntPuntualidad = 10;
        }
        else if(MinuTardanza<=2 ||MinuTardanza>=0){
            PuntPuntualidad = 8;
        }
        else if(MinuTardanza<=5 ||MinuTardanza>=3){
            PuntPuntualidad  = 6;
        }
        else if(MinuTardanza<=9 ||MinuTardanza>=6){
            PuntPuntualidad = 4;
        }
        else if(MinuTardanza>9){
            PuntPuntualidad = 0;
        }
        if(NumeroObser==0){
            PuntRendimiento = 10;
        }
        else if(NumeroObser==1 ){
            PuntRendimiento = 8;
        }
        else if(NumeroObser==2 ){
            PuntRendimiento  = 5;
        }
        else if(NumeroObser==3 ){
            PuntRendimiento = 1;
        }
        else if(NumeroObser>3){
            PuntRendimiento = 0;
        }
        PuntajeTotal = PuntPuntualidad + PuntRendimiento;
        if(PuntajeTotal<11){
            Bonificacion =  (int) (2.5*PuntajeTotal);
        }
        else if(PuntajeTotal>=11 &&PuntajeTotal<=13 ){
            Bonificacion = (int) (5.0*PuntajeTotal);
        }
        else if(PuntajeTotal>=14 &&PuntajeTotal<=16 ){
            Bonificacion  = (int) (7.5*PuntajeTotal);
        }
        else if(PuntajeTotal>=17 &&PuntajeTotal<=19 ){
            Bonificacion = 10*PuntajeTotal;
        }
        else if(PuntajeTotal==20){
            Bonificacion = (int) (12.5*PuntajeTotal);
        }


        resultado.append("\n" +  "Puntaje por puntualidad......" +  PuntPuntualidad   + "\n");
        resultado.append("Puntaje por redimiento........ " +  PuntRendimiento +  "\n");
        resultado.append("Puntaje Total......." + PuntajeTotal +  "\n");
        resultado.append("Bonificaci√≥n......." + Bonificacion +   "\n");


    }
    public void Borrar(){
        resultado.setText("");
    }


}