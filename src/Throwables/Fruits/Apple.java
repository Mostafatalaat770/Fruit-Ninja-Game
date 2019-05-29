package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Apple extends Fruit {


    public Apple() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/GreenApple.png"), 60, 60, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/GreenAppleSliced.png"), 75, 75, true, true));
    }


}
