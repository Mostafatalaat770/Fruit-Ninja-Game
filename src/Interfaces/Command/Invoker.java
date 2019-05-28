package Interfaces.Command;

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

    public Clip playSound(String type, int duration) {
        return command.play(type, duration);
    }

    public void resume() {
        command.resume();
    }
}
