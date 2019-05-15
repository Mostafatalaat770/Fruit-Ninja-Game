package Gui.Controller;

import Interfaces.Factory.ObjectCreator;
import Interfaces.GameActions;
import Interfaces.GameObject;
import Throwables.Bombs.Bomb;
import Throwables.Fruits.SpecialFruits.SpecialFruit;
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
    public int secs  =  0;
    public  int mins = 0;
    public int lives;
    public int difficulty = 1;
    public String type;

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
    public boolean removeUnwantedThrowable(ArrayList<GameObject> throwables) {
        Iterator<GameObject> iterator= throwables.iterator();
       while (iterator.hasNext()){
           GameObject throwable= iterator.next();
           if (throwable.hasMovedOffScreen() && !throwable.isSliced() && !(throwable instanceof Bomb)) {
                iterator.remove();
                return false;
            }
        }
        return true;
    }

    public void drawAllThings(GraphicsContext gc,ArrayList<GameObject> list,Controller controller){
        Image image = new Image("Resources/ConceptGreatWave1 (2).jpg",1280,720,false,false);
        gc.drawImage(image, 0, 0);
        gc.setFill(Color.ORANGE);
        gc.setLineWidth(2);
        Font theFont = Font.font("Gang Of Three", 30);
        gc.setFont(theFont);
        gc.fillText("score: " + controller.Score , 20, 30);
        gc.fillText(controller.mins+" : "+controller.secs,1180,30);
        if(controller.lives!=0)
        {
            gc.fillText("lives: "+controller.lives,1150,70);
        }
        Font theFont2 = Font.font("Gang Of Three", 15);
        gc.setFont(theFont2);
        gc.setFill(Color.GRAY);
        gc.fillText("best score: ",20,50);



        for(int i=0;i<list.size();i++){
            list.get(i).render(gc);
            list.get(i).updatePosition();
        }
    }

    public boolean isSliced(ArrayList<GameObject> throwables,double x, double y,Controller controller){
        for(int i=0;i<throwables.size();i++){
            if(x>throwables.get(i).getXlocation()&&x<throwables.get(i).getXlocation()+throwables.get(i).getImages()[0].getWidth()){
                if(y>throwables.get(i).getYlocation()&&y<throwables.get(i).getYlocation()+throwables.get(i).getImages()[0].getHeight()){
                    if (!throwables.get(i).isSliced()) {
                        throwables.get(i).setFalling(true);
                        throwables.get(i).setSliced(true);
                        controller.Score++;
                        if(throwables.get(i) instanceof Bomb){
                            // todo : special effects
                            controller.Score--;
                        }
                        if(throwables.get(i) instanceof SpecialFruit){
                            //todo : special effects
                            controller.Score--;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }



}
