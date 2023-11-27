package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;


public class RegistrarUsuario {
    private UsuarioRepositorio usuarioRepositorio;

    private static RegistrarUsuario instance;

    private RegistrarUsuario(UsuarioRepositorio usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static RegistrarUsuario getInstance() {
        if (instance == null) {
            instance = new RegistrarUsuario(new UsuarioArchivosRepositorio());
        }
        return instance;
    }


    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario esta vacio");
        }
        usuarioRepositorio.guardarUsuario(usuario);
    }
}
