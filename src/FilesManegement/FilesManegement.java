package FilesManegement;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Observer.Observer;
import Throwables.Bombs.DangerousBomb;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Apple;
import Throwables.Fruits.Banana;
import Throwables.Fruits.Melon;
import Throwables.Fruits.Orange;
import Throwables.Fruits.SpecialFruits.FreezeBanana;
import Throwables.Fruits.SpecialFruits.MagicBeans;
import UsersDB.Player;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class FilesManegement {
    private static FilesManegement ourInstance = new FilesManegement();

    public static FilesManegement getInstance() {
        return ourInstance;
    }

    public GameObject createObject(String type) {
        GameObject object = null;
        switch (type) {
            case "apple":
                object = new Apple();
                break;
            case "banana":
                object = new Banana();
                break;
            case "melon":
                object = new Melon();
                break;
            case "orange":
                object = new Orange();
                break;
            case "freezeBanana":
                object = new FreezeBanana();
                break;
            case "magicBeans":
                object = new MagicBeans();
                break;
            case "dangerousBomb":
                object = new DangerousBomb();
                break;
            case "fatalBomb":
                object = new FatalBomb();
                break;
        }
        return object;
    }

    public void saveGame(Controller controller) throws IOException {

        Element levelElement = new Element(controller.type);
        Document doc = new Document(levelElement);

        Element parent = new Element("lives");
        parent.setText(Integer.toString(controller.lives));
        levelElement.addContent(parent);

        parent = new Element("difficulty");
        parent.setText(Double.toString(controller.difficulty));
        levelElement.addContent(parent);

        parent = new Element("scores");
        parent.addContent(new Element("score").setText(Integer.toString(controller.score)));
        parent.addContent(new Element("personalHighscore").setText(Integer.toString(controller.personalHighscore)));
        levelElement.addContent(parent);

        parent = new Element("time");
        levelElement.addContent(parent);
        Element child = new Element("mins");
        child.setText(Integer.toString(controller.mins));
        parent.addContent(child);
        child = new Element("secs");
        child.setText(Integer.toString(controller.secs));
        parent.addContent(child);


        Element superParent = new Element("fruits");
        String type = "";
        for (GameObject throwable : controller.throwables) {
            if (throwable instanceof Apple) {
                type = "apple";
            }
            if (throwable instanceof Banana) {
                type = "banana";
            }
            if (throwable instanceof Orange) {
                type = "orange";
            }
            if (throwable instanceof Melon) {
                type = "melon";
            }
            if (throwable instanceof FreezeBanana) {
                type = "freezeBanana";

            }
            if (throwable instanceof MagicBeans) {
                type = "magicBeans";

            }
            if (throwable instanceof DangerousBomb) {
                type = "dangerousBomb";

            }
            if (throwable instanceof FatalBomb) {
                type = "fatalBomb";

            }
            parent = new Element(type);
            superParent.addContent(parent);


            child = new Element("x");
            child.setText(Double.toString(throwable.getXlocation()));
            parent.addContent(child);

            child = new Element("y");
            child.setText(Double.toString(throwable.getYlocation()));
            parent.addContent(child);

            child = new Element("maxHeight");
            child.setText(Double.toString(throwable.getMaxHeight()));
            parent.addContent(child);

            child = new Element("startPos");
            child.setText(Double.toString(throwable.getStartPos()));
            parent.addContent(child);

            child = new Element("midPoint");
            child.setText(Double.toString(throwable.getMidPoint()));
            parent.addContent(child);

            child = new Element("endPos");
            child.setText(Double.toString(throwable.getEndPos()));
            parent.addContent(child);

            child = new Element("a");
            child.setText(Double.toString(throwable.getA()));
            parent.addContent(child);

            child = new Element("p");
            child.setText(Double.toString(throwable.getP()));
            parent.addContent(child);

            child = new Element("q");
            child.setText(Double.toString(throwable.getQ()));
            parent.addContent(child);

            child = new Element("falling");
            child.setText(Boolean.toString(throwable.isFalling()));
            parent.addContent(child);

            child = new Element("sliced");
            child.setText(Boolean.toString(throwable.isSliced()));
            parent.addContent(child);

            child = new Element("leftToRight");
            child.setText(Boolean.toString(throwable.isLeftToRight()));
            parent.addContent(child);


            child = new Element("movedOffScreen");
            child.setText(Boolean.toString(throwable.hasMovedOffScreen()));
            parent.addContent(child);
        }
        levelElement.addContent(superParent);

        XMLOutputter xmlOutput = new XMLOutputter();

        File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Saves" + File.separator + controller.usersDB.getPlayer().getUsername() + "/");
        if (file.mkdirs()) {
            file.createNewFile();
        }
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(file + "/" + controller.type + ".txt"));
    }

    public void loadGame(Controller controller) throws JDOMException, IOException {
        File inputFile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Saves" + File.separator + controller.usersDB.getPlayer().getUsername() + File.separator + controller.type + ".txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element classElement = document.getRootElement();

        controller.lives = Integer.parseInt(classElement.getChild("lives").getText());
        controller.difficulty = Double.parseDouble(classElement.getChild("difficulty").getText());

        controller.score = Integer.parseInt(classElement.getChild("scores").getChild("score").getText());
        controller.personalHighscore = Integer.parseInt(classElement.getChild("scores").getChild("personalHighscore").getText());

        controller.mins = Integer.parseInt(classElement.getChild("time").getChild("mins").getText());

        controller.secs = Integer.parseInt(classElement.getChild("time").getChild("secs").getText());

        List<Element> childs = classElement.getChild("fruits").getChildren();
        for (int i = 0; i < childs.size(); i++) {
            Element child = childs.get(i);
            double x = Double.parseDouble(child.getChild("x").getText());
            double y = Double.parseDouble(child.getChild("y").getText());
            double maxHeight = Double.parseDouble(child.getChild("maxHeight").getText());
            double startPos = Double.parseDouble(child.getChild("startPos").getText());
            double midPoint = Double.parseDouble(child.getChild("midPoint").getText());
            double endPos = Double.parseDouble(child.getChild("endPos").getText());
            double a = Double.parseDouble(child.getChild("a").getText());
            double p = Double.parseDouble(child.getChild("p").getText());
            double q = Double.parseDouble(child.getChild("q").getText());
            boolean falling = Boolean.parseBoolean(child.getChild("falling").getText());
            boolean sliced = Boolean.parseBoolean(child.getChild("sliced").getText());
            boolean leftToRight = Boolean.parseBoolean(child.getChild("leftToRight").getText());
            boolean movedOffScreen = Boolean.parseBoolean(child.getChild("movedOffScreen").getText());
            GameObject object = createObject(child.getName());

            object.setX(x);
            object.setY(y);
            object.setMaxHeight(maxHeight);
            object.setStartPos(startPos);
            object.setMidPoint(midPoint);
            object.setEndPos(endPos);
            object.setA(a);
            object.setP(p);
            object.setQ(q);
            object.setFalling(falling);
            object.setSliced(sliced);
            object.setLeftToRight(leftToRight);
            object.setMovedOffScreen(movedOffScreen);
            controller.throwables.add(object);
            if (object.isSliced()) {
                controller.unregister((Observer) controller.throwables.get(controller.throwables.size() - 1));
            }
        }
    }

    public void savePlayers(Controller controller) throws IOException {
        Element levelElement = new Element("Players");
        Document doc = new Document(levelElement);
        Element parent;
        Element child;
        Player player;
        for (int i = 0; i < controller.usersDB.getPlayers().size(); i++) {
            player = controller.usersDB.getPlayers().get(i);
            parent = new Element("player" + (i + 1));

            child = new Element("name");
            child.setText(player.getUsername());
            parent.addContent(child);

            child = new Element("arcadeScore");
            child.setText(Integer.toString(player.getArcadeScore()));
            parent.addContent(child);

            child = new Element("classicScore");
            child.setText(Integer.toString(player.getClassicScore()));
            parent.addContent(child);
            doc.getRootElement().addContent(parent);
        }

        XMLOutputter xmlOutput = new XMLOutputter();

            File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Players");
        if (file.mkdirs()) {
            file.createNewFile();
        }
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(file + "/players.txt"));
    }

    public void loadPlayers(Controller controller) throws JDOMException, IOException {
        File inputFile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/Players" + File.separator + "players.txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        System.out.println(inputFile.toString());

        Document document = saxBuilder.build(inputFile);

        List<Element> childs = document.getRootElement().getChildren();

        for (Element child : childs) {
            controller.usersDB.addUser(child.getChildText("name"), Integer.parseInt(child.getChildText("arcadeScore")), Integer.parseInt(child.getChildText("classicScore")));
        }
    }
}
