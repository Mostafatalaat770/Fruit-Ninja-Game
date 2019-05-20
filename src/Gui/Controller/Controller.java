package Gui.Controller;

import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Interfaces.Memento.Files;
import Interfaces.Strategy.Strategy;
import Observer.Observer;
import Throwables.Bombs.Bomb;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Fruit;
import Throwables.Fruits.SpecialFruits.FreezeBanana;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import UsersDB.UsersDB;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jdom2.JDOMException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mostafa Talaat
 */
public class Controller implements GameActions {
    private static Controller ourInstance = new Controller();
    public ArrayList<GameObject> throwables = new ArrayList<>();
    public Strategy players = null;
    public int score = 0;
    public int personalHighscore = 0;
    public int highestScore = 0;
    public int secs = 0;
    public int mins = 0;
    public int lives;
    public double difficulty = 1;
    public String type;
    public int freezeTimer = 0;
    public boolean freezeEffect = false;
    public int luckyStrike = 1;
    public int fatalBombRateControl = 0;
    public UsersDB usersDB = UsersDB.getInstance();
    public Files files = new Files();
    ArrayList<Observer> observers = new ArrayList<Observer>();

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
    public void saveGame() throws IOException {
        files.saveState(getInstance());
        files.saveGame();
    }

    @Override
    public void loadGame() throws JDOMException, IOException {
        files.loadGame(getInstance(), type);
    }

    public void loadPlayers() throws JDOMException, IOException {
        files.loadPlayers(getInstance());
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
            fatalBombRateControl = 0;
            personalHighscore = usersDB.getPlayer().getScore();
            highestScore = players.getHighScore();
        } else if (type.equals("arcade")) {
            throwables.clear();
            score = 0;
            secs = 0;
            mins = 1;
            lives = 0;
            difficulty = 2.5;
            freezeEffect = false;
            freezeTimer = 0;
            personalHighscore = usersDB.getPlayer().getScore();
            highestScore = players.getHighScore();
        }

    }

    public void setUser(String username) {
        usersDB.setPlayer(username);
    }

    @Override
    public GameObject getRandomThrowable() {
        Strategy game = null;
        switch (type) {
            case "classic":
                game = new Strategy(new ClassicMode());
                break;
            case "arcade":
                game = new Strategy(new ArcadeMode());
                break;
        }
        assert game != null;
        return game.create(getInstance());
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
        Font theFont = Font.font("Gang Of Three", 30);
        gc.setFont(theFont);
        gc.fillText("score: " + score, 20, 30);
        gc.fillText(mins + " : " + secs, 1180, 30);
        if (type.equals("classic")) {
            gc.fillText("lives: " + lives, 1150, 70);
        }
        Font theFont1 = Font.font("Gang Of Three", 15);
        gc.setFont(theFont1);
        gc.fillText("best: " + personalHighscore, 20, 50);
        gc.fillText("all time best: " + highestScore, 20, 70);


        for (GameObject gameObject : throwables) {
            gameObject.render(gc);
            gameObject.updatePosition();
        }
    }

    public void slice(double x, double y) {
        for (GameObject throwable : throwables) {
            if (x > throwable.getXlocation() && x < throwable.getXlocation() + throwable.getImg1().getWidth() && y > throwable.getYlocation() && y < throwable.getYlocation() + throwable.getImg1().getHeight()) {

                if (!throwable.isSliced()) {
                    throwable.slice(getInstance());
                    notifyallobservers();
                    if (throwable instanceof Fruit)
                        playSound("pome-slice-1.wav", 0);
                    else if (throwable instanceof FatalBomb)
                        playSound("Bomb-explode.wav", 0);
                    else if (throwable instanceof DangerousBomb)
                        playSound("menu-Bomb.wav", 0);
                    else if (throwable instanceof FreezeBanana)
                        playSound("Bonus-Banana-Freeze.wav", 0);
                    else if (throwable instanceof MagicBeans)
                        playSound("extra-life.wav", 0);
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

    public void updateScore() {
        if (players.validate(score)) {
            usersDB.getPlayer().setScore(score);
            personalHighscore = usersDB.getPlayer().getScore();
        }
        if (highestScore < personalHighscore) {
            highestScore = personalHighscore;
        }
    }

    public boolean gameOver() {

        if (type.equals("classic")) {
            return lives == 0;
        } else if (type.equals("arcade")) {
            return mins == 0 && secs == 0;
        }
        return false;
    }

    public void freezeCountDown() {
        if (freezeEffect == true) {
            freezeTimer++;
            if (freezeTimer == 5) {
                freezeTimer = 0;
                freezeEffect = false;
            }

        }
    }

    public Clip playSound(String filename, int i) {
        File music = new File(filename);
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.loop(i);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
        return clip;

    }


    public void register(Observer O) {
        observers.add(O);
    }

    public void unregister(Observer O) {
        observers.remove(O);
    }

    public void notifyallobservers() {
        int size = observers.size();
        while (size-- > 0)
            observers.get(size).update();
    }

}



