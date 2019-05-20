package UsersDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class UsersDB {
    private static UsersDB instance = new UsersDB();
    private Player player;
    private List<Player> players = new ArrayList<>();

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

    public boolean validateScore(int score) {
        return player.getScore() < score;
    }

    public void sort() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < i - 1; j++) {
                if (players.get(j).getScore() < players.get(j + 1).getScore()) {
                    Collections.swap(players, j, j + 1);
                }
            }
        }
    }

    public int getHighestScore() {
        int max = 0;
        for (Player player : players) {
            if (player.getScore() > max) {
                max = player.getScore();
            }
        }
        return max;
    }

    public void addUser(String username, int score) {
        players.add(new Player(username, score));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
