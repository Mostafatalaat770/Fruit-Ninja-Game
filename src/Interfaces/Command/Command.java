package Interfaces.Command;

import javafx.scene.control.ToggleButton;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public interface Command {
    void execute(ToggleButton toggleButton);

    Clip play(String type, int duration);

    void resume();
}
