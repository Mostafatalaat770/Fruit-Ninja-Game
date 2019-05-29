package Throwables.Fruits;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public abstract class Fruit extends Throwables.Throwable {


    Fruit() {
        super();
    }
    
    public void slice(Controller controller) throws InterruptedException {
    	super.slice(controller);
        controller.playSound("slice", 0);
	}

}
