package Interfaces.Memento;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public class Originator {
    private Controller state;

    public Controller getState() {
        return state;
    }

    public void setState(Controller state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}