package Settings;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Backgrounds {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Image changeBackground(int ID) {
        Image background = null;
        this.ID = ID;
        switch (ID) {
            case 1:
                background = new Image("Resources/wallpaper1.jpg");
                break;
            case 2:
                background = new Image("Resources/wallpaper2.jpg");
                break;
            case 3:
                background = new Image("Resources/wallpaper3.jpg");
                break;
            case 4:
                background = new Image("Resources/wallpaper4.jpg");
                break;
            case 5:
                background = new Image("Resources/wallpaper5.jpg");
                break;
            case 6:
                background = new Image("Resources/wallpaper6.jpg");
                break;
            case 7:
                background = new Image("Resources/wallpaper7.jpg");
                break;
            case 8:
                background = new Image("Resources/wallpaper8.jpg");
                break;
        }
        return background;
    }
}
