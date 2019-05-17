package Throwables.Bombs;

import javafx.scene.image.Image;
import Gui.Controller.Controller;


/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {


    public FatalBomb() {
        super();
        super.setImg1(new Image("Resources/Bomb.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/Bomb.png", 75, 75, true, true));
    }

    @Override
    public void slice() {
        Controller.lives=0;
        setSliced(true);
    }

}
