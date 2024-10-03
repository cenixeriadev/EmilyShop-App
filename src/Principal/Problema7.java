package Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema7 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculo de Longitud");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 20, 360, 200);
        textArea.setEditable(false);
        textArea.setRows(100);
        textArea.setColumns(100);
        scrollPane.setViewportView(textArea);

        JLabel kmLabel = new JLabel("Longitud en kilómetros:");
        JTextField kmField = new JTextField();
        kmLabel.setBounds(20, 230, 150, 20);
        kmField.setBounds(180, 230, 100, 20);

        JLabel piesLabel = new JLabel("Longitud en pies:");
        JTextField piesField = new JTextField();
        piesLabel.setBounds(20, 260, 150, 20);
        piesField.setBounds(180, 260, 100, 20);

        JLabel millasLabel = new JLabel("Longitud en millas:");
        JTextField millasField = new JTextField();
        millasLabel.setBounds(20, 290, 150, 20);
        millasField.setBounds(180, 290, 100, 20);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBounds(300, 260, 100, 30);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double km = Double.parseDouble(kmField.getText());
                double pies = Double.parseDouble(piesField.getText());
                double millas = Double.parseDouble(millasField.getText());

                double totalMetros = km * 1000 + pies * 0.3048 + millas * 1609.34;
                double totalYardas = totalMetros * 1.09361;

                textArea.append("Total longitud en metros: " + totalMetros + " m\n");
                textArea.append("Total longitud en yardas: " + totalYardas + " yd\n");
                textArea.requestFocus();
            }
        });

        panel.add(scrollPane);
        panel.add(kmLabel);
        panel.add(kmField);
        panel.add(piesLabel);
        panel.add(piesField);
        panel.add(millasLabel);
        panel.add(millasField);
        panel.add(calcularButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}