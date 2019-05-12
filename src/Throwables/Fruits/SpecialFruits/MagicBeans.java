package Throwables.Fruits.SpecialFruits;

/**
 * @author Mostafa Talaat
 */
public class MagicBeans extends SpecialFruit {
    public MagicBeans(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
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
