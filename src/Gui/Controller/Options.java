package Gui.Controller;

import Gui.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Options implements Initializable {

    Controller controller=Controller.getInstance();
    @FXML private ToggleButton soundToggle; // TODO: 19-May-19 bta3 el moseeqa dah
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

        soundToggle.setSelected(controller.sound);
        soundToggle.setOnMouseClicked(event -> controller.toggleSound(soundToggle));

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            Main main = new Main();
            try {
                main.getMainMenu(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });

        help.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            Main main = new Main();
            try {
                main.getHelp(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        credits.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            Main main = new Main();
            try {
                main.getCredits(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        wallpaper1.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper1.jpg");
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper2.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper2.jpg");
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper3.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper3.png");
            controller.playSound("equip wallpaper", 0);
        });
        wallpaper4.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper4.png");
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper5.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper5.png");
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper6.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper6.png");
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper7.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper7.png");
            controller.playSound("equip wallpaper", 0);
        });

        wallpaper8.setOnMouseClicked(event -> {
            controller.background=new Image("Resources/wallpaper8.png");
            controller.playSound("equip wallpaper", 0);
        });
    }
}
