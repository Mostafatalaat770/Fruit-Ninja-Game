package Interfaces.Factory;

import Interfaces.GameObject;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import Throwables.Fruits.SpecialFruits.FreezeBanana;

import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class ObjectCreator {
    public GameObject createObject(int flag) {

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
            case 5:
                return new FreezeBanana();
            case 6:
                return new DangerousBomb();
            case 7:
                return new FatalBomb();
        }
        return null;
    }
}
