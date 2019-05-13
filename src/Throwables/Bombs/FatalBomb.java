package Throwables.Bombs;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {
    public FatalBomb(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
        super(x, y, maxHeight, intialVelocity, fallingVelocity);
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public javafx.scene.image.Image[] getImages() {
        return super.getImages();
    }
}
