package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.AutenticacionService;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActualizarPerfilTest {


    @Test
    void updatePerfiltestNullPerfilDTO() {
        //AutenticacionService autenticacionService = new AutenticacionService();
        UsuarioRepositorio usuarioRepositorio = new UsuarioArchivosRepositorio();
        ActualizarPerfil actualizarPerfil = new ActualizarPerfil(usuarioRepositorio);

        Credenciales credenciales = new Credenciales("pedrito", "12345@");
        Usuario usuario = new Usuario("12345", "pedrito@javeriana.edu.co", credenciales);

        assertThrows(IllegalArgumentException.class, () -> {
            actualizarPerfil.updatePerfil(null, usuario);
        });
    }

    @Test
    void updatePerfiltestNullUsuario() {
        //AutenticacionService autenticacionService = new AutenticacionService();
        UsuarioRepositorio usuarioRepositorio = new UsuarioArchivosRepositorio();
        ActualizarPerfil actualizarPerfil = new ActualizarPerfil(usuarioRepositorio);

        PerfilDTO perfilDTO = new PerfilDTO(180, 20, "","","");

        assertThrows(IllegalArgumentException.class, () -> {
            actualizarPerfil.updatePerfil(perfilDTO, null);
        });
    }

    @Test
    void changeProfilePhototestNullPerfilDTO() {
        //AutenticacionService autenticacionService = new AutenticacionService();
        UsuarioRepositorio usuarioRepositorio = new UsuarioArchivosRepositorio();
        ActualizarPerfil actualizarPerfil = new ActualizarPerfil(usuarioRepositorio);

        Credenciales credenciales = new Credenciales("pedrito", "12345@");
        Usuario usuario = new Usuario("12345", "pedrito@javeriana.edu.co", credenciales);

        assertThrows(IllegalArgumentException.class, () -> {
            actualizarPerfil.changeProfilePhoto(null, usuario);
        });
    }

    @Test
    void changeProfilePhototestNullUsuario() {
        //AutenticacionService autenticacionService = new AutenticacionService();
        UsuarioRepositorio usuarioRepositorio = new UsuarioArchivosRepositorio();
        ActualizarPerfil actualizarPerfil = new ActualizarPerfil(usuarioRepositorio);

        PerfilDTO perfilDTO = new PerfilDTO(180, 20, "","","");

        assertThrows(IllegalArgumentException.class, () -> {
            actualizarPerfil.changeProfilePhoto(perfilDTO, null);
        });
    }
}