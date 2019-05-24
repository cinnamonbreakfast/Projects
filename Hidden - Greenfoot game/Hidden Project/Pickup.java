import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pickup extends Etaj2_Room2
{
    GreenfootSound melodie = new GreenfootSound("ambient/piano1.mp3");
    GifImage trpy = new GifImage("objects/trpy.gif");
    
    public boolean areDisc = false, pornesteGif = false, apasat = false;
    public long currentTime, startTimer;
    private boolean once = false;
    
    public Pickup()
    {
        setImage("objects/pickup.png");
    }
    
    public void act() 
    {
        Trophy trp = (Trophy) getWorld().getObjects(Trophy.class).get(0);
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if(Greenfoot.mouseClicked(this))
            if(areDisc)
            {
                setImage("objects/pickup_disk.png");
                trp.setImage("objects/trpy.gif");
                pornesteGif = true;
                apasat = true;
                melodie.setVolume(60);
                melodie.play();
                currentTime = System.currentTimeMillis();
                startTimer = currentTime + 4000;
            }
            
        if(pornesteGif) trp.setImage(trpy.getCurrentImage());
        
        if(areDisc && apasat) {
            currentTime = System.currentTimeMillis();
            if(currentTime > startTimer)
            {
                trp.setImage("objects/trophyM.png");
                player.keys[2]=1;
                if(once==false) {
                    getWorld().addObject(new key(3), 210, 400); once =true; }
            }
        }    
    }
}