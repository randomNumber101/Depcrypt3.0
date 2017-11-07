import greenfoot.*;

/**
 * Write a description of class SyrerRoboter here.
 * 
 * @author  Isis
 * @version 9/11
 */
public class SyrerRoboter extends Roboter
{
   
    boolean[] ba;
    public SyrerRoboter(boolean[] bitarray){
        ba = bitarray;
    }
    
    public void act()       //wird jeden Tick aufgerufen
    {
       if(ba[getX()]){
           RoboterWelt.result= RoboterWelt.result*RoboterWelt.numbers[getX()];
           dropBomb();
       }
       setLocation(getX()+1,getY()); 
    }   
    
    public void dropBomb(){ //ALAHU AKBAR!!!!
        getWorld().addObject(new Bomb(), getX(), getY()+1);
    }
    
    public void setBitArray(boolean[] bitarray){
        ba = bitarray;
    }
}
