package Throwables;

import Interfaces.GameObject;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Mostafa Talaat
 */
public abstract class Throwable implements GameObject {
    private double x;
    private double y;
    private double maxHeight;
    private int initialVelocity;
    private int fallingVelocity;
    private boolean falling = false;
    private boolean sliced = false;
    private boolean movedOffScreen = false;

    public Throwable(int x, int y, int maxHeight, int initialVelocity, int fallingVelocity) {
        this.x = x;
        this.y = y;
        this.maxHeight = maxHeight;
        this.initialVelocity = initialVelocity;
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
    public double getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getInitialVelocity() {
        return initialVelocity;
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

    public Boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
    }

    public void setMovedOffScreen(boolean movedOffScreen) {
        this.movedOffScreen = movedOffScreen;
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
    public void render(GraphicsContext gc) {
        if (isSliced())
            gc.drawImage(getImages()[1], x, y);
        else
            gc.drawImage(getImages()[0], x, y);

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setInitialVelocity(int initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    @Override
    public void updatePosition(){
        double newPos= y-initialVelocity;
        if(falling==false){
            if(newPos>maxHeight){
                falling=true;
                y+=initialVelocity;
            }
            else{
                y-=initialVelocity;
            }
        }else{
            y+=initialVelocity;
        }
    }
}
