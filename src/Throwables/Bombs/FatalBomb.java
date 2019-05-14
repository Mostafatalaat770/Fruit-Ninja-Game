package Throwables.Bombs;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {


    public FatalBomb(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Bomb.png");
        images[1]= new Image("Resources/Banana.png");
        return images;
    }
}
