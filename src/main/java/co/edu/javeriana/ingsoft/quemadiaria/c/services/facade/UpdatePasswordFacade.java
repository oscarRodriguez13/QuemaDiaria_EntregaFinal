package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;

public interface UpdatePasswordFacade {
    void updateUserPassword(String userName, String newPassword);
}
