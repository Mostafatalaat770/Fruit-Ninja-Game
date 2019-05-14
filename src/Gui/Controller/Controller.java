package Gui.Controller;

import Interfaces.Factory.ObjectCreator;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Throwables.Bombs.FatalBomb;
import Throwables.Fruits.Melon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public class Controller implements GameActions {
    private static Controller ourInstance = new Controller();
    public ArrayList<GameObject> throwables= new ArrayList<>();
    public int Score = 0;

    public static Controller getInstance() {
        return ourInstance;
    }

    @Override
    public GameObject createGameObject() {
       return null;
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
        Iterator<GameObject> iterator= throwables.iterator();
       while (iterator.hasNext()){
           GameObject throwable= iterator.next();
            if (throwable.hasMovedOffScreen()) {
                iterator.remove();
                System.out.println("removed");
            }
        }
    }

    public void drawAllThings(GraphicsContext gc,ArrayList<GameObject> list,int score){
        Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);
        gc.drawImage(image, 0, 0);
        gc.setFill(Color.ORANGE);
        gc.setLineWidth(2);
        Font theFont = Font.font("Gang Of Three", 30);
        gc.setFont(theFont);
        gc.fillText("score: " + score , 20, 30);
        Font theFont2 = Font.font("Gang Of Three", 15);
        gc.setFont(theFont2);
        gc.setFill(Color.GRAY);
        gc.fillText("best score: ",20,50);
        for(int i=0;i<list.size();i++){
            list.get(i).render(gc);
            list.get(i).updatePosition();
        }
    }

    public boolean isSliced(ArrayList<GameObject> throwables,double x, double y){
        for(int i=0;i<throwables.size();i++){
            if(x>throwables.get(i).getXlocation()&&x<throwables.get(i).getXlocation()+throwables.get(i).getImages()[0].getWidth()){
                if(y>throwables.get(i).getYlocation()&&y<throwables.get(i).getYlocation()+throwables.get(i).getImages()[0].getHeight()){
                    if(throwables.get(i).isSliced()==false){
                        throwables.get(i).setSliced(true);

                        return true;
                    }
                }
            }
        }
        return false;
    }



}
