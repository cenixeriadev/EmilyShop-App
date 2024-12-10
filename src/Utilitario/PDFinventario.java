package Utilitario;

import Modelo.Modelo_Reporte_Ventas;
import java.awt.Desktop;
import Modelo.inventario;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PDFinventario {
    private ArrayList<inventario> listaInventario ;
    private Modelo_Reporte_Ventas modelo = new Modelo_Reporte_Ventas();
    public void generarReporteInventario() {
        String rutaArchivo = "src/pdf/reporte_inventario_zapatillas.pdf";//cambiar nombre de archivo

        // Crear documento
        Document documento = new Document();
        try {
            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _

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
            tablaInfo.addCell(String.valueOf(modelo.TotalProductos()));
            tablaInfo.addCell(celda("Última Actualización", BaseColor.LIGHT_GRAY));
            tablaInfo.addCell(fechaActual);

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
            inventario objinventario = new inventario();
            listaInventario = objinventario.listarInventario();
            for (inventario ObjInventario : listaInventario) { // codigo  marca color  talla  cantidad P.compra PVenta
                tablaInventario.addCell(ObjInventario.getCodigo());
                tablaInventario.addCell(ObjInventario.getMarca());
                tablaInventario.addCell(ObjInventario.getColor());
                tablaInventario.addCell(String.valueOf(ObjInventario.getTalla()));
                tablaInventario.addCell(String.valueOf(ObjInventario.getStock()));
                tablaInventario.addCell(String.valueOf(ObjInventario.getPrecio_compra()));
                tablaInventario.addCell(String.valueOf(ObjInventario.getPrecio_venta()));
            }
            documento.add(tablaInventario);

            // Pie de página con diseño
            documento.add(new Paragraph("\n"));
            PdfPTable piePagina = new PdfPTable(1);
            PdfPCell celdaPie = new PdfPCell(new Phrase("Reporte generado automáticamente el " + fechaActual ));// cambiar fecha
            celdaPie.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaPie.setBackgroundColor(new BaseColor(149, 165, 166)); // Gris
            celdaPie.setPadding(10);
            piePagina.setWidthPercentage(100);
            piePagina.addCell(celdaPie);
            documento.add(piePagina);

            // Cerrar documento
            documento.close();
            Desktop.getDesktop().open(new File(rutaArchivo));

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

