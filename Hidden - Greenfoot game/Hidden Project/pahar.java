import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pahar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pahar extends Etaj2_Room1
{
    public GreenfootSound pahar = new GreenfootSound("objects/pahar.wav");
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-81);
        
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if (Greenfoot.mouseClicked(this)){
            if(player.getX()>=getX()-100 && player.getX()<=getX()+100) {
                pahar.setVolume(80);
                pahar.play();
            }
        }
    }      
}
