package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class ControllerRegister1 {
    public TextField nameBox;
    public TextField lastNameBox;
    public TextField documentBox;
    public TextField mailBox;
    private MenuLogin mainApp;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    public void onclickContinuar(ActionEvent actionEvent) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(this.nameBox.getText());
        usuarioDTO.setApellido(this.lastNameBox.getText());
        usuarioDTO.setCorreo(this.mailBox.getText());
        usuarioDTO.setNumeroDocumento(this.documentBox.getText());

        try {
            this.mainApp.showRegister2Screen(usuarioDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onclickCancelar(ActionEvent actionEvent) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
