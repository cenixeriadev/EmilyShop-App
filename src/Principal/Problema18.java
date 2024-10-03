package Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema18 extends JFrame implements ActionListener {

    // Declarar los componentes
    private JTextField txtDonacion;
    private JTextArea resultadosArea;

    // Constructor
    public Problema18() {
        // Configuración del JFrame
        setTitle("Distribución de Donación");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centramos la ventana

        // Etiqueta
        JLabel labelDonacion = new JLabel("Monto de la Donación:");
        labelDonacion.setBounds(20, 20, 150, 20);
        add(labelDonacion);

        // Caja de texto
        txtDonacion = new JTextField();
        txtDonacion.setBounds(180, 20, 150, 20);
        add(txtDonacion);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 60, 100, 30);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        // Caja de texto con scroll para mostrar los resultados
        resultadosArea = new JTextArea();
        resultadosArea.setRows(100);
        resultadosArea.setEditable(false);
        resultadosArea.setColumns(100);
        JScrollPane scrollPane = new JScrollPane(resultadosArea);
        scrollPane.setBounds(20, 100, 350, 200);
        scrollPane.setViewportView(resultadosArea);
        add(scrollPane);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener el monto de la donación
            double donacionTotal = Double.parseDouble(txtDonacion.getText());

            // Calcular los montos para cada área
            if(donacionTotal<0) {
                throw  new NumberFormatException("Invalid");
            }else {
                double medicinaGeneral = donacionTotal * 0.45;
                double ginecologia = donacionTotal * 0.30;
                double pediatria = (donacionTotal * 0.20) / 2;
                double traumatologia = donacionTotal - (medicinaGeneral + ginecologia + pediatria * 2);

                // Mostrar los resultados
                resultadosArea.append("Medicina General: " + medicinaGeneral + "\n");
                resultadosArea.append("Ginecología: " + ginecologia + "\n");
                resultadosArea.append("Pediatría: " + pediatria + "\n");
                resultadosArea.append("Traumatología: " + traumatologia + "\n");
                resultadosArea.requestFocus();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor válido.");
        }
    }

    public static void main(String[] args) {
        new Problema18(); // Ejecutar la ventana
    }
}

