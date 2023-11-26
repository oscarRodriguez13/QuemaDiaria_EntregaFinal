package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ConsultarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class ConsultaUsuarioService {
    private ConsultarUsuario consultarUsuario = new ConsultarUsuario(new UsuarioArchivosRepositorio());

    public Usuario consultarUsuario(LoginDTO loginDTO) {

        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }
        Usuario usuarioActual = consultarUsuario.consultarUsuario(loginDTO);
        return usuarioActual;
    }
}