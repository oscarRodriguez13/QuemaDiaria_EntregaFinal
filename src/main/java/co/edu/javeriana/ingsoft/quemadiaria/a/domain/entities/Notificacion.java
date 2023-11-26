package co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;

public class Notificacion {
    private String descripcion;
    private boolean activo;

    public Notificacion(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
