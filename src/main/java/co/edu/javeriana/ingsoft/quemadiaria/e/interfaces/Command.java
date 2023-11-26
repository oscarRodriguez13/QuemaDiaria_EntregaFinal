package co.edu.javeriana.ingsoft.quemadiaria.e.interfaces;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;

public interface Command {
    void execute(LoginDTO loginDTO);
}
