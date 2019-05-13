package Throwables.Fruits.SpecialFruits;

/**
 * @author Mostafa Talaat
 */
public abstract class SpecialFruit extends Throwables.Throwable {


    public SpecialFruit(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }
}
