package Gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void getArcade(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Classic.fxml"));  //TODO change classic.fxml to arcade.fxml when you make one
		Scene arcadeScene = new Scene(root, 1270, 720);
		Stage arcadeWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		arcadeWindow.setScene(arcadeScene);
		arcadeWindow.show();
	}
	
	public void getClassic(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/Classic.fxml"));
		Scene classicScene = new Scene(root, 1270, 720);
		Stage classicWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		classicWindow.setScene(classicScene);
		classicWindow.show();
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("FxmlFiles/StartScene.fxml"));
        primaryStage.setTitle("Fruits Ninja");
        primaryStage.setScene(new Scene(root1, 1270, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}