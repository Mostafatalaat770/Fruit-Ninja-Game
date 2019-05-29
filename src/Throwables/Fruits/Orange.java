package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Orange extends Fruit {

    public Orange() {
        super();
        super.setImg1(new Image(this.getClass().getResourceAsStream("/Orange.png"), 60, 60, true, true));
        super.setImg2(new Image(this.getClass().getResourceAsStream("/OrangeSliced.png"), 75, 75, true, true));
    }

    @Override
    public void setImg1(Image img1) {

    }

}
