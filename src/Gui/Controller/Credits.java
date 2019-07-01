package Gui.Controller;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;


public class Credits implements Initializable {

    @FXML
    Canvas canvas;
    @FXML
    ImageView back;
    private GraphicsContext gc;
    final Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        AtomicInteger y= new AtomicInteger(750);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 1280, 720);
                gc.setFill(Color.BLACK);

                gc.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 25));
                gc.fillText("Fruit ninja game", 85, y.get());
                gc.fillText("made by:", 15, y.get() + 25);
                gc.fillText("-Abdelrahman Zaghloul-", 15, y.get() + 50);
                gc.fillText("-Ahmed Swidan-", 15, y.get() + 75);
                gc.fillText("-Islam Tarek-", 15, y.get() + 100);
                gc.fillText("-Mostafa Talaat-", 15, y.get() + 125);
                gc.fillText("-Seif Amr-", 15, y.get() + 150);
                gc.fillText("Special thanks to:", 15, y.get() + 200);
                gc.fillText("-Dr. Mervat Mikhail-", 55, y.get() + 225);
                gc.fillText("all the teaching committee",15,y.get()+250);
                gc.fillText("piazza.com",15,y.get()+275);
                gc.fillText("Stack Overflow", 15, y.get() + 300);
                gc.fillText("The New Boston", 15, y.get() + 325);
                gc.fillText("Tim Buchalka", 15, y.get() + 350);
                gc.fillText("Special thanks to the\ngame testers:", 15, y.get() + 400);
                gc.fillText("-Youssef Swidan-", 15, y.get() + 450);
                gc.fillText("-Mazen Morsy-", 15, y.get() + 475);
                gc.fillText("-Ahmed Essam-", 15, y.get() + 500);
                gc.fillText("-Ahmed Talaat-", 15, y.get() + 525);
                gc.fillText("All content used are\ncopyrights of Halfbrick co.", 15, y.get() + 625);
                gc.fillText("programming 2 final\nproject",15,y.get()+700);
                y.getAndDecrement();
            }
        };

        timer.start();

       back.setOnMouseClicked(event -> {
           timer.stop();
           controller.playSound("press", 0);
           try {
               controller.sceneChanger.getOptions(event);
           } catch (IOException e) {
               e.printStackTrace();
           }
       });

    }
}
