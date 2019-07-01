package Gui.Controller;


import UsersDB.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Leaderboard implements Initializable {

    public Text text2;
    public Text text1;
    public Text text3;
    @FXML private TableView<PlayerLeaderboard> leaderboardClassic;
    @FXML private TableView<PlayerLeaderboard> leaderboardArcade;
    @FXML private TableColumn<PlayerLeaderboard,String> usernameClassic;
    @FXML private TableColumn<PlayerLeaderboard,String> usernameArcade;
    @FXML private TableColumn<PlayerLeaderboard,Integer> scoreClassic;
    @FXML private TableColumn<PlayerLeaderboard,Integer> scoreArcade;
    @FXML ImageView back;
    final Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text1.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));
        text2.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));
        text3.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));


        List<Player> players = controller.usersDB.query(1);
        for (Player player : players) {
            leaderboardClassic.getItems().add(new PlayerLeaderboard(player.getUsername(), player.getClassicScore()));
        }

        players = controller.usersDB.query(2);

        for (Player player : players) {
            leaderboardArcade.getItems().add(new PlayerLeaderboard(player.getUsername(), player.getArcadeScore()));
        }

        usernameClassic.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreClassic.setCellValueFactory(new PropertyValueFactory<>("score"));
        usernameArcade.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreArcade.setCellValueFactory(new PropertyValueFactory<>("score"));

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            try {

                controller.sceneChanger.getMainMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
