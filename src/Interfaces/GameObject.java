package Interfaces;

import Gui.Controller.Controller;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface GameObject {
    /**
     * @return X location of game object
     */
    double getLocationX();

    /**
     * @return Y location of game object
     */
    double getLocationY();

    /**
     * @return max Y location that the object can reach on the screen
     */
    double getMaxHeight();

    /**
     * @return whether the object is sliced or not
     */
    Boolean isSliced();

    /**
     * @return whether the object is dropped off the screen or not
     */
    Boolean hasMovedOffScreen();

    /**
     * it is used to slice the object
     *
     * @param controller
     * @throws InterruptedException 
     */
    void slice(Controller controller) throws InterruptedException;

    Boolean isFalling();

    void setFalling(boolean falling);

    void setSliced(boolean sliced);

    void setMovedOffScreen(boolean movedOffScreen);

    void setX(double x);

    void setY(double y);

    void setMaxHeight(double maxHeight);

    double getStartPos();

    void setStartPos(double startPos);

    double getMidPoint();

    void setMidPoint(double midPoint);

    double getEndPos();

    void setEndPos(double endPos);

    double getA();

    void setA(double a);

    double getQ();

    void setQ(double q);

    double getP();

    void setP(double p);

    Image getImg1();

    void setImg1(Image img1);

    void setImg2(Image img2);

    boolean isLeftToRight();

    void setLeftToRight(boolean leftToRight);

    /**
     * @return the type of game object
     */
    enum getObjectType {}

    /**
     * used to render the image on the canvas
     */
    void render(GraphicsContext gc);

    /**
     * updates the movement of any fruit
     */
    void updatePosition();

}
