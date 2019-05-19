package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class DangerousBomb extends Bomb {
 Controller controller = Controller.getInstance();

    public DangerousBomb() {
        super();
        super.setImg1(new Image("Resources/-10_Bomb.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/-10_Bomb.png", 75, 75, true, true));
    }

    @Override
    public void slice(Controller controller) {

    }
       @Override
       public void update()
       {
           if(controller.score>9)
           controller.score-=10;
       else
           controller.score=0;
           setSliced(true);

       }

}
