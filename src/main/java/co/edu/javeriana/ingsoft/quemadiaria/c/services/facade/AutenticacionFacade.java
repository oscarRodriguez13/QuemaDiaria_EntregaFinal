package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public interface AutenticacionFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);
    Credenciales recuperarCredenciales(LoginDTO loginDTO);
}
