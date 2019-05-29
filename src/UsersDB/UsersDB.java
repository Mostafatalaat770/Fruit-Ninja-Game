package UsersDB;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class UsersDB {
    private static final UsersDB instance = new UsersDB();
    private Player player;
    private final List<Player> players = new ArrayList<>();

    public static UsersDB getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                this.player = player;
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addUser(String username, int arcadeScore, int classicScore) {
        players.add(new Player(username, arcadeScore, classicScore));
    }

    public boolean verify(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
