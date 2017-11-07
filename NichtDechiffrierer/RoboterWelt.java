import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *   
 *   ___________________§§§§§§
_____________§§§§__§§__§§_§§§§§§
_____§§__§§_§§__§§_§§§§§§_§§__§§_§§____§§
_____§§__§§_§§§§§§_§§_____§§§§§§__§§__§§
_____§§§§§§_§§__§§_§§_____§§_______§§§§
_____§§__§§_§§__§§________§§________§§
_____§§__§§_________________________§§

_______§§§§§§___§§__§§§§§__§§§§§§_§§__§§
_______§§___§§__§§__§§__§§___§§___§§__§§
_______§§§§§§___§§__§§§§§____§§___§§§§§§
_______§§___§§__§§__§§_§§____§§___§§__§§
_______§§§§§§___§§__§§__§§___§§___§§__§§

__________§§§§§§§__________§§____§§
___________§§___§§___§§§§§__§§__§§
___________§§___§§__§§___§§__§§§§
___________§§___§§__§§§§§§§___§§
__________§§§§§§§___§§___§§___§§
____________________§§___§§
________________¶¶
_______________¶¶¶¶_______________¶¶
______________¶¶S¶¶______¶¶_____¶¶¶¶
_____________¶¶SS¶_____¶¶¶¶____¶¶SS¶
_____________¶¶S¶¶____¶¶SS¶___¶¶SS¶¶
______________¶¶______¶SS¶_____¶SS¶
_____________¶¶¶¶¶_____¶¶_______¶¶
_____________¶__¶¶____¶¶¶¶¶____¶¶¶¶¶
_____________¶__¶¶____¶__¶¶____¶__¶¶
_____________¶__¶_____¶__¶¶____¶__¶¶
_____________¶__¶_____¶__¶¶____¶__¶
_____________¶__¶_____¶__¶_____¶__¶
___________¶¶¶__¶¶¶¶¶¶¶__¶¶¶¶¶¶¶__¶
________¶¶¶¶¶¶__¶11111¶__¶11111¶__¶¶¶¶
______¶¶¶1111¶__¶11111¶__¶11111¶__¶11¶¶¶¶
_____¶¶111$11¶¶¶¶11111¶__¶11111¶¶¶¶11$11¶¶¶
____¶¶111$$$$11111$111¶¶¶¶11$1111111$$$$11¶¶
____¶¶¶¶111$11111$$$$111111$$$$1111111$11¶¶¶
____¶__¶¶¶¶¶¶¶¶1111$111111111$1111111¶¶¶¶¶_¶
___¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶
_¶¶¶¶_____§§________________________§§__¶¶11¶¶
¶¶11¶¶__§§_§§___§§_____§§____§§___§§_§§_¶¶111¶
¶111¶¶¶___§§___§§_§§__§§_§§_§§_§§___§§_¶¶¶111¶
¶1111¶¶¶¶________§§_____§§____§§_____¶¶¶¶111¶¶
¶¶¶¶111¶¶¶¶¶¶¶¶¶¶¶________¶¶¶¶¶¶¶¶¶¶¶¶¶¶11¶¶¶¶
__¶¶¶¶¶11111111¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶11111111¶¶¶
____¶¶¶11111111111111111111111111111111111¶¶
_____¶¶¶¶111¶¶¶¶11111111¶¶11111111¶¶¶¶1111¶¶
______¶¶¶¶¶¶¶¶¶¶¶111¶¶¶¶¶¶¶1111¶¶¶_¶¶¶¶¶¶¶
_______________¶¶¶¶¶¶¶¶___¶¶¶¶¶¶¶¶
 *          
 *          
 *         (Huchala und eujeujeu! Wo ist denn die dechiffrier Methode hin?)
 *         
 *                              ¯\_(?)_/¯     
 *   
 *   
 *   
 *          (Du kannst uns doch sicherlich helfen!)
 *           (Rette die Welt!                      
 *      
 *              (?°?°)?
 *                            
 *   
 */

public class RoboterWelt extends World
{
    
    private Thread t;
    private SyrerRoboter syri;
    public static RoboterWelt instance ;
    private static int zellenGroesse = 50;
    public static InputWindow iw;
    public static int[] numbers = new int[]{2,7,5,11,3,17,13,19};
    public static int result =1;
    public RoboterWelt()
    {
        
        super(8, 11, zellenGroesse);
        instance = this;
        setBackground("images/Bodenplatte.png");
        Greenfoot.setSpeed(15);   

        prepare();
        if(InputWindow.instance == null)
            iw = new InputWindow(this);
    }
    
   
    private void prepare()
    {
                           
        showText("Um zu chiffrieren,  \n den Text in den Input schreiben, \n  auf chiffrieren drücken und  \n die Simulation mit  \" run \" starten! ",3,4);
        for(int i = 0;i< numbers.length;i++){
            showText(""+ numbers[i],i,10);
        }
        showText("Zahl: "+result,3,7);
        
        //Welt bauen:
        Goal goal = new Goal();
        addObject(goal, 10, 0);
        Spawn spawn = new Spawn();
        addObject(spawn, 0, 0);
        
        Haus_klein haus_klein = new Haus_klein();
        addObject(haus_klein, 0, 10);
        Haus_klein haus_klein2 = new Haus_klein();
        addObject(haus_klein2, 1, 10);
        Haus_klein haus_klein3 = new Haus_klein();
        addObject(haus_klein3, 2, 10);
        Haus haus = new Haus();
        addObject(haus, 3, 10);
        Haus haus2 = new Haus();
        addObject(haus2, 4, 10);
        Haus haus3 = new Haus();
        addObject(haus3, 5, 10);
        Haus haus4 = new Haus();
        addObject(haus4, 7, 10);
        Leuchtturm leuchtturm = new Leuchtturm();
        addObject(leuchtturm, 6, 10);
    }
    
    //wird vom JFrame aufgerufen
    public void startEncoding(String code){        
        t = new MyThread(code);
        t.start();      
   }
   
    
    private synchronized int encode(char c){
        result = 1;
        boolean[] bitArray = new boolean[8];
        for(int i = 0; i<8;i++){
            bitArray[i] = getBit((int)c,i);
        }                              
                      
       System.out.println("Erstelle Roboter...");
       if(syri == null){
           syri = new SyrerRoboter(bitArray);
            addObject(syri, 0, 0);
            System.out.println("Auf in den Jihad!!!");
        }
       else{
           //setze den Syrer zurück und gib ihm die neuen Variablen
           syri.setBitArray(bitArray);
            syri.setLocation(0,0);
        }
       addObject(syri, 0, 0);        
       
       //solange der Roboter nicht auf dem letzten Feld ist, lass den t Thread warten
       while(syri.getX()<7){
           try{
               t.wait();
               showText("Zahl: "+result,3,7);
               System.out.println("Not ready");}
           catch(Exception e){}
        }
       return result;       
    }
    
    private boolean getBit(int integer, int spot){
        return ((integer>>spot)&1) == 1;    
    }

    
   public class MyThread extends Thread{
       String code;
       public MyThread(String s){
           code = s;
        }
       public void run(){
             char[] elements = code.toCharArray(); 
            String output = "";         
            for(int i = 0; i<elements.length;i++){
                result = encode(elements[i]);
                RoboterWelt.instance.showText("Ergebnis: "+RoboterWelt.instance.result,3,7);
                if(i==0)
                    output = ""+result;
                else
                    output+= "." + result;
            } 
            RoboterWelt.iw.setResult(output);          
            }   
       
    }
}