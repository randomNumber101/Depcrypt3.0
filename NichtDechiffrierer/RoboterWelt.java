import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *                
 ________________$$$$$
 ______________$$____$$
 ______________$$____$$
 ______________$$____$$
 ______________$$____$$
 ______________$$____$$
 __________$$$$$$____$$$$$$
 ________$$____$$____$$____$$$$
 ________$$____$$____$$____$$__$$
 $$$$$$__$$____$$____$$____$$____$$
 $$____$$$$________________$$____$$
 $$______$$______________________$$
 __$$____$$______________________$$
 ___$$$__$$______________________$$
 ____$$__________________________$$
 _____$$$________________________$$
 ______$$______________________$$$
 _______$$$____________________$$
 ________$$____________________$$
 _________$$$________________$$$
 __________$$________________$$
 __________$$$$$$$$$$$$$$$$$$$$
 *   
 *   Alle Beweise vernichtet! MUHAHAHHAHAHA
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

        for(int i = 0;i< numbers.length;i++){
            showText(""+ numbers[i],i,10);
        }
        showText("Zahl: over 9000",3,7);

        showText("Hier hat wohl jemand  \n sein Unwesen getrieben!", 4,5);

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
        rakete rakete = new rakete();
        addObject(rakete, 0, 5);
        rakete.setLocation(0, 3);
        rakete rakete2 = new rakete();
        addObject(rakete2, 6, 2);
        Leuchtturm leuchtturm2 = new Leuchtturm(false);
        addObject(leuchtturm2, 2, 10);
        Leuchtturm leuchtturm3 = new Leuchtturm();
        addObject(leuchtturm3, 2, 9);
        spawn.setLocation(0, 0);
        Spawn spawn2 = new Spawn();
        addObject(spawn2, 7, 1);
        Goal goal2 = new Goal();
        addObject(goal2, 0, 1);
        Spawn spawn3 = new Spawn();
        addObject(spawn3, 0, 2);
        Spawn spawn4 = new Spawn();
        addObject(spawn4, 0, 4);
        Spawn spawn5 = new Spawn();
        addObject(spawn5, 0, 6);
        Spawn spawn6 = new Spawn();
        addObject(spawn6, 0, 8);
        Spawn spawn7 = new Spawn();
        addObject(spawn7, 7, 7);
        Spawn spawn8 = new Spawn();
        addObject(spawn8, 7, 5);
        Spawn spawn9 = new Spawn();
        addObject(spawn9, 7, 3);
        Goal goal3 = new Goal();
        addObject(goal3, 7, 2);
        Goal goal4 = new Goal();
        addObject(goal4, 7, 4);
        Goal goal5 = new Goal();
        addObject(goal5, 7, 6);
        Goal goal6 = new Goal();
        addObject(goal6, 7, 8);
        Goal goal7 = new Goal();
        addObject(goal7, 0, 7);
        Goal goal8 = new Goal();
        addObject(goal8, 0, 5);
        removeObject(spawn6);
        goal7.act();
        removeObject(goal7);
        removeObject(spawn5);
        removeObject(goal8);
        removeObject(spawn4);
        removeObject(spawn3);
        removeObject(goal6);
        removeObject(spawn7);
        removeObject(goal5);
        removeObject(spawn8);
        removeObject(goal4);
        removeObject(spawn9);
        removeObject(goal3);
        removeObject(spawn2);
        removeObject(goal);
        removeObject(goal2);
        removeObject(spawn);
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
               showText("Zahl: over 9000",3,7);
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
                RoboterWelt.instance.showText("Ergebnis: over 9000",3,7);
                if(i==0)
                    output = ""+result;
                else
                    output+= "." + result;
            } 
            RoboterWelt.iw.setResult(output);          
            }   
       
    }
}