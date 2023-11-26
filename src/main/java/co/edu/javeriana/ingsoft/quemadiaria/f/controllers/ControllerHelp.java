package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerHelp implements Initializable {
    private MenuLogin mainApp;
    private Command homeCommand;
    private Command settingsCommand;
    private Command updateProfileCommand;
    private Command logOutCommand;
    private NotificationCommand notificationCommand;
    @FXML
    private Text textUser;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private ChoiceBox CB_Question;
    @FXML
    private AnchorPane answer;
    @FXML
    private Label question1;
    @FXML
    private Label answer1;
    @FXML
    private Label question2;
    @FXML
    private Label answer2;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, LoginDTO loginDTO) {
        this.mainApp = mainApp;
        this.homeCommand = new HomeCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.updateProfileCommand = new UpdateProfileCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
        this.notificationCommand = new NotificationCommand(mainApp);
        this.loginDTO = loginDTO;
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginDTO != null) {
            textUser.setText(loginDTO.getUsername());
            setUpAccount.setTranslateX(171);
            cuenta1.setVisible(true);
            cuenta2.setVisible(false);
            CB_Question.setItems(optionsQuestions);
            answer.setVisible(false);
        }
    }
    private ObservableList<String> optionsQuestions = FXCollections.observableArrayList(
            "Registrar cuenta",
            "Iniciar o cerrar sesión",
            "Actualizar perfil",
            "Cambiar contraseña"
    );

    @FXML
    public void onClickSearchQuestion(ActionEvent event) throws IOException {
        String selectedQuestion = (String) CB_Question.getValue();
        if (selectedQuestion != null) {
            showQuestionAndAnswer(selectedQuestion);
        }
        answer.setVisible(true);
    }

    private void showQuestionAndAnswer(String selectedQuestion) {
        question1.setWrapText(true);
        answer1.setWrapText(true);
        question2.setWrapText(true);
        answer2.setWrapText(true);
        switch (selectedQuestion) {
            case "Registrar cuenta":
                question1.setText("¿Qué datos necesito para registrar una cuenta?");
                answer1.setText("Necesitas crear un nuevo usuario y contraseña además de digitar tu nombre, apellido, documento y correo.");
                question2.setText("¿Con el mismo correo puedo registrar más de una cuenta?");
                answer2.setText("No, un correo solo puede estar relacionado a una sola cuenta.");
                break;
            case "Iniciar o cerrar sesión":
                question1.setText("¿Qué necesito para iniciar sesión?");
                answer1.setText("Primero debes registrarte, ya una vez tengas tu cuenta puedes iniciar sesión.");
                question2.setText("¿Por qué no me deja iniciar sesión?");
                answer2.setText("Recuerda cerrar tu cuenta en otros dispositivos, la sesión solo puede estar abierta en un dispositivo.");
                break;
            case "Actualizar perfil":
                question1.setText("¿Por qué mis datos no se guardaron al momento de actualizar mi perfil?");
                answer1.setText("Recuerda darle al botón guardar para que tus datos sean almacenados en tu cuenta.");
                question2.setText("¿Puedo actualizar mi perfil varias veces?");
                answer2.setText("Es correcto, puede actualizar cuantas veces desee su perfil.");
                break;
            case "Cambiar contraseña":
                question1.setText("¿Cómo puedo cambiar mi contraseña?");
                answer1.setText("En la configuración de la cuenta está la opción para cambiar su contraseña.");
                question2.setText("¿Si olvido mi contraseña y no puedo iniciar sesión en otro dispositivo, qué puedo hacer?");
                answer2.setText("En login hay una opción que permite cambiar su contraseña si fue olvidada.");
                break;
            default:
                break;
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
    public void onClickHome(ActionEvent event) { homeCommand.execute(loginDTO);}

    @FXML
    public void onClickLogOut() { logOutCommand.execute(loginDTO); }

    @FXML
    public void onClickUpdateProfile() { updateProfileCommand.execute(loginDTO); }

    @FXML
    public void onClickSettings() { settingsCommand.execute(loginDTO); }
    @FXML
    public void onClickNotification() { notificationCommand.execute(loginDTO); }
}
