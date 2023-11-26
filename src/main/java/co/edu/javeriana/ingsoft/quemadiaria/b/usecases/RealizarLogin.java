package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;

public class RealizarLogin {

    private UsuarioRepositorio usuarioRepositorio;

    public RealizarLogin(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public void login(String nombreUsuario, String contrasenna) {

        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);

        if(!usuario.getCredenciales().validarCredenciales(nombreUsuario, contrasenna))
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_CREDENCIALES_INVALIDAS, "Credenciales invalidas 1");
    }

}
