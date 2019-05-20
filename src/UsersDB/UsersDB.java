package UsersDB;

import FilesManegement.FilesManegement;
import Gui.Controller.Controller;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
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


    public static void main(String[] args) throws IOException, JDOMException {
        Controller controller = Controller.getInstance();
        FilesManegement filesManegement = FilesManegement.getInstance();
        controller.usersDB.addUser("musty", 100, 0);
        controller.usersDB.addUser("swi", 23, 1);
        controller.usersDB.addUser("3dma", 242, 100);
        filesManegement.savePlayers(controller);
        System.out.println("we5o");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addUser(String username, int arcadeScore, int classicScore) {
        players.add(new Player(username, arcadeScore, classicScore));
    }
}
