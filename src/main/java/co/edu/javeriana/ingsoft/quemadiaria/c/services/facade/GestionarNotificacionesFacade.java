package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.GestionarEstadoNotificacionesService;

public class GestionarNotificacionesFacade implements GestionNotificacionesFacade {

    private GestionarEstadoNotificacionesService gestionarEstadoNotificacionesService = new GestionarEstadoNotificacionesService();

    @Override
    public void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario) {
        gestionarEstadoNotificacionesService.cambiarEstadoNotificacion(notificacionDTO, usuario);
    }

}
