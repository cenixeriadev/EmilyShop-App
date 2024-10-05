package Projecto_Final;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Principal extends JFrame implements ActionListener {
    // Declarar los objetos
    private JPanel mainPanel;
    private JButton ventasButton, inventarioButton, eliminarButton, cierreCajaButton;
    private JLabel ventasLabel,TitleFrame, inventarioLabel, eliminarLabel, cierreCajaLabel;

    public Menu_Principal() {
        // Inicializar el marco principal
        //setLocation(400, 100);
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null); // Usar layout nulo para setBounds
        setLocationRelativeTo(null);
        // Inicializar los botones y etiquetas

        TitleFrame = new JLabel("CALZADOS EMILY'S");
        TitleFrame.setFont(new Font("Arial", Font.BOLD, 24));
        TitleFrame.setBounds(180, 120, 500, 30); // Mover el título un poco más abajo
        add(TitleFrame);
        ventasLabel = new JLabel("Ingrese ventas");
        ventasLabel.setBounds(230, 180, 200, 30);

        eliminarLabel = new JLabel("Elimine una venta específica");
        eliminarLabel.setBounds(230, 280, 200, 30);

        inventarioLabel = new JLabel("Ingrese cantidad de mercadería");
        inventarioLabel.setBounds(230, 230, 200, 30);


        ventasButton = new JButton("VENTAS");
        ventasButton.setBounds(100, 180, 120, 30); // Ajustar tamaño y posición
        ventasButton.addActionListener(this);


        inventarioButton = new JButton("INVENTARIO");
        inventarioButton.setBounds(100, 230, 120, 30);
        inventarioButton.addActionListener(this);


        eliminarButton = new JButton("ELIMINAR");
        eliminarButton.setBounds(100, 280, 120, 30);
        eliminarButton.addActionListener(this);


        cierreCajaButton = new JButton("CIERRE CAJA");
        cierreCajaButton.setBounds(100, 330, 120, 30);
        cierreCajaButton.addActionListener(this);
        cierreCajaLabel = new JLabel("Cerrar ventas del día con reporte");
        cierreCajaLabel.setBounds(230, 330, 200, 30);

        // Inicializar el panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(null); // Usar layout nulo para setBounds
        mainPanel.setBounds(0, 0, 400, 400);

        // Agregar los botones y etiquetas al panel principal
        mainPanel.add(ventasButton);
        mainPanel.add(ventasLabel);
        mainPanel.add(inventarioButton);
        mainPanel.add(inventarioLabel);
        mainPanel.add(eliminarButton);
        mainPanel.add(eliminarLabel);
        mainPanel.add(cierreCajaButton);
        mainPanel.add(cierreCajaLabel);

        // Agregar el panel principal al marco
        add(mainPanel);

        // Hacer visible el marco
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventasButton) {
            Ventas ventas = new Ventas();
            ventas.setVisible(true);

        } else if (e.getSource() == inventarioButton) {
            Inventario inventario = new Inventario();
            inventario.setVisible(true);

        } else if (e.getSource() == eliminarButton) {
            Eliminar_Venta DeleteVenta  =new Eliminar_Venta();
            DeleteVenta.setVisible(true);
        }
        this.dispose();
    }
    public static void main(String[] args) {
        // Crear y mostrar la ventana
        Menu_Principal frame = new Menu_Principal();
        frame.setVisible(true);
    }
}

