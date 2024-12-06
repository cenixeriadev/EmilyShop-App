package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class clientes {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getId_cliente(){return id_cliente;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getTelefono(){return telefono;}

    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<clientes> listaClientes = null;
    clientes objCliente = null;

}
