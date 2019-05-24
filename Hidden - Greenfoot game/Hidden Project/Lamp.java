import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lamp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lamp extends Etaj2_Room1
{
    
    public boolean open = false;
    
    public GreenfootSound lamp_on = new GreenfootSound("objects/lamp_on.wav");
    public GreenfootSound lamp_off = new GreenfootSound("objects/lamp_off.wav");
    
    public void act() 
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-82);
        
        if (Greenfoot.mouseClicked(this)){
            if(player.getX()>=180 && player.getX()<=330) {
                if(open==false){
                    setImage("objects/lamp_open.png");
                    lamp_on.setVolume(80);
                    lamp_on.play();
                    open=true;
                } else {
                    setImage("objects/lampa.png"); 
                    lamp_off.setVolume(80);
                    lamp_off.play();
                    open=false;
                }
            }
        }
    }  
}
