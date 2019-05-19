package Gui.Controller;

import Gui.Main;
import Interfaces.GameObject;
import Throwables.Bombs.Bomb;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sound.sampled.Clip;

public class Arcade implements Initializable {
	private Controller controller= Controller.getInstance();
    @FXML private Canvas canvas ;
    @FXML private ImageView pause;
    @FXML private ImageView resume;
    @FXML private  ImageView reset;
    @FXML private ImageView background;
    @FXML private ImageView save;
    @FXML private ImageView back;
    @FXML private javafx.scene.text.Text gameOver;
    @FXML private javafx.scene.text.Text score;
    @FXML private javafx.scene.text.Text bestScore;
    @FXML private javafx.scene.text.Text alltimeBestScore;
    private boolean stopAll = true ;
    private GraphicsContext gc;
  boolean timeup = false;
  private Random random= new Random();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        bestScore.setText("best score:"+controller.personalHighscore);
        alltimeBestScore.setText("alltime best score:"+controller.highestScore);
		resume.setVisible(false);
        reset.setVisible(false);
        save.setVisible(false);
        back.setVisible(false);
        background.setImage(new Image("Resources/wallpaper2.jpg"));
        gc=canvas.getGraphicsContext2D();
        
        Timeline timeline = new Timeline(new KeyFrame(new Duration(2000), actionEvent->{
            if(controller.throwables.size()<6) {
            /*	GameObject temp = controller.getRandomThrowable();
                controller.throwables.add(temp);
                if(temp instanceof Bomb)
                	controller.playSound("Throw-bomb.wav", 0);
                else
                	controller.playSound("Throw-fruit.wav", 0);
                	*/
            	for(int i=0;i<1+random.nextInt(5);i++){
                    controller.throwables.add(controller.getRandomThrowable());
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        canvas.setOnMouseMoved(event -> {
            if(stopAll)
                controller.slice(event.getSceneX(),event.getSceneY());
        });

        Timeline clock= new Timeline(new KeyFrame(new Duration(1000), actionEvent1->{
            controller.updateTime_Difficulty(timeline);
            controller.freezeCountDown();
        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                   controller.drawAllThings(gc);
                   controller.removeUnwantedThrowable();

                   if(controller.gameOver()) {
                	   if(!timeup) {
                		   Clip clip = controller.playSound("time-up.wav", 0);
                		   timeup = true;
                	   }
                       stopAll=false ;
                       timeline.stop();
                       clock.stop();
                       canvas.setEffect(new GaussianBlur(50));
                       background.setEffect(new GaussianBlur(50));
                       gameOver.setText("game over");
                       score.setText("score: " + controller.score);
                       pause.setVisible(false);
                       back.setVisible(true);
                   }

            }
        };
        timer.start();
        
        
        pause.setOnMouseClicked(event -> {
        	controller.playSound("pause.wav", 0);
            stopAll=false;
            pause.setVisible(false);
            resume.setVisible(true);
            reset.setVisible(true);
            save.setVisible(true);
            back.setVisible(true);
            timeline.stop();
            timer.stop();
            clock.stop();
            canvas.setEffect(new GaussianBlur(50));
            background.setEffect(new GaussianBlur(50));
        });

        resume.setOnMouseClicked(event -> {
            if(resume.isVisible()){
            	controller.playSound("Unpause.wav", 0);
                resume.setVisible(false);
                reset.setVisible(false);
                save.setVisible(false);
                back.setVisible(false);
                canvas.setEffect(new GaussianBlur(-50));
                background.setEffect(new GaussianBlur(-50));
                AtomicInteger seconds= new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), acttionEvent->{
                    controller.drawAllThings(gc);
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
                    stopAll= true;
                });

            }
        });

        reset.setOnMouseClicked(event -> {
            if(reset.isVisible()){
            	controller.playSound("Unpause.wav", 0);
                resume.setVisible(false);
                reset.setVisible(false);
                save.setVisible(false);
                back.setVisible(false);
                pause.setVisible(true);
                canvas.setEffect(new GaussianBlur(-50));
                background.setEffect(new GaussianBlur(-50));

                controller.ResetGame();
                AtomicInteger seconds= new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), acttionEvent->{
                    controller.drawAllThings(gc);
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
                    stopAll=true;
                });

            }

        });

        save.setOnMouseClicked(event -> {
            if(save.isVisible())
            {
            	controller.playSound("Next-screen-button.wav", 0);
                try {
                    controller.saveGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        back.setOnMouseClicked(event -> {
            if(back.isVisible()){
            	controller.playSound("Next-screen-button.wav", 0);
                controller.ResetGame();
                timeline.stop();
                timer.stop();
                clock.stop();
                Main main = new Main();
                try {
                    main.getMainMenu(event);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

				
}

