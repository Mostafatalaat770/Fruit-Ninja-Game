package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;
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
public class ArcadeMode implements ObjectCreator {
    Random rand = new Random();

    public GameObject create(Controller controller) {

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

}
