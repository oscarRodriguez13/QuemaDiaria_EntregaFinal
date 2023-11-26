package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class EliminarUsuario {

    private static EliminarUsuario instance;
    private UsuarioRepositorio usuarioRepositorio;

    private EliminarUsuario(UsuarioRepositorio usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }

    public static EliminarUsuario getInstance() {
        if (instance == null) {
            instance = new EliminarUsuario(new UsuarioArchivosRepositorio());
        }
        return instance;
    }

    public boolean eliminar(String nombreUsuario){

        boolean eliminado = usuarioRepositorio.eliminarUsuarioPorNombreUsuario(nombreUsuario);

        return eliminado;
    }
}
