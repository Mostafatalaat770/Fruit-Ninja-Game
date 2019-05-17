package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public class Strategy {
    private ObjectCreator objectCreator;

    public Strategy(ObjectCreator objectCreator) {
        this.objectCreator = objectCreator;
    }

    public GameObject create(Controller controller) {
        return objectCreator.create(controller);
    }

}
