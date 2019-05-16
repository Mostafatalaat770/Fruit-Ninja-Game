package Throwables.Fruits;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public abstract class Fruit extends Throwables.Throwable {


    public Fruit() {
        super();
    }

    @Override
    public void slice() {
        super.slice();
    }


    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        score++;

    }


}
