package Gui.Controller;

import Interfaces.Command.Command;
import Interfaces.Command.Invoker;
import Interfaces.Command.PlaySound;
import Interfaces.Command.ToggleSound;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Interfaces.Memento.Files;
import Interfaces.Strategy.Strategy;
import Observer.Observer;
import Throwables.Bombs.Bomb;
import UsersDB.UsersDB;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jdom2.JDOMException;

import javax.sound.sampled.Clip;
import java.io.IOException;
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
    public Strategy gameMode = null;
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
    public int comboChecker = 0;
    public int comboTimer = 0;
    public boolean comboEffect = false;
    public int luckyStrike = 1;
    public int fatalBombRateControl = 0;
    public UsersDB usersDB = UsersDB.getInstance();
    public Files files = new Files();
    public boolean sound = true;
    public Invoker invoker = new Invoker();
    public Clip gameStart = playSound("main theme", Clip.LOOP_CONTINUOUSLY);
    ArrayList<Observer> observers = new ArrayList<Observer>();
    Image background = new Image("Resources/wallpaper1.jpg", 1270, 720, true, true);
    public boolean personalScorePassed = false;
    public boolean highestScorePassed = false;
    private Random random=new Random();
    public boolean touchFunctionality = false;


    public static Controller getInstance() {
        return ourInstance;
    }

    @Override
    public void saveGame() throws IOException {
        files.saveState(getInstance());
        files.saveGame(getInstance());
    }

    public void savePlayers() throws IOException {
        files.savePlayers(getInstance());
    }

    @Override
    public void loadGame() throws JDOMException, IOException {
        files.loadGame(getInstance());
        comboChecker = 0;
        comboEffect = false;
        comboTimer = 0;
        personalHighscore = usersDB.getPlayer().getScore();
        highestScore = gameMode.getHighScore();

    }

    public void loadPlayers() throws JDOMException, IOException {
        files.loadPlayers(getInstance());

    }

    @Override
    public void ResetGame() {
        if (type.equals("classic")) {
            mins = 0;
            lives = 3;
            difficulty = 1;
            fatalBombRateControl = 0;

        } else if (type.equals("arcade")) {

            mins = 1;
            lives = 0;
            difficulty = 2.5;
            freezeEffect = false;
            freezeTimer = 0;
        }

        throwables.clear();
        score = 0;
        secs = 0;
        comboChecker = 0;
        comboEffect = false;
        comboTimer = 0;
        personalHighscore = usersDB.getPlayer().getScore();
        highestScore = gameMode.getHighScore();

    }

    public void setUser(String username) {
        usersDB.setPlayer(username);
    }

    @Override
    public GameObject getRandomThrowable() {
        return gameMode.createObject();
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
                if (lives > 0) {
                    playSound("lose life", 0);
                    lives--;
                }
            } else if (throwable.hasMovedOffScreen()) {
                iterator.remove();
            }
        }

    }

    public void drawAllThings(GraphicsContext gc) {
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

    public void slice(double x, double y) throws InterruptedException {
        for (GameObject throwable : throwables) {
            if (x > throwable.getXlocation() && x < throwable.getXlocation() + throwable.getImg1().getWidth() && y > throwable.getYlocation() && y < throwable.getYlocation() + throwable.getImg1().getHeight()) {

                if (!throwable.isSliced()) {
                    if (comboEffect == false) {
                        comboEffect = true;
                    }
                    if (comboEffect == true) {
                        comboChecker++;
                    }
                    throwable.slice(getInstance());
                    notifyallobservers();
                    updateScore();
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
        if (gameMode.validate(score)) {
            if (!personalScorePassed) {
                personalScorePassed = true;
                playSound("high score", 0);
            }
            usersDB.getPlayer().setScore(score);
            personalHighscore = usersDB.getPlayer().getScore();
        }
        if (highestScore < personalHighscore) {
            if (!highestScorePassed) {
                highestScorePassed = true;
                playSound("high score", 0);
            }
            highestScore = personalHighscore;
        }
    }

    public boolean gameOver() {

        if (type.equals("classic")) {
            return lives <= 0;
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

    public Clip playSound(String type, int duration) {
        Command playSound = new PlaySound();
        invoker.setCommand(playSound);
        return invoker.playSound(type, duration);
    }

    public void comboCountdown() {
        if (comboEffect) {
            comboTimer++;
            if (comboTimer == 1) {
                if (comboChecker > 2) {
                    playSound("combo", 0);
                    score += comboChecker;
                }
                comboChecker = 0;
                comboTimer = 0;
                comboEffect = false;

            }
        }
    }


    public void toggleSound(ToggleButton toggleButton) {
        Command toggleSound = new ToggleSound();
        invoker.setCommand(toggleSound);
        invoker.execute(toggleButton);
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

    public void getThrowables(){
      if(type.equals("arcade")){
          if(throwables.size()<6) {

              for(int i=0;i<1+random.nextInt(5);i++){
                  GameObject temp = getRandomThrowable();
                  throwables.add(temp);
                  if(temp instanceof Bomb)
                      playSound("throw bomb", 0);
                  else
                      playSound("throw fruit", 0);
              }
          }
      }else if(type.equals("classic")) {
          if(throwables.size()<6) {
              if(difficulty>1){
                  for (int i=0;i<1+random.nextInt(3);i++){
                      GameObject temp = getRandomThrowable();
                      throwables.add(temp);
                      if(temp instanceof Bomb)
                          playSound("throw bomb", 0);
                      else
                          playSound("throw fruit", 0);
                  }
              }
              else{
                  GameObject temp = getRandomThrowable();
                  throwables.add(temp);
                  if(temp instanceof Bomb)
                      playSound("throw bomb", 0);
                  else
                      playSound("throw fruit", 0);
              }
          }
      }
    }


}



