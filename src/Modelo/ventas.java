package Modelo;
import java.text.DateFormat;
import java.sql.Date;

public class ventas {

    private int idventas;
    private String  cliente;
    private String metododepago;
    private int precio;
    private Date horaventa;

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setHoraventa(Date horaventa) {
        this.horaventa = horaventa;
    }
    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }


    public int getIdventas() {
        return idventas;
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
    public Date getHoraventa() {
        return horaventa;
    }

}
