package UsersDB;

/**
 * @author Mostafa Talaat
 */
public class Player {
    private String username;
    private int score;

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
