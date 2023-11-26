package co.edu.javeriana.ingsoft.quemadiaria;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.UsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuLogin extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        showLoginScreen();
        System.out.println("jola");
    }

    public void showLoginScreen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        ControllerLogin inicioSesionController = loader.getController();
        inicioSesionController.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRegister1Screen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register1.fxml"));
        Parent root = loader.load();
        ControllerRegister1 controllerRegistro1 = loader.getController();
        controllerRegistro1.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRegister2Screen(UsuarioDTO usuarioDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register2.fxml"));
        Parent root = loader.load();
        ControllerRegister2 controllerRegistro2 = loader.getController();
        controllerRegistro2.setMainApp(this, usuarioDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showHomeScreen(LoginDTO loginDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        ControllerHome controllerHome = loader.getController();
        controllerHome.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showUpdateProfile(LoginDTO loginDTO) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProfile.fxml"));
        Parent root = loader.load();
        ControllerUpdateProfile controllerUpdateProfile = loader.getController();
        controllerUpdateProfile.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRecoverPassword() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecoverPassword.fxml"));
        Parent root = loader.load();
        ControllerRecoverPassword controllerRecoverPassword = loader.getController();
        controllerRecoverPassword.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showSettings(LoginDTO loginDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        Parent root = loader.load();
        ControllerSettings controllerSettings = loader.getController();
        controllerSettings.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRemoveAccount(LoginDTO loginDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveAccount.fxml"));
        Parent root = loader.load();
        ControllerRemoveAccount controllerRemoveAccount = loader.getController();
        controllerRemoveAccount.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showHelp(LoginDTO loginDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Help.fxml"));
        Parent root = loader.load();
        ControllerHelp controllerHelp = loader.getController();
        controllerHelp.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showNotification(LoginDTO loginDTO) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Notifications.fxml"));
        Parent root = loader.load();
        ControllerNotification controllerNotification = loader.getController();
        controllerNotification.setMainApp(this, loginDTO);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
