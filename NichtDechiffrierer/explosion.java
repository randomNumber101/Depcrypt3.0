import greenfoot.*;


public class explosion extends Actor
{
    public void act() 
    {
        //löscht sich selbst im nächsten Schritt
       RoboterWelt.instance.removeObject(this);
    }    
}
