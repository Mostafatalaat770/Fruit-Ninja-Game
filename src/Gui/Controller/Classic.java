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
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ResourceBundle;

public class Classic implements Initializable {
   private Controller controller= new Controller();
    @FXML private Canvas canvas ;
    private GraphicsContext gc;
    private Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.type = "classic";
        controller.lives = 3;
        gc=canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        Timeline timeline = new Timeline(new KeyFrame(new Duration(2000), actionEvent->{
            if(controller.throwables.size()<5) {
                controller.throwables.add(controller.getRandomThrowable());
                System.out.println(controller.throwables.size());
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline clock= new Timeline(new KeyFrame(new Duration(1000), actionEvent1->{
            controller.secs++;
            if (controller.secs == 60) {
                controller.secs = 0;
                controller.mins++;
            }
            if (controller.secs % 30 == 0 && controller.difficulty < 3){
                timeline.setRate(++controller.difficulty);
            }


        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

//        canvas.setOnMouseMoved(event -> {
//
//
//        });

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.drawAllThings(gc,controller.throwables,controller);
                if (!controller.removeUnwantedThrowable(controller.throwables))
                    controller.lives--;
                if(controller.lives==0){
                    timeline.stop();
                    clock.stop();
                    // todo: game over scene
                    System.out.println("GAME OVER");


                }

            }
        };
        timer.start();


    }

    public void handleMove(MouseEvent event){
        if(controller.isSliced(controller.throwables,event.getSceneX(),event.getSceneY(),controller)) {
            System.out.println("cut");
            // todo: cut
        }

    }



}
