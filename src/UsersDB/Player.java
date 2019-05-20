package UsersDB;

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
}
