package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

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

    public void updateUserPassword(String userName, String newPassword){
        usuarioRepositorio.actualizarContrasennaUsuario(userName, newPassword);
    }

}
