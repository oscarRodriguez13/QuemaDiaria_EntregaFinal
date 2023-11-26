package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AutenticacionServiceTest {

    @Test
    void testSuccessfulUserAuthentication() {
        AutenticacionService autenticacionService = new AutenticacionService();

        LoginDTO loginDTO = new LoginDTO();
        ResponseDTO<String> responseDTO = autenticacionService.autenticarUsuario(loginDTO);

        assertEquals(ResponseDTO.OK, responseDTO.getCodigo());
        assertEquals("Login exitoso", responseDTO.getMensaje());
    }

    @Test
    void testFailedUserAuthentication() {
        AutenticacionService autenticacionService = new AutenticacionService();

        LoginDTO loginDTO = new LoginDTO();

        ResponseDTO<String> responseDTO = autenticacionService.autenticarUsuario(loginDTO);

        assertEquals("ErrorCode", responseDTO.getCodigo()); // Set the expected error code
        assertEquals("Error Message", responseDTO.getMensaje()); // Set the expected error message
    }

    @Test
    void testNullLoginDTO() {
        AutenticacionService autenticacionService = new AutenticacionService();

        assertThrows(IllegalArgumentException.class, () -> {
            autenticacionService.autenticarUsuario(null);
        });
    }
}
