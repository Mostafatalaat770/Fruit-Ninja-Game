package FilesManegement;

import Interfaces.GameObject;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import Throwables.Fruits.SpecialFruits.FreezeBanana;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class FilesManegement {
    private static FilesManegement ourInstance = new FilesManegement();

    public static FilesManegement getInstance() {
        return ourInstance;
    }

    private List<GameObject> throwables = new ArrayList<>();
    private int numberOfLives;
    private int difficulty;
    private int score;
    private int time;
    private int highScore;


    public void save(List<GameObject> throwables, String type, int numberOfLives, int difficulty, int score, int time) throws IOException {

        Element levelElement = new Element(type);
        Document doc = new Document(levelElement);

        Element parent = new Element("numberOfLives");
        parent.setText(Integer.toString(numberOfLives));
        levelElement.addContent(parent);

        parent = new Element("difficulty");
        parent.setText(Integer.toString(difficulty));
        levelElement.addContent(parent);

        parent = new Element("score");
        parent.setText(Integer.toString(score));
        levelElement.addContent(parent);

        parent = new Element("time");
        parent.setText(Integer.toString(time));
        levelElement.addContent(parent);

        parent = new Element("fruits");
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
            if (throwable instanceof FreezeBanana) {
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
            child.setText(Double.toString(throwable.getMaxHeight()));

            child = new Element("initialVelocity");
            child.setText(Integer.toString(throwable.getInitialVelocity()));

            child = new Element("fallingVelocity");
            child.setText(Integer.toString(throwable.getFallingVelocity()));

            child = new Element("falling");
            child.setText(Boolean.toString(throwable.isFalling()));

            child = new Element("sliced");
            child.setText(Boolean.toString(throwable.isSliced()));

            child = new Element("movedOffScreen");
            child.setText(Boolean.toString(throwable.hasMovedOffScreen()));

            parent.addContent(child);
        }
        levelElement.addContent(parent);

        XMLOutputter xmlOutput = new XMLOutputter();

        File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Saves");
        if (file.mkdirs()) {
            file.createNewFile();
        }
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(file + "/" + type + ".txt"));
    }

    public void load(String type) throws JDOMException, IOException {
        File inputFile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Saves" + File.separator + type + ".txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element classElement = document.getRootElement();

        numberOfLives = Integer.parseInt(classElement.getChild("numberOfLives").getText());
        difficulty = Integer.parseInt(classElement.getChild("difficulty").getText());
        score = Integer.parseInt(classElement.getChild("score").getText());
        time = Integer.parseInt(classElement.getChild("time").getText());

        List<Element> childs = classElement.getChildren("fruits");
        for (int i = 0; i < childs.size(); i++) {
            Element child = childs.get(i);
            switch (child.getName()) {
                case "apple":
                    throwables.add(new Apple(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "banana":
                    throwables.add(new Banana(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "orange":
                    throwables.add(new Orange(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "melon":
                    throwables.add(new Melon(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "magicBeans":
                    throwables.add(new MagicBeans(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "score2xBanana":
                    throwables.add(new FreezeBanana(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "dangerousBomb":
                    throwables.add(new DangerousBomb(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));
                case "fatalBomb":
                    throwables.add(new FatalBomb(Double.parseDouble(child.getChild("X").getText()), Double.parseDouble(child.getChild("Y").getText()), Double.parseDouble(child.getChild("maxHeight").getText()), Integer.parseInt(child.getChild("initialVelocity").getText()), Integer.parseInt(child.getChild("fallingVelocity").getText()), Boolean.parseBoolean(child.getChild("falling").getText()), Boolean.parseBoolean(child.getChild("sliced").getText()), Boolean.parseBoolean(child.getChild("movedOffScreen").getText())));

            }
        }
    }

    public void saveHighScore(int highScore) throws IOException {
        Element levelElement = new Element("highScore");
        levelElement.setText(Integer.toString(highScore));
        Document doc = new Document(levelElement);
        XMLOutputter xmlOutput = new XMLOutputter();

        File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/LeaderBoards");
        if (file.mkdirs()) {
            file.createNewFile();
        }
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(file + "/highScore.txt"));
    }

    public void loadHighScore() throws JDOMException, IOException {
        File inputFile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/LeaderBoards" + File.separator + "highScore.txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        highScore = Integer.parseInt(document.getRootElement().getText());
    }

    public List<GameObject> getThrowables() {
        return throwables;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public int getHighScore() {
        return highScore;
    }
}
