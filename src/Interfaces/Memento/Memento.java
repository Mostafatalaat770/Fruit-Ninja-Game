package Interfaces.Memento;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
class Memento {
    private final Controller state;

    Memento(Controller state) {
        this.state = state;
    }

    Controller getState() {
        return state;
    }
}