package Interfaces.Strategy;

import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public interface GameMode {
    GameObject createObject();

    void sort();

    int getHighScore();

    boolean validate(int score);
}
