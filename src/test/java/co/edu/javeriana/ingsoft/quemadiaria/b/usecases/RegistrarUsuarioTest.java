package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarUsuarioTest {

    @Test
    void registrarUsuarioNullUsuario() {
        RegistrarUsuario registrarUsuario = RegistrarUsuario.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            registrarUsuario.registrarUsuario(null);
        });
    }
}