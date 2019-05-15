package Gui.Controller;

import Interfaces.Factory.ObjectCreator;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Throwables.Bombs.Bomb;
import Throwables.Fruits.Fruit;
import Throwables.Fruits.SpecialFruits.SpecialFruit;
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
    private int Score = 0;
    int secs = 0;
    int mins = 0;
    int lives;
    int difficulty = 1;
    String type;
    int luckyStrike = 1;

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

    public int getRandom() {
        Random rand = new Random();
        luckyStrike %= 3;
        return (luckyStrike++ < 2 ? rand.nextInt(8) % 4 : rand.nextInt(8) % 8);
    }

    @Override
    public void ResetGame() {
        if (type.equals("classic")) {
            throwables.clear();
            Score = 0;
            secs = 0;
            mins = 0;
            lives = 3;
            difficulty = 1;
        } else if (type.equals("arcade")) {
            // TODO: 15-May-19 acdade reseter
        }
    }

    @Override
    public GameObject getRandomThrowable() {
        ObjectCreator objectCreator = new ObjectCreator();
        return objectCreator.createObject(getRandom());
    }

    @Override
    public boolean removeUnwantedThrowable(ArrayList<GameObject> throwables) {
        Iterator<GameObject> iterator = throwables.iterator();
        while (iterator.hasNext()) {
            GameObject throwable = iterator.next();
            if (throwable.hasMovedOffScreen() && throwable.isSliced()) {
                iterator.remove();
                return true;
            } else if (throwable.hasMovedOffScreen() && !throwable.isSliced() && !(throwable instanceof Bomb)) {
                iterator.remove();
                return false;
            } else if (throwable.hasMovedOffScreen()) {
                iterator.remove();
                return true;
            }
        }

        return true;
    }

    public void drawAllThings(GraphicsContext gc, Controller controller) {
        // Todo remove that damned paramiter (swidan, please)
        gc.clearRect(0, 0, 1280, 720);
        gc.setFill(Color.ORANGE);
        gc.setLineWidth(2);
        Font theFont = Font.font("Gang Of Three", 30);
        gc.setFont(theFont);
        gc.fillText("score: " + controller.Score, 20, 30);
        gc.fillText(controller.mins + " : " + controller.secs, 1180, 30);
        if (controller.type.equals("classic")) {
            gc.fillText("lives: " + controller.lives, 1150, 70);
        }
        Font theFont2 = Font.font("Gang Of Three", 15);
        gc.setFont(theFont2);
        gc.setFill(Color.GRAY);
        gc.fillText("best score: ", 20, 50);


        for (GameObject gameObject : controller.throwables) {
            gameObject.render(gc);
            gameObject.updatePosition();
        }
    }

    public void slice(ArrayList<GameObject> throwables, double x, double y, Controller controller) {
        for (GameObject throwable : throwables) {
            if (x > throwable.getXlocation() && x < throwable.getXlocation() + throwable.getImages()[0].getWidth()) {
                if (y > throwable.getYlocation() && y < throwable.getYlocation() + throwable.getImages()[0].getHeight()) {
                    if (!throwable.isSliced()) {
                        throwable.setFalling(true);
                        throwable.setSliced(true);
                        if (throwable instanceof Fruit) {
                            controller.Score++;
                            // todo slice sound
                        }
                        if (throwable instanceof Bomb) {
                            // todo : special effects
                            // todo slice sound (bomb)
                        }
                        if (throwable instanceof SpecialFruit) {
                            //todo : special effects
                            // todo slice sound (special fruit)
                        }
                    }
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
            if (secs == 60) {
                secs = 0;
                mins++;
            }
            if (secs % 30 == 0 && difficulty < 3) {
                timeline.setRate(++difficulty);
            }
        } else if (type.equals("arcade")) {
            // TODO: arcade timer 
        }
    }
}



