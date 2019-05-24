import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class pantofiR extends Etaj2_Room1
{

    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        background bg = (background) getWorld();
        
        if( !bg.nowYouCanMove ) 
            setLocation(getX(), view1.getY()-51);
        
    }    
}
