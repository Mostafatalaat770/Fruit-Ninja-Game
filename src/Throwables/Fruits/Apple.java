package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Apple extends Fruit {


    public Apple(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public Image[] getImages() {
        return super.getImages();
    }




}
