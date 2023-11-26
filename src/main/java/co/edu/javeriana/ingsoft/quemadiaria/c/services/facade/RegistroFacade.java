package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;


import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public interface RegistroFacade {

    ResponseDTO<String> registrarUsuario(UsuarioDTO usuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
