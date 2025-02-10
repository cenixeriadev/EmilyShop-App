package Controlador;

import Modelo.Modelo_Reporte_Ventas;
import Utilitario.PDFinventario;
import Utilitario.PDFventas;
import Vista.ReporteVista;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControladorReportes {
    private final  ReporteVista reporteVista;
    private final PDFinventario InventarioReporte = new PDFinventario();
    private Modelo_Reporte_Ventas objVentaspdf;
    private ArrayList<Modelo_Reporte_Ventas> listaTablaVentasMpago;
    private  ArrayList<Modelo_Reporte_Ventas> listaTablaProductosVendidos;
    private double totalVentas ,MargenDeGanancia;
    private int cantidadVendida;
    public ControladorReportes(ReporteVista reporteVista ) {
        this.reporteVista = reporteVista;
        IniciarEventos();
    }
    private void IniciarEventos(){
        reporteVista.getBtnInventario().addActionListener(e -> InventarioReporte.generarReporteInventario());
        reporteVista.getBtnVentas().addActionListener(e->{
            try {
                objVentaspdf = new Modelo_Reporte_Ventas();
                Date fechaDesde = reporteVista.getDateChooserDesde().getDate();
                Date fechaHasta = reporteVista.getDateChooserHasta().getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaHastaFmd = formato.format(fechaHasta);
                String fechaDesdeFmd = formato.format(fechaDesde);
                listaTablaVentasMpago = objVentaspdf.getTablaVentasMpago(fechaDesdeFmd, fechaHastaFmd);
                totalVentas = objVentaspdf.TotalVentas(fechaDesdeFmd, fechaHastaFmd);
                listaTablaProductosVendidos = objVentaspdf.getTablasProductosVendidos(fechaDesdeFmd, fechaHastaFmd);
                MargenDeGanancia = objVentaspdf.MargenDeGanancia(fechaDesdeFmd, fechaHastaFmd);
                cantidadVendida = objVentaspdf.cantidadVendida(fechaDesdeFmd, fechaHastaFmd);
                PDFventas.GenerarPdfVentas(fechaDesdeFmd, fechaHastaFmd, listaTablaVentasMpago, listaTablaProductosVendidos, totalVentas, MargenDeGanancia, cantidadVendida);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(reporteVista, "Debe seleccionar las fechas");
            }
        });
    }
}
