module co.edu.javeriana.ingsoft.quemadiaria{
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.google.gson;
    requires java.sql;

    opens co.edu.javeriana.ingsoft.quemadiaria to javafx.fxml;
    opens co.edu.javeriana.ingsoft.quemadiaria.f.controllers to javafx.fxml;
    exports co.edu.javeriana.ingsoft.quemadiaria.f.controllers;
    opens co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities to com.google.gson;
    exports co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities;
    exports co.edu.javeriana.ingsoft.quemadiaria;
}
