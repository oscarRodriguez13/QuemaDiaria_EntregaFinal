package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.EliminarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RecuperarCredenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public class EliminarUsuarioService {

    private EliminarUsuario eliminarUsuario;

    private RecuperarCredenciales recuperarCredenciales;


    public EliminarUsuarioService() {
        this.eliminarUsuario =  EliminarUsuario.getInstance();

    }


    public boolean eliminarUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }
        boolean eliminado = eliminarUsuario.eliminar(loginDTO.getUsername());
        return eliminado;
    }
}
