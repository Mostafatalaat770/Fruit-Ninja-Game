package Interfaces;

import org.jdom2.JDOMException;

import java.io.IOException;

public interface GameActions {

    /**
     * saves the current state of the game
     */
    void saveGame() throws IOException;

    /**
     * loads the last saved state of the game
     */
    void loadGame() throws JDOMException, IOException;

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
    /*
     *  adds a random throwable to the scene to be drawn
     */

}
