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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentaPDF {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection cn = null;
    ArrayList<ventas> listaCarrito = new ArrayList<>();
    ventas objVentas;
    //metodo para obtener datos del cliente
    public ArrayList<ventas> DatosCliente(String nombCliente) {
        try {
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("SELECT id_cliente ,metodo_pago , total_venta , fecha_venta FROM ventas WHERE id_cliente = ?;");
            ps.setString(1,nombCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                objVentas = new ventas();
                objVentas.setId_cliente(rs.getInt("id_cliente"));
                objVentas.setMetodo_pago(rs.getString("metodo_pago"));
                objVentas.setFecha_venta(rs.getTimestamp("fecha_venta"));
                objVentas.setTotal_venta(rs.getDouble("total_venta"));

                listaCarrito.add(objVentas);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
        return  listaCarrito;
    }
    public void generarFactura(ArrayList<carrito> listaproductos , ArrayList<ventas> listaventas) {
        try {
            //cargar la fecha actual
            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                    break;
                }
            }

            // Crear el documento
            Document doc = new Document(PageSize.A4, 36, 36, 20, 20);
            int nombreArchivo =  listaventas.getFirst().getId_cliente();
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivo + fechaNueva + ".pdf");//agregue fecha actual para el nombre de la ruta y el de el open doc es el mismo
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
            String direccion = """
                    Jr san cristobal N° 1660 1er sotano tda 070 Galeria YUYI
                    """ +
                    """
                    Fabricados Directo de Trujillo
                    """.indent(6);
            celdaInfo.setBorder(Rectangle.NO_BORDER);
            celdaInfo.addElement(new Paragraph("Calzatura Emily".indent(4) + "Ventas al por Mayor y  Menor".indent(2), new Font(Font.FontFamily.HELVETICA, 14, Font.UNDERLINE)));
            celdaInfo.addElement(new Paragraph("RUC: 10600700214"));
            celdaInfo.addElement(new Paragraph(direccion));
            celdaInfo.addElement(new Paragraph("Cel: 955151725".indent(5)));
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
            clienteCell.addElement(new Paragraph("Cliente: " + listaventas.getFirst().getId_cliente() ));
            clienteCell.addElement(new Paragraph("DNI: 06907263"));
            clienteCell.addElement(new Paragraph("Dirección: CALLE PEDRO RUIZ NRO. 129, SURQUILLO, LIMA, LIMA, PERÚ"));
            clienteCell.addElement(new Paragraph("Teléfono: " + listaventas.getFirst().getMetododepago()));
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
                    new PdfPCell(new Phrase("Método de pago", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Descripción", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("P. Unit.", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE))),
                    new PdfPCell(new Phrase("Total", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE)))
            };

            for (PdfPCell celda : encabezados) {
                celda.setBackgroundColor(BaseColor.BLUE);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaProductos.addCell(celda);
            }
            double totalventa = 0;
            // Agregar filas de ejemplo
            for (int i = 0; i <= listaventas.size()-1 ; i++) {
                tablaProductos.addCell(String.valueOf(i+1));
                tablaProductos.addCell("1");
                tablaProductos.addCell(listaventas.get(i).getMetododepago());//codigo
                //tablaProductos.addCell(listaproductos.get(i).get()+" " + listaproductos.get(i).getColor() + " " + listaproductos.get(i).getTalla());//descripcion
                tablaProductos.addCell(String.valueOf(listaventas.get(i).getTotal_venta()) +" Soles");//precio unitario
                tablaProductos.addCell(String.valueOf(listaventas.get(i).getTotal_venta())+" Soles");//precio total del producto
                totalventa += listaventas.get(i).getTotal_venta();
            }

            doc.add(tablaProductos);

            // Total
            PdfPTable totales = new PdfPTable(2);
            totales.setWidthPercentage(40);
            totales.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totales.setWidths(new float[]{1,1});

            totales.addCell(new PdfPCell(new Phrase("TOTAL:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD))));
            totales.addCell(new PdfPCell(new Phrase(String.valueOf(totalventa)+" Soles")));

            doc.add(totales);

            doc.add(new Paragraph("\n"));

            // Pie de página
            Paragraph pie = new Paragraph("Gracias por su compra.", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
            pie.setAlignment(Element.ALIGN_CENTER);
            doc.add(pie);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(new File("src/pdf/" + nombreArchivo + fechaNueva + ".pdf"));

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
