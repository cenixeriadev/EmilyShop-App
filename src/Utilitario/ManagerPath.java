package Utilitario;


public class ManagerPath {

    public static String getRuta(String path) {
        path = System.getenv("DOCKER_ENV") != null ? "/app/Recursos/".concat(path) : (path.contains("gif") ? "Recursos/" : "C:\\Users\\Lenovo\\IdeaProjects\\Practice\\src\\Recursos\\").concat(path);
        return path;
    }
}
