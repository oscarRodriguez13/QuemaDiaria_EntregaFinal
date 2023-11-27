package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class RealizarLogin {

    private static RealizarLogin instance;
    private UsuarioRepositorio usuarioRepositorio;

    private RealizarLogin(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static RealizarLogin getInstance() {
        if (instance == null) {
            instance = new RealizarLogin(new UsuarioArchivosRepositorio());
        }
        return instance;
    }

    public void login(String nombreUsuario, String contrasenna) {

        if (nombreUsuario == null ||  contrasenna == null) {
            throw new IllegalArgumentException("Los datos estan vacio");
        }

        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);

        if(!usuario.getCredenciales().validarCredenciales(nombreUsuario, contrasenna))
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_CREDENCIALES_INVALIDAS, "Credenciales invalidas 1");
    }

}
