package co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioArchivosRepositorioTest {

    private UsuarioRepositorio repositorio;
    private UsuarioArchivosRepositorio archivosRepositorio;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() {
        repositorio = new UsuarioArchivosRepositorio();
        archivosRepositorio = new UsuarioArchivosRepositorio();
        repositorio = archivosRepositorio;

        // Crea usuarios de prueba
        usuario1 = new Usuario("10734894389", "usuario1@javeriana.edu.co", new Credenciales("user1", "contrasenia1"));
        usuario2 = new Usuario("73298932893", "usuario2@javeriana.edu.co", new Credenciales("user2", "contrasenia2"));
    }

    @Test
    void guardarUsuarioYConsultarListaUsuarios() {
        // Arrange
        repositorio.guardarUsuario(usuario1);
        List<Usuario> usuarios = repositorio.consultarListaUsuarios();
        // Act and Assert
        assertFalse(usuarios.isEmpty());
        assertTrue(usuarios.contains(usuario1));
    }

    @Test
    void consultarUsuarioPorUserName() {
        // Arrange
        repositorio.guardarUsuario(usuario1);
        repositorio.guardarUsuario(usuario2);

        // Act
        Usuario usuarioEncontrado = repositorio.consultarUsuarioPorUserName("usuario1");

        // Assert
        assertEquals(usuario1, usuarioEncontrado);
    }

    @Test
    void consultarUsuarioPorUserNameUsuarioNoEncontrado() {
        // Act
        repositorio.guardarUsuario(usuario1);

        // Assert
        assertThrows(QuemaDiariaException.class, () -> {
            repositorio.consultarUsuarioPorUserName("usuario3");
        });
    }

    @Test
    void actualizarContrasennaUsuario() {
        // Arrange
        String nombreUsuario = "user1";
        String nuevaContrasenna = "nuevaContrasenna";

        // Guarda un usuario con el nombre de usuario especificado
        repositorio.guardarUsuario(usuario1);

        // Act
        repositorio.actualizarContrasennaUsuario(nombreUsuario, nuevaContrasenna);

        // Recupera el usuario actualizado
        Usuario usuarioActualizado = repositorio.consultarUsuarioPorUserName(nombreUsuario);

        // Assert
        assertEquals(nuevaContrasenna, usuarioActualizado.getCredenciales().getContrasenna());
    }

    @Test
    void consultarUsuarioPorUserName2() {
        // Arrange
        repositorio.guardarUsuario(usuario1);

        // Act
        Usuario usuarioEncontrado = repositorio.consultarUsuarioPorUserName2("user1");
        Usuario usuarioNoEncontrado = repositorio.consultarUsuarioPorUserName2("usuario3");

        // Assert
        assertNotNull(usuarioEncontrado);
        assertNull(usuarioNoEncontrado);
    }

    @Test
    void guardarListaUsuariosYActualizarPerfil() {
        // Arrange
        /*archivosRepositorio.guardarUsuario(usuario1);

        // Act
        usuario2 = new Usuario("1234567890", "usuario2@javeriana.edu.co", new Credenciales("user2", "contrasenia2"));
        //archivosRepositorio.guardarListaUsuarios(List.of(usuario1, usuario2));

        PerfilDTO nuevoPerfil = new PerfilDTO(175, 75, "Normal", "Ganar masa muscular", "");
        archivosRepositorio.actualizarPerfil(nuevoPerfil, usuario1);

        Usuario usuarioActualizado = archivosRepositorio.consultarUsuarioPorUserName("user1");

        // Assert
        assertTrue(usuarioActualizado.getPerfil().equals(nuevoPerfil));*/
    }

}