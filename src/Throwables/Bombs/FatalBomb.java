package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {

    private final Controller controller = Controller.getInstance();
    public FatalBomb() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/Bomb.png"), 75, 75, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/Bomb.png"), 75, 75, true, true));

    }

    @Override
    public void slice(Controller controller) throws InterruptedException {
        Clip fatal = controller.playSound("bomb explode", 0);
        setSliced(true);
        Thread.sleep(fatal.getMicrosecondLength()/3000);
    }

    @Override
    public void update() {
        if (isSliced()) {
            controller.lives = 0;
            controller.unregister(this);
        }
        if(hasMovedOffScreen())
            controller.unregister(this);
    }
}
