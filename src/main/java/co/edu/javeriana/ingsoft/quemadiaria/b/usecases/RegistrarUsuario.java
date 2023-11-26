package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;


public class RegistrarUsuario {
    private UsuarioRepositorio usuarioRepositorio;

    public RegistrarUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.guardarUsuario(usuario);
    }
}
