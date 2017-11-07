import greenfoot.*;

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bomb(){
        super();  
    }
    
    public void act() 
    {       
        if(getY()<10){
            //hyperrealistische Physikengine  !!
           setLocation(getX(),getY()+1);
        }
        else{
            //erstellt Explosionsobjekt und löscht sich  selbst
            RoboterWelt.instance.addObject(new explosion(),getX(),getY());
            RoboterWelt.instance.removeObject(this);
        }
    }    
}
