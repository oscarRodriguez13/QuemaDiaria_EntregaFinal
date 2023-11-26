package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ActualizarPerfil;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ActualizacionPerfilFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ActualizarPerfilFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.facade.ConsultaUsuariosFacade;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.services.ConsultaUsuarioService;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import com.google.gson.Gson;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class ControllerUpdateProfile implements Initializable {
    private MenuLogin mainApp;
    private Command helpCommand;
    private Command homeCommand;
    private Command settingsCommand;
    private Command logOutCommand;
    private Command notificationCommand;
    @FXML
    private Text textUser;
    @FXML
    private ImageView profilePicture;
    @FXML
    private AnchorPane anchorPaneProfile;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private TextField textPeso;
    @FXML
    private TextField textAltura;
    @FXML
    private ChoiceBox<String> textComplexion;
    @FXML
    private ChoiceBox<String> textObjetivo;
    @FXML
    private Text textNombreNEW;
    @FXML
    private Text textApellidoNEW;
    @FXML
    private Text textNumIdentidadNEW;
    @FXML
    private Text textCorreoNEW;
    private LoginDTO loginDTO;

    public void setMainApp(MenuLogin mainApp, LoginDTO loginDTO) {
        this.mainApp = mainApp;
        this.loginDTO = loginDTO;
        this.helpCommand = new HelpCommand(mainApp);
        this.homeCommand = new HomeCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
        this.notificationCommand = new NotificationCommand(mainApp);
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginDTO != null) {
            ConsultaFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
            Usuario usuarioActual = consultaUsuariosFacade.consultarUsuario(loginDTO);

            textUser.setText(loginDTO.getUsername());
            textNombreNEW.setText(usuarioActual.getNombre());
            textApellidoNEW.setText(usuarioActual.getApellido());
            textNumIdentidadNEW.setText(usuarioActual.getNumeroDocumento());
            textCorreoNEW.setText(usuarioActual.getCorreo());
            textPeso.setText(String.valueOf(usuarioActual.getPerfil().getPeso()));
            textAltura.setText(String.valueOf(usuarioActual.getPerfil().getAltura()));
            setUpAccount.setTranslateX(171);
            cuenta1.setVisible(true);
            cuenta2.setVisible(false);
            ObservableList<String> opcionesComplexion = FXCollections.observableArrayList("Delgada", "Normal", "Robusta");
            ObservableList<String> opcionesObjetivo = FXCollections.observableArrayList("Llegar al peso ideal de acuerdo a mi altura", "Adelgazar y tonificar mi cuerpo", "Ganar masa muscular");
            // Asignar la lista de elementos al ChoiceBox
            textComplexion.setItems(opcionesComplexion);
            textObjetivo.setItems(opcionesObjetivo);
            textComplexion.setValue(usuarioActual.getPerfil().getComplexion());
            textObjetivo.setValue(usuarioActual.getPerfil().getObjetivo());
        }
    }

    @FXML
    public void onMouseEnteredImageView(MouseEvent event) {
        this.anchorPaneProfile.setVisible(true);
    }
    @FXML
    public void onMouseExitedImageView(MouseEvent event) {
        this.anchorPaneProfile.setVisible(false);
    }
    @FXML
    public void changeProfilePhoto(MouseEvent event) throws MalformedURLException {
        // Realizar la acción de cambio de imagen aquí

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Mostrar el cuadro de diálogo para seleccionar una imagen
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            // Cargar la imagen seleccionada
            Image image = new Image(selectedFile.toURI().toURL().toExternalForm());

            // Asignar la imagen al ImageView
            profilePicture.setImage(image);

            // Establecer el tamaño fijo de 120x120
            profilePicture.setFitWidth(120);
            profilePicture.setFitHeight(120);
        }
    }

    @FXML
    public void onClickSave(ActionEvent event) throws IOException {
        // Obtener los valores de los campos de texto
        String peso = textPeso.getText();
        String altura = textAltura.getText();
        String complexion = textComplexion.getValue();
        String objetivo = textObjetivo.getValue();
        String photoPath = "";

        ConsultaFacade consultaUsuariosFacade = new ConsultaUsuariosFacade();
        Usuario usuarioEnSesion = consultaUsuariosFacade.consultarUsuario(loginDTO);

        // Actualizar los datos del usuario con los nuevos valores
        if (usuarioEnSesion != null) {
            PerfilDTO perfilDTO = new PerfilDTO(Integer.parseInt(peso), Integer.parseInt(altura), complexion, objetivo, photoPath);
            ActualizacionPerfilFacade actualizacionPerfilFacade = new ActualizarPerfilFacade();
            actualizacionPerfilFacade.updatePerfil(perfilDTO, usuarioEnSesion);

            // Muestra una alerta de confirmación
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Actualizar datos");
            alert.setHeaderText("Datos actualizados correctamente");

            ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

            Optional<ButtonType> result = alert.showAndWait();
            this.mainApp.showHomeScreen(loginDTO);
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
    public void onClickLogOut(ActionEvent event) { logOutCommand.execute(loginDTO); }
    @FXML
    public void onclickGoBack(ActionEvent actionEvent) { homeCommand.execute(loginDTO); }

    @FXML
    public void onClickSettings() { settingsCommand.execute(loginDTO); }

    @FXML
    public void onClickHelp() { helpCommand.execute(loginDTO); }

    @FXML
    public void onClickNotification() { notificationCommand.execute(loginDTO); }

    @FXML
    public void onClickChangeProfilePhoto() {
        try {
            this.mainApp.showChangeProfilePhoto(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
