import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Numar extends Cifru
{
    public int i = 0;
    
    public Numar(int j)
    {
        setImage("UI/locknum/"+j+".png");
        i=j;
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && !getWorld().getObjects(foodbox.class).get(0).isKey1Found())
        {
            if(i>=9) i=0;
            else i++;
            setImage("UI/locknum/"+i+".png");
            
        }
    }
    public int getNumar() {
        return i;
    }
}
