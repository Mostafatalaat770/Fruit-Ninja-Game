package Interfaces.Factory;

import Interfaces.GameObject;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import Throwables.Fruits.SpecialFruits.Score2xBanana;

/**
 * @author Mostafa Talaat
 */
public class ObjectCreator {
    public GameObject createObject(int flag) {
        switch (flag) {
            case 0:
                return new Apple(100, 100, 100, 100, 100, false, false, false);
            case 1:
                return new Banana(100, 100, 100, 100, 100, false, false, false);
            case 2:
                return new Melon(100, 100, 100, 100, 100, false, false, false);
            case 3:
                return new Orange(100, 100, 100, 100, 100, false, false, false);
            case 4:
                return new MagicBeans(100, 100, 100, 100, 100, false, false, false);
            case 5:
                return new Score2xBanana(100, 100, 100, 100, 100, false, false, false);
            case 6:
                return new DangerousBomb(100, 100, 100, 100, 100, false, false, false);
            case 7:
                return new FatalBomb(100, 100, 100, 100, 100, false, false, false);
        }
        return null;
    }
}
