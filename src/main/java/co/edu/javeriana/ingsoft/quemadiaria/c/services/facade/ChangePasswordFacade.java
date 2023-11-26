package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ChangePasswordService;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ConsultaUsuarioService;

public class ChangePasswordFacade implements UpdatePasswordFacade {

    private ChangePasswordService changePasswordService = new ChangePasswordService();

    @Override
    public void updateUserPassword(String userName, String newPassword) {
        changePasswordService.updateUserPassword(userName, newPassword);
    }

}
