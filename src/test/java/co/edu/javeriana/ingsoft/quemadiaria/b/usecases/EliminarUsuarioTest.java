package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EliminarUsuarioTest {

    @Test
    void eliminarNullUserName() {
        EliminarUsuario eliminarUsuario = EliminarUsuario.getInstance();

        assertThrows(IllegalArgumentException.class, () -> {
            eliminarUsuario.eliminar(null);
        });
    }
}