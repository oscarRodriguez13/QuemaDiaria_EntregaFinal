package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealizarLoginTest {

    @Test
    void loginNullnombreUsuario() {
        RealizarLogin realizarLogin = RealizarLogin.getInstance();
        String contra = "contraseña";
        assertThrows(IllegalArgumentException.class, () -> {
            realizarLogin.login(null,contra);
        });
    }

    @Test
    void loginNullcontrasenna() {
        RealizarLogin realizarLogin = RealizarLogin.getInstance();
        String nombreUsuario = "nombreUsuario";
        assertThrows(IllegalArgumentException.class, () -> {
            realizarLogin.login(nombreUsuario,null);
        });
    }
}