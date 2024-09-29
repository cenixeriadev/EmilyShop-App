package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Problema2 extends JFrame implements ActionListener
{   private final JLabel lblnum1  ,lblcombo;
    private  final JTextField txtn1 ;
    private  final JButton btncalcular;
    private  final JComboBox   comboTemp;
    JScrollPane jscroll;
    JTextArea txtArea;
    public Problema2()
    {
        setLocation(430,80);

        setSize(600,600);
        setTitle("Ventana Principal");
        setLayout(null);// deja sin efecto la  distribucion normal

        lblcombo=new JLabel("Elegir Operacion :");
        lblcombo.setBounds(80,30,200,30);//Bounds = Limites
        add(lblcombo);
        txtArea = new JTextArea();
        txtArea.setBounds(100,190,400,350);
        txtArea.setEditable(false);
        add(txtArea);
        jscroll = new JScrollPane();
        jscroll.setBounds(100,190,400,350);
        txtArea.setColumns(100);
        txtArea.setRows(100);
        jscroll.setViewportView(txtArea);
        add(jscroll);
        lblnum1=new JLabel("Grados centigrados: ");
        lblnum1.setBounds(70,70,200,30);
        add(lblnum1);
        comboTemp=new JComboBox<>(new String[]{"","Faranheit","Kelvin","Rankine"});
        comboTemp.setBounds(200,30,200,30);
        add(comboTemp);
        txtn1=new JTextField();
        txtn1.setBounds(200,70,200,30);
        add(txtn1);

        btncalcular=new JButton("Calcular ");
        btncalcular.setBounds(155,150,200,30);
        btncalcular.addActionListener(this);
        add(btncalcular);




    }
    public static void main(String[] args)
    {
        Problema2  ventana=new Problema2();
        ventana.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btncalcular)
        {
            calcular();
        }
    }
    public  void  calcular() {
        int op;
        double num2,result2;
        op = comboTemp.getSelectedIndex(); //  capturar el indica de seleccion del combox
        num2  = Double.parseDouble(txtn1.getText());
        String aprox = "%.2f";
        if(num2>=-273.15){
            switch (op) {
                case 1: {
                    result2 = ((num2 * 9) / 5)-32;
                    txtArea.append("A GRADOS FARANHEIT  ES:  " + String.format(aprox,result2) + "\n");
                    txtArea.requestFocus();
                    break;
                }
                case 2: {

                    result2 =  num2 + 273;
                    txtArea.append("A GRADOS KELVIN ES: " + String.format(aprox,result2) + "\n");
                    txtArea.requestFocus();
                    break;
                }
                case 3:{
                    result2 = num2 + 460;
                    txtArea.append("A GRADOS RANKINE ES: " + String.format(aprox,result2) + "\n");
                    txtArea.requestFocus();
                    break;
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "Quieres romper la fisica bro? ,no se permiten valores menores a -273,15!!");
        }

    }

}
