/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Controller;


import Gui.Main;
import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;
import Interfaces.Strategy.Strategy;
import com.jfoenix.controls.JFXButton;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.jdom2.JDOMException;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 *
 * @author LENOVO
 */
public class MainMenu implements Initializable {

    private Label label;

    private ImageView img;
    @FXML private ImageView classic_img;
    @FXML private ImageView arcade_img;
    @FXML private ImageView exit_img;
    @FXML private AnchorPane anchor;
    @FXML private ImageView slicedmelon_right;
    @FXML private ImageView slicedmelon_left;
    @FXML private ImageView slicedbanana_bottom;
    @FXML private ImageView slicedbanana_top;
    @FXML private JFXButton loadClassic;
    @FXML private JFXButton loadArcade;
    @FXML private JFXButton load;
    @FXML private JFXButton options;
    @FXML private JFXButton leaderboard;


    Controller controller = Controller.getInstance();

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition transition = new RotateTransition(Duration.seconds(4), classic_img);
        transition.setAutoReverse(true);
        transition.setByAngle(360);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();

        RotateTransition transition1 = new RotateTransition(Duration.seconds(4), arcade_img);
        transition1.setAutoReverse(true);
        transition1.setByAngle(360);
        transition1.setCycleCount(TranslateTransition.INDEFINITE);
        transition1.play();

        RotateTransition transition2 = new RotateTransition(Duration.seconds(4), exit_img);
        transition2.setAutoReverse(true);
        transition2.setByAngle(360);
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.play();

        RotateTransition transition3 = new RotateTransition(Duration.millis(300), slicedmelon_right);
        transition3.setByAngle(90);

        RotateTransition transition4 = new RotateTransition(Duration.millis(300), slicedmelon_left);
        transition4.setByAngle(-90);

        TranslateTransition transition5 = new TranslateTransition(Duration.millis(300), slicedmelon_right);
        transition5.setByX(20);

        TranslateTransition transition6 = new TranslateTransition(Duration.millis(300), slicedmelon_left);
        transition6.setByX(-20);
        //

        RotateTransition transition7 = new RotateTransition(Duration.millis(300), slicedbanana_top);
        transition7.setByAngle(90);

        RotateTransition transition8 = new RotateTransition(Duration.millis(300), slicedbanana_bottom);
        transition8.setByAngle(-90);

        TranslateTransition transition9 = new TranslateTransition(Duration.millis(300), slicedbanana_top);
        transition9.setByX(5);

        TranslateTransition transition10 = new TranslateTransition(Duration.millis(300), slicedbanana_bottom);
        transition10.setByX(-5);
        
        Clip gameStart = controller.playSound("main-theme.wav", Clip.LOOP_CONTINUOUSLY);



       classic_img.setOnMouseExited((event) -> {
           classic_img.setVisible(false);
           slicedmelon_left.setVisible(true);
           slicedmelon_right.setVisible(true);
           transition3.play();
           transition4.play();
           transition5.play();
           transition6.play();
           gameStart.stop();
           controller.playSound("pome-slice-1.wav", 0);
           transition3.setOnFinished((event1) -> {
        	   Main main = new Main();
				try {
                    controller.loadPlayers();
                    controller.type = "classic";
                    controller.setUser("musty");
                    controller.gameMode = new Strategy(new ClassicMode());
                    controller.ResetGame();
                    main.getClassic(event);
                } catch (IOException | JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

           });
           System.out.println("Classic mode activated");
       });

       arcade_img.setOnMouseExited((event) -> {
           arcade_img.setVisible(false);
           slicedbanana_bottom.setVisible(true);
           slicedbanana_top.setVisible(true);
           transition7.play();
           transition8.play();
           transition9.play();
           transition10.play();
           gameStart.stop();
           controller.playSound("pome-slice-1.wav", 0);
           transition7.setOnFinished((event1) -> {
        	   Main main = new Main();
				try {
                    controller.type = "arcade";
                    controller.gameMode = new Strategy(new ArcadeMode());
                    controller.ResetGame();
                    main.getArcade(event);
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           });
           System.out.println("Arcade mode activated");
       });

       exit_img.setOnMouseExited((event) -> {
    	   gameStart.stop();
    	   Clip gameStart1 = gameStart;
    	   controller.playSound("menu-bomb.wav", 0);
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText("Are you sure you want to exit?");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
              Platform.exit();
           else {
        	   gameStart1.loop(Clip.LOOP_CONTINUOUSLY);
        	   gameStart1.start();
        	   
           }
       });

       loadClassic.setOnMouseClicked(event -> {
    	   gameStart.stop();
    	   controller.playSound("Next-screen-button.wav", 0);
           Main main = new Main();
           try {
               controller.type = "classic";
               controller.loadGame();
               main.getClassic(event);
           } catch (IOException | JDOMException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

       loadArcade.setOnMouseClicked(event -> {
    	   gameStart.stop();
    	   controller.playSound("Next-screen-button.wav", 0);
           Main main = new Main();
           try {
               controller.type = "arcade";
               controller.loadGame();
               main.getArcade(event);
           } catch (IOException | JDOMException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

       options.setOnMouseClicked(event -> {
    	   gameStart.stop();
    	   controller.playSound("Next-screen-button.wav", 0);
           Main main = new Main();
           try {
               main.getOptions(event);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

       leaderboard.setOnMouseClicked(event -> {
           gameStart.stop();
           controller.playSound("Next-screen-button.wav", 0);
           Main main = new Main();
           try {
               main.getLeaderboard(event);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });
    }

    public void loadButton(){
    	controller.playSound("Next-screen-button.wav", 0);
        TranslateTransition classic=new TranslateTransition(new Duration(1000),loadClassic);
        TranslateTransition arcade= new TranslateTransition(new Duration(1000),loadArcade);
        arcade.setByX(270);
        classic.setByX(180);
        classic.play();
        arcade.play();
        arcade.setOnFinished(event -> {load.setDisable(true); });
    }


}
