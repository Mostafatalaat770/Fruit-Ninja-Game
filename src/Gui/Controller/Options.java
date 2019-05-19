package Gui.Controller;

import Gui.Main;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Options implements Initializable {


    @FXML private JFXToggleButton soundToggle; // TODO: 19-May-19 bta3 el moseeqa dah
    @FXML private ImageView wallpaper1;
    @FXML private ImageView wallpaper2;
    @FXML private ImageView background;
    @FXML private ImageView back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        background.setEffect(new GaussianBlur(50));
        back.setOnMouseClicked(event -> {
            Main main = new Main();
            try {
                main.getMainMenu(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }

    public void wall1Press(){
        // TODO: 19-May-19 set this wallpaper in both gameplays
        System.out.println(1);
    }
    public void wall2Press(){
        // TODO: 19-May-19 set this wallpaper in both gameplays
        System.out.println(2);

    }
}
