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
                filename = "MainTheme.wav";
                break;
            case "time's up":
                filename = "TimesUp.wav";
                break;
            case "game over":
                filename = "GameOver.wav";
                break;
            case "pause":
                filename = "Pause.wav";
                break;
            case "resumeMusic":
                filename = "Resume.wav";
                break;
            case "press":
                filename = "Button.wav";
                break;
            case "equip wallpaper":
                filename = "NewBackground.wav";
                break;
            case "start game":
                filename = "GameStart.wav";
                break;
            case "throw bomb":
                filename = "BombThrow.wav";
                break;
            case "throw fruit":
            case "classic mode":
            case "arcade mode":
                filename = "FruitThrow.wav";
                break;
            case "exit":
                filename = "MainMenuExit.wav";
                break;
            case "freeze":
                filename = "FreezeBanana.wav";
                break;
            case "extra life":
                filename = "ExtraLife.wav";
                break;
            case "high score":
                filename = "NewHighScore.wav";
                break;
            case "bomb explode":
                filename = "BombExplode.wav";
                break;
            case "slice":
                filename = "FruitSlice.wav";
                break;
            case "lose life":
                filename = "LoseLife.wav";
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
