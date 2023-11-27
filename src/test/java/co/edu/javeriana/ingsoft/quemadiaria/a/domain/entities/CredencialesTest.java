package co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CredencialesTest {
    private Credenciales credenciales;

    @BeforeEach
    public void setUp() {
        credenciales = new Credenciales("usuario1", "contrasenna123");
    }

    @Test
    public void correctCredentials() {
        assertTrue(credenciales.validarCredenciales("usuario1", "contrasenna123"));
    }

    @Test
    public void incorrectCredentials() {
        assertFalse(credenciales.validarCredenciales("usuario2", "contrasenna123"));
        assertFalse(credenciales.validarCredenciales("usuario1", "password"));
    }
}
