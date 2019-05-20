package Gui.Controller;


import Gui.Main;
import Interfaces.Strategy.Arcade;
import Interfaces.Strategy.Classic;
import Interfaces.Strategy.Strategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Leaderboard implements Initializable {

    @FXML private TableView<PlayerLeaderboard> leaderboardClassic;
    @FXML private TableView<PlayerLeaderboard> leaderboardArcade;
    @FXML private TableColumn<PlayerLeaderboard,String> usernameClassic;
    @FXML private TableColumn<PlayerLeaderboard,String> usernameArcade;
    @FXML private TableColumn<PlayerLeaderboard,Integer> scoreClassic;
    @FXML private TableColumn<PlayerLeaderboard,Integer> scoreArcade;
    @FXML ImageView back;
    Controller controller= Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.players=new Strategy(new Classic());
        controller.players.sort();
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            leaderboardClassic.getItems().add(new PlayerLeaderboard(controller.usersDB.getPlayers().get(i).getUsername(),controller.usersDB.getPlayers().get(i).getClassicScore()));
        }

        controller.players=new Strategy(new Arcade());
        controller.players.sort();
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            leaderboardArcade.getItems().add(new PlayerLeaderboard(controller.usersDB.getPlayers().get(i).getUsername(),controller.usersDB.getPlayers().get(i).getArcadeScore()));
        }

        usernameClassic.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreClassic.setCellValueFactory(new PropertyValueFactory<>("score"));
        usernameArcade.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreArcade.setCellValueFactory(new PropertyValueFactory<>("score"));

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
