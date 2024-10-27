package Modelo;
public class producto {
    private int idproducto ;
    private int idventa2;
    private String modelo;
    private String codigo;
    private String color ;
    private int talla;

    public void setIdProducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public void setIdVenta2(int idventa2) {
        this.idventa2 = idventa2;
    }
    public void setModel(String modelo) {
        this.modelo = modelo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getIdProducto() {
        return idproducto;
    }
    public int getIdVenta2() {
        return idventa2;
    }
    public String getModel() {
        return modelo;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getColor() {
        return color;
    }
    public int getTalla() {
        return talla;
    }

}
