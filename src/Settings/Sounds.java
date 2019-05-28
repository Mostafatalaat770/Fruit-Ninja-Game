package Settings;

import javax.sound.sampled.Clip;

/**
 * @author Mostafa Talaat
 */
public class Sounds {
    private boolean music = true;
    private boolean fx = true;
    private Clip mainTheme;

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isFx() {
        return fx;
    }

    public void setFx(boolean fx) {
        this.fx = fx;
    }

    public Clip getMainTheme() {
        return mainTheme;
    }

    public void setMainTheme(Clip mainTheme) {
        this.mainTheme = mainTheme;
    }

}
