package Projecto_Final;
import javax.swing.*;
import java.awt.*;

public class Menu_Principal extends JFrame {
    // Declarar los objetos
    private JPanel mainPanel;
    private JButton ventasButton, inventarioButton, eliminarButton, cierreCajaButton;
    private JLabel ventasLabel,TitleFrame, inventarioLabel, eliminarLabel, cierreCajaLabel;

    public Menu_Principal() {
        // Inicializar el marco principal
        setLocation(400, 100);
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null); // Usar layout nulo para setBounds

        // Inicializar los botones y etiquetas

        TitleFrame = new JLabel("CALZADOS EMILY'S");
        TitleFrame.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        TitleFrame.setBounds(180, 120, 500, 30); // Mover el título un poco más abajo
        add(TitleFrame);

        ventasButton = new JButton("VENTAS");
        ventasButton.setBounds(100, 180, 120, 30); // Ajustar tamaño y posición
        ventasLabel = new JLabel("Ingrese ventas");
        ventasLabel.setBounds(230, 180, 200, 30);

        inventarioButton = new JButton("INVENTARIO");
        inventarioButton.setBounds(100, 230, 120, 30);
        inventarioLabel = new JLabel("Ingrese cantidad de mercadería");
        inventarioLabel.setBounds(230, 230, 200, 30);

        eliminarButton = new JButton("ELIMINAR");
        eliminarButton.setBounds(100, 280, 120, 30);
        eliminarLabel = new JLabel("Elimine una venta específica");
        eliminarLabel.setBounds(230, 280, 200, 30);

        cierreCajaButton = new JButton("CIERRE CAJA");
        cierreCajaButton.setBounds(100, 330, 120, 30);
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

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        Menu_Principal frame = new Menu_Principal();
        frame.setVisible(true);
    }
}

