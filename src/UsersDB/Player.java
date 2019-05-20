package UsersDB;

import Gui.Controller.Controller;

/**
 * @author Mostafa Talaat
 */
public class Player {

    private String username;
    private int arcadeScore;
    private int classicScore;

    public Player(String username, int arcadeScore, int classicScore) {
        this.username = username;
        this.arcadeScore = arcadeScore;
        this.classicScore = classicScore;
    }

    public String getUsername() {
        return username;
    }

    public int getArcadeScore() {
        return arcadeScore;
    }

    public void setArcadeScore(int arcadeScore) {
        this.arcadeScore = arcadeScore;
    }

    public int getClassicScore() {
        return classicScore;
    }

    public void setClassicScore(int classicScore) {
        this.classicScore = classicScore;
    }

    public int getScore() {
        Controller controller = Controller.getInstance();
        if (controller.players.getDataBase() instanceof Interfaces.Strategy.Arcade) {
            return arcadeScore;
        } else if (controller.players.getDataBase() instanceof Interfaces.Strategy.Classic) {
            return classicScore;
        }
        return 0;
    }

    public void setScore(int score) {
        Controller controller = Controller.getInstance();
        if (controller.players.getDataBase() instanceof Interfaces.Strategy.Arcade) {
            arcadeScore = score;
        } else if (controller.players.getDataBase() instanceof Interfaces.Strategy.Classic) {
            classicScore = score;
        }
    }

}
