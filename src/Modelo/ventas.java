package Modelo;

import java.sql.Timestamp;
@SuppressWarnings("ALL")
public class ventas {

    private int idventas;
    private String  cliente;
    private String metododepago;
    private int precio;
    private Timestamp horaventa;
    private int idproducto;
    private int codigo ;

    public void setCodigo(int codigo){this.codigo = codigo;}
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setHoraventa(Timestamp horaventa) {
        this.horaventa = horaventa;
    }
    public void setIdProducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public void setIdventas(int idventas){this.idventas = idventas;}


    public int getCodigo() { return codigo;}
    public int getIdVenta() {
        return idventas;}
    public int getIdProducto() {
        return idproducto;
    }
    public String getCliente() {
        return cliente;
    }
    public String getMetododepago() {
        return metododepago;
    }
    public int getPrecio() {
        return precio;
    }
    public Timestamp getHoraventa() {
        return horaventa;
    }

}
