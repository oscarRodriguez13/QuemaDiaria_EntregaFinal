package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;

public interface EliminarUsuarioFacade {
    boolean eliminarUsuario(LoginDTO loginDTO);
}
