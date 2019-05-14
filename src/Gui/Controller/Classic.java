package Gui.Controller;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Classic implements Initializable {
    Controller controller= new Controller();
    @FXML  Canvas canvas ;
    GraphicsContext gc;
    Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc=canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        Timeline timeline = new Timeline(new KeyFrame(new Duration(1000), actionEvent->{
            controller.throwables.add(controller.createGameObject());

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.drawAllThings(gc,controller.throwables);
                controller.removeUnwantedThrowable(controller.throwables);
            }
        };
        timer.start();


    }



}
