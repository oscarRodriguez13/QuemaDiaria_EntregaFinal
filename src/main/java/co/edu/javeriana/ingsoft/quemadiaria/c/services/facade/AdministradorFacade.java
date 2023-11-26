package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public interface AdministradorFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);

    ResponseDTO<String> registrarUsuario(UsuarioDTO usuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
