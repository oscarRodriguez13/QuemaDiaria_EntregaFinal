package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.ControllerRecoverPassword;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ChangePassword {
    UsuarioRepositorio usuarioRepositorio;
    private static ChangePassword instance;

    private ChangePassword(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static ChangePassword getInstance() {
        if (instance == null) {
            instance = new ChangePassword(new UsuarioArchivosRepositorio());
        }
        return instance;
    }

    public void updateUserPassword(String userName, String newPassword) throws IOException {
        if (userName == null ||  newPassword == null) {
            throw new IllegalArgumentException("Los datos estan vacio");
        }
        usuarioRepositorio.actualizarContrasennaUsuario(userName, newPassword);
    }

}
