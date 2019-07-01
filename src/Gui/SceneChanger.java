package Gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    private static SceneChanger instance = new SceneChanger();
    Scene scene = null;
    Stage stage = null;
    Parent root = null;

    public static SceneChanger getInstance() {
        return instance;
    }

    public void getArcade(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Arcade.fxml"));
        scene = new Scene(root, 1270, 720);
        Image image = new Image(this.getClass().getResourceAsStream("/Cursor1.png"));
        scene.setCursor(new ImageCursor(image));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getOptions(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Settings.fxml"));
        scene = new Scene(root, 1270, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void getClassic(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Classic.fxml"));
        scene = new Scene(root, 1270, 720);
        Image image = new Image(this.getClass().getResourceAsStream("/Cursor1.png"));
        scene.setCursor(new ImageCursor(image));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void getMainMenu(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/MainMenu.fxml"));
        scene = new Scene(root, 1270, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void getLeaderboard(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Leaderboard.fxml"));
        scene = new Scene(root, 1270, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void getHelp(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Help.fxml"));
        scene = new Scene(root, 1270, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getCredits(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Credits.fxml"));
        scene = new Scene(root, 1270, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



}
