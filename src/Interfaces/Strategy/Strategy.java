package Interfaces.Strategy;

import Gui.Controller.Controller;
import Interfaces.GameObject;

/**
 * @author Mostafa Talaat
 */
public class Strategy {
    private ObjectCreator objectCreator;
    private DataBase dataBase;

    public Strategy(ObjectCreator objectCreator) {
        this.objectCreator = objectCreator;
    }

    public Strategy(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public GameObject create(Controller controller) {
        return objectCreator.create(controller);
    }

    public void sort() {
        dataBase.sort();
    }

    public int getHighScore() {
        return dataBase.getHighScore();
    }

    public boolean validate(int score) {
        return dataBase.validate(score);
    }

}
