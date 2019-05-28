package Gui.Controller;


import Gui.SceneChanger;
import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;
import Interfaces.Strategy.Strategy;
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
    Controller controller= Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text1.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));
        text2.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));
        text3.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 50));

        controller.gameMode = new Strategy(new ClassicMode());
        controller.gameMode.sort();
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            leaderboardClassic.getItems().add(new PlayerLeaderboard(controller.usersDB.getPlayers().get(i).getUsername(),controller.usersDB.getPlayers().get(i).getClassicScore()));
        }

        controller.gameMode = new Strategy(new ArcadeMode());
        controller.gameMode.sort();
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            leaderboardArcade.getItems().add(new PlayerLeaderboard(controller.usersDB.getPlayers().get(i).getUsername(),controller.usersDB.getPlayers().get(i).getArcadeScore()));
        }

        usernameClassic.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreClassic.setCellValueFactory(new PropertyValueFactory<>("score"));
        usernameArcade.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreArcade.setCellValueFactory(new PropertyValueFactory<>("score"));

        back.setOnMouseClicked(event -> {
            controller.playSound("press", 0);
            SceneChanger sceneChanger=new SceneChanger();
            try {

                sceneChanger.getMainMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
