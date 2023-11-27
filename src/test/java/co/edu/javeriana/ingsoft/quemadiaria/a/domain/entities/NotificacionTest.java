package co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificacionTest {
    private Notificacion notificacion;

    @BeforeEach
    public void setUp() {
        notificacion = new Notificacion("Notificación de prueba", true);
    }

    @Test
    public void notificationIsActive() {
        assertTrue(notificacion.isActivo());
    }
}
