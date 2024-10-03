package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PruebaRichard extends JFrame implements ActionListener {
    JLabel lbltipo , lblcantidad;
    JTextField txtcantidad;
    JButton btnprocesar, btnborrar;
    JTextArea txtParcial , txtTotal;
    JComboBox cblicencia;
    JScrollPane scrollPaneParcial , scrollPaneTotal;
    public int a = 0, b= 0 , c = 0 , d=0 ;
    public int av = 0, bv = 0 , cv = 0 , dv= 0;

    public PruebaRichard() {
        setTitle("Licencias...");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lbltipo = new JLabel("Tipo de inventario: ");
        lbltipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbltipo.setBounds(80, 100, 150, 30);
        add(lbltipo);
        cblicencia = new JComboBox<>(new String[]{"" , "Cobre" , "Bronce" , "Silver", "Gold"} );
        cblicencia.setBounds(200, 100, 100, 30);
        cblicencia.addActionListener(this);
        add(cblicencia);

        lblcantidad = new JLabel("Número de licencias");
        lblcantidad.setBounds(70, 200, 150, 30);
        lblcantidad.setFont(new Font("Times New Roman", Font.BOLD , 14));
        add(lblcantidad);

        txtcantidad = new JTextField();
        txtcantidad.setBounds(200, 200, 100, 30);
        txtcantidad.addActionListener(this);
        add(txtcantidad);
        btnborrar = new JButton("Borrar");
        btnborrar.setBounds(400, 200, 100, 30);
        btnborrar.addActionListener(this);
        add(btnborrar);
        btnprocesar = new JButton("Procesar");
        btnprocesar.setBounds(400, 100, 100, 30);
        btnprocesar.addActionListener(this);
        add(btnprocesar);
        txtParcial = new JTextArea("      VENTA ACTUAL");
        txtParcial.setBounds(100 , 400, 300 , 300);
        txtParcial.setColumns(60);
        txtParcial.setRows(60);
        txtParcial.setEditable(false);
        add(txtParcial);
        scrollPaneParcial = new JScrollPane(txtParcial);
        scrollPaneParcial.setBounds(100, 400, 300, 300);
        scrollPaneParcial.setViewportView(txtParcial);
        add(scrollPaneParcial);
        txtTotal = new JTextArea("      REPORTE HISTORICO");
        txtTotal.setBounds(500 , 400 , 300,300);
        txtTotal.setColumns(100);
        txtTotal.setEditable(false);
        txtTotal.setRows(100);
        add(txtTotal);
        scrollPaneTotal = new JScrollPane(txtTotal);
        scrollPaneTotal.setViewportView(txtTotal);
        scrollPaneTotal.setBounds(500, 400, 300, 300);
        add(scrollPaneTotal);


        txtTotal.append("\n" +"Numero de licencias Vendidas:  " + "\n");
        txtTotal.append("       Por  licencias de Cobre......... "  + a + "\n");
        txtTotal.append("       Por  licencias de Bronce......... "  +  b + "\n");
        txtTotal.append("       Por  licencias de Silver.......... "  + c + "\n");
        txtTotal.append("       Por  licencias de Gold........... "  +  d + "\n");
        txtTotal.append("Número de ventas efectuadas.............. "  +  "\n");
        txtTotal.append("       Por licencias de Cobre........... "  + av +"\n");
        txtTotal.append("       Por  licencias de Bronce......... "  +  bv + "\n");
        txtTotal.append("       Por  licencias de Silver.......... "  +  cv + "\n");
        txtTotal.append("       Por  licencias de Gold........... "  + dv + "\n");

    }


    public static void main(String[] args) {
        PruebaRichard ventana = new PruebaRichard();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //!txtcantidad.getText().equals(null)  (e.getSource() == cblicencia)
        try {
            if (!txtcantidad.getText().equals(null) && e.getSource() == cblicencia) {
                ShowParcial();

            }
            if (e.getSource() == btnborrar) {
                Borrar();
            } else if (e.getSource() == btnprocesar) {
                Procesar();
            }

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Debe llenar los campos requeridos!!" );

        }

    }


    public void ShowParcial(){
        int price = 0;
        String licencia = cblicencia.getItemAt(cblicencia.getSelectedIndex()).toString();
        int cant = Integer.parseInt(txtcantidad.getText());
        switch (licencia) {
            case "Cobre":
                price = 510;
                break;
            case "Bronce":
                price = 1500;
                break;
            case "Silver":
                price = 3100;
                break;
            case "Gold":
                price = 4500;
                break;

        }

        txtParcial.append("\n" +"Tipo de licencia:........" +  licencia + "\n");
        txtParcial.append("Número de licencias:........ " + txtcantidad.getText() +"\n");
        txtParcial.append("Importe a pagar:........... $" + price*cant );
    }
    public void Borrar(){
        txtParcial.setText("");
    }
    public void Procesar() {
        int price = 0;
        String licencia = cblicencia.getItemAt(cblicencia.getSelectedIndex()).toString();
        int cant = Integer.parseInt(txtcantidad.getText());
        int value = Integer.parseInt(txtcantidad.getText());
        switch (licencia) {
            case "Cobre":
                a += value;
                av++;
                break;
            case "Bronce":
                b += value;
                bv++;
                break;
            case "Silver":
                c += value;
                cv++;
                break;
            case "Gold":

                d += value;
                dv++;
                break;

        }

        txtTotal.setText("");
        txtTotal.append("       REPORTE HISTORICO");
        txtTotal.append("\n" +"Numero de licencias Vendidas:  " + "\n");
        txtTotal.append("       Por  licencias de Cobre......... "  + a + "\n");
        txtTotal.append("       Por  licencias de Bronce......... "  +  b + "\n");
        txtTotal.append("       Por  licencias de Silver.......... "  + c + "\n");
        txtTotal.append("       Por  licencias de Gold........... "  +  d + "\n");
        txtTotal.append("Número de ventas efectuadas.............. "  +  "\n");
        txtTotal.append("       Por licencias de Cobre........... "  + av +"\n");
        txtTotal.append("       Por  licencias de Bronce......... "  +  bv + "\n");
        txtTotal.append("       Por  licencias de Silver.......... "  +  cv + "\n");
        txtTotal.append("       Por  licencias de Gold........... "  + dv + "\n");
    }

}
