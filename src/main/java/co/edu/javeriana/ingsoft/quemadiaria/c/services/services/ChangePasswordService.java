package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ChangePassword;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ConsultarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;

public class ChangePasswordService {
    private ChangePassword changePassword = ChangePassword.getInstance();

    public void updateUserPassword(String userName, String newPassword) {
        if (newPassword == null ) {
            throw new IllegalArgumentException("COntrasenna vacia");
        }
        changePassword.updateUserPassword(userName, newPassword);
    }

}