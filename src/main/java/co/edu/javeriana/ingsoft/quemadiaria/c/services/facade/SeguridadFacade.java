package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.AutenticacionService;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.EliminarUsuarioService;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.RegistroUsuarioService;

public class SeguridadFacade implements AutenticacionFacade, RegistroFacade, AdministradorFacade, EliminarUsuarioFacade {

    private RegistroUsuarioService registroUsuarioService = new RegistroUsuarioService();
    private AutenticacionService autenticacionService = new AutenticacionService();

    private EliminarUsuarioService eliminarUsuarioService = new EliminarUsuarioService();

    @Override
    public ResponseDTO<String> login(LoginDTO loginDTO) {
        return autenticacionService.autenticarUsuario(loginDTO);
    }

    @Override
    public ResponseDTO<String> registrarUsuario(UsuarioDTO usuarioDTO) {
        return registroUsuarioService.registrarUsuario(usuarioDTO);
    }

    @Override
    public ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna) {
        return null;//autenticacionService.cambiarContrasenna(usuario, contrasenna);
    }

    @Override
    public ResponseDTO<String> cancelarRegistro(String email, String motivo) {
        return null;//autenticacionService.recuperarContrasenna(usuario);
    }

    @Override
    public Credenciales recuperarCredenciales(LoginDTO loginDTO){
        return autenticacionService.credencialesUsuario(loginDTO);
    }

    @Override
    public boolean eliminarUsuario(LoginDTO loginDTO){

        return eliminarUsuarioService.eliminarUsuario(loginDTO);
    }


}
