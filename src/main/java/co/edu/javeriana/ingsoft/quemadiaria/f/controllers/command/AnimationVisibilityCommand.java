package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;

public class AnimationVisibilityCommand implements Command {
    private TranslateTransition slide;
    private double toX;
    private Group groupToShow;
    private Group groupToHide;

    public AnimationVisibilityCommand(TranslateTransition slide, double toX, Group groupToShow, Group groupToHide) {
        this.slide = slide;
        this.toX = toX;
        this.groupToShow = groupToShow;
        this.groupToHide = groupToHide;
    }

    @Override
    public void execute(LoginDTO loginDTO) {
        slide.setToX(toX);
        slide.play();

        slide.setOnFinished((ActionEvent e) -> {
            groupToShow.setVisible(true);
            groupToHide.setVisible(false);
        });
    }
}
