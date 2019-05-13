package Throwables.Fruits;

/**
 * @author Mostafa Talaat
 */
public abstract class Fruit extends Throwables.Throwable {


    public Fruit(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }

    @Override
    public void slice() {
        super.slice();
    }


}
