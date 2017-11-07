import greenfoot.*;
/**
 * Write a description of class rakete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rakete extends Actor
{
    /**
     * Act - do whatever the rakete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getRotation() == 0){
            if(getX()<7){
                if(getRotation() == 0)
                setLocation(getX()+1,getY());                           
            }
            else{            
                setLocation(0,getY());
            }}
        else{
            if(getX()>0){
                if(getRotation() == 0)
                setLocation(getX()-1,getY());                           
            }
            else{            
                setLocation(7,getY());
            }}
        if(Math.random()>0.8f){    
            dropBomb();
        }
    }
       public void dropBomb(){ //ALAHU AKBAR!!!!
        getWorld().addObject(new Bomb(), getX(), getY()+1);
    } 
        
    }    

