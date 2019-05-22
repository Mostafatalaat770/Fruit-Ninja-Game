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
import UsersDB.Player;

import java.util.Collections;
import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class ArcadeMode implements GameMode {
    private Random rand = new Random();
    private Controller controller = Controller.getInstance();

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

    public void sort() {
        for (int i = 0; i < controller.usersDB.getPlayers().size() - 1; i++) {
            for (int j = 0; j < controller.usersDB.getPlayers().size() - i - 1; j++) {
                if (controller.usersDB.getPlayers().get(j).getArcadeScore() < controller.usersDB.getPlayers().get(j + 1).getArcadeScore()) {
                    Collections.swap(controller.usersDB.getPlayers(), j, j + 1);
                }
            }
        }
    }

    public int getHighScore() {
        int max = 0;
        for (Player player : controller.usersDB.getPlayers()) {
            if (player.getArcadeScore() > max) {
                max = player.getArcadeScore();
            }
        }
        return max;
    }

    public boolean validate(int score) {
        return controller.usersDB.getPlayer().getArcadeScore() < score;
    }
}
