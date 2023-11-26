package co.edu.javeriana.ingsoft.quemadiaria.c.services.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioDTO {
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String correo;
    private LoginDTO login;
    private PerfilDTO perfil;
}