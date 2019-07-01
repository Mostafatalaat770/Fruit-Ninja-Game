/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Controller;


import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;
import Interfaces.Strategy.Strategy;
import com.jfoenix.controls.JFXButton;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
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

    private boolean selected = false;

    @FXML private ImageView classic_img;
    @FXML private ImageView arcade_img;
    @FXML private ImageView exit_img;
    final Controller controller = Controller.getInstance();
    @FXML
    private ImageView melonSlicedRight;
    @FXML
    private ImageView melonSlicedLeft;
    @FXML
    private ImageView slicedBananaBottom;
    @FXML private JFXButton loadClassic;
    @FXML private JFXButton loadArcade;
    @FXML private JFXButton load;
    @FXML private JFXButton options;
    @FXML private JFXButton leaderboard;
    @FXML
    private ImageView bananaSlicedTop;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClassic.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
        loadArcade.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
        load.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
        leaderboard.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
        options.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
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

        RotateTransition transition3 = new RotateTransition(Duration.millis(300), melonSlicedRight);
        transition3.setByAngle(90);

        RotateTransition transition4 = new RotateTransition(Duration.millis(300), melonSlicedLeft);
        transition4.setByAngle(-90);

        TranslateTransition transition5 = new TranslateTransition(Duration.millis(300), melonSlicedRight);
        transition5.setByX(20);

        TranslateTransition transition6 = new TranslateTransition(Duration.millis(300), melonSlicedLeft);
        transition6.setByX(-20);

        RotateTransition transition7 = new RotateTransition(Duration.millis(300), bananaSlicedTop);
        transition7.setByAngle(90);

        RotateTransition transition8 = new RotateTransition(Duration.millis(300), slicedBananaBottom);
        transition8.setByAngle(-90);

        TranslateTransition transition9 = new TranslateTransition(Duration.millis(300), bananaSlicedTop);
        transition9.setByX(5);

        TranslateTransition transition10 = new TranslateTransition(Duration.millis(300), slicedBananaBottom);
        transition10.setByX(-5);


        classic_img.setOnMouseDragged((event) -> {
    	   if(!selected) {
    		   selected = true;
    		   	classic_img.setVisible(false);
               melonSlicedLeft.setVisible(true);
               melonSlicedRight.setVisible(true);
           		transition3.play();
           		transition4.play();
           		transition5.play();
           		transition6.play();
               controller.settings.getSounds().getMainTheme().stop();
               controller.playSound("slice", 0);
           		transition3.setOnFinished((event1) -> {
                    try {
                    	controller.type = "classic";
                    	controller.gameMode = new Strategy(new ClassicMode());
                    	controller.ResetGame();
                        controller.sceneChanger.getClassic(event);
                    } catch (IOException e) {
						e.printStackTrace();
					}

           		});
    	   }
       });

        arcade_img.setOnMouseDragged((event) -> {
    	   if(!selected) {
    		   selected = true;
    		   arcade_img.setVisible(false);
               slicedBananaBottom.setVisible(true);
               bananaSlicedTop.setVisible(true);
    		   transition7.play();
    		   transition8.play();
    		   transition9.play();
    		   transition10.play();
               controller.settings.getSounds().getMainTheme().stop();
               controller.playSound("slice", 0);
    		   transition7.setOnFinished((event1) -> {
                   try {
    				   controller.type = "arcade";
    				   controller.gameMode = new Strategy(new ArcadeMode());
    				   controller.ResetGame();
                       controller.sceneChanger.getArcade(event);
    			   } catch (IOException e) {
    				   e.printStackTrace();
    			   }
    		   });
    	   }
       });

        exit_img.setOnMouseDragged((event) -> {
           controller.settings.getSounds().getMainTheme().stop();
           controller.playSound("exit", 0);
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText("Are you sure you want to exit?");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
              Platform.exit();
           else {
               controller.settings.getSounds().getMainTheme().loop(Clip.LOOP_CONTINUOUSLY);
               if (controller.settings.getSounds().isMusic())
                   controller.settings.getSounds().getMainTheme().start();
        	   else
                   controller.settings.getSounds().getMainTheme().stop();
        	   
           }
       });

       loadClassic.setOnMouseClicked(event -> {
           controller.settings.getSounds().getMainTheme().stop();
           controller.playSound("press", 0);
           try {
               controller.type = "classic";
               controller.gameMode = new Strategy(new ClassicMode());
               controller.loadGame();
               controller.sceneChanger.getClassic(event);
           } catch (IOException | JDOMException e) {
               e.printStackTrace();
           }
       });

       loadArcade.setOnMouseClicked(event -> {
           controller.settings.getSounds().getMainTheme().stop();
           controller.playSound("press", 0);
           try {
               controller.type = "arcade";
               controller.gameMode = new Strategy(new ArcadeMode());
               controller.loadGame();
               controller.sceneChanger.getArcade(event);
           } catch (IOException | JDOMException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

       options.setOnMouseClicked(event -> {
           controller.playSound("press", 0);
           try {
               controller.sceneChanger.getOptions(event);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

       leaderboard.setOnMouseClicked(event -> {
           controller.playSound("press", 0);
           try {
               controller.sceneChanger.getLeaderboard(event);
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
    }

    public void loadButton(){
        controller.playSound("press", 0);
        TranslateTransition classic=new TranslateTransition(new Duration(1000),loadClassic);
        TranslateTransition arcade= new TranslateTransition(new Duration(1000),loadArcade);
        arcade.setByX(270);
        classic.setByX(180);
        classic.play();
        arcade.play();
        arcade.setOnFinished(event -> load.setDisable(true));
    }


}
