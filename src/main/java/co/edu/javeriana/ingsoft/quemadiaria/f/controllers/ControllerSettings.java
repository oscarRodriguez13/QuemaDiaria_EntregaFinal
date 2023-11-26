package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaUsuariosFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ConsultaUsuarioService;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import com.google.gson.Gson;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerSettings implements Initializable {
    private MenuLogin mainApp;
    private Command helpCommand;
    private Command homeCommand;
    private Command updateProfileCommand;
    private Command logOutCommand;
    private Command notificationCommand;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private Text textUser;
    @FXML
    private Text textMail;
    @FXML
    private Text textObjective;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, LoginDTO loginDTO) {
        this.mainApp = mainApp;
        this.helpCommand = new HelpCommand(mainApp);
        this.homeCommand = new HomeCommand(mainApp);
        this.updateProfileCommand = new UpdateProfileCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
        this.notificationCommand = new NotificationCommand(mainApp);
        this.loginDTO = loginDTO;
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginDTO != null) {
            ConsultaUsuariosFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
            Usuario usuarioActual = consultaUsuariosFacade.consultarUsuario(loginDTO);
            textUser.setText(loginDTO.getUsername());
            textMail.setText(usuarioActual.getCorreo());
            textObjective.setText(usuarioActual.getPerfil().getObjetivo());
            setUpAccount.setTranslateX(171);
            cuenta1.setVisible(true);
            cuenta2.setVisible(false);
        }
    }

    private void animateAndSetVisible(TranslateTransition slide, double toX, Group groupToShow, Group groupToHide) {
        Command Animationcommand = new AnimationVisibilityCommand(slide, toX, groupToShow, groupToHide);
        Animationcommand.execute(loginDTO);
    }

    @FXML
    public void onclickCuenta2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 342, cuenta1, cuenta2);
    }

    @FXML
    public void onclickCuenta1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 0, cuenta2, cuenta1);
    }

    @FXML
    public void onMouseEntered(MouseEvent event) {
        Button boton = (Button) event.getSource();
        boton.setStyle("-fx-font-weight: bold; -fx-background-color: transparent;");
    }

    @FXML
    public void onMouseExited(MouseEvent event) {
        Button boton = (Button) event.getSource();
        boton.setStyle("-fx-font-weight: normal; -fx-background-color: transparent;");
    }

    @FXML
    public void onClickHome(ActionEvent event) { homeCommand.execute(loginDTO); }

    @FXML
    public void onClickUpdateProfile() { updateProfileCommand.execute(loginDTO); }

    @FXML
    public void onClickHelp() { helpCommand.execute(loginDTO); }

    @FXML
    public void onClickLogOut()  { logOutCommand.execute(loginDTO); }

    @FXML
    public void onClickNotification() { notificationCommand.execute(loginDTO); }

    @FXML
    public void onRemoveAccount() {
        try {
            this.mainApp.showRemoveAccount(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
