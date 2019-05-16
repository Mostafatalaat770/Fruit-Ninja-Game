package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Apple extends Fruit {


    public Apple() {
        super();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Green_Apple.png",75,75,true,true);
        images[1]= new Image("Resources/Green_Apple.png",75,75,true,true);
        return images;
    }
    @Override
    public void getEffect(int score,int lives, int secs){
        score++;
        // TODO: 17-May-19 mostafa


    }


}
