package Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema19 extends JFrame implements ActionListener {

    // Declarar los componentes
    private JTextField txtNumero;
    private JTextArea resultadosArea;

    // Constructor
    public Problema19() {
        // Configuración del JFrame
        setTitle("Formar Número");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centramos la ventana

        // Etiqueta
        JLabel labelNumero = new JLabel("Número de 4 cifras:");
        labelNumero.setBounds(20, 20, 150, 20);
        add(labelNumero);

        // Caja de texto
        txtNumero = new JTextField();
        txtNumero.setBounds(180, 20, 150, 20);
        add(txtNumero);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 60, 100, 30);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        // Caja de texto con scroll para mostrar los resultados
        resultadosArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultadosArea);
        scrollPane.setBounds(20, 100, 350, 100);
        add(scrollPane);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener el número ingresado
            String numeroStr = txtNumero.getText();

            // Validar que sea un número de 4 cifras
            if (numeroStr.length() != 4) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número de 4 cifras.");
                return;
            }

            // Formar el nuevo número con las cifras de los millares y unidades
            char millar = numeroStr.charAt(0);
            char unidad = numeroStr.charAt(3);
            String nuevoNumero = "" + millar + unidad;

            // Mostrar el resultado
            resultadosArea.append("Nuevo número formado: " + nuevoNumero + "\n");
            resultadosArea.requestFocus();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor válido.");
        }
    }

    public static void main(String[] args) {

        new Problema19(); // Ejecutar la ventana
    }
}
