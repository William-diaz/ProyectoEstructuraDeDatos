package co.uniquindio.proyectoestructuradedatos;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {

    private List<Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        // Añadir un usuario de ejemplo
        usuarios.add(new Usuario("admin", "admin123", Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("usuario", "user123", Rol.USUARIO_REGULAR));
    }

    public Usuario autenticar(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public void agregarUsuario(String nombreUsuario, String contraseña, Rol rol) {
        usuarios.add(new Usuario(nombreUsuario, contraseña, rol));
    }
}
