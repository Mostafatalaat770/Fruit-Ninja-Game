package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Melon extends Fruit {


    public Melon(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public Image[] getImages() { Image[] images= new Image[2];
        images[0]= new Image("Resources/Watermelon.png",100,100,true,true);
        images[1]= new Image("Resources/Watermelon.png",100,100,true,true);
        return images; }

}
