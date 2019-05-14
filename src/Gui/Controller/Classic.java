package Gui.Controller;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Classic implements Initializable {
   private Controller controller= new Controller();
    @FXML private Canvas canvas ;
    private GraphicsContext gc;
    private  int seconds=0;
    private  int mins=0;
    private Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc=canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        Timeline timeline = new Timeline(new KeyFrame(new Duration(2000), actionEvent->{
            controller.throwables.add(controller.getRandomThrowable());

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline clock= new Timeline(new KeyFrame(new Duration(1000), actionEvent1->{
            seconds++;
            if(seconds==60){
                seconds=0;
                mins++;
            }
        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        canvas.setOnMouseMoved(event -> {
            if(controller.isSliced(controller.throwables,event.getSceneX(),event.getSceneY(),controller)) {
                System.out.println("cut");
                // todo: cut
            }

        });

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.drawAllThings(gc,controller.throwables,controller.Score,seconds,mins);

                controller.removeUnwantedThrowable(controller.throwables);

            }
        };
        timer.start();


    }



}
