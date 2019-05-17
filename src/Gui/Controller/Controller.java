package Gui.Controller;

import Interfaces.Factory.ObjectCreator;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Throwables.Bombs.Bomb;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mostafa Talaat
 */
public class Controller implements GameActions {
    private static Controller ourInstance = new Controller();
    public ArrayList<GameObject> throwables = new ArrayList<>();
    public static int score = 0;
    public int personalHighscore = 0;
    public int highestScore = 0;
    public static int secs = 0;
    public int mins = 0;
    public static int lives;
    public double difficulty = 1;
    public String type;
    public String username;
    public int luckyStrike = 1;

    public static Controller getInstance() {
        return ourInstance;
    }

    @Override
    public GameObject createGameObject() {
        return null;
    }

    @Override
    public void updateObjectsLocations() {

    }

    @Override
    public void sliceObjects() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRandom() {
        Random rand = new Random();
        luckyStrike %= 3;
        return (luckyStrike++ < 2 ? rand.nextInt(8) % 4 : rand.nextInt(8) % 8);
    }

    @Override
    public void ResetGame() {
        if (type.equals("classic")) {
            throwables.clear();
            score = 0;
            secs = 0;
            mins = 0;
            lives = 3;
            difficulty = 1;
        } else if (type.equals("arcade")) {
            throwables.clear();
            score = 0;
            secs = 0;
            mins = 1;
            lives = 3;
            difficulty = 1;
        }

    }

    @Override
    public GameObject getRandomThrowable() {
        ObjectCreator objectCreator = new ObjectCreator();
        return objectCreator.createObject(getRandom());
    }

    @Override
    public void removeUnwantedThrowable() {
        Iterator<GameObject> iterator = throwables.iterator();
        while (iterator.hasNext()) {
            GameObject throwable = iterator.next();
            if (throwable.hasMovedOffScreen() && throwable.isSliced()) {
                iterator.remove();
            } else if (throwable.hasMovedOffScreen() && !throwable.isSliced() && !(throwable instanceof Bomb)) {
                iterator.remove();
                lives--;
            } else if (throwable.hasMovedOffScreen()) {
                iterator.remove();
            }
        }

    }

    public void drawAllThings(GraphicsContext gc) {
        // Todo remove that damned paramiter (swidan, please)
        gc.clearRect(0, 0, 1280, 720);
        gc.setFill(Color.ORANGE);
        gc.setLineWidth(2);
        Font theFont = Font.font("Gang Of Three", 30);
        gc.setFont(theFont);
        gc.fillText("score: " + score, 20, 30);
        gc.fillText(mins + " : " + secs, 1180, 30);
        if (type.equals("classic")) {
            gc.fillText("lives: " + lives, 1150, 70);
        }


        for (GameObject gameObject : throwables) {
            gameObject.render(gc);
            gameObject.updatePosition();
        }
    }

    public void slice(double x, double y) {
        for (GameObject throwable : throwables) {
            if (x > throwable.getXlocation() && x < throwable.getXlocation() + throwable.getImg1().getWidth() && y > throwable.getYlocation() && y < throwable.getYlocation() + throwable.getImg1().getHeight()) {

                if (!throwable.isSliced()) {
                    throwable.slice();
                }
            }
        }

    }

    public void getCountDown(GraphicsContext gc, AtomicInteger seconds) {
        gc.setFill(Color.ORANGE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        Font theFont = Font.font("Gang Of Three", 200);
        gc.setFont(theFont);
        gc.fillText(String.valueOf(4 - seconds.get()), 600, 350);
        gc.strokeText(String.valueOf(4 - seconds.get()), 600, 350);
    }

    public void updateTime_Difficulty(Timeline timeline) {
        if (type.equals("classic")) {
            secs++;
            if (secs >= 60) {
                secs -= 60;
                mins++;
            }
            if (secs % 20 == 0 && difficulty < 3) {
                difficulty += 0.5;
                timeline.setRate(difficulty);
            }
        } else if (type.equals("arcade")) {

            if (secs == 0) {
                secs = 60;
                mins--;
            }
            secs--;
            if (secs % 10 == 0) {
                difficulty += 0.2;
                timeline.setRate(difficulty);

            }
        }

    }

    public boolean gameOver() {
        if (type.equals("classic")) {
            // todo: game over scene
            return lives == 0;
        } else if (type.equals("arcade")) {
            // todo: game over scene
            return mins == 0 && secs == 0;
        }
        return false;
    }
}



