
package Utilitario;

import Modelo.Modelo_Reporte_Ventas;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDFventas {

    public static void GenerarPdfVentas(String fechaInicio , String fechaFinal , ArrayList<Modelo_Reporte_Ventas> listaTablaVentasMpago , ArrayList<Modelo_Reporte_Ventas> listaTablaProductosVendidos, double totalVentas , double MargenDeGanancia , int cantidadVendida) {
        String rutaArchivo = "src/pdf/reporte_semanal_ventas.pdf";

        // Crear documento
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
            documento.open();
            String fechaInicioMod = "";
            String fechaFinalMod = "";
            for (int i = 0; i < fechaInicio.length(); i++) {
                if (fechaInicio.charAt(i) == '-') {
                    fechaInicioMod = fechaInicio.replace("-", "/");
                    break;
                }
            }
            for (int i = 0; i < fechaFinal.length(); i++) {
                if (fechaFinal.charAt(i) == '-') {
                    fechaFinalMod = fechaFinal.replace("-", "/");
                    break;
                }
            }
            
            // Tabla para el título y la imagen
            PdfPTable tablaTituloImagen = new PdfPTable(2); // Dos columnas: imagen y título
            tablaTituloImagen.setWidthPercentage(100);
            tablaTituloImagen.setWidths(new float[]{6, 1}); // Ajusta las proporciones entre la imagen y el título
        
            // Título
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.WHITE);
            PdfPCell celdaTitulo = new PdfPCell(new Phrase("REPORTE DE VENTAS", fontTitulo));
            celdaTitulo.setBackgroundColor(new BaseColor(60, 78, 92)); // Azul oscuro
            celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celdaTitulo.setPadding(10);
            celdaTitulo.setBorder(Rectangle.NO_BORDER); // Sin bordes
            tablaTituloImagen.addCell(celdaTitulo);
            
            // Imagen
            Image imagen = Image.getInstance("src/Recursos/nuevologo.png");
            imagen.scaleToFit(70, 70); // Ajusta el tamaño de la imagen
            PdfPCell celdaImagen = new PdfPCell(imagen);
            celdaImagen.setBorder(Rectangle.NO_BORDER); // Sin bordes
            celdaImagen.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinea la imagen a la derecha
            celdaImagen.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaTituloImagen.addCell(celdaImagen);
            
            // Añadir la tabla con el título y la imagen al documento
            documento.add(tablaTituloImagen);
            documento.add(new Paragraph("\n"));

            // Información general
            PdfPTable tablaInfo = new PdfPTable(2);
            tablaInfo.setWidthPercentage(100);
            tablaInfo.setSpacingAfter(10);

            tablaInfo.addCell(celda("Fecha de Inicio", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell(fechaInicioMod);
            tablaInfo.addCell(celda("Fecha de Fin", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell(fechaFinalMod);
            tablaInfo.addCell(celda("Ventas Totales", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("S/. "+ String.valueOf(totalVentas));
            tablaInfo.addCell(celda("Margen de Ganancia", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell( "S/. "+ String.valueOf(MargenDeGanancia));
            tablaInfo.addCell(celda("Cantidad Vendida", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell(String.valueOf(cantidadVendida));

            documento.add(tablaInfo);

            // Tabla de ventas por fechas
            PdfPCell tituloVentasFechas = new PdfPCell(new Phrase("VENTAS DIARIAS POR MÉTODO DE PAGO", fontTitulo));
            tituloVentasFechas.setBackgroundColor(new BaseColor(60, 78, 92)); // Azul
            tituloVentasFechas.setHorizontalAlignment(Element.ALIGN_CENTER);
            tituloVentasFechas.setPadding(10);
            PdfPTable tablaTituloFechas = new PdfPTable(1);
            tablaTituloFechas.setWidthPercentage(100);
            tablaTituloFechas.addCell(tituloVentasFechas);
            documento.add(tablaTituloFechas);
            documento.add(new Paragraph("\n"));

            PdfPTable tablaVentasDia = new PdfPTable(5);
            tablaVentasDia.setWidthPercentage(100);
            tablaVentasDia.setSpacingAfter(10);

            tablaVentasDia.addCell(celda("Día", BaseColor.LIGHT_GRAY));
            tablaVentasDia.addCell(celda("Ventas Yape", BaseColor.LIGHT_GRAY));
            tablaVentasDia.addCell(celda("Ventas Efectivo", BaseColor.LIGHT_GRAY));
            tablaVentasDia.addCell(celda("Ventas Tarjeta", BaseColor.LIGHT_GRAY));
            tablaVentasDia.addCell(celda("Ventas Totales", BaseColor.LIGHT_GRAY));

            System.out.println(listaTablaVentasMpago.size());
            System.out.println(listaTablaProductosVendidos.size());
            for (Modelo_Reporte_Ventas reporteVenta : listaTablaVentasMpago) {
                if (reporteVenta.getDia()!=null) {
                    tablaVentasDia.addCell(reporteVenta.getDia());
                    tablaVentasDia.addCell(String.valueOf(reporteVenta.getVentasYape()));
                    tablaVentasDia.addCell(String.valueOf(reporteVenta.getVentasEfectivo()));
                    tablaVentasDia.addCell(String.valueOf(reporteVenta.getVentasTarjeta()));
                    tablaVentasDia.addCell(String.valueOf(reporteVenta.getVentasTotales()));

                }
            }
            documento.add(tablaVentasDia);

            // Tabla de productos vendidos
            PdfPCell tituloProductosVendidos = new PdfPCell(new Phrase("DETALLE DE PRODUCTOS VENDIDOS", fontTitulo));
            tituloProductosVendidos.setBackgroundColor(new BaseColor(60, 78, 92)); // Azul
            tituloProductosVendidos.setHorizontalAlignment(Element.ALIGN_CENTER);
            tituloProductosVendidos.setPadding(10);
            PdfPTable tablaTituloProductos = new PdfPTable(1);
            tablaTituloProductos.setWidthPercentage(100);
            tablaTituloProductos.addCell(tituloProductosVendidos);
            documento.add(tablaTituloProductos);
            documento.add(new Paragraph("\n"));

            PdfPTable tablaProductos = new PdfPTable(6); // Número de columnas
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setWidths(new float[]{2f, 3f, 2f, 3f, 2f, 3f});

            // Encabezados
            String[] encabezados = {
                    "Código", "Marca", "Cantidad", "Método de Pago", "Precio Venta", "Fecha de Venta"
            };
            for (String encabezado : encabezados) {
                tablaProductos.addCell(celda(encabezado, BaseColor.LIGHT_GRAY));
            }


            for (Modelo_Reporte_Ventas reporteVentas : listaTablaProductosVendidos) {
                if (reporteVentas.getCodigo() != null && reporteVentas.getMarca()!=null && reporteVentas.getMetodo_pago()!=null && reporteVentas.getFechaVenta()!=null) {
                    tablaProductos.addCell(reporteVentas.getCodigo());
                    tablaProductos.addCell(reporteVentas.getMarca());
                    tablaProductos.addCell(String.valueOf(reporteVentas.getCantidad()));
                    tablaProductos.addCell(reporteVentas.getMetodo_pago());
                    tablaProductos.addCell(String.valueOf(reporteVentas.getPrecio_venta()));
                    tablaProductos.addCell(reporteVentas.getFechaVenta());
                }
                // Añadir fecha de venta al pdf en la última columna
            }

            documento.add(tablaProductos);

            // Cerrar documento
            documento.close();
            Desktop.getDesktop().open(new File(rutaArchivo));


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Error al generar el pdf");
        }
    }

    private static PdfPCell celda(String texto, BaseColor colorFondo) {
        PdfPCell celda = new PdfPCell(new Phrase(texto));
        celda.setBackgroundColor(colorFondo);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(5);
        return celda;
    }
}
