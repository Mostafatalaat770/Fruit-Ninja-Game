package Interfaces.Memento;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public class Memento {
    private Controller state;

    public Memento(Controller state) {
        this.state = state;
    }

    public Controller getState() {
        return state;
    }
}