package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;

import java.io.IOException;

public class HomeCommand implements Command {
    private MenuLogin mainApp;

    public HomeCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute(LoginDTO loginDTO) {
        try {
            mainApp.showHomeScreen(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
