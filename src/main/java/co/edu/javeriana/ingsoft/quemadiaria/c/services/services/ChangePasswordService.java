package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ChangePassword;

import java.io.IOException;

public class ChangePasswordService {
    private ChangePassword changePassword = ChangePassword.getInstance();

    public void updateUserPassword(String userName, String newPassword) {
        if (newPassword == null ) {
            throw new IllegalArgumentException("Contrasenna vacia");
        }
        try {
            changePassword.updateUserPassword(userName, newPassword);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}