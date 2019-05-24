import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class mosquitos extends Etaj2_Room1
{
    GifImage mosq = new GifImage("objects/mosquitos.gif");
    
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-206);
        
       setImage(mosq.getCurrentImage());
    }    
}
