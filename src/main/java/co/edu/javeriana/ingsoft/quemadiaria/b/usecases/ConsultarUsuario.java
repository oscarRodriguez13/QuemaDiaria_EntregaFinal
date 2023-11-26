package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class ConsultarUsuario {
    UsuarioRepositorio usuarioRepositorio;
    private static ConsultarUsuario instance;

    private ConsultarUsuario(UsuarioRepositorio usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static ConsultarUsuario getInstance() {
        if (instance == null) {
            instance = new ConsultarUsuario(new UsuarioArchivosRepositorio());
        }
        return instance;
    }

    public Usuario consultarUsuario(LoginDTO loginDTO) {
        // Consultar el usuario por nombre de usuario
        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(loginDTO.getUsername());

        // Verificar si el usuario existe
        if (usuario == null) {
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_USUARIO_NO_ENCONTRADO, "Usuario no encontrado: " + loginDTO.getUsername());
        }

        // Validar las credenciales del usuario
        if (!usuario.getCredenciales().validarCredenciales(loginDTO.getUsername(), loginDTO.getPassword())) {
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_CREDENCIALES_INVALIDAS, "Credenciales inválidas");
        }

        // Devolver el usuario consultado
        return usuario;
    }

}
