package Gui.Controller;

import Gui.Main;
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
    GraphicsContext gc;
    Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        AtomicInteger y= new AtomicInteger(750);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 1280, 720);
                gc.setFill(Color.BLACK);
                Font theFont = Font.font("Gang Of Three", 25);
                gc.setFont(theFont);
                gc.fillText("Fruit ninja game", 85, y.get());
                gc.fillText("made by:", 15, y.get() + 25);
                gc.fillText("-abdelrahman zaghloul-", 15, y.get() + 50);
                gc.fillText("-ahmed swidan-", 15, y.get() + 75);
                gc.fillText("-islam tarek-", 15, y.get() + 100);
                gc.fillText("-mostafa talaat-", 15, y.get() + 125);
                gc.fillText("-seif amr-", 15, y.get() + 150);
                gc.fillText("special thanks to:",15,y.get()+200);
                gc.fillText("-Dr. Mervat mekhaeil-",55,y.get()+225);
                gc.fillText("all the teaching committee",15,y.get()+250);
                gc.fillText("piazza.com",15,y.get()+275);
                gc.fillText("stack over flow",15,y.get()+300);
                gc.fillText("the new boston",15,y.get()+325);
                gc.fillText("tim buchalka",15,y.get()+350);
                gc.fillText("all content used are\ncopyrights of halfbrick co.",15,y.get()+450);
                gc.fillText("programming 2 final\nproject",15,y.get()+550);
                y.getAndDecrement();
            }
        };

        timer.start();

       back.setOnMouseClicked(event -> {
           timer.stop();
           controller.playSound("Next-screen-button.wav", 0);
           Main main = new Main();
           try {
               main.getOptions(event);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       });

    }
}
