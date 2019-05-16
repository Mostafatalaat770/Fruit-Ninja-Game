package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FatalBomb extends Bomb {


    public FatalBomb() {
        super();
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Bomb.png");
        images[1]= new Image("Resources/Bomb.png");
        return images;
    }
    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        lives=0;
    }
}
