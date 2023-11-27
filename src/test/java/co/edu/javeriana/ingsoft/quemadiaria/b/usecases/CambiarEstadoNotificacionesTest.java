package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CambiarEstadoNotificacionesTest {


    @Test
    void cambiarEstadoNotificacionesNullNotificacionDTO() {

        CambiarEstadoNotificaciones cambiarEstadoNotificaciones = CambiarEstadoNotificaciones.getInstance();

        Credenciales credenciales = new Credenciales("pedrito", "12345@");
        Usuario usuario = new Usuario("12345", "pedrito@javeriana.edu.co", credenciales);

        assertThrows(IllegalArgumentException.class, () -> {
            cambiarEstadoNotificaciones.cambiarEstadoNotificaciones(null, usuario);
        });
    }

    @Test
    void cambiarEstadoNotificacionesNullUsuario() {

        CambiarEstadoNotificaciones cambiarEstadoNotificaciones = CambiarEstadoNotificaciones.getInstance();

        NotificacionDTO notificacionDTO = new NotificacionDTO();

        assertThrows(IllegalArgumentException.class, () -> {
            cambiarEstadoNotificaciones.cambiarEstadoNotificaciones(notificacionDTO, null);
        });
    }

}