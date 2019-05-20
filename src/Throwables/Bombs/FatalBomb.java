package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {

    Controller controller = Controller.getInstance();
    public FatalBomb() {
        super();
        super.setImg1(new Image("Resources/Bomb.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/Bomb.png", 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {
        setSliced(true);

    }

    @Override
    public void update() {
        if (isSliced())
            controller.lives = 0;
        controller.unregister(this);
    }
}
