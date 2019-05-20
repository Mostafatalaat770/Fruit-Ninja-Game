package Interfaces.Strategy;

import UsersDB.Player;
import UsersDB.UsersDB;

import java.util.Collections;

/**
 * @author Mostafa Talaat
 */
public class Arcade implements DataBase {

    private UsersDB usersDB = UsersDB.getInstance();

    public void sort() {
        for (int i = 0; i < usersDB.getPlayers().size() - 1; i++) {
            for (int j = 0; j < usersDB.getPlayers().size() - i - 1; j++) {
                if (usersDB.getPlayers().get(j).getArcadeScore() < usersDB.getPlayers().get(j + 1).getArcadeScore()) {
                    Collections.swap(usersDB.getPlayers(), j, j + 1);
                }
            }
        }
    }

    public int getHighScore() {
        int max = 0;
        for (Player player : usersDB.getPlayers()) {
            if (player.getArcadeScore() > max) {
                max = player.getArcadeScore();
            }
        }
        return max;
    }

    public boolean validate(int score) {
        return usersDB.getPlayer().getArcadeScore() < score;
    }
}
