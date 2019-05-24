import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dor3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dor3 extends Etaj2_Room2
{
    boolean play = false;
    GifImage dr = new GifImage("objects/dore2.gif");
    public void act() 
    {
        if(play==true){
            setImage(dr.getCurrentImage());
        }
    }    
}
