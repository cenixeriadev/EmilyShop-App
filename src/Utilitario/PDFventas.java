
package Utilitario;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class PDFventas {

    public static void main(String[] args) {
        String rutaArchivo = "reporte_semanal_ventas.pdf";

        // Crear documento
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
            documento.open();

            
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
            Image imagen = Image.getInstance("nuevologo.png");
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
            tablaInfo.addCell("04/12/2024");
            tablaInfo.addCell(celda("Fecha de Fin", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("10/12/2024");
            tablaInfo.addCell(celda("Ventas Totales", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("$12,500.00");
            tablaInfo.addCell(celda("Margen de Ganancia", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("2,500");
            tablaInfo.addCell(celda("Cantidad Vendida", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("320");

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

            String[][] ventasPorDia = {
                    {"Lunes", "1000", "500", "500", "$2,000"},
                    {"Martes", "1000", "500", "500", "$1,800"},
                    {"Miércoles", "1000", "500", "500", "$2,300"},
                    {"Jueves", "1000", "500", "500", "$2,100"},
                    {"Viernes", "1000", "500", "500", "$3,000"},
                    {"Sábado", "1000", "500", "500", "$1,300"},
                    {"Domingo", "1000", "500", "500", "$2,000"}
            };
            for (String[] dia : ventasPorDia) {
                for (String dato : dia) {
                    tablaVentasDia.addCell(dato);
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
                    "Código", "Modelo", "Cantidad", "Método de Pago", "Precio Venta", "Fecha de Venta"
            };
            for (String encabezado : encabezados) {
                tablaProductos.addCell(celda(encabezado, BaseColor.LIGHT_GRAY));
            }

            // Datos de ejemplo
            String[][] datosProductos = {
                    {"P001", "Air Max", "2", "Yape", "$150.00", "04/12/2024"},
                    {"P002", "Superstar", "1", "Efectivo", "$120.00", "05/12/2024"},
                    {"P003", "Old Skool", "3", "Tarjeta", "$180.00", "06/12/2024"},
                    {"P004", "Gel Kayano", "2", "Yape", "$250.00", "07/12/2024"}
            };

            for (String[] fila : datosProductos) {
                for (String dato : fila) {
                    tablaProductos.addCell(dato);
                }
            }

            documento.add(tablaProductos);

            // Cerrar documento
            documento.close();
            System.out.println("Reporte generado correctamente: " + rutaArchivo);

        } catch (Exception e) {
            e.printStackTrace();
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
