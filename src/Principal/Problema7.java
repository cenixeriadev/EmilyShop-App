package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Problema7 extends JFrame implements ActionListener
{   private final JLabel  lblnum1, lblcombo;
    private  final JTextField txtn1 ;
    private  final JButton btncalcular;
    private  final JComboBox   comboTemp;
    JScrollPane scrollPane1;
    JTextArea txtArea;

    public Problema7() {
        setLocation(430,80);
        setSize(600,600);
        setTitle("Ventana Principal ");
        setLayout(null);// deja sin efecto la  distribucion normal
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblnum1=new JLabel("Capacidad en Gigabytes: ");
        lblnum1.setBounds(55,70,200,30);
        add(lblnum1);


        lblcombo=new JLabel("Elegir Operacion :");
        lblcombo.setBounds(90,30,200,30);//Bounds = Limites
        add(lblcombo);
        txtArea = new JTextArea();
        txtArea.setBounds(100,190,400,350);
        txtArea.setEditable(false);
        add(txtArea);
        scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(100,190,400,350);
        txtArea.setColumns(100);
        txtArea.setRows(100);
        scrollPane1.setViewportView(txtArea);
        add(scrollPane1);
        comboTemp=new JComboBox<>(new String[]{"","Megabytes","Kilobytes","Bytes"});
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
        Problema7  ventana=new Problema7();
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

        int op ;
        int VALX = 1024;
        double num2, result2;
        op = comboTemp.getSelectedIndex(); //  capturar el indica de seleccion del combox
        num2  = Double.parseDouble(txtn1.getText());
        String format = "%.10f";
        if(num2>=0) {
            switch (op) {
                case 1: {
                    result2 = num2 / VALX;
                    txtArea.append("A MEGABYTES ES:  " + String.format(format, result2) + " MB" + "\n");

                    txtArea.requestFocus();
                    break;
                }
                case 2: {

                    result2 = num2 / Math.pow(VALX, 2);
                    txtArea.append("A KILOBYTES ES: " + String.format(format, result2) +" KB"+ "\n");

                    txtArea.requestFocus();
                    break;
                }
                case 3: {
                    result2 = num2 / Math.pow(VALX, 3);
                    txtArea.append("A BYTES ES: " + String.format(format, result2) +" B"+ "\n");

                    txtArea.requestFocus();
                    break;
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "No se permiten valores negativos!!");
        }

    }

}