package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.CambiarEstadoNotificaciones;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;

public class GestionarEstadoNotificacionesService {
    private CambiarEstadoNotificaciones cambiarEstadoNotificaciones = CambiarEstadoNotificaciones.getInstance();

    public void cambiarEstadoNotificacion(NotificacionDTO notificacionDTO, Usuario usuario) {
        if (usuario == null || notificacionDTO == null) {
            throw new IllegalArgumentException("Datos no validos");
        }
        cambiarEstadoNotificaciones.cambiarEstadoNotificaciones(notificacionDTO, usuario);
    }
}
