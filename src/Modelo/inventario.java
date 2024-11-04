package Modelo;

public class inventario {
    // El modelo solo encargarse de la logica de los datos y no tener relacion directa 
    // con la vista
    private int idinventario ;
    private int preciocosto;
    private int talla;
    private String modelo;
    private String codigo;
    private String color ;

    public void setPrecioCosto(int preciocosto){
        this.preciocosto = preciocosto;
    }
    public void setIdinventario(int idinventario){this.idinventario = idinventario;}
    public void setModel(String modelo){
        this.modelo = modelo;
    }
    public void setColor(String color){
        this.color = color;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setTalla(int talla){
        this.talla = talla;
    }


    public int getIdInventario(){ return idinventario;}
    public int getPrecioCosto(){
        return preciocosto;
    }
    public String getModel(){
        return modelo;
    }
    public String getColor(){
        return color;
    }
    public String getCodigo(){return codigo; }
    public int getTalla(){
        return talla; 
    }
    
}
