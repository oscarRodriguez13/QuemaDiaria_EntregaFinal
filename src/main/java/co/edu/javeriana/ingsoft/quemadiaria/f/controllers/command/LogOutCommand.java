package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class LogOutCommand implements Command {
    private MenuLogin mainApp;

    public LogOutCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute(LoginDTO loginDTO) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Estás seguro de que deseas cerrar la sesión?");

        ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == confirmButton) {
            try {
                this.mainApp.showLoginScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //validación de credenciales o problemas para cerrar sesión
        }
    }
}
