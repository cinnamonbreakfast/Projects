import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stickyread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stickyread extends Actor
{
    public GreenfootSound paper = new GreenfootSound("objects/papere.wav");
    
    int letter;
    
    public stickyread(int l){
        if(l>=0){
            setImage("images/replici/s"+l+".png");
            letter=l;
        }
        setLocation(400, 300);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            paper.setVolume(80);
            paper.play();
            getWorld().removeObject(this);
        }
        
        setLocation(400, 300);
    }
    
    public void showNote(int l){
        letter = l;
        setImage("images/replici/s"+l+".png");
    }
}
