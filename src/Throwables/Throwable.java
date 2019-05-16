package Throwables;

import Interfaces.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public abstract class Throwable implements GameObject {
    private double x;
    private double y;
    private double maxHeight;
    private double startPos;
    private double midPoint;
    private double endPos;
    private double a,q,p;
    private boolean falling ;
    private boolean sliced ;
    private boolean movedOffScreen ;

    public Throwable() {
        Random random=new Random();
        startPos=200+random.nextDouble()*680;
        y=720;
        x=startPos;
        endPos=startPos+200;
        midPoint=(startPos+endPos)/2;
        maxHeight=400+200*random.nextDouble();
        q=-startPos-endPos;
        p=startPos*endPos;
        a=maxHeight/((midPoint*midPoint)+(q*midPoint)+(p));
        falling=false;
        sliced=false;
        movedOffScreen=false;
    }

    @Override
    public double getXlocation() {
        return x;
    }

    @Override
    public double getYlocation() {
        return y;
    }

    @Override
    public double getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getInitialVelocity() {
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }
    @Override
    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen(){
       if(!movedOffScreen){
           if(x>=endPos)
           {
               movedOffScreen=true;

               return true;
           }
           else
               return false;
       }
       else {
           return true;
       }
       }

    public Boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
    }

    public void setMovedOffScreen(boolean movedOffScreen) {
        this.movedOffScreen = movedOffScreen;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getStartPos() {
        return startPos;
    }

    public void setStartPos(double startPos) {
        this.startPos = startPos;
    }

    public double getMidPoint() {
        return midPoint;
    }

    public void setMidPoint(double midPoint) {
        this.midPoint = midPoint;
    }

    public double getEndPos() {
        return endPos;
    }

    public void setEndPos(double endPos) {
        this.endPos = endPos;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public javafx.scene.image.Image[] getImages() {
        return new javafx.scene.image.Image[0];
    }

    @Override
    public void render(GraphicsContext gc) {
        if (isSliced())
            gc.drawImage(getImages()[1], x, y);
        else
            gc.drawImage(getImages()[0], x, y);

    }


    @Override
    public void updatePosition(){
//
        if(x==midPoint){
            falling=true;
        }
        y=720 - (a*x*x+a*q*x+a*p);

            x+=2;
   }
   @Override
    public void getEffect(int score,int lives, int secs){
       // TODO: 17-May-19 mostafa
   }
}
