package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class Principal extends JFrame implements ActionListener
{   JLabel lblnum1 , lblnum2 ,lblcombo, lblresultado;
    JTextField txtn1, txtn2 ;
    JButton btncalcular;
    JComboBox   cboop;
    public Principal()
    {  setSize(500,500);
        setTitle("Ventana Principal !!!");
        setLayout(null);// deja sin efecto la  distribucion normal

        lblcombo=new JLabel("Elegir Operacion :");
        lblcombo.setBounds(80,30,200,30);
        add(lblcombo);

        lblnum1=new JLabel("Numero 1 :");
        lblnum1.setBounds(80,70,200,30);
        add(lblnum1);
        lblnum2=new JLabel("Numero 2 :");
        lblnum2.setBounds(80,110,200,30);
        add(lblnum2);
        cboop=new JComboBox();
        cboop.setBounds(200,30,200,30);
        cboop.addItem("----------------");
        cboop.addItem("   Sumar        ");
        cboop.addItem("   Restar       ");
        cboop.addItem("   Multiplicar  ");
        cboop.addItem("   Dividir      ");
        add(cboop);
        txtn1=new JTextField();
        txtn1.setBounds(200,70,200,30);
        add(txtn1);
        txtn2=new JTextField();
        txtn2.setBounds(200,110,200,30);
        add(txtn2);

        btncalcular=new JButton("Calcular");
        btncalcular.setBounds(155,150,200,30);
        btncalcular.addActionListener(this);
        add(btncalcular);

        lblresultado=new JLabel("--------- Resultado -----------");
        lblresultado.setBounds(180,190,200,40);
        add(lblresultado);

    }
    public static void main(String[] args)
    {
        Principal  ventana=new Principal();
        ventana.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btncalcular)
        {
            calcular();
        }
    }
    public  void  calcular()
    {
        int op, num1, num2 , suma,  resta, producto;
        double  division ;

        op=cboop.getSelectedIndex(); //  capturar el indica de seleccion de
        // del combo
        num1=Integer.parseInt(txtn1.getText());
        num2=Integer.parseInt(txtn2.getText());
        switch(op)
        {  case 1: {
            suma=num1+num2;
            lblresultado.setText("LA SUMA ES : "+suma); break;
        }
            case 2: {
                resta=num1*num2;
                lblresultado.setText("LA RESTA ES : "+resta); break;
            }
            case 3: {
                producto=num1*num2;
                lblresultado.setText("EL PRODUCTO  ES : "+producto); break;
            }
            case 4: {
                resta=num1/num2;
                lblresultado.setText("LA DIVISION ES : "+resta); break;
            }
        }


    }

    public static class Ejercicio11 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("La potencia de e pibe es: ");
            int x = scanner.nextInt();

            double suma = 0;
            int potencia = 0;
            double limit = 0.0001;
            double sub_total;

            do {
                sub_total = Math.pow(x, potencia) / factorial(potencia);
                suma += sub_total;
                potencia++;
            } while (sub_total > limit);

            System.out.printf("El valor aproximado de e^%d es: %.5f%n", x, suma);
        }

        public static double factorial(int n) {
            if (n == 0) return 1;
            double fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}