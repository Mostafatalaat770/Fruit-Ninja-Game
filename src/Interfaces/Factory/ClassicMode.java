package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Interfaces.Strategy.ObjectCreator;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;

import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class ClassicMode implements ObjectCreator {
    Random rand = new Random();

    public GameObject create(Controller controller) {
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

}
