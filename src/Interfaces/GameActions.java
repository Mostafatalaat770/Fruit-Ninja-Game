package Interfaces;

import java.util.ArrayList;

public interface GameActions {
    /**
     *@return created game object
     */
    public GameObject createGameObject();
/**
* update moving objects locations
 */
public void updateObjectsLocations();
    /**
    * it is used to slice fruits located in your swiping region
    This method can take your swiping region as parameters (they
    depend on how you calculate it).
    */
    public void sliceObjects();
    /**
     *saves the current state of the game
     */
    public void saveGame();
    /**
     *loads the last saved state of the game
     */
    public void loadGame();
    /**
     *resets the game to its initial state
     */
    public void ResetGame();
    /**
     * returns any random throwable randomly
     */
    public GameObject getRandomThrowable();
    /**
     * removes any out of screen throwable from the array list
     */
    public void removeUnwantedThrowable(ArrayList<GameObject> throwables);

}
