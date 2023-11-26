package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class CambiarEstadoNotificaciones {
    UsuarioRepositorio usuarioRepositorio;
    private static CambiarEstadoNotificaciones instance;

    private CambiarEstadoNotificaciones(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static CambiarEstadoNotificaciones getInstance() {
        if (instance == null) {
            instance = new CambiarEstadoNotificaciones(new UsuarioArchivosRepositorio());
        }
        return instance;
    }

    public void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario){
        usuarioRepositorio.cambiarEstadoNotificaciones(notificacionDTO, usuario);
    }

}
