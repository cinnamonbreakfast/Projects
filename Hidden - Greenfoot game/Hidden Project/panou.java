import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class panou extends Etaj2_Room1
{
    public GreenfootSound pahar = new GreenfootSound("objects/ignite.mp3");
    
    public boolean panouOn = false;
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-150);
        
        background bg = (background) getWorld();
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if (bg.isGameStarted() == true && Greenfoot.mouseClicked(this)){
            if(player.getX()>=getX()-100 && player.getX()<=getX()+100 && panouOn == false) {
                setImage("images/objects/panou_on.png");
                pahar.setVolume(80);
                pahar.play();
                panouOn = true;
                //bezna 2 down -> 
                Bezna bzn = (Bezna) getWorld().getObjects(Bezna.class).get(0);
                getWorld().removeObject(bzn);
            }
        }
    }    
}
