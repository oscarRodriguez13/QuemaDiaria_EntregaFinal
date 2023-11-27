package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class RecuperarCredenciales {

    private UsuarioRepositorio usuarioRepositorio;

    private static RecuperarCredenciales instance;

    private RecuperarCredenciales(UsuarioRepositorio usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }
    public static RecuperarCredenciales getInstance() {
        if (instance == null) {
            instance = new RecuperarCredenciales(new UsuarioArchivosRepositorio());
        }
        return instance;
    }


    public Credenciales recuperar(String nombreUsuario, String contrasenna) {

        if (nombreUsuario == null ||  contrasenna == null) {
            throw new IllegalArgumentException("Los datos estan vacio");
        }

        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);

        return usuario.getCredenciales();
    }
}
