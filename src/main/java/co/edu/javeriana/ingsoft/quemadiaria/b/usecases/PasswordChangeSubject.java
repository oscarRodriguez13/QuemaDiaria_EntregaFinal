package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.PasswordChangeObserver;

import java.util.ArrayList;
import java.util.List;

public  class PasswordChangeSubject {
    private List<PasswordChangeObserver> observers = new ArrayList<>();

    public void addObserver(PasswordChangeObserver observer) {
        if (observer == null ) {
            throw new IllegalArgumentException("El observer esta vacio");
        }
        observers.add(observer);
    }

    public void notifyObservers() {
        for (PasswordChangeObserver observer : observers) {
            observer.onPasswordChanged();
        }
    }
}
