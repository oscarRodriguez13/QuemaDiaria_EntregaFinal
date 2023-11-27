package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ActualizacionPerfilService;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ConsultaUsuarioService;

public class ActualizarPerfilFacade implements ActualizacionPerfilFacade{

    private ActualizacionPerfilService actualizacionPerfilService = new ActualizacionPerfilService();

    @Override
    public void updatePerfil(PerfilDTO perfilDTO, Usuario usuarioActual) {
        actualizacionPerfilService.updateProfile(perfilDTO, usuarioActual);
    }

    @Override
    public void changeProfilePhoto(PerfilDTO perfilDTO, Usuario usuarioActual) {
        actualizacionPerfilService.changeProfilePhoto(perfilDTO, usuarioActual);
    }
}
