package Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema11 extends JFrame implements ActionListener {

    // Declarar los componentes globalmente
    private JTextField txtAcciones1, txtAcciones2, txtAcciones3, txtGanancias;
    private JTextArea resultadosArea;

    // Constructor
    public Problema11() {
        // Configuración del JFrame
        setTitle("Reparto de Ganancias");
        setSize(400, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiquetas
        JLabel labelAcciones1 = new JLabel("Acciones Socio 1 (%):");
        labelAcciones1.setBounds(20, 20, 140, 20);
        add(labelAcciones1);

        JLabel labelAcciones2 = new JLabel("Acciones Socio 2 (%):");
        labelAcciones2.setBounds(20, 60, 140, 20);
        add(labelAcciones2);

        JLabel labelAcciones3 = new JLabel("Acciones Socio 3 (%):");
        labelAcciones3.setBounds(20, 100, 140, 20);
        add(labelAcciones3);

        JLabel labelGanancias = new JLabel("Ganancias Totales:");
        labelGanancias.setBounds(20, 140, 140, 20);
        add(labelGanancias);

        // Cajas de texto
        txtAcciones1 = new JTextField();
        txtAcciones1.setBounds(150, 20, 100, 20);
        add(txtAcciones1);

        txtAcciones2 = new JTextField();
        txtAcciones2.setBounds(150, 60, 100, 20);
        add(txtAcciones2);

        txtAcciones3 = new JTextField();
        txtAcciones3.setBounds(150, 100, 100, 20);
        add(txtAcciones3);

        txtGanancias = new JTextField();
        txtGanancias.setBounds(150, 140, 100, 20);
        add(txtGanancias);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 180, 100, 30);
        btnCalcular.addActionListener(this); // Añadimos el ActionListener al botón
        add(btnCalcular);

        // Caja de texto con scroll para mostrar los resultados
        resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadosArea);
        scrollPane.setBounds(20, 230, 350, 300);
        resultadosArea.setColumns(100);
        resultadosArea.setRows(100);
        scrollPane.setViewportView(resultadosArea);
        add(scrollPane);

        // Mostrar la ventana
        setVisible(true);
    }

    // Implementación del método actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener datos de las cajas de texto
            int acciones1 = Integer.parseInt(txtAcciones1.getText());
            int acciones2 = Integer.parseInt(txtAcciones2.getText());
            int acciones3 = Integer.parseInt(txtAcciones3.getText());
            if(acciones1<0 || acciones2<0 || acciones3<0  || (acciones1 + acciones2 + acciones3!=100)){
                throw  new NumberFormatException("Invalid");
            }else {
                double gananciasTotales = Double.parseDouble(txtGanancias.getText());

                int totalAcciones = acciones1 + acciones2 + acciones3;

                // Calcular ganancias para cada socio
                double ganancia1 = (acciones1 / (double) totalAcciones) * gananciasTotales;
                double ganancia2 = (acciones2 / (double) totalAcciones) * gananciasTotales;
                double ganancia3 = (acciones3 / (double) totalAcciones) * gananciasTotales;

                // Mostrar resultados en el área de texto
                resultadosArea.append("Socio 1: " + ganancia1 + "\n");
                resultadosArea.append("Socio 2: " + ganancia2 + "\n");
                resultadosArea.append("Socio 3: " + ganancia3 + "\n");
                resultadosArea.append("\n"); // Para separación entre cálculos
                resultadosArea.requestFocus();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos.");
        }
    }

    public static void main(String[] args) {
        Problema11 ventanasol = new Problema11(); // Crear la ventana
        ventanasol.setVisible(true);
    }
}

