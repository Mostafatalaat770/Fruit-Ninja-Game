package Throwables;

import Interfaces.GameObject;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Mostafa Talaat
 */
public abstract class Throwable implements GameObject {
    private double x;
    private double y;
    private int maxHeight;
    private int intialVelocity;
    private int fallingVelocity;
    private boolean isfalling=false;
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
    public double getXlocation() {
        return x;
    }

    @Override
    public double getYlocation() {
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
    public javafx.scene.image.Image[] getImages() {
        return new javafx.scene.image.Image[0];
    }

    @Override
    public void render(GraphicsContext gc){
        if(isSliced())
        gc.drawImage(getImages()[1],x,y);
        else
            gc.drawImage(getImages()[0],x,y);

    }
}
