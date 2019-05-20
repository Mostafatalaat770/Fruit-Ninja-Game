package Throwables.Fruits.SpecialFruits;

import Gui.Controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * @author Mostafa Talaat
 */
public class FreezeBanana extends SpecialFruit {


    public FreezeBanana() {
        super();
        super.setImg1(new Image("Resources/Freeze_Banana.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/SlicedFreezeBanana.png", 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {
        controller.freezeEffect=true;
        controller.secs += 5;
        controller.playSound("Bonus-Banana-Freeze.wav", 0);
        setSliced(true);

    }

}
