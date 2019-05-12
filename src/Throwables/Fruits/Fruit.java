package Throwables.Fruits;

/**
 * @author Mostafa Talaat
 */
public abstract class Fruit extends Throwables.Throwable {

    public Fruit(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
        super(x, y, maxHeight, intialVelocity, fallingVelocity);
    }

    @Override
    public void slice() {
        super.slice();
    }
}
