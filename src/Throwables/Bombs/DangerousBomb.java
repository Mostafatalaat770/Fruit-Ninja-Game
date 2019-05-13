package Throwables.Bombs;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class DangerousBomb extends Bomb {


    public DangerousBomb(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        return super.getImages();
    }
}
