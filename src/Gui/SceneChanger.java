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
    public void getArcade(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Arcade.fxml"));
        Scene arcadeScene = new Scene(root, 1270, 720);
        Image image = new Image("Resources/dot_PNG40.png");
        arcadeScene.setCursor(new ImageCursor(image));
        Stage arcadeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        arcadeWindow.setScene(arcadeScene);
        arcadeWindow.show();
    }
    public void getOptions(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Options.fxml"));
        Scene arcadeScene = new Scene(root, 1270, 720);
        Stage arcadeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        arcadeWindow.setScene(arcadeScene);
        arcadeWindow.show();
    }

    public void getClassic(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Classic.fxml"));
        Scene classicScene = new Scene(root, 1270, 720);
        Image image = new Image("Resources/dot_PNG40.png");
        classicScene.setCursor(new ImageCursor(image));
        Stage classicWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        classicWindow.setScene(classicScene);
        classicWindow.show();
    }

    public void getMainMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/MainMenu.fxml"));
        Scene classicScene = new Scene(root, 1270, 720);
        Stage classicWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        classicWindow.setScene(classicScene);
        classicWindow.show();
    }

    public void getLeaderboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Leaderboard.fxml"));
        Scene classicScene = new Scene(root, 1270, 720);
        Stage classicWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        classicWindow.setScene(classicScene);
        classicWindow.show();
    }

    public void getHelp(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Help.fxml"));
        Scene classicScene = new Scene(root, 1270, 720);
        Stage classicWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        classicWindow.setScene(classicScene);
        classicWindow.show();
    }
    public void getCredits(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Credits.fxml"));
        Scene classicScene = new Scene(root, 1270, 720);
        Stage classicWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        classicWindow.setScene(classicScene);
        classicWindow.show();
    }



}
