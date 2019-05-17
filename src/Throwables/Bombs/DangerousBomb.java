package Throwables.Bombs;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class DangerousBomb extends Bomb {


    public DangerousBomb() {
        super();
        super.setImg1(new Image("Resources/-10_Bomb.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/-10_Bomb.png", 75, 75, true, true));
    }

    @Override
    public void slice() {
        super.slice();
    }

}
