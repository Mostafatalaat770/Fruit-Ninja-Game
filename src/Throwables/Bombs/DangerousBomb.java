package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class DangerousBomb extends Bomb {
    private final Controller controller = Controller.getInstance();

    public DangerousBomb() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/-10Bomb.png"), 75, 75, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/-10BombSliced.png"), 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {
        setSliced(true);
        controller.playSound("exit", 0);
    }

    @Override
    public void update() {
        if (isSliced()) {
            if (controller.score > 9)
                controller.score -= 10;
            else
                controller.score = 0;
            controller.unregister(this);
        }
        else if(hasMovedOffScreen())
        {
            controller.unregister(this);
        }
    }
}
