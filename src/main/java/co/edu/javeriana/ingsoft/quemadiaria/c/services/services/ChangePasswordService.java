package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ChangePassword;

public class ChangePasswordService {
    private ChangePassword changePassword = ChangePassword.getInstance();

    public void updateUserPassword(String userName, String newPassword) {
        if (newPassword == null ) {
            throw new IllegalArgumentException("COntrasenna vacia");
        }
        changePassword.updateUserPassword(userName, newPassword);
    }

}