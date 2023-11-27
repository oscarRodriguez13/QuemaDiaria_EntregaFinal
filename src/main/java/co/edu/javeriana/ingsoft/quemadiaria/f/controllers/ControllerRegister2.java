package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerRegister2 {
    public TextField nameUserBox;
    public PasswordField passwordBox;
    public Text txtIniciarSesion;
    private MenuLogin mainApp;
    private UsuarioDTO usuarioDTO;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        txtIniciarSesion.setOnMouseClicked(this::onclickIniciarSesion);
    }

    public void onclickRegistrarse(ActionEvent actionEvent) {

        boolean contrasennaValida = validarContrasenna(this.passwordBox.getText());

        if(contrasennaValida){
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUsername(this.nameUserBox.getText());
            loginDTO.setPassword(this.passwordBox.getText());

            usuarioDTO.setLogin(loginDTO);

            boolean registroExitoso = registrarUsuario(usuarioDTO);

            if (registroExitoso) {
                Platform.runLater(() -> {
                    try {
                        this.mainApp.showLoginScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }else{
            showErrorMessagePassword();
        }
    }

    public boolean registrarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null ) {
            throw new IllegalArgumentException("Invalido registroUsuarioDTO");
        }

        RegistroFacade seguridadFacade = new SeguridadFacade();

        ResponseDTO<String> responseDTO =  seguridadFacade.registrarUsuario(usuarioDTO);

        System.out.println(responseDTO.toString());

        if (responseDTO.getCodigo().equals(ResponseDTO.OK)){
            if (loginDTO != null) {
                ConsultaFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
                Usuario usuarioActual = consultaUsuariosFacade.consultarUsuario(loginDTO);
                String photoPath = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil0.png";
                PerfilDTO perfilDTO = new PerfilDTO(photoPath);
            }
            System.out.println("Registro exitoso");
            return true;
        }
        System.out.println("Registro fallido");
        return false;
    }

    public boolean validarContrasenna(String contrasenna) {
        if (contrasenna.length() < 6) {
            return false;
        }
        boolean contieneCaracterEspecial = false;
        for (char caracter : contrasenna.toCharArray()) {
            if (!Character.isLetterOrDigit(caracter) && caracter != ' ') {
                contieneCaracterEspecial = true;
                break;
            }
        }
        return contieneCaracterEspecial;
    }

    private void showErrorMessagePassword() {
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setHeaderText("Contraseña Invalida");
        mensaje.setTitle("¡Error!");
        mensaje.setContentText("La contraseña debe tener al menos 6 caracteres,  \nun caracter especial y ningun espacio ");
        mensaje.showAndWait();
    }

    @FXML
    public void onclickIniciarSesion(MouseEvent mouseEvent) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
