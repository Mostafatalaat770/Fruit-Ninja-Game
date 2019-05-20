package Gui.Controller;


import Gui.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Leaderboard implements Initializable {

    @FXML
    JFXListView<String> leaderboardClassic;
    @FXML
    JFXListView<String> leaderboardArcade;
    @FXML
    ImageView back;
    Controller controller= Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");
        leaderboardClassic.getItems().add("swidan\t\t55");

        back.setOnMouseClicked(event -> {
            controller.playSound("Next-screen-button.wav", 0);
            Main main = new Main();
            try {
                main.getMainMenu(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}
