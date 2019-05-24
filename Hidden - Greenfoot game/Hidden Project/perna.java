import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class perna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class perna extends Etaj2_Room1
{
    public GreenfootSound perna = new GreenfootSound("objects/perna.mp3");
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-72);
        
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if (Greenfoot.mouseClicked(this)){
            if(player.getX()<=120)
                perna.setVolume(40);
                perna.play();
        }
    }    
}
