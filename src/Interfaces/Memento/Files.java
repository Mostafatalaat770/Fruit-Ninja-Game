package Interfaces.Memento;

import FilesManegement.FilesManegement;
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
    FilesManegement filesManegement = FilesManegement.getInstance();

    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    public void saveState(Controller controller) {
        originator.setState(controller);
        careTaker.add(originator.saveStateToMemento());
    }

    public void saveGame(Controller controller) throws IOException {
        originator.getStateFromMemento(careTaker.get(0));
        filesManegement.saveGame(controller);
    }

    public void loadGame(Controller controller) throws JDOMException, IOException {
        filesManegement.loadGame(controller);
        if (controller.type.equals("arcade")) {
            controller.gameMode = new Strategy(new ArcadeMode());
        } else if (controller.type.equals("classic")) {
            controller.gameMode = new Strategy(new ClassicMode());
        }
    }

    public void loadPlayers(Controller controller) throws JDOMException, IOException {
        filesManegement.loadPlayers(controller);
    }

    public void savePlayers(Controller controller) throws IOException {
        filesManegement.savePlayers(controller);
    }
}
