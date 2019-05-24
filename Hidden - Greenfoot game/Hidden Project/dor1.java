import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class dor1 extends Etaj2_Room1
{

    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-90);
    }    
}
