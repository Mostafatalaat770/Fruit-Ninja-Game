package Throwables.Fruits.SpecialFruits;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class FreezeBanana extends SpecialFruit {


    public FreezeBanana() {
        super();
    }

    @Override
    public void slice() {
        super.slice();
    }

    @Override
    public Image[] getImages() {
        Image[] images= new Image[2];
        images[0]= new Image("Resources/Freeze_Banana.png");
        images[1]= new Image("Resources/Freeze_Banana.png");
        return images;
    }
}
