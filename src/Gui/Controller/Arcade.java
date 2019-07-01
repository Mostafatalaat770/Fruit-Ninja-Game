package Gui.Controller;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Arcade implements Initializable {
    public ImageView settings;
    private Controller controller = Controller.getInstance();
    @FXML
    private Canvas canvas;
    @FXML
    private ImageView pause;
    @FXML
    private ImageView resume;
    @FXML
    private ImageView reset;
    @FXML
    private ImageView background;
    @FXML
    private ImageView save;
    @FXML
    private ImageView back;
    @FXML
    private javafx.scene.text.Text gameOver;
    @FXML
    private javafx.scene.text.Text score;
    private boolean stopAll = true;
    private GraphicsContext gc;
    private boolean timesUp = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameOver.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 90));
        score.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 90));
        controller.playSound("start game", 0);
        resume.setVisible(false);
        reset.setVisible(false);
        save.setVisible(false);
        back.setVisible(false);
        settings.setVisible(false);
        background.setImage(controller.settings.getBackgrounds().getBackground());
        gc = canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline(new KeyFrame(new Duration(2000), actionEvent -> controller.getThrowables()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        canvas.setOnMouseDragged(event -> {
            if (stopAll)
                try {
                    controller.slice(event.getSceneX(), event.getSceneY());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        Timeline clock = new Timeline(new KeyFrame(new Duration(1000), actionEvent1 -> {
            controller.updateTime_Difficulty(timeline);
            controller.freezeCountDown();
            controller.comboCountdown();
        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.drawAllThings(gc);
                controller.removeUnwantedThrowable();

                if (controller.gameOver()) {
                    if (!timesUp) {
                        Clip time = controller.playSound("time's up", 0);
                        try {
                            Thread.sleep(time.getMicrosecondLength() / 3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        controller.playSound("game over", 0);
                        timesUp = true;
                        controller.inGame = false; // for in-game button functionality
                    }
                    stopAll = false;
                    timeline.stop();
                    clock.stop();
//                       canvas.setEffect(new GaussianBlur(50));
//                       background.setEffect(new GaussianBlur(50));
                    gameOver.setText("game over");
                    score.setText("score: " + controller.score);
                    pause.setVisible(false);
                    back.setVisible(true);
                    try {
                        controller.savePlayers();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        timer.start();


        pause.setOnMouseClicked(event -> {
            controller.playSound("pause", 0);
            stopAll = false;
            pause.setVisible(false);
            resume.setVisible(true);
            reset.setVisible(true);
            save.setVisible(true);
            back.setVisible(true);
            settings.setVisible(true);
            timeline.stop();
            timer.stop();
            clock.stop();
//            canvas.setEffect(new GaussianBlur(50));
//            background.setEffect(new GaussianBlur(50));
        });

        resume.setOnMouseClicked(event -> {
            if (resume.isVisible()) {
                controller.playSound("resumeMusic", 0);
                resume.setVisible(false);
                reset.setVisible(false);
                save.setVisible(false);
                back.setVisible(false);
                settings.setVisible(false);
//                canvas.setEffect(new GaussianBlur(-50));
//                background.setEffect(new GaussianBlur(-50));
                AtomicInteger seconds = new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), actionEvent -> {
                    controller.drawAllThings(gc);
                    seconds.getAndIncrement();
                    controller.getCountDown(gc, seconds);
                }));
                resume.setCycleCount(4);
                resume.play();
                resume.setOnFinished(event1 -> {
                    pause.setVisible(true);
                    timeline.play();
                    timer.start();
                    clock.play();
                    stopAll = true;
                });

            }
        });

        reset.setOnMouseClicked(event -> {
            if (reset.isVisible()) {
                controller.playSound("resumeMusic", 0);
                resume.setVisible(false);
                reset.setVisible(false);
                save.setVisible(false);
                back.setVisible(false);
                settings.setVisible(false);
                pause.setVisible(true);
//                canvas.setEffect(new GaussianBlur(-50));
//                background.setEffect(new GaussianBlur(-50));

                controller.ResetGame();
                AtomicInteger seconds = new AtomicInteger();
                Timeline resume = new Timeline(new KeyFrame(new Duration(500), actionEvent -> {
                    controller.drawAllThings(gc);
                    seconds.getAndIncrement();
                    controller.getCountDown(gc, seconds);
                }));
                resume.setCycleCount(4);
                resume.play();
                resume.setOnFinished(event1 -> {
                    pause.setVisible(true);
                    timeline.play();
                    timer.start();
                    clock.play();
                    stopAll = true;
                });

            }

        });

        save.setOnMouseClicked(event -> {
            if (save.isVisible()) {
                controller.playSound("press", 0);
                try {
                    controller.saveGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        settings.setOnMouseClicked(event -> {
            if (settings.isVisible()) {
                controller.playSound("press", 0);
                timeline.stop();
                timer.stop();
                clock.stop();
                controller.inGame = true;

                try {
                    controller.sceneChanger.getOptions(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        back.setOnMouseClicked(event -> {
            if (back.isVisible()) {
                controller.playSound("press", 0);
                controller.inGame = false;
                controller.ResetGame();
                timeline.stop();
                timer.stop();
                clock.stop();
                controller.resumeMusic();

                try {
                    controller.sceneChanger.getMainMenu(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

