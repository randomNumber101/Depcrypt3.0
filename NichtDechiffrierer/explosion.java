import greenfoot.*;


public class explosion extends Actor
{
    public void act() 
    {
        //l�scht sich selbst im n�chsten Schritt
       RoboterWelt.instance.removeObject(this);
    }    
}
