package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;

public class ActualizarPerfil {
    private UsuarioRepositorio usuarioRepositorio;

    public ActualizarPerfil(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void updatePerfil(PerfilDTO perfilDTO, Usuario usuarioActual) {
        usuarioRepositorio.actualizarPerfil(perfilDTO, usuarioActual);
        System.out.println("Perfil del usuario actualizado correctamente.");
    }

    public void changeProfilePhoto(PerfilDTO perfilDTO, Usuario usuarioActual) {
        usuarioRepositorio.changeProfilePhoto(perfilDTO, usuarioActual);
        System.out.println("Foto del usuario actualizado correctamente.");
    }
}