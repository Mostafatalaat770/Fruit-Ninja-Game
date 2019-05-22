package Gui.Controller;

public class PlayerLeaderboard {
    String username;
    int score;



    public PlayerLeaderboard(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
