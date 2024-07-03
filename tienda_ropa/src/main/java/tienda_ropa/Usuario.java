package tienda_ropa;


public class Usuario {
private String nombreUsuario;
    private String contrasena;
    private String email;

    public Usuario(String nombreUsuario, String contrasena, String email) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    public void ponerNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String obtenerNombreUsuario() {
        return nombreUsuario;
    }

    public void ponerContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String obtenerContrasena() {
        return contrasena;
    }

    public void ponerEmail(String email) {
        this.email = email;
    }

    public String obtenerEmail() {
        return email;
    }
}
