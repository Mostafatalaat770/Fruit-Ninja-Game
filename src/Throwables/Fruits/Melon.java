package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Melon extends Fruit {


    public Melon() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/Watermelon.png"), 75, 75, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/WatermelonSliced.png"), 110, 110, true, true));
    }

}
