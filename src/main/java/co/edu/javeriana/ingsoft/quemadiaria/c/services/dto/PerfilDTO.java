package co.edu.javeriana.ingsoft.quemadiaria.c.services.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PerfilDTO {
    private int altura;
    private int peso;
    private String complexion;
    private String objetivo;
    private String photoPath;


    public PerfilDTO(int altura, int peso, String complexion, String objetivo, String photoPath) {
        this.altura = altura;
        this.peso = peso;
        this.complexion = complexion;
        this.objetivo = objetivo;
        this.photoPath = photoPath;
    }

    public PerfilDTO(String photoPath) {
        this.photoPath = photoPath;
    }
}
