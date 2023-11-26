package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ActualizacionPerfilFacadeTest {/*
    private UsuarioRepositorio usuarioRepositorio;
    private ActualizarPerfil actualizarPerfil;

    @BeforeEach
    void setUp() {
        usuarioRepositorio = new UsuarioArchivosRepositorio();

        Credenciales credenciales = new Credenciales("pedrito", "12345@");
        Usuario usuario = new Usuario("12345", "pedrito@javeriana.edu.co", credenciales);

        Perfil perfil = new Perfil(175, 70, "Normal", "Adelgazar y tonificar mi cuerpo");
        usuario.setPerfil(perfil);

        usuarioRepositorio.guardarUsuario(usuario);

        actualizarPerfil = new ActualizarPerfil(usuarioRepositorio);
    }*/

    /*@Test
    void testUpdatePerfil() {

        Credenciales credenciales = new Credenciales("pedrito", "12345@");
        Usuario usuario = new Usuario("12345", "pedrito@javeriana.edu.co", credenciales);

        Perfil perfil = new Perfil(180, 80, "Normal", "Adelgazar y tonificar mi cuerpo");

        // Llamar al método updatePerfil de la clase ActualizarPerfil
        actualizarPerfil.updatePerfil(perfil.getAltura(), perfil.getPeso(), perfil.getComplexion(), perfil.getObjetivo(), usuario);

        // Verificar que el perfil del usuario se haya actualizado correctamente
        Perfil perfilActualizado = usuarioRepositorio.consultarUsuarioPorUserName(usuario.getCredenciales().getNombreUsuario()).getPerfil();
        assertEquals(perfil, perfilActualizado);
    }*/
}