package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Banana extends Fruit {


    public Banana() {
        super();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Banana.png");
        images[1]= new Image("Resources/Banana.png");
        return images;
    }

    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        score++;

    }
}
