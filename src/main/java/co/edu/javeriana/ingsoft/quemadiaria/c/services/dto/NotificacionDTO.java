package co.edu.javeriana.ingsoft.quemadiaria.c.services.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotificacionDTO {
    private String descripcion;
    private boolean activo;
}
