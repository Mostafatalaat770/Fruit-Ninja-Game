package Throwables.Fruits.SpecialFruits;

import Gui.Controller.Controller;
import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class MagicBeans extends SpecialFruit {


    public MagicBeans() {
        super();
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Magic_Bean.png",75,75,true,true);
        images[1]= new Image("Resources/Magic_Bean.png",75,75,true,true);
        return images;
    }
    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        if(lives>2){
            score+=25;
        }
        else {
            lives++;
        }
    }
}
