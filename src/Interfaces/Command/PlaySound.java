package Interfaces.Command;

import Gui.Controller.Controller;
import Settings.Settings;
import javafx.scene.control.ToggleButton;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Mostafa Talaat
 */
public class PlaySound implements Command {
    @Override
    public void execute(ToggleButton toggleButton) {

    }

    @Override
    public Clip play(String type, int duration) {
        Controller controller = Controller.getInstance();
        String filename = null;
        switch (type) {
            case "main theme":
                filename = "main-theme.wav";
                break;
            case "time's up":
                filename = "time-up.wav";
                break;
            case "game over":
                filename = "Game-over.wav";
                break;
            case "pause":
                filename = "Pause.wav";
                break;
            case "resumeMusic":
                filename = "Unpause.wav";
                break;
            case "press":
                filename = "Next-screen-button.wav";
                break;
            case "equip wallpaper":
                filename = "equip-new-wallpaper.wav";
                break;
            case "start game":
                filename = "Game-start.wav";
                break;
            case "throw bomb":
                filename = "Throw-bomb.wav";
                break;
            case "throw fruit":
            case "classic mode":
            case "arcade mode":
                filename = "Throw-fruit.wav";
                break;
            case "exit":
                filename = "menu-bomb.wav";
                break;
            case "freeze":
                filename = "Bonus-Banana-Freeze.wav";
                break;
            case "extra life":
                filename = "extra-life.wav";
                break;
            case "high score":
                filename = "New-best-score.wav";
                break;
            case "bomb explode":
                filename = "Bomb-explode.wav";
                break;
            case "slice":
                filename = "pome-slice-1.wav";
                break;
            case "lose life":
                filename = "gank.wav";
                break;
            case "combo":
                filename = "Combo.wav";
                break;
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.getClass().getResource("/" + filename)));
            clip.loop(duration);

            if (type.equals("main theme")) {
                controller.settings.getSounds().setMainTheme(clip);
                if (controller.settings.getSounds().isMusic()) {
                    clip.start();
                } else {
                    clip.stop();
                }
                return clip;
            }

            if (controller.settings.getSounds().isFx())
                clip.start();
            else
                clip.stop();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
            e1.printStackTrace();

        }
        return clip;
    }

    public void resume() {

        if (Settings.getInstance().getSounds().isMusic()) {
            Settings.getInstance().getSounds().getMainTheme().start();
        } else {
            Settings.getInstance().getSounds().getMainTheme().stop();
        }
    }

}
