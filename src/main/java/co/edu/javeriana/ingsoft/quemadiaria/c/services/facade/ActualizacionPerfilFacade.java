package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;

public interface ActualizacionPerfilFacade {
    void updatePerfil(PerfilDTO perfilDTO, Usuario usuarioActual);

    void changeProfilePhoto(PerfilDTO perfilDTO, Usuario usuarioActual);

}
