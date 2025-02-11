package Vista;
import javax.swing.*;

import Utilitario.BotonPersonalizado;
import Utilitario.ManagerPath;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import Utilitario.PanelDegradadoAzul;

public class ReporteVista extends JFrame{
    //---panel---
    JPanel panelusuario;

    //--------------nuevo------------------
    JLabel  lblInventario, lblVentas, lblReporte;
    JButton btnInventario , btnVentas;
    JLabel lblFechaDesde, lblFechaHasta;
    JDateChooser dateChooserDesde, dateChooserHasta;
    //----------------------------------------

    public ReporteVista() {
        setTitle("Menu Calzados Emily´s");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 840);
        setResizable(false);

        //-----------panel Fondo----------
        panelusuario = new PanelDegradadoAzul();
        panelusuario.setBounds(0,70,1140,540);
        panelusuario.setLayout(null);
        add(panelusuario);

        //-------------NUEVO------------------------
        //------------dentro de Panel----------
        lblReporte= new JLabel("REPORTE GENERAL");
        lblReporte.setBounds(400,75,580,60);
        lblReporte.setForeground(Color.WHITE); // Color del texto
        lblReporte.setFont(new Font("Times New Roman", Font.BOLD, 35)); // Estilo de fuente
        panelusuario.add(lblReporte);

        lblInventario= new JLabel("Reporte General Inventario");
        lblInventario.setForeground(Color.WHITE);
        lblInventario.setFont(new Font("Times New Roman", Font.BOLD,22));
        lblInventario.setBounds(450,160,300,40);
        panelusuario.add(lblInventario);

        btnInventario = new BotonPersonalizado("CREAR ",ManagerPath.getRuta("reporte.png"),null);
        btnInventario.setBounds(500, 210, 160, 40);
        panelusuario.add(btnInventario);

        lblVentas= new JLabel("Reporte Ventas por Fecha");
        lblVentas.setForeground(Color.WHITE);
        lblVentas.setFont(new Font("Times New Roman", Font.BOLD,22));
        lblVentas.setBounds(450,260,300,40);
        panelusuario.add(lblVentas);

        btnVentas = new BotonPersonalizado("CREAR", ManagerPath.getRuta("reporte.png"),null);
        btnVentas.setBounds(500, 410, 160, 40);
        panelusuario.add(btnVentas);

        lblFechaDesde = new JLabel("Desde:");
        lblFechaDesde.setForeground(Color.WHITE);
        lblFechaDesde.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblFechaDesde.setBounds(450, 310, 80, 30);
        panelusuario.add(lblFechaDesde);

        dateChooserDesde = new JDateChooser();
        dateChooserDesde.setBounds(550, 310, 150, 30);
        dateChooserDesde.setDateFormatString("yyyy-MM-dd");
        panelusuario.add(dateChooserDesde);

        lblFechaHasta = new JLabel("Hasta:");
        lblFechaHasta.setForeground(Color.WHITE);
        lblFechaHasta.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblFechaHasta.setBounds(450, 360, 80, 30);
        panelusuario.add(lblFechaHasta);

        dateChooserHasta = new JDateChooser();
        dateChooserHasta.setBounds(550, 360, 150, 30);
        dateChooserHasta.setDateFormatString("yyyy-MM-dd");
        panelusuario.add(dateChooserHasta);

        //---------------------------------------------------------------------
    }
    public JPanel getPanelUsuario() {
        return panelusuario;
    }
    public JDateChooser getDateChooserDesde() {
        return dateChooserDesde;
    }
    public JDateChooser getDateChooserHasta() {
        return dateChooserHasta;
    }
    public JButton getBtnInventario() {
        return  btnInventario;
    }
    public JButton getBtnVentas() {
        return btnVentas;
    }

}

