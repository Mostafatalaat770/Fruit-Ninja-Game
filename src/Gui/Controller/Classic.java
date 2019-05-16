package Gui.Controller;

import Gui.Main;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Classic implements Initializable {
   private Controller controller= new Controller();
    @FXML private Canvas canvas ;
    @FXML private ImageView pause;
    @FXML private ImageView resume;
    @FXML private  ImageView reset;
    @FXML private ImageView background;
    private GraphicsContext gc;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.type = "classic";
        controller.lives = 3;
        resume.setVisible(false);
        reset.setVisible(false);
        background.setImage(new Image("Resources/ConceptGreatWave1 (2).jpg"));
        gc=canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline(new KeyFrame(new Duration(2000), actionEvent->{
            if(controller.throwables.size()<5) {
                controller.throwables.add(controller.getRandomThrowable());
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline clock= new Timeline(new KeyFrame(new Duration(1000), actionEvent1->{
            controller.updateTime_Difficulty(timeline);
        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.drawAllThings(gc,controller);
                controller.removeUnwantedThrowable();
                if(controller.gameOver()){
                    timeline.stop();
                    clock.stop();
                }

            }
        };
        timer.start();

        pause.setOnMouseClicked(event -> {
            pause.setVisible(false);
            resume.setVisible(true);
            reset.setVisible(true);
            timeline.stop();
            timer.stop();
            clock.stop();
            canvas.setEffect(new GaussianBlur(50));
            background.setEffect(new GaussianBlur(50));
        });

        resume.setOnMouseClicked(event -> {
            if(resume.isVisible()){
                resume.setVisible(false);
                reset.setVisible(false);
                canvas.setEffect(new GaussianBlur(-50));
                background.setEffect(new GaussianBlur(-50));
                AtomicInteger seconds= new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), acttionEvent->{
                    controller.drawAllThings(gc,controller);
                    seconds.getAndIncrement();
                    controller.getCountDown(gc,seconds);
                }));
                resume.setCycleCount(4);
                resume.play();
                resume.setOnFinished(event1 -> {
                    pause.setVisible(true);
                    timeline.play();
                    timer.start();
                    clock.play();
                });

            }
        });

        reset.setOnMouseClicked(event -> {
            if(reset.isVisible()){
                resume.setVisible(false);
                reset.setVisible(false);
                pause.setVisible(true);
                canvas.setEffect(new GaussianBlur(-50));
                background.setEffect(new GaussianBlur(-50));

                controller.ResetGame();
                AtomicInteger seconds= new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), acttionEvent->{
                    controller.drawAllThings(gc,controller);
                    seconds.getAndIncrement();
                    controller.getCountDown(gc,seconds);
                }));
                resume.setCycleCount(4);
                resume.play();
                resume.setOnFinished(event1 -> {
                    pause.setVisible(true);
                    timeline.play();
                    timer.start();
                    clock.play();
                });

            }

        });


    }

    public void handleMove(MouseEvent event){
        controller.slice(event.getSceneX(),event.getSceneY());

        }

}


