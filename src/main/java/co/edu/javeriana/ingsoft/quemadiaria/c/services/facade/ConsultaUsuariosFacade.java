package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ConsultaUsuarioService;

public class ConsultaUsuariosFacade implements ConsultaFacade{

    private ConsultaUsuarioService consultaUsuarioService = new ConsultaUsuarioService();

    @Override
    public Usuario consultarUsuario(LoginDTO loginDTO) {
        return consultaUsuarioService.consultarUsuario(loginDTO);
    }

    @Override
    public Usuario consultarUsuarioPorUsername(String userName) {
        return consultaUsuarioService.consultarUsuarioPorUserName(userName);
    }

}
