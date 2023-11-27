package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangePasswordTest {


    @Test
    void updateUserPasswordNullUserName() {

        ChangePassword changePassword = ChangePassword.getInstance();
        String contra = "contrseña";
        assertThrows(IllegalArgumentException.class, () -> {
            changePassword.updateUserPassword(null, contra);
        });
    }
    @Test
    void updateUserPasswordNullnewPassword() {

        ChangePassword changePassword = ChangePassword.getInstance();
        String userName = "name";
        assertThrows(IllegalArgumentException.class, () -> {
            changePassword.updateUserPassword(userName, null);
        });
    }

}