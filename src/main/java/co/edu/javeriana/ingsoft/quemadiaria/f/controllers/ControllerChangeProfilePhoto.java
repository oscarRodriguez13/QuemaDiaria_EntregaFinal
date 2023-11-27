package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ActualizacionPerfilFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ActualizarPerfilFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaUsuariosFacade;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.AnimationVisibilityCommand;
import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerChangeProfilePhoto implements Initializable {
    private MenuLogin mainApp;
    private Command homeCommand;
    private Command helpCommand;
    private Command settingsCommand;
    private Command updateProfileCommand;
    private Command logOutCommand;
    private Command notificationCommand;
    @FXML
    public Text textUser;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private ImageView profilePicture;
    @FXML
    private ImageView icon1;
    @FXML
    private ImageView icon2;
    @FXML
    private ImageView menuPhoto;
    String photoRute;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, LoginDTO loginDTO) {
        this.homeCommand = new HomeCommand(mainApp);
        this.helpCommand = new HelpCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.updateProfileCommand = new UpdateProfileCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
        this.notificationCommand = new NotificationCommand(mainApp);
        this.loginDTO = loginDTO;

        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginDTO != null){
            ConsultaFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
            Usuario usuarioActual = consultaUsuariosFacade.consultarUsuario(loginDTO);

            String path = getClass().getResource(usuarioActual.getPerfil().getPhotoPath()).toExternalForm();
            Image image = new Image(path);
            icon1.setImage(image);
            icon2.setImage(image);
            profilePicture.setImage(image);
            menuPhoto.setImage(image);
            textUser.setText(loginDTO.getUsername());
            setUpAccount.setTranslateX(171);
            cuenta1.setVisible(true);
            cuenta2.setVisible(false);
        }
    }
    @FXML
    private void selectPhoto1() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }
    @FXML
    private void selectPhoto2() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil2.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }
    @FXML
    private void selectPhoto3() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil3.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }

    @FXML
    private void selectPhoto4() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil4.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }

    @FXML
    private void selectPhoto5() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil5.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }

    @FXML
    private void selectPhoto6() {
        photoRute = "/co/edu/javeriana/ingsoft/quemadiaria/RecursosVisuales/FotosDePerfil/Foto-perfil6.png";
        String path = getClass().getResource(photoRute).toExternalForm();
        Image image = new Image(path);
        profilePicture.setImage(image);
    }
    @FXML
    private void onClickSavePhoto() throws Exception{
        String photoPath = photoRute;

        ConsultaFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
        Usuario usuarioEnSesion = consultaUsuariosFacade.consultarUsuario(loginDTO);

        if (usuarioEnSesion != null) {
            PerfilDTO perfilDTO = new PerfilDTO(photoPath);
            ActualizacionPerfilFacade actualizacionPerfilFacade = new ActualizarPerfilFacade();
            actualizacionPerfilFacade.updatePerfil(perfilDTO, usuarioEnSesion);

            // Muestra una alerta de confirmación
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cambiar foto de perfil");
            alert.setHeaderText("Foto actualizada correctamente");
            ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
            Optional<ButtonType> result = alert.showAndWait();
            this.mainApp.showUpdateProfile(loginDTO);
        }

        System.out.println(photoRute);
    }

    private void animateAndSetVisible(TranslateTransition slide, double toX, Group groupToShow, Group groupToHide) {
        Command Animationcommand = new AnimationVisibilityCommand(slide, toX, groupToShow, groupToHide);
        Animationcommand.execute(loginDTO);
    }

    @FXML
    public void onclickCuenta1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 0, cuenta2, cuenta1);
    }

    @FXML
    public void onclickCuenta2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 342, cuenta1, cuenta2);
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
    public void onClickLogOut() { logOutCommand.execute(loginDTO); }

    @FXML
    public void onClickUpdateProfile() { updateProfileCommand.execute(loginDTO); }

    @FXML
    public void onClickSettings() { settingsCommand.execute(loginDTO); }

    @FXML
    public void onClickHelp() {
        helpCommand.execute(loginDTO);
    }

    @FXML
    public void onClickNotification() {
        notificationCommand.execute(loginDTO);
    }

    @FXML
    public void onclickGoBack(ActionEvent actionEvent) { homeCommand.execute(loginDTO); }
}
