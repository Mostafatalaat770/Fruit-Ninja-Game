package Gui.Controller;

import Interfaces.Factory.ObjectCreator;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Throwables.Fruits.Melon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class Controller implements GameActions {
    private static Controller ourInstance = new Controller();
    public ArrayList<GameObject> throwables= new ArrayList<>();

    public static Controller getInstance() {
        return ourInstance;
    }

    @Override
    public GameObject createGameObject() {
        Random random= new Random();
        GameObject gameObject= getRandomThrowable();
        gameObject.setX(100+random.nextDouble()*1080);
        gameObject.setY(720);
        gameObject.setMaxHeight(100+200*random.nextDouble());
        gameObject.setInitialVelocity(3);
        return gameObject;
    }

    @Override
    public void updateObjectsLocations() {

    }

    @Override
    public void sliceObjects() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void ResetGame() {

    }

    @Override
    public GameObject getRandomThrowable() {
        ObjectCreator objectCreator = new ObjectCreator();
        Random rand = new Random();
        int numberOfThrowables = 7; // number of supported throwables - 1 *starting from 0*
        return objectCreator.createObject(rand.nextInt(numberOfThrowables));
    }

    @Override
    public void removeUnwantedThrowable(ArrayList<GameObject> throwables) {
        //  todo : 23mlha bel iterator, htdeek intersections kda
        for (GameObject throwable : throwables) {
            if (throwable.hasMovedOffScreen()) {
                throwables.remove(throwable);
            }
        }
    }

    public void drawAllThings(GraphicsContext gc,ArrayList<GameObject> list){
        Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);
        gc.drawImage(image, 0, 0);
        for(int i=0;i<list.size();i++){
            list.get(i).render(gc);
            list.get(i).updatePosition();
        }
    }



}
