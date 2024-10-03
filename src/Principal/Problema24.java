package Principal;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Problema24 extends JFrame {

    // Componentes de la interfaz
    private JTextField inputTimeField;
    private JTextField inputSecondsField;
    private JTextField resultField;
    private JButton calculateButton;

    public Problema24() {
        setTitle("Calculadora de Tiempo");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);  // Sin layout manager

        // Etiquetas
        JLabel timeLabel = new JLabel("Hora (HH:MM:SS): ");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel secondsLabel = new JLabel("Segundos a sumar: ");
        secondsLabel.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel resultLabel = new JLabel("Hora resultante: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD , 13));

        // Campos de texto
        inputTimeField = new JTextField();
        inputSecondsField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);  // Solo lectura para el resultado

        // Botón para calcular
        calculateButton = new JButton("Calcular");

        // Definir posiciones y tamaños con setBounds(x, y, width, height)
        timeLabel.setBounds(30, 30, 150, 25);
        inputTimeField.setBounds(180, 30, 150, 25);

        secondsLabel.setBounds(30, 70, 150, 25);
        inputSecondsField.setBounds(180, 70, 150, 25);

        resultLabel.setBounds(30, 110, 150, 25);
        resultField.setBounds(180, 110, 150, 25);

        calculateButton.setBounds(140, 150, 100, 30);

        // Agregamos los componentes al frame
        add(timeLabel);
        add(inputTimeField);
        add(secondsLabel);
        add(inputSecondsField);
        add(resultLabel);
        add(resultField);
        add(calculateButton);


        // Acción del botón
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateNewTime();
            }
        });
    }


    private void calculateNewTime() {
        try {
            // Tomamos la hora y los segundos ingresados
            String timeInput = inputTimeField.getText();
            int secondsToAdd = Integer.parseInt(inputSecondsField.getText());

            // Verificamos si los segundos ingresados son negativos
            if (secondsToAdd < 0) {
                throw new IllegalArgumentException("No se permiten segundos negativos.");
            }

            // Validamos el formato de la hora (HH:mm:ss) utilizando una expresión regular
            String timePattern = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";//regex
            if (!timeInput.matches(timePattern)) {
                throw new IllegalArgumentException("El formato de la hora es inválido. Debe ser HH:mm:ss.");
            }

            // Parseamos la hora ingresada
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date time = format.parse(timeInput);

            // Sumamos los segundos
            long newTimeInMillis = time.getTime() + (secondsToAdd * 1000L);
            Date newTime = new Date(newTimeInMillis);

            // Mostramos el resultado
            resultField.setText(format.format(newTime));
            resultField.requestFocus();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {

        Problema24 ventanacal = new Problema24();
        ventanacal.setVisible(true);
    }
}

