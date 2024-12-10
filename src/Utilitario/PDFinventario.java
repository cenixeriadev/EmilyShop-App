package Utilitario;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class PDFinventario {

    public static void main(String[] args) {
        String rutaArchivo = "src/pdf/reporte_inventario_zapatillas.pdf";//cambiar nombre de archivo

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
            PdfPCell celdaTitulo = new PdfPCell(new Phrase("REPORTE DE INVENTARIO ", fontTitulo));
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
            Font fontSubtitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
            documento.add(new Paragraph("Información General del Inventario", fontSubtitulo));
            documento.add(new Paragraph("\n"));

            PdfPTable tablaInfo = new PdfPTable(2);
            tablaInfo.setWidthPercentage(100);
            tablaInfo.setSpacingAfter(10);

            tablaInfo.addCell(celda("Total de Zapatillas en Inventario", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("850");
            tablaInfo.addCell(celda("Última Actualización", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell("09/12/2024");

            documento.add(tablaInfo);

            // Tabla de inventario
            documento.add(new Paragraph("Detalles del Inventario", fontSubtitulo));
            documento.add(new Paragraph("\n"));

            PdfPTable tablaInventario = new PdfPTable(7); // 6 columnas
            tablaInventario.setWidthPercentage(100);
            tablaInventario.setWidths(new float[]{2f, 3f, 2f, 2f, 2f, 2f,2f});
            tablaInventario.setSpacingAfter(10);

            // Encabezados con diseño
            String[] encabezados = {"Código", "Marca", "Color", "Talla", "Cantidad","P.Compra","P.Venta"};
            for (String encabezado : encabezados) {
                tablaInventario.addCell(celda(encabezado, BaseColor.LIGHT_GRAY)); // azul
            }

            // Datos de ejemplo
            String[][] datosInventario = {
                    {"Z001", "Nike", "Negro", "42", "25","$70","$110"},
                    {"Z002", "Adidas", "Blanco", "40", "30","$70","$130"},
                    {"Z003", "Reebok", "Azul", "41", "20","$70","$110"},
                    {"Z004", "ASICS", "Gris", "44", "15","$70","$150"},
                    {"Z005", "Vans", "Rojo", "39", "40","$70","$110"},
                    {"Z006", "Mizuno", "Negro", "43", "20","$70","$110"}
            };

            for (String[] fila : datosInventario) {
                for (String dato : fila) {
                    tablaInventario.addCell(dato);
                }
            }
            documento.add(tablaInventario);

            // Pie de página con diseño
            documento.add(new Paragraph("\n"));
            PdfPTable piePagina = new PdfPTable(1);
            PdfPCell celdaPie = new PdfPCell(new Phrase("Reporte generado automáticamente el 09/12/2024"));// cambiar fecha
            celdaPie.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaPie.setBackgroundColor(new BaseColor(149, 165, 166)); // Gris
            celdaPie.setPadding(10);
            piePagina.setWidthPercentage(100);
            piePagina.addCell(celdaPie);
            documento.add(piePagina);

            // Cerrar documento
            documento.close();
            System.out.println("Reporte de inventario generado correctamente: " + rutaArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPCell celda(String texto, BaseColor colorFondo) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        celda.setBackgroundColor(colorFondo);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(5);
        return celda;
    }
}

