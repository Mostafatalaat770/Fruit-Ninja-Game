package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Interfaces.Strategy.GameMode;
import Throwables.Bombs.DangerousBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.FreezeBanana;

import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class ArcadeMode implements GameMode {
    private final Random rand = new Random();
    private final Controller controller = Controller.getInstance();

    public GameObject createObject() {

        controller.luckyStrike = rand.nextInt() % 3;
        int flag = controller.luckyStrike < 1 ? rand.nextInt(5) % 4 : rand.nextInt(6) % 6;
        switch (flag) {
            case 0:
                return new Apple();
            case 1:
                return new Banana();
            case 2:
                return new Melon();
            case 3:
                return new Orange();
            case 4:
                return new FreezeBanana();
            case 5:
                return new DangerousBomb();

        }
        return null;
    }



    public int getHighScore() {
        return controller.usersDB.getHighestScore(2);
    }

    public boolean validate(int score) {
        return controller.usersDB.getPlayer().getArcadeScore() < score;
    }
}
