package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;

import java.io.IOException;

public class SettingsCommand implements Command {
    private MenuLogin mainApp;
    public SettingsCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute(LoginDTO loginDTO) {
        try {
            mainApp.showSettings(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
