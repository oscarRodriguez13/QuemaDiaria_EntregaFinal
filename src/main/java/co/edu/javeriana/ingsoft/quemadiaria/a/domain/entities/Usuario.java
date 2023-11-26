package co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

    private final String numeroDocumento;
    private String nombre;
    private String apellido;
    private final String correo;
    private final Credenciales credenciales;
    private Perfil perfil;


    public Usuario(String numeroDocumento, String correo, Credenciales credenciales) {
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.credenciales = credenciales;
        this.perfil = new Perfil(0, 0, "", "");
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Credenciales getCredenciales() {
        return credenciales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario {" + "numeroDocumento=" + numeroDocumento + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", credenciales=" + credenciales + '}';
    }
}
