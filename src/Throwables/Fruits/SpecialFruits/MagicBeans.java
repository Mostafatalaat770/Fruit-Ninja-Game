package Throwables.Fruits.SpecialFruits;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class MagicBeans extends SpecialFruit {
Controller controller = Controller.getInstance();

    public MagicBeans() {
        super();
        super.setImg1(new Image("Resources/Magic_Bean.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/Sliced_Magic_Bean.png", 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {

        setSliced(true);
    }
    @Override
    public void update()
    {  if(isSliced()){
        if (controller.lives > 2) {
            controller.score += 25;
            controller.playSound("pome-slice-1.wav", 0);
        } else {
            controller.lives++;
            controller.playSound("extra-life.wav", 0);
        }
        controller.unregister(this);
    }
    else if(hasMovedOffScreen())
        controller.unregister(this);
    }

}
