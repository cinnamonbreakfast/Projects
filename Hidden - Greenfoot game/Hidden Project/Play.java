import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Play extends Roof
{
    GreenfootImage playN = new GreenfootImage("UI/playN.png");
    GreenfootImage playC = new GreenfootImage("UI/playC.png");
    public boolean startgame = false;
    
    public void Play()
    {
        setImage(playN);
    }
    
    public void act() 
    {
        
        if(Greenfoot.mouseClicked(this))
            {
                startgame = true;
                setImage(playC);
            }
    }
    
    public boolean getStartGame()
    {
        return startgame;
    }
}
