import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Disc extends Etaj2_Room2
{
    
    private long currentTime, discTime;
    public boolean discLuat = false;
    
    public void act() 
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        
        if(Greenfoot.mouseClicked(this))
            if(player.getX() >= getX()-150 && player.getX() <= getX()+150 && !discLuat)
            {
                currentTime = System.currentTimeMillis();
                discTime = currentTime + 3000;
                setLocation(player.getX(), player.getY()-90);
                discLuat = true;
                getWorld().getObjects(Pickup.class).get(0).areDisc = true;
            }
        if(discLuat)
        {
            if(currentTime >= discTime) {
                getWorld().removeObject(this);
            }
            currentTime = System.currentTimeMillis();
            setLocation(player.getX(), player.getY()-90);
        } 
    }    
}