package Modelo;
public interface LoginObserver{
    void  loginExitoso(String nombreUsuario);
    void loginFallido(String ErrorMessage);
}
