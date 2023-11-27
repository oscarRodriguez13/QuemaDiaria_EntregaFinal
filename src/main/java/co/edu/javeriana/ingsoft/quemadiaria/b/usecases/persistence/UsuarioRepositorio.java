package co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;

import java.util.List;

public interface UsuarioRepositorio {

    void guardarUsuario(Usuario listaUsuarios);

    List<Usuario> consultarListaUsuarios();

    Usuario consultarUsuarioPorUserName(String username);

    Usuario consultarUsuarioPorUserName2(String userName);

    void actualizarContrasennaUsuario(String nombreUsuario, String nuevaContrasenna);

    void actualizarPerfil(PerfilDTO perfilDTO, Usuario usuarioActual);

    boolean eliminarUsuarioPorNombreUsuario(String nombreUsuario);

    void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario);

    void changeProfilePhoto(PerfilDTO perfilDTO, Usuario usuarioActual);
}
