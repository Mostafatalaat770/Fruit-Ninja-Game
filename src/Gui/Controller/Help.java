package Gui.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Help implements Initializable {
    public Text text1;
    public Text text2;
    public Text text3;
    public Text text4;
    public Text text5;
    @FXML private ImageView back;
    final Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text1.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 24));
        text2.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 24));
        text3.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 24));
        text4.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 24));
        text5.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 24));

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            try {
                controller.sceneChanger.getOptions(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
