package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Interfaces.Strategy.GameMode;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import UsersDB.Player;

import java.util.Collections;
import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class ClassicMode implements GameMode {
    Random rand = new Random();
    Controller controller = Controller.getInstance();

    public GameObject createObject() {
        if (++controller.fatalBombRateControl % 7 == 0) {
            controller.fatalBombRateControl = 0;
            return new FatalBomb();
        }
        controller.luckyStrike %= 3;

        int flag = controller.luckyStrike++ < 2 ? rand.nextInt(5) % 4 : rand.nextInt(5) % 5;

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
                return new MagicBeans();
        }
        return null;
    }

    public void sort() {
        for (int i = 0; i < controller.usersDB.getPlayers().size() - 1; i++) {
            for (int j = 0; j < controller.usersDB.getPlayers().size() - i - 1; j++) {
                if (controller.usersDB.getPlayers().get(j).getClassicScore() < controller.usersDB.getPlayers().get(j + 1).getClassicScore()) {
                    Collections.swap(controller.usersDB.getPlayers(), j, j + 1);
                }
            }
        }
    }

    public int getHighScore() {
        int max = 0;
        for (Player player : controller.usersDB.getPlayers()) {
            if (player.getClassicScore() > max) {
                max = player.getClassicScore();
            }
        }
        return max;
    }

    public boolean validate(int score) {
        return controller.usersDB.getPlayer().getClassicScore() < score;
    }
}
