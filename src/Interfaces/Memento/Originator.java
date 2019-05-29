package Interfaces.Memento;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
class Originator {
    private Controller state;

    public Controller getState() {
        return state;
    }

    void setState(Controller state) {
        this.state = state;
    }

    Memento saveStateToMemento() {
        return new Memento(state);
    }

    void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}