package Utilitario;

import Modelo.clientes;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BoletaPDF {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection cn = null;
    private  ArrayList<BoletaPDF> listaBoleta;
    private BoletaPDF objBoleta;
    private int cantidad;
    private String metodoPago;
    private String descripcion;
    private int talla;
    private String marca;
    private String color;
    private double precioUnitario;
    private double subtotal;
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTalla(int talla) {
        this.talla = talla;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public int getCantidad() {
        return cantidad;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getTalla() {
        return talla;
    }
    public String getMarca() {
        return marca;
    }
    public String getColor() {
        return color;
    }

    public ArrayList<BoletaPDF> generarDatos(clientes objClientes){
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("select d.cantidad , v.metodo_pago , i.descripcion , i.talla , i.marca , i.color , d.precio_unitario , d.subtotal from detalle_ventas d inner join ventas v on d.id_venta = v.id_venta inner join clientes c on v.id_cliente = c.id_cliente inner join inventario i on i.id_inventario = d.id_inventario WHERE c.id_cliente =?;");
            ps.setInt(1, objClientes.getId_cliente());
            rs = ps.executeQuery();
            listaBoleta = new ArrayList<>();
            while (rs.next()) {
                objBoleta = new BoletaPDF();
                objBoleta.setCantidad(rs.getInt("cantidad"));
                objBoleta.setMetodoPago(rs.getString("metodo_pago"));
                objBoleta.setDescripcion(rs.getString("descripcion"));
                objBoleta.setTalla(rs.getInt("talla"));
                objBoleta.setMarca(rs.getString("marca"));
                objBoleta.setColor(rs.getString("color"));
                objBoleta.setPrecioUnitario(rs.getDouble("precio_unitario"));
                objBoleta.setSubtotal(rs.getDouble("subtotal"));
                listaBoleta.add(objBoleta);
            }
            return listaBoleta;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return listaBoleta;
    }

    public  void generarFactura(ArrayList<BoletaPDF> boleta ,clientes cliente) {
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
            FileOutputStream archivo;
            File file = new File("src/pdf/" + "Boleta" + cliente.getNombre_apellido() + fechaNueva + ".pdf");//agregue fecha actual para el nombre de la ruta y el de el open doc es el mismo
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
            Paragraph titulo = new Paragraph("BOLETA DE VENTA REALIZADA", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
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
            clienteCell.addElement(new Paragraph("Cliente: " + cliente.getNombre_apellido()));
            clienteCell.addElement(new Paragraph("Teléfono: " + cliente.getTelefono()));
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
                    new PdfPCell(new Phrase("SubTotal", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE)))
            };

            for (PdfPCell celda : encabezados) {
                celda.setBackgroundColor(BaseColor.BLUE);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaProductos.addCell(celda);
            }
            double totalventa = 0;
            // Agregar filas de ejemplo
            for (int i = 0; i <= listaBoleta.size()-1 ; i++) {
                tablaProductos.addCell(String.valueOf(i+1));
                tablaProductos.addCell(String.valueOf(listaBoleta.get(i).getCantidad()));
                tablaProductos.addCell(listaBoleta.get(i).getMetodoPago());
                tablaProductos.addCell(listaBoleta.get(i).getMarca() +" " +  listaBoleta.get(i).getColor()+ " " + String.valueOf(listaBoleta.get(i).getTalla()) + " " + listaBoleta.get(i).getDescripcion());
                tablaProductos.addCell(String.valueOf(listaBoleta.get(i).getPrecioUnitario()) +" Soles");//precio unitario
                tablaProductos.addCell(String.valueOf(listaBoleta.get(i).getSubtotal())+" Soles");//precio total del producto
                totalventa += listaBoleta.get(i).getSubtotal();
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

            Desktop.getDesktop().open(new File("src/pdf/" + "Boleta" + cliente.getNombre_apellido() + fechaNueva + ".pdf"));

        } catch (IOException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error al generar pdf!");
        }
    }
}
