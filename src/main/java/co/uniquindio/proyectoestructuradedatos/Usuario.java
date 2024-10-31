package co.uniquindio.proyectoestructuradedatos;

public class Usuario {

    //Datos del usuario
    private String nombreUsuario;
    private String contraseña;
    private Rol rol;


    //Constructor
    public Usuario(String nombreUsuario, String contraseña, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    //Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public Rol getRol() {
        return rol;
    }
}
