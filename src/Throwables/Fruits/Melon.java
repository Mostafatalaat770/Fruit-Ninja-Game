package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Melon extends Fruit {


    public Melon() {
        super();
    }

    @Override
    public Image[] getImages() { Image[] images= new Image[2];
        images[0]= new Image("Resources/Watermelon.png",100,100,true,true);
        images[1]= new Image("Resources/Watermelon.png",100,100,true,true);
        return images; }

    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        score++;

    }
}
