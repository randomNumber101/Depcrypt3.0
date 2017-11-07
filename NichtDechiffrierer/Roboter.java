import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Diese Klasse ist die Oberklasse fuer die Roboter "Robita", "Robson" und "Robby".
 * Programme sollen nur in den Unterklassen
 * implementiert werden, da diese Klasse fuer Java-Beginner sehr komplex ist.
 * Ein Roboter kann sich felderweise in die vier Himmelsrichtungen im Szenario bewegen.
 * Ueber Sensoren kann er Informationen ueber seine Umwelt erhalten.
 */

public class Roboter extends Actor
{
    public Roboter()
    {       
    }
    
    public void act(){
      
       super.act();
    }
    
    
    /**
     * Der Roboter dreht sich um 90 Grad nach rechts (aus der Sicht des Roboters).
     */
    public void dreheRechts()
    {
            this.setRotation((getRotation()+90) % 360);
            Greenfoot.delay(1);
    }


    /**
     * Der Roboter dreht sich um 90 Grad nach links (aus der Sicht des Roboters).
     */
    public void dreheLinks()
    {
            this.setRotation((getRotation()+270) % 360);
            Greenfoot.delay(1);
    }

 

     /**
     * Der Sensor ueberprueft, ob sich der Roboter bewegen kann?
     */
    

     /**
     * Der Sensor ueberprueft, ob der Roboter nach rechts blickt.
     */

    public boolean rechts()
    {
        if(this.getRotation()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean links()
    {
        if(this.getRotation()==180)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean oben()
    {
        if(this.getRotation()==270)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean unten()
    {
        if(this.getRotation()==90)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
      /**
      * Der Sensor ueberprueft, ob auf dem Feld des Roboters ein Akku liegt.
      */
   

      /**
      * Der Sensor ueberprueft, ob sich der Roboter an der Weltgrenze befindet und zur Grenze "blickt".
      */
    public boolean anGrenze()
    {
        if (this.getX()+1>=this.getWorld().getWidth() || this.getX()<=0)
        {return true;}

        if (this.getY()+1>=this.getWorld().getHeight() || this.getY()<=0)
        {return true;}

        return false;

    }



   
     
  
                                      
}
