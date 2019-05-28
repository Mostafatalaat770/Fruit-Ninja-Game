package Settings;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Settings {
    private static Settings ourInstance = new Settings();
    private Sounds sounds = new Sounds();
    private Backgrounds backgrounds = new Backgrounds();

    private Settings() {
    }

    public static Settings getInstance() {
        return ourInstance;
    }

    public Image changeBackground(int ID) {
        return backgrounds.changeBackground(ID);
    }

    public Sounds getSounds() {
        return sounds;
    }

    public void setSounds(Sounds sounds) {
        this.sounds = sounds;
    }

    public Backgrounds getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(Backgrounds backgrounds) {
        this.backgrounds = backgrounds;
    }
}
