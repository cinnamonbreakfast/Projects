import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

public class Bezna extends Etaj2_Room2
{
    public int j;
    
    public Bezna(int i)
    {
        j=i;
        switch(i)
        {
            case 1: setImage("level/bn1.png"); break;
            case 2: setImage("level/bn2.png"); break; 
            case 3: setImage("level/bn3.png"); break;
        }
        
    }
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        
        if(j==1) setLocation(getX(), view1.getY()-154);
        /*switch(j)
        {
            case 1: setLocation(getX(), view1.getY()-154); break;
            case 2: setLocation(getX(), view1.getY()+100); break;
            case 3: setLocation(getX(), view1.getY()+300); break;
        }*/
    }    
}
