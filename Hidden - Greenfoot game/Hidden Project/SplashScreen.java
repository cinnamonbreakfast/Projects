import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SplashScreen extends Roof
{
    GifImage roof = new GifImage("roof.gif");
    
    public void act() 
    {
       setImage(roof.getCurrentImage());
    }    
}
