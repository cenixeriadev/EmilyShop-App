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
            ps = cn.prepareStatement("SELECT cliente ,codigo , telefono  , precio , horaventa FROM ventas WHERE cliente = ?;");
            ps.setString(1,nombCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                objVentas = new ventas();
                objVentas.setCliente(rs.getString("cliente"));
                objVentas.setCodigo(rs.getString("codigo"));
                objVentas.setHoraventa(rs.getTimestamp("horaventa"));
                objVentas.setTelefono(rs.getString("telefono"));
                objVentas.setPrecio(rs.getInt("precio"));

                listaCarrito.add(objVentas);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
        return  listaCarrito;
    }
    public void generarFactura(ArrayList<producto> listaproductos , ArrayList<ventas> listaventas) {
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
            String nombreArchivo =  listaventas.getFirst().getCliente();
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
            celdaInfo.setBorder(Rectangle.NO_BORDER);
            celdaInfo.addElement(new Paragraph("\t\tCalzatura Emily \n\tVentas al por Mayor y  Menor", new Font(Font.FontFamily.HELVETICA, 14, Font.UNDERLINE)));
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
            clienteCell.addElement(new Paragraph("Cliente: " + listaventas.getFirst().getCliente() ));
            clienteCell.addElement(new Paragraph("DNI: 06907263"));
            clienteCell.addElement(new Paragraph("Dirección: CALLE PEDRO RUIZ NRO. 129, SURQUILLO, LIMA, LIMA, PERÚ"));
            clienteCell.addElement(new Paragraph("Teléfono: " + listaventas.getFirst().getTelefono()));
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
            int totalventa = 0;
            // Agregar filas de ejemplo
            for (int i = 0; i <= listaventas.size()-1 ; i++) {
                tablaProductos.addCell(String.valueOf(i));
                tablaProductos.addCell("1");
                tablaProductos.addCell(listaventas.get(i).getCodigo());//codigo
                tablaProductos.addCell(listaproductos.get(i).getModel()+" " + listaproductos.get(i).getColor() + " " + listaproductos.get(i).getTalla());//descripcion
                tablaProductos.addCell(String.valueOf(listaventas.get(i).getPrecio()));//precio unitario
                tablaProductos.addCell(String.valueOf(listaventas.get(i).getPrecio()));//precio total del producto
                totalventa += listaventas.get(i).getPrecio();
            }

            doc.add(tablaProductos);

            // Total
            PdfPTable totales = new PdfPTable(2);
            totales.setWidthPercentage(40);
            totales.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totales.setWidths(new float[]{1,1});

            totales.addCell(new PdfPCell(new Phrase("TOTAL:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD))));
            totales.addCell(new PdfPCell(new Phrase(String.valueOf(totalventa))));

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
