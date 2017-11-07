import greenfoot.*;
import java.util.*;


public class Leuchtturm extends Actor
{
    boolean grow = true;
    public Leuchtturm(){
        super();
    }
    public Leuchtturm(boolean grw){
        super();
        grow = false;
    }
    public void act() 
    {
       if(Math.random()>0.5f && grow){
        setLocation(getX(),getY()-1);
        RoboterWelt.instance.addObject(new Leuchtturm(false),getX(),getY()+1);
    }
        
        
    }    
}
