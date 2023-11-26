package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RecuperarCredenciales;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public class AutenticacionService {


    private RealizarLogin realizarLogin;

    private RecuperarCredenciales recuperarCredenciales;


    public AutenticacionService() {
        this.realizarLogin =  RealizarLogin.getInstance();
        this.recuperarCredenciales = RecuperarCredenciales.getInstance();
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
