package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecuperarCredencialesTest {

    @Test
    void recuperarNullnombreUsuario() {
        RecuperarCredenciales recuperarCredenciales = RecuperarCredenciales.getInstance();
        String contra = "contraseña";
        assertThrows(IllegalArgumentException.class, () -> {
            recuperarCredenciales.recuperar(null,contra);
        });
    }
    @Test
    void recuperarNullcontrasenna() {
        RecuperarCredenciales recuperarCredenciales = RecuperarCredenciales.getInstance();
        String userName = "userName";
        assertThrows(IllegalArgumentException.class, () -> {
            recuperarCredenciales.recuperar(userName,null);
        });
    }
}