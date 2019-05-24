import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stickyread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class message extends Actor
{
    public GreenfootSound paper = new GreenfootSound("pop.mp3");
    public GreenfootSound plop = new GreenfootSound("dog1.mp3");
    
    int letter;
    long end, current, show;
    boolean played = false;
    
    public message(int l){
        setImage("images/replici/msj"+l+".png");
        
        letter=l;
        
        setLocation(400, 300);
        
        if(played==false) {
            paper.setVolume(30);
            paper.play();
            played = true;
        }
    }
    
    public void act()
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if (Greenfoot.mouseClicked(this)){
            
            player.nextMsj();
            getWorld().removeObject(this);
        }
    }
    
    public void showNote(int l){
        letter = l;
        setImage("images/replici/msj"+l+".png");
    }
}
