package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
/*import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.AnnouncementNotification;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.NewRoutineNotification;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.UpdatesNotification;*/
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
//import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Notification;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNotification implements Initializable {
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    private Command homeCommand;
    private Command settingsCommand;
    private Command notificationCommand;
    private Command helpCommand;
    private Command updateProfileCommand;
    private Command logOutCommand;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private CheckBox CheckBoxAnnouncement;
    @FXML
    private CheckBox CheckBoxUpdate;
    @FXML
    private CheckBox CheckBoxNewRoutine;
    private MenuLogin mainApp;
    private boolean originalAnnouncementState;
    private boolean originalUpdateState;
    private boolean originalNewRoutineState;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, LoginDTO loginDTO) {
        this.mainApp = mainApp;
        this.helpCommand = new HelpCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.updateProfileCommand = new UpdateProfileCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
        this.notificationCommand = new NotificationCommand(mainApp);
        this.homeCommand = new HomeCommand(mainApp);
        this.loginDTO = loginDTO;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpAccount.setTranslateX(171);
        cuenta1.setVisible(true);
        cuenta2.setVisible(false);
        CheckBoxAnnouncement = new CheckBox();
        CheckBoxNewRoutine = new CheckBox();
        CheckBoxUpdate = new CheckBox();
        CheckBoxAnnouncement.setSelected(false);
        CheckBoxUpdate.setSelected(false);
        CheckBoxNewRoutine.setSelected(false);
        originalAnnouncementState = CheckBoxAnnouncement.isSelected();
        originalUpdateState = CheckBoxUpdate.isSelected();
        originalNewRoutineState = CheckBoxNewRoutine.isSelected();
    }

    public void onClickSaveNotifications(ActionEvent actionEvent) {
        showNotificationsChangeMessage();
    }
    public void onClickCancelNotifications(ActionEvent actionEvent) {
        showCancelNotificationsMessage();
        // Restaura el estado original al cancelar
        CheckBoxAnnouncement.setSelected(originalAnnouncementState);
        CheckBoxUpdate.setSelected(originalUpdateState);
        CheckBoxNewRoutine.setSelected(originalNewRoutineState);
    }

    public boolean OnCheckAnnouncement() {
        if(CheckBoxAnnouncement.isSelected() == true){
            return true;
        }
        return false;
    }

    public boolean OnCheckUpdate() {
        if(CheckBoxUpdate.isSelected() == true){
            return true;
        }
        return false;
    }

    public boolean OnCheckNewRoutine() {
        if(CheckBoxNewRoutine.isSelected() == true){
            return true;
        }
        return false;
    }

    private void showNotificationsChangeMessage() {
        //String notificationMessage = ChainOfResponsability();
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setHeaderText("¡Éxito!");
        mensaje.setTitle("Notificaciones actualizadas");
        //mensaje.setContentText(notificationMessage);
        mensaje.showAndWait();
    }

    private void showCancelNotificationsMessage() {
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setHeaderText("Cancelar");
        mensaje.setTitle("Cambios cancelados");
        mensaje.setContentText("Los cambios realizados fueron cancelados por tanto no fueron guardados");
        mensaje.showAndWait();
    }

    /*pblic String ChainOfResponsability(){
        String notification = "";
        Notification n1 = new AnnouncementNotification();
        Notification n2 = new NewRoutineNotification();
        Notification n3 = new UpdatesNotification();
        n1.setNext(n2);
        n2.setNext(n3);

        // Pasa los estados originales a los métodos check() de tus notificaciones
        notification += n1.check(originalAnnouncementState);
        notification += n2.check(originalUpdateState);
        notification += n3.check(originalNewRoutineState);

        return notification;
    }*/

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

}
