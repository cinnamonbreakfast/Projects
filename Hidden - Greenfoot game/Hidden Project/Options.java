import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Options extends Roof
{
    GreenfootImage optionsN = new GreenfootImage("UI/optionsN.png");
    GreenfootImage optionsC = new GreenfootImage("UI/optionsC.png");
    public boolean options = false;
    
    public void Options()
    {
        setImage(optionsN);
    }
    
    public void act() 
    {
        
        if(Greenfoot.mouseClicked(this))
            {
                options = true;
                setImage(optionsC);
            }
    }    
    
    public boolean getOptions()
    {
        return options;
    }
}
