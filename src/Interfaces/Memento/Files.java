package Interfaces.Memento;

import FilesManegement.FilesManegement;
import Gui.Controller.Controller;
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

    public void saveGame() throws IOException {
        originator.getStateFromMemento(careTaker.get(0));
        filesManegement.save(originator.getState());
    }

    public void load(Controller controller, String type) throws JDOMException, IOException {
        filesManegement.load(controller, type);
        //filesManegement.loadHighestScore(controller);
    }
}
