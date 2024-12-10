package Controlador;

import Modelo.Modelo_Reportes;
import Utilitario.PDFinventario;
import Vista.ReporteVista;

public class ControladorReportes {
    private final  ReporteVista reporteVista;
    private final PDFinventario InventarioReporte = new PDFinventario();
    public ControladorReportes(ReporteVista reporteVista ) {
        this.reporteVista = reporteVista;
        IniciarEventos();
    }
    private void IniciarEventos(){
        reporteVista.getBtnInventario().addActionListener(e -> InventarioReporte.generarReporteInventario());
        //reporteVista.getBtnVentas().addActionListener(e -> );
    }
}
