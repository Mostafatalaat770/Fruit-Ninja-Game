package Interfaces.Memento;

import FilesManegement.FilesManagement;
import Gui.Controller.Controller;
import Interfaces.Factory.ArcadeMode;
import Interfaces.Factory.ClassicMode;
import Interfaces.Strategy.Strategy;
import org.jdom2.JDOMException;

import java.io.IOException;

/**
 * @author Mostafa Talaat
 */
public class Files {
    private final FilesManagement filesManagement = FilesManagement.getInstance();

    private final Originator originator = new Originator();
    private final CareTaker careTaker = new CareTaker();

    public void saveState(Controller controller) {
        originator.setState(controller);
        careTaker.add(originator.saveStateToMemento());
    }

    public void saveGame(Controller controller) throws IOException {
        originator.getStateFromMemento(careTaker.get(0));
        filesManagement.saveGame(controller);
    }

    public void loadGame(Controller controller) throws JDOMException, IOException {
        filesManagement.loadGame(controller);
        if (controller.type.equals("arcade")) {
            controller.gameMode = new Strategy(new ArcadeMode());
        } else if (controller.type.equals("classic")) {
            controller.gameMode = new Strategy(new ClassicMode());
        }
    }

    public void loadPlayers(Controller controller) throws JDOMException, IOException {
        filesManagement.loadPlayers(controller);
    }

    public void savePlayers(Controller controller) throws IOException {
        filesManagement.savePlayers(controller);
    }

    public void loadSettings(Controller controller) throws JDOMException, IOException {
        filesManagement.loadSettings(controller);
    }

    public void saveSettings(Controller controller) throws IOException {
        filesManagement.saveSettings(controller);
    }
}
