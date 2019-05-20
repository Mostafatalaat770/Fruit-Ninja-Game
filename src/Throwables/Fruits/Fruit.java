package Throwables.Fruits;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public abstract class Fruit extends Throwables.Throwable {


    public Fruit() {
        super();
    }
    
    public void slice(Controller controller) throws InterruptedException {
    	super.slice(controller);
    	controller.playSound("pome-slice-1.wav", 0);
	}

}
