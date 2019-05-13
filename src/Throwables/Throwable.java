package Throwables;

import Interfaces.GameObject;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public abstract class Throwable implements GameObject {
    private int x;
    private int y;
    private int maxHeight;
    private int intialVelocity;
    private int fallingVelocity;
    private boolean sliced = false;
    private boolean movedOffScreen = false;

    public Throwable(int x, int y, int maxHeight, int intialVelocity, int fallingVelocity) {
        this.x = x;
        this.y = y;
        this.maxHeight = maxHeight;
        this.intialVelocity = intialVelocity;
        this.fallingVelocity = fallingVelocity;
    }

    @Override
    public int getXlocation() {
        return x;
    }

    @Override
    public int getYlocation() {
        return y;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getInitialVelocity() {
        return intialVelocity;
    }

    @Override
    public int getFallingVelocity() {
        return fallingVelocity;
    }

    @Override
    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return movedOffScreen;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public Image[] getImages() {
        return new Image[0];
    }
}
