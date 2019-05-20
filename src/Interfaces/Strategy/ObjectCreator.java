package Interfaces.Strategy;

import Gui.Controller.Controller;
import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public interface ObjectCreator {
    GameObject create(Controller controller);

}