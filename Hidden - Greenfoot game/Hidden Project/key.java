import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class key extends Cifru
{
    private int j;
    public long currentTime, keyTime;
    public boolean clicked;
    
    public key(int i)
    {
        j=i;
        currentTime = System.currentTimeMillis();
        keyTime = currentTime + 3000;
        if(i==1 || i==2) setImage("UI/"+i+"4.png");
        else if(i==3) setImage("objects/key.png");
    }
    public void act() 
    {
        test player = getWorld().getObjects(test.class).get(0);
        if(j==1 || j==2)
        {
            setLocation(player.getX(), player.getY()-90);
        
            currentTime = System.currentTimeMillis();
            
            if(currentTime >= keyTime) {
                getWorld().removeObject(this);
            }
        }
        else if(j==3)
        {
            if(Greenfoot.mouseClicked(this)) 
            {
                clicked = true;
                keyTime = currentTime + 3000;
            }
            if(clicked){

                setImage("UI/34.png");
                setLocation(player.getX(), player.getY()-90);
            
                currentTime = System.currentTimeMillis();
                
                if(currentTime >= keyTime) {
                    getWorld().removeObject(this);
                }
            }
        }
    }    
}
