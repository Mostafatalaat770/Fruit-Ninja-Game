package Interfaces.Command;

import javafx.scene.control.ToggleButton;

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
}
