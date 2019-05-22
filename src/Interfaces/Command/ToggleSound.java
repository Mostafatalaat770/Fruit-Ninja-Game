package Interfaces.Command;

import Gui.Controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public class ToggleSound implements Command {
    @FXML
    private
    Controller controller = Controller.getInstance();

    private void toggleSound(ToggleButton soundToggle) {
        controller.sound = soundToggle.isSelected();
        controller.gameStart.loop(Clip.LOOP_CONTINUOUSLY);
        if (controller.sound)
            controller.gameStart.start();
        else
            controller.gameStart.stop();
    }

    @Override
    public void execute(ToggleButton toggleButton) {
        toggleSound(toggleButton);

    }

    @Override
    public Clip play(String type, int duration) {
        return null;
    }
}
