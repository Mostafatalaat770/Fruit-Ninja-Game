package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {

    // TODO: 18-May-19 the bomb thingie every 6 fruit (mosta)

    public FatalBomb() {
        super();
        super.setImg1(new Image("Resources/Bomb.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/Bomb.png", 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {
        controller.lives = 0;
        setSliced(true);
    }

}
