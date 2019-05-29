package UsersDB;

import Gui.Controller.Controller;
import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;

/**
 * @author Mostafa Talaat
 */
public class Player {

    private final String username;
    private int arcadeScore;
    private int classicScore;

    Player(String username, int arcadeScore, int classicScore) {
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

    public int getClassicScore() {
        return classicScore;
    }

    public int getScore() {
        Controller controller = Controller.getInstance();
        if (controller.gameMode.getGameMode() instanceof ArcadeMode) {
            return arcadeScore;
        } else if (controller.gameMode.getGameMode() instanceof ClassicMode) {
            return classicScore;
        }
        return 0;
    }

    public void setScore(int score) {
        Controller controller = Controller.getInstance();
        if (controller.gameMode.getGameMode() instanceof ArcadeMode) {
            arcadeScore = score;
        } else if (controller.gameMode.getGameMode() instanceof ClassicMode) {
            classicScore = score;
        }
    }

}
