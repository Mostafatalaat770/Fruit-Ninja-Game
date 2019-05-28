package Gui.Controller;

import Gui.SceneChanger;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Options implements Initializable {

    Controller controller=Controller.getInstance();
    @FXML private ToggleButton soundToggle;
    @FXML
    private JFXToggleButton FXToggle;
    @FXML private ImageView wallpaper1;
    @FXML private ImageView wallpaper2;
    @FXML private ImageView wallpaper3;
    @FXML private ImageView wallpaper4;
    @FXML private ImageView wallpaper5;
    @FXML private ImageView wallpaper6;
    @FXML private ImageView wallpaper7;
    @FXML private ImageView wallpaper8;
    @FXML private ImageView back;
    @FXML private Button help;
    @FXML private Button credits;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        soundToggle.setSelected(controller.settings.getSounds().isMusic());
        FXToggle.setSelected(controller.settings.getSounds().isFx());
        soundToggle.setOnMouseClicked(event -> controller.toggleSound(soundToggle));
        FXToggle.setOnMouseClicked(event -> controller.settings.getSounds().setFx(FXToggle.isSelected()));

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            try {
                controller.saveSettings();
            } catch (IOException e) {
                e.printStackTrace();
            }
            SceneChanger sceneChanger=new SceneChanger();
            try {
                sceneChanger.getMainMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        help.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            SceneChanger sceneChanger=new SceneChanger();
            try {
                sceneChanger.getHelp(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        credits.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            SceneChanger sceneChanger=new SceneChanger();
            try {
                sceneChanger.getCredits(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        wallpaper1.setOnMouseClicked(event -> {
            controller.settings.changeBackground(1);
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper2.setOnMouseClicked(event -> {
            controller.settings.changeBackground(2);
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper3.setOnMouseClicked(event -> {
            controller.settings.changeBackground(3);
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper4.setOnMouseClicked(event -> {
            controller.settings.changeBackground(4);
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper5.setOnMouseClicked(event -> {
            controller.settings.changeBackground(5);
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper6.setOnMouseClicked(event -> {
            controller.settings.changeBackground(6);
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper7.setOnMouseClicked(event -> {
            controller.settings.changeBackground(7);
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper8.setOnMouseClicked(event -> {
            controller.settings.changeBackground(8);
            controller.playSound("equip wallpaper", 0);
        });
    }
}
