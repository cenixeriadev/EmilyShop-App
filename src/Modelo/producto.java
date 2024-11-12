package Modelo;
@SuppressWarnings("ALL")
public class producto {
    private int idproducto ;
    private int idinventario;
    private String modelo;
    private String codigo;
    private String color ;
    private int talla;

    public void setIdProducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
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
    public int getIdinventario() {
        return idinventario;
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
