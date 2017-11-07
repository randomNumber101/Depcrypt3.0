import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Haus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haus extends Actor
{
    
    public void act() 
    {
        Random random = new Random();
        if(Math.random()>0.3f){
            setLocation(random.nextInt(8),random.nextInt(11));
        }
    }    
}
