package FilesManegement;

import Interfaces.GameObject;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import Throwables.Fruits.SpecialFruits.Score2xBanana;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class FilesManegement {
    private static FilesManegement ourInstance = new FilesManegement();

    public static FilesManegement getInstance() {
        return ourInstance;
    }

    public void save(List<GameObject> throwables, String type, int difficulty, int score, int time) {

        Element levelElement = new Element(type);
        Document doc = new Document(levelElement);
        Element parent = new Element("Fruits");
        Element child;
        for (GameObject throwable : throwables) {
            if (throwable instanceof Apple) {
                parent.addContent("apple");
            }
            if (throwable instanceof Banana) {
                parent.addContent("banana");
            }
            if (throwable instanceof Orange) {
                parent.addContent("orange");
            }
            if (throwable instanceof Melon) {
                parent.addContent("melon");
            }
            if (throwable instanceof Score2xBanana) {
                parent.addContent("score2xBanana");
            }
            if (throwable instanceof MagicBeans) {
                parent.addContent("magicBeans");
            }
            if (throwable instanceof DangerousBomb) {
                parent.addContent("dangerousBomb");
            }
            if (throwable instanceof FatalBomb) {
                parent.addContent("fatalBomb");
            }
            child = new Element("X");
            child.setText(Double.toString(throwable.getXlocation()));
            child = new Element("Y");
            child.setText(Double.toString(throwable.getYlocation()));
            child = new Element("maxHeight");
            child.setText(Integer.toString(throwable.getMaxHeight()));
            child = new Element("initialVelocity");
            child.setText(Integer.toString(throwable.getInitialVelocity()));
            child = new Element("fal");
            child.setText(Double.toString(throwable.getXlocation()));
        }
    }

}
