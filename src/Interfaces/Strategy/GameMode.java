package Interfaces.Strategy;

import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public interface GameMode {
    GameObject createObject();

    int getHighScore();

    boolean validate(int score);
}
