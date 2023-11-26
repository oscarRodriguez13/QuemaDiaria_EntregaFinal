package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;

public interface GestionNotificacionesFacade {
    void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario);
}
