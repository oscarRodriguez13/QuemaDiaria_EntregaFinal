package co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;

public class Perfil {
    private int altura;
    private int peso;
    private String complexion;
    private String objetivo;
    private String photoPath;

    public Perfil(int altura, int peso, String complexion, String objetivo, String photoPath) {
        this.altura = altura;
        this.peso = peso;
        this.complexion = complexion;
        this.objetivo = objetivo;
        this.photoPath = photoPath;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public String getPhotoPath() {
        return photoPath;
    }


    @Override
    public String toString() {
        return "Perfil{" +
                "altura=" + altura +
                ", peso=" + peso +
                ", complexion='" + complexion + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
