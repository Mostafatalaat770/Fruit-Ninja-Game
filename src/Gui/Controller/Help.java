package Gui.Controller;

import Gui.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Help implements Initializable {
    @FXML private ImageView back;
    Controller controller=Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            Main main = new Main();
            try {
                main.getOptions(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }
}
