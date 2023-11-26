package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ConsultarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
public class ConsultaUsuarioService {
    private ConsultarUsuario consultarUsuario = ConsultarUsuario.getInstance();

    public Usuario consultarUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }
        Usuario usuarioActual = consultarUsuario.consultarUsuario(loginDTO);
        return usuarioActual;
    }

    public Usuario consultarUsuarioPorUserName(String userName) {
        if (userName == null ) {
            throw new IllegalArgumentException("Invalido username");
        }
        Usuario usuarioActual = consultarUsuario.consultarUsuarioPorUserName2(userName);
        return usuarioActual;
    }

}