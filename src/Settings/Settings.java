package Settings;

/**
 * @author Mostafa Talaat
 */
public class Settings {
    private static final Settings ourInstance = new Settings();
    private final Sounds sounds = new Sounds();
    private final Backgrounds backgrounds = new Backgrounds();

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
