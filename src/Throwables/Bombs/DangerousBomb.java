package Throwables.Bombs;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class DangerousBomb extends Bomb {


    public DangerousBomb() {
        super();
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/-10_Bomb.png");
        images[1]= new Image("Resources/-10_Bomb.png");
        return images;
    }
    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        score--;
       lives--;
    }
}
