package Modelo;

import java.util.ArrayList;

public class Modelo_Inventario implements MetodosInventario {
    ArrayList<inventario> listaInventario =  new ArrayList<>();
    inventario objInventario ;
    inventarioDAO objInventarioDAO  = new inventarioDAO();


    @Override
    public void CargarDatos() {

    }

    @Override
    public void ModificarProducto() {

    }

    @Override
    public void EliminarProducto() {

    }

    @Override
    public void AgregarProducto() {

    }
}
