package Gui.Controller;

import Gui.SceneChanger;
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
            SceneChanger sceneChanger=new SceneChanger();
            try {
                sceneChanger.getOptions(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
