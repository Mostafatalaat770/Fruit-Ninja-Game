/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Controller;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author LENOVO
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    private ImageView img;
    @FXML
    private ImageView classic_img;
    @FXML
    private ImageView arcade_img;
    @FXML
    private ImageView exit_img;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView slicedmelon_right;
    @FXML
    private ImageView slicedmelon_left;
    @FXML
    private ImageView slicedbanana_bottom;
    @FXML
    private ImageView slicedbanana_top;

    
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
        
        
        
       classic_img.setOnMouseExited((event) -> {
           classic_img.setVisible(false);
           slicedmelon_left.setVisible(true);
           slicedmelon_right.setVisible(true);
           transition3.play();
           transition4.play();
           transition5.play();
           transition6.play();
           transition3.setOnFinished((event1) -> {
               //TODO: close this scene and open the classic mode scene
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
           transition7.setOnFinished((event1) -> {
               //TODO: close this scene and open the arcade mode scene
           });
           System.out.println("Arcade mode activated");
       });
       
       exit_img.setOnMouseExited((event) -> {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText("Are you sure you want to exit?");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
              Platform.exit();
       });
    }    
    
}
