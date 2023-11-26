package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RecuperarCredenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class AutenticacionService {


    private RealizarLogin realizarLogin;

    private RecuperarCredenciales recuperarCredenciales;


    public AutenticacionService() {
        this.realizarLogin = new RealizarLogin(new UsuarioArchivosRepositorio());
        this.recuperarCredenciales = new RecuperarCredenciales(new UsuarioArchivosRepositorio());
    }

    public ResponseDTO<String> autenticarUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }
        try {
            realizarLogin.login(loginDTO.getUsername(), loginDTO.getPassword());
            return new ResponseDTO<>(ResponseDTO.OK, "Login exitoso", "Login exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al hacer el login");
        }

    }

    public Credenciales credencialesUsuario(LoginDTO loginDTO) {
        if (loginDTO == null ) {
            throw new IllegalArgumentException("Invalido loginDTO");
        }
         Credenciales credenciales = recuperarCredenciales.recuperar(loginDTO.getUsername(), loginDTO.getPassword());
        return credenciales;
    }
}
