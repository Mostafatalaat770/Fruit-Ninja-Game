package Interfaces.Command;

import Gui.Controller.Controller;
import javafx.scene.control.ToggleButton;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute(ToggleButton toggleButton) {
        command.execute(toggleButton);
    }

    public Clip playSound(String type, int duration, Controller controller) {
        return command.play(type, duration);
    }
}
