package Modelo;

import Utilitario.ConexionBD;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

public class VentaPDF {
    private String nombreCliente;
    private String horaventa;
    private String telefonoCliente;
    private String precioVenta;

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection cn = null;
    //metodo para obtener datos del cliente
    public void DatosCliente(String nombCliente) {
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT cliente , telefono  , precio , horaventa FROM ventas WHERE cliente = ?;");
            ps.setString(1,nombCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombreCliente = rs.getString("cliente");
                horaventa = rs.getString("horaventa");
                telefonoCliente = rs.getString("telefono");
                precioVenta = rs.getString("precio");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }
    public void generarFactura() {
        try {
            // Crear el documento
            Document doc = new Document(PageSize.A4, 36, 36, 20, 20);
            String nombreArchivo = "Boleta_Electronica.pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivo);
            archivo = new FileOutputStream(file);
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            // Agregar el logo
            Image img = Image.getInstance("src/Recursos/logoempresa.png");
            img.scaleAbsolute(100, 50);
            img.setAlignment(Element.ALIGN_LEFT);

            // Encabezado de la empresa
            PdfPTable encabezado = new PdfPTable(2);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new float[]{2, 5});

            PdfPCell celdaLogo = new PdfPCell(img);
            celdaLogo.setBorder(Rectangle.NO_BORDER);
            encabezado.addCell(celdaLogo);

            PdfPCell celdaInfo = new PdfPCell();
            celdaInfo.setBorder(Rectangle.NO_BORDER);
            celdaInfo.addElement(new Paragraph("Calzatura Emily \n Ventas al por Mayor y  Menor", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            celdaInfo.addElement(new Paragraph("RUC: 10600700214"));
            celdaInfo.addElement(new Paragraph("Jr san cristobal N° 1660 1er sotano tda 070 Galeria YUYI \n\t Fabricados Directo de Trujillo"));
            celdaInfo.addElement(new Paragraph("Cel: 955151725"));
            encabezado.addCell(celdaInfo);

            doc.add(encabezado);

            // Línea separadora
            doc.add(new Paragraph("\n"));

            // Título del documento
            Paragraph titulo = new Paragraph("BOLETA ELECTRÓNICA BB01-2", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            doc.add(new Paragraph("\n"));

            // Datos del cliente y otros documentos
            PdfPTable datosCliente = new PdfPTable(1);
            datosCliente.setWidthPercentage(100);
            datosCliente.setWidths(new float[]{1});

            PdfPCell clienteCell = new PdfPCell();
            clienteCell.setBorder(Rectangle.ALIGN_RIGHT);
            clienteCell.addElement(new Paragraph("Datos del cliente", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE)));
            clienteCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            clienteCell.addElement(new Paragraph("Cliente: GERARDO ESPINOZA"));
            clienteCell.addElement(new Paragraph("DNI: 06907263"));
            clienteCell.addElement(new Paragraph("Dirección: CALLE PEDRO RUIZ NRO. 129, SURQUILLO, LIMA, LIMA, PERÚ"));
            clienteCell.addElement(new Paragraph("Teléfono: 2425154"));
            datosCliente.addCell(clienteCell);

            doc.add(datosCliente);

            doc.add(new Paragraph("\n"));

            // Tabla de productos
            PdfPTable tablaProductos = new PdfPTable(6);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setWidths(new float[]{10, 15, 20, 35, 10, 15});

            PdfPCell[] encabezados = {
                    new PdfPCell(new Phrase("#", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Cant.", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Código", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Descripción", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("P. Unit.", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Total", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE)))
            };

            for (PdfPCell celda : encabezados) {
                celda.setBackgroundColor(BaseColor.BLUE);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaProductos.addCell(celda);
            }

            // Agregar filas de ejemplo
            for (int i = 1; i <= 3; i++) {
                tablaProductos.addCell(String.valueOf(i));
                tablaProductos.addCell("1");
                tablaProductos.addCell("10000" + i);
                tablaProductos.addCell("Producto de prueba " + i);
                tablaProductos.addCell("S/ 10.00");
                tablaProductos.addCell("S/ 10.00");
            }

            doc.add(tablaProductos);

            // Total
            PdfPTable totales = new PdfPTable(2);
            totales.setWidthPercentage(40);
            totales.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totales.setWidths(new float[]{1, 1});

            totales.addCell(new PdfPCell(new Phrase("SUB TOTAL:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD))));
            totales.addCell(new PdfPCell(new Phrase("S/ 30.00")));

            totales.addCell(new PdfPCell(new Phrase("IGV:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD))));
            totales.addCell(new PdfPCell(new Phrase("S/ 5.40")));

            totales.addCell(new PdfPCell(new Phrase("TOTAL:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD))));
            totales.addCell(new PdfPCell(new Phrase("S/ 35.40")));

            doc.add(totales);

            doc.add(new Paragraph("\n"));

            // Pie de página
            Paragraph pie = new Paragraph("Gracias por su compra.", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
            pie.setAlignment(Element.ALIGN_CENTER);
            doc.add(pie);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(new File("src/pdf/" + nombreArchivo));

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
