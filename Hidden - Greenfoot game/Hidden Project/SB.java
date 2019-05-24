import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SB extends Etaj2_Room1
{
    int a;
    public SB(int s){
        if(s==1) setImage("ss.png");
        else setImage("w.png");
        a=s;
    }
    
    public void act() 
    {
        if(a==1) setImage("ss.png");
        else setImage("w.png");
    }    
}
