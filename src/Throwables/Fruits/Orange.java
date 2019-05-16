package Throwables.Fruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Orange extends Fruit {


    public Orange() {
        super();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Orange.png",75,75,true,true);
        images[1]= new Image("Resources/Orange.png",75,75,true,true);
        return images;
    }

    public void getEffect(int score,int lives, int secs){
        // TODO: 17-May-19 mostafa

        score++;

    }
}
