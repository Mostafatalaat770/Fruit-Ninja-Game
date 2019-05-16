package Interfaces;

import java.util.ArrayList;

public interface GameActions {
    /**
     * @return created game object
     */
    GameObject createGameObject();

    /**
     * update moving objects locations
     */
    void updateObjectsLocations();

    /**
     * it is used to slice fruits located in your swiping region
     * This method can take your swiping region as parameters (they
     * depend on how you calculate it).
     */
    void sliceObjects();

    /**
     * saves the current state of the game
     */
    void saveGame();

    /**
     * loads the last saved state of the game
     */
    void loadGame();

    /**
     * resets the game to its initial state
     */
    void ResetGame();

    /**
     * returns any random throwable randomly
     */
    GameObject getRandomThrowable();

    /**
     * removes any out of screen throwable from the array list
     */
    void removeUnwantedThrowable();
    /**
     *  adds a random throwable to the scene to be drawn
     */

}
