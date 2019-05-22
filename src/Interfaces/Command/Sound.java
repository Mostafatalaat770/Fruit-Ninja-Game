package Interfaces.Command;

import Gui.Controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Mostafa Talaat
 */
public class Sound implements Command {
    @FXML
    Controller controller = Controller.getInstance();

    public void toggleSound(ToggleButton soundToggle) {
        controller.sound = soundToggle.isSelected();
        controller.gameStart.loop(Clip.LOOP_CONTINUOUSLY);
        if (controller.sound)
            controller.gameStart.start();
        else
            controller.gameStart.stop();
    }

    @Override
    public void execute(ToggleButton toggleButton) {
        toggleSound(toggleButton);

    }

    @Override
    public Clip play(String type, int duration) {
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
            case "resume":
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
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.getClass().getResource("/" + filename)));
            clip.loop(duration);
            boolean sound;
            if (controller == null) {
                sound = true;
            } else {
                sound = controller.sound;
            }
            if (sound)
                clip.start();
            else
                clip.stop();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
        return clip;
    }
}
