package co.edu.javeriana.ingsoft.quemadiaria.c.services.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UsuarioDTO {
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaCreacion;
    private LoginDTO login;
    private PerfilDTO perfil;
}