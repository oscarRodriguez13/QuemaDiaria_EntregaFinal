package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;


import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.AutenticacionFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.SeguridadFacade;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerLogin {
    public Text txtRegistrar;
    private MenuLogin mainApp;
    @FXML
    private TextField userBox;
    @FXML
    private TextField passwordBox;
    @FXML
    private Label lblInicioRechazado;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        txtRegistrar.setOnMouseClicked(this::onclickRegistrar);
    }

    @FXML
    public void onclickIngresar(ActionEvent actionEvent) {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(userBox.getText());
        loginDTO.setPassword(passwordBox.getText());
        boolean loginExitoso = loginUsuario(loginDTO);

        if (loginExitoso) {
            Platform.runLater(() -> {
                try {
                    this.mainApp.showHomeScreen(loginDTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            Platform.runLater(() -> {
                lblInicioRechazado.setText("Credenciales inválidas");
                lblInicioRechazado.setStyle("-fx-text-fill: red;");
            });
        }
    }

    @FXML
    public void onclickRegistrar(MouseEvent mouseEvent) {
        try {
            this.mainApp.showRegister1Screen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onclickForgetPassword(MouseEvent mouseEvent) {
        try {
            this.mainApp.showRecoverPassword();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }

        AutenticacionFacade seguridadFacade = new SeguridadFacade();

        ResponseDTO<String> responseDTO =  seguridadFacade.login(loginDTO);

        if (responseDTO.getCodigo().equals(ResponseDTO.OK)){
            System.out.println("Login exitoso");
            return true;
        }
        System.out.println("Login fallido");
        return false;
    }

    public Credenciales credencialesUsuarioActivoUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }

        AutenticacionFacade seguridadFacade = new SeguridadFacade();

        return seguridadFacade.recuperarCredenciales(loginDTO);
    }
}