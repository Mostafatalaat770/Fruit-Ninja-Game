package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Banana extends Fruit {


    public Banana(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Banana.png");
        images[1]= new Image("Resources/Banana.png");
        return images;
    }
}
