package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ActualizarPerfil;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class ActualizacionPerfilService {
    private ActualizarPerfil actualizarPerfil = new ActualizarPerfil(new UsuarioArchivosRepositorio());

    public void updateProfile(PerfilDTO perfilDTO, Usuario usuarioActual) {
        if (perfilDTO == null || usuarioActual == null) {
            throw new IllegalArgumentException("Datos invalidos");
        }
        actualizarPerfil.updatePerfil(perfilDTO, usuarioActual);
    }

    public void changeProfilePhoto(PerfilDTO perfilDTO, Usuario usuarioActual){
        if (perfilDTO == null || usuarioActual == null) {
            throw new IllegalArgumentException("Datos invalidos");
        }
        actualizarPerfil.changeProfilePhoto(perfilDTO, usuarioActual);
    }

}
