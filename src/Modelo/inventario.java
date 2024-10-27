package Modelo;

public class inventario {
    // El modelo solo encargarse de la logica de los datos y no tener relacion directa 
    // con la vista
    private int preciocosto;
    private int idproducto2;
    private int idinventario;
    private int talla;
    private String modelo;
    private String codigo;
    private String color ;

    public void setIdProducto2(int idproducto2 ){
        this.idproducto2 = idproducto2;
    }
    public void setPrecioCosto(int preciocosto){
        this.preciocosto = preciocosto;
    }
    public void setIdInventario(int idinventario){
        this.idinventario = idinventario;
    }
    public void setModel(String modelo){
        this.modelo = modelo;
    }
    public void setColor(String color){
        this.color = color;
    }

    public void setCodigo(int idproducto2){
        this.idproducto2 = idproducto2;
    }
    public void setTalla(int talla){
        this.talla = talla;
    }

    public int getPrecioCosto(){
        return preciocosto;
    }
    public int getIdInventario(){
        return idinventario;
    }
    public String getModel(){
        return modelo;
    }
    public String getColor(){
        return color;
    }
    public int getCodigo(){
        return idproducto2;
    }
    public int getIdproducto(){
        return idproducto2;
    }
    public int getTalla(){
        return talla; 
    }
    
}
