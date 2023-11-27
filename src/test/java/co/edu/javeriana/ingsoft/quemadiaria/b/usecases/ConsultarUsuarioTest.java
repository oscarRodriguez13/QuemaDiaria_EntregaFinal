package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarUsuarioTest {

    @Test
    void consultarUsuarioNullLoginDTO() {

        ConsultarUsuario consultarUsuario = ConsultarUsuario.getInstance();

        assertThrows(IllegalArgumentException.class, () -> {
            consultarUsuario.consultarUsuario(null);
        });

    }

    @Test
    void consultarUsuarioPorUserName2NULLUserName() {

        ConsultarUsuario consultarUsuario = ConsultarUsuario.getInstance();

        assertThrows(QuemaDiariaException.class, () -> {
            consultarUsuario.consultarUsuarioPorUserName2(null);
        });

    }
}