package Throwables;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Observer.Observer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

/**
 * @author Mostafa Talaat
 */
public abstract class Throwable implements GameObject, Observer {
    private double x;
    private double y;
    private double maxHeight;
    private double startPos;
    private double midPoint;
    private double endPos;
    private double a,q,p;
    private boolean falling ;
    private boolean sliced ;
    private boolean movedOffScreen;
    private boolean leftToRight;
    private Image img1;
    private Image img2;
    private final Controller controller = Controller.getInstance();

    protected Throwable() {
        controller.register(this);
        Random random=new Random();
        startPos=200+random.nextDouble()*680;
        endPos=startPos+200;
        switch (random.nextInt(2)){
            case 0:
                leftToRight=true;
                x=startPos;
            break;
            case 1:
                leftToRight=false;
                x=endPos;
            break;
        }
        y=720;
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
    public double getLocationX() {
        return x;
    }

    @Override
    public double getLocationY() {
        return y;
    }

    @Override
    public double getMaxHeight() {
        return maxHeight;
    }

    @Override
    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen(){
       if(leftToRight){
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
       }else {
           if(!movedOffScreen){
               if(x<=startPos)
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

    public boolean isLeftToRight() {
        return leftToRight;
    }

    public void setLeftToRight(boolean leftToRight) {
        this.leftToRight = leftToRight;
    }

    public Image getImg1() {
        return img1;
    }

    public void setImg1(Image img1) {
        this.img1 = img1;
    }

    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    @Override
    public void slice(Controller controller) throws InterruptedException {
        sliced = true;
    }
    @Override
    public void update()
    {  if(sliced) {
        controller.score++;
        controller.unregister(this);
    }
    else if(hasMovedOffScreen())
        controller.unregister(this);
    }


    @Override
    public void render(GraphicsContext gc) {
        if (isSliced())
            gc.drawImage(img2, x, y);
        else
            gc.drawImage(img1, x, y);

    }


    @Override
    public void updatePosition(){
        if(x==midPoint){
            falling=true;
        }
        y=720- (a*x*x+a*q*x+a*p);

         if(controller.freezeEffect){
             if(leftToRight){
                 x+=0.5;
             }
             else {
                 x-=0.5;
             }
         }else {
             if(leftToRight){
                 x+=2;
             }
             else {
                 x-=2;
             }
         }
   }
}
