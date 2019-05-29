package Interfaces.Command;

import Gui.Controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public class ToggleMusic implements Command {
    @FXML
    private final
    Controller controller = Controller.getInstance();

    private void toggleMusic(ToggleButton soundToggle) {
        controller.settings.getSounds().setMusic(soundToggle.isSelected());
        if (controller.settings.getSounds().isMusic())
            controller.settings.getSounds().getMainTheme().start();
        else
            controller.settings.getSounds().getMainTheme().stop();
    }

    @Override
    public void execute(ToggleButton toggleButton) {
        toggleMusic(toggleButton);

    }

    @Override
    public Clip play(String type, int duration) {
        return null;
    }

    @Override
    public void resume() {

    }
}
