import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class jacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jacket extends Etaj2_Room1
{
    /**
     * Act - do whatever the jacket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-100);
    }    
}
