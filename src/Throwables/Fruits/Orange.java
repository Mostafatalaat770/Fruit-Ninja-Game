package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Orange extends Fruit {


    public Orange(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Orange.png",75,75,true,true);
        images[1]= new Image("Resources/Orange.png",75,75,true,true);
        return images;
    }
}
