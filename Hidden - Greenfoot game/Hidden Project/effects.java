import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class effects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class effects extends Actors
{
    GifImage rest = new GifImage("messages_effects.gif");
    GifImage shocked = new GifImage("shock_effect.gif");
    
    int effect = 0;
    
    public void act() 
    {
        test player = (test)getWorld().getObjects(test.class).get(0);
        
        if(effect == 0){
            getImage().clear();
        }
        if(effect == 1){
            setImage(rest.getCurrentImage());
            setLocation(player.getX()+10, player.getY()-40);
        }
        else if(effect == 2){
            setImage(shocked.getCurrentImage());
            setLocation(player.getX()-30, player.getY()-50);
        }
    }
    
    public void addEffect(int eff){
        effect = eff;
        
    }
}
