package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Banana extends Fruit {


    public Banana() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/Banana.png"), 75, 75, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/BananaSliced.png"), 75, 75, true, true));
    }

}
