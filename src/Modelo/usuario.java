package Modelo;

public class usuario {
    private int idusuario;
    private String apellidoynombre;
    private String contraseña;


    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public void setApellidoynombre(String apellidoynombre) {
        this.apellidoynombre = apellidoynombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdusuario() {
        return idusuario;
    }
    public String getNames(){
        return apellidoynombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}
