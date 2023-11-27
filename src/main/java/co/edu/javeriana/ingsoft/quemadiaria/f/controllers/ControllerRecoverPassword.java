package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.PasswordChangeSubject;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ChangePasswordFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaUsuariosFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.UpdatePasswordFacade;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.PasswordChangeObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerRecoverPassword implements Initializable {
    private MenuLogin mainApp;
    private UsuarioRepositorio usuarioRepositorio;
    @FXML
    private TextField textUser;
    @FXML
    private TextField textDocument;
    @FXML
    private TextField textMail;
    @FXML
    private AnchorPane validarDatos;
    @FXML
    private AnchorPane cambiarContraseña;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button savePassword;
    public Text differentPasswords;
    public Text invalidPassword;

    private PasswordChangeSubject passwordChangeSubject = new PasswordChangeSubject();


    public void setMainApp(MenuLogin mainApp) {this.mainApp = mainApp;}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validarDatos.setVisible(true);
        cambiarContraseña.setVisible(false);
        differentPasswords.setVisible(false);
        invalidPassword.setVisible(false);
    }

    public ControllerRecoverPassword() {
        this.usuarioRepositorio = new UsuarioArchivosRepositorio(); // Proporciona una implementación adecuada
    }

    @FXML
    private void validateData(ActionEvent event) {
        String numeroDocumento = textDocument.getText();
        String correo = textMail.getText();
        String nombreUsuario = textUser.getText();

        ConsultaFacade consultaFacade = new ConsultaUsuariosFacade();
        Usuario usuario = consultaFacade.consultarUsuarioPorUsername(nombreUsuario);

        if (usuario != null && usuario.getNumeroDocumento().equals(numeroDocumento) && usuario.getCorreo().equals(correo)) {
            validarDatos.setVisible(false);
            cambiarContraseña.setVisible(true);
        } else {
            aviso();
        }
    }

    @FXML
    public void onclickGoBack(ActionEvent actionEvent) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aviso() {
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setHeaderText("¡ERROR!");
        mensaje.setTitle("Datos incorrectos");
        mensaje.setContentText("Los datos que ha ingresado no son correctos.\nVuelva a intentarlo.");
        mensaje.showAndWait();
    }

    @FXML
    private void changePassword(ActionEvent event) {
        String newPassword = password.getText();
        String comPassword = confirmPassword.getText();

        if (newPassword.equals(comPassword)) {
            differentPasswords.setVisible(false);
            String userName = textUser.getText();

            ConsultaFacade consultaFacade = new ConsultaUsuariosFacade();
            Usuario usuario = consultaFacade.consultarUsuarioPorUsername(userName);

            if (usuario != null) {
                if (validarContrasenna(newPassword)) {
                    invalidPassword.setVisible(false);
                    UpdatePasswordFacade updatePasswordFacade = new ChangePasswordFacade();
                    passwordChangeSubject.addObserver((PasswordChangeObserver) updatePasswordFacade);
                    updatePasswordFacade.updateUserPassword(userName, newPassword);
                    passwordChangeSubject.notifyObservers();
                    showPasswordChangedMessage();
                    //passwordChangeSubject.notifyObservers();
                    try {
                        this.mainApp.showLoginScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    invalidPassword.setVisible(true);
                }
            } else {
                showErrorMessage();
            }
        } else {
            differentPasswords.setVisible(true);
        }
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

    private void showPasswordChangedMessage() {
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setHeaderText("¡Éxito!");
        mensaje.setTitle("Contraseña actualizada");
        mensaje.setContentText("La contraseña se ha actualizado con éxito.");
        mensaje.showAndWait();
    }

    private void showErrorMessage() {
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setHeaderText("¡Error!");
        mensaje.setTitle("Error");
        mensaje.setContentText("Usuario no encontrado");
        mensaje.showAndWait();
    }


}

