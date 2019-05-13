package Throwables.Bombs;

/**
 * @author Mostafa Talaat
 */
public abstract class Bomb extends Throwables.Throwable {


    public Bomb(double x, double y, double maxHeight, int initialVelocity, int fallingVelocity, boolean falling, boolean sliced, boolean movedOffScreen) {
        super(x, y, maxHeight, initialVelocity, fallingVelocity, falling, sliced, movedOffScreen);
    }
}

