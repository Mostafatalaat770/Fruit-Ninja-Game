package Settings;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Backgrounds {
    private int ID;
    private Image background = new Image(this.getClass().getResourceAsStream("/wallpaper1.jpg"));

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    void changeBackground(int ID) {
        this.ID = ID;
        switch (ID) {
            case 1:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper1.jpg"));
                break;
            case 2:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper2.jpg"));
                break;
            case 3:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper3.png"));
                break;
            case 4:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper4.png"));
                break;
            case 5:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper5.png"));
                break;
            case 6:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper6.png"));
                break;
            case 7:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper7.png"));
                break;
            case 8:
                background = new Image(this.getClass().getResourceAsStream("/wallpaper8.png"));
                break;
        }
    }
}
