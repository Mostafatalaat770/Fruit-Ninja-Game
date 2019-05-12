package Interfaces;

import javafx.scene.image.Image;

public interface GameObject {
    /**
     * @return X location of game object
     */
    int getXlocation();

    /**
     * @return Y location of game object
     */
    int getYlocation();

    /**
     * @return max Y location that the object can reach on the screen
     */
    int getMaxHeight();

    /**
     * @return velocity at which game object is thrown
     */
    int getInitialVelocity();

    /**
     * @return failing velocity of game object
     */
    int getFallingVelocity();

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
     */
    void slice();

    /**
     * it is used to move the object on the screen
     *
     * @param time: time elapsed since the object is thrown
     *              it is used calculate the new position of
     *              fruit object.
     */
    void move(double time);

    /**
     * @return at least two images of the object, one when it is
     * sliced and one when it is not.
     */
    Image[] getImages();

    /**
     * @return the type of game object
     */
    enum getObjectType {}
}
