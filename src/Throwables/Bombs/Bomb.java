package Throwables.Bombs;

/**
 * @author Mostafa Talaat
 */
public abstract class Bomb extends Throwables.Throwable {

    public Bomb(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
        super(x, y, maxHeight, intialVelocity, fallingVelocity);
    }

}

