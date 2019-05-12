package Throwables.Fruits.SpecialFruits;

/**
 * @author Mostafa Talaat
 */
public abstract class SpecialFruit extends Throwables.Throwable {

    public SpecialFruit(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
        super(x, y, maxHeight, intialVelocity, fallingVelocity);
    }
}
