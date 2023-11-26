package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;

public class RecuperarCredenciales {

    private UsuarioRepositorio usuarioRepositorio;

    public RecuperarCredenciales(UsuarioRepositorio usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }
    public Credenciales recuperar(String nombreUsuario, String contrasenna) {

        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);

        return usuario.getCredenciales();
    }
}
