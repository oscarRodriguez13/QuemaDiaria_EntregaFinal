package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ChangePasswordService;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.PasswordChangeObserver;

public class ChangePasswordFacade implements UpdatePasswordFacade, PasswordChangeObserver {

    private ChangePasswordService changePasswordService = new ChangePasswordService();

    private String userName;
    private String newPassword;


    @Override
    public void updateUserPassword(String userName, String newPassword) {
        this.userName = userName;
        this.newPassword = newPassword;
    }

    @Override
    public void onPasswordChanged() {
        changePasswordService.updateUserPassword(userName, newPassword);
    }
}
