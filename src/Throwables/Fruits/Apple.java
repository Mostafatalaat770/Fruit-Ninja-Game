package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Apple extends Fruit {


    public Apple() {
        super();
        super.setImg1(new Image("Resources/Green_Apple.png", 75, 75, true, true));
        super.setImg2(new Image("Resources/SlicedGreenApple.png", 75, 75, true, true));
    }


}
