package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordChangeSubjectTest {

    @Test
    void addObserverNULLObserver() {
        PasswordChangeSubject passwordChangeSubject = new PasswordChangeSubject();

        assertThrows(IllegalArgumentException.class, () -> {
            passwordChangeSubject.addObserver(null);
        });
    }
}