import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Haus_klein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haus_klein extends Actor
{
    /**
     * Act - do whatever the Haus_klein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Random random = new Random();
        if(Math.random()>0.7f){
            setLocation(random.nextInt(8),random.nextInt(11));
        }
    }    
}
