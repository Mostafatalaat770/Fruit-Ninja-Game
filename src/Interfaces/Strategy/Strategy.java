package Interfaces.Strategy;

import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public class Strategy {
    private GameMode gameMode;


    public Strategy(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameObject createObject() {
        return gameMode.createObject();
    }

    public void sort() {
        gameMode.sort();
    }

    public int getHighScore() {
        return gameMode.getHighScore();
    }

    public boolean validate(int score) {
        return gameMode.validate(score);
    }

    public GameMode getGameMode() {
        return gameMode;
    }
}
