package Throwables.Fruits.SpecialFruits;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FreezeBanana extends SpecialFruit {

    private Controller controller = Controller.getInstance();
    public FreezeBanana() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/Freeze_Banana.png"), 75, 75, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/SlicedFreezeBanana.png"), 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {
        controller.freezeEffect=true;
        controller.secs += 5;
        controller.playSound("freeze", 0);
        setSliced(true);

    }
    @Override
    public void update()
    {  if(super.isSliced()) {
        controller.score++;
        controller.unregister(this);
    }
    else if(hasMovedOffScreen())
        controller.unregister(this);
    }

}
