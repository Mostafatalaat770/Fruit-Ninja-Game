package Settings;

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

    public void changeBackground(int ID) {
        backgrounds.changeBackground(ID);
    }

    public Sounds getSounds() {
        return sounds;
    }

    public Backgrounds getBackgrounds() {
        return backgrounds;
    }
}
