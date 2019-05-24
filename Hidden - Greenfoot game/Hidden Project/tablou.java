import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class tablou extends Etaj2_Room1
{
    boolean tabl = false;
    public GreenfootSound snd = new GreenfootSound("objects/perna.mp3");
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        background bg = (background) getWorld();
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        if(tabl==false)
            setLocation(getX(), view1.getY()-144);
            
        if (bg.isGameStarted() == true && Greenfoot.mouseClicked(this)){
            if(player.getX()>=getX()-100 && player.getX()<=getX()+100) {
                if(tabl==false) {
                    setImage("images/objects/painting2.png");
                    setLocation(getX()-62, getY()+24);
                    snd.setVolume(80);
                    snd.play();
                    tabl = true;
                } else {
                    
                    setImage("images/objects/painting.png");
                    setLocation(getX()+62, view1.getY()-144);
                    snd.setVolume(80);
                    snd.play();
                    tabl = false;
                    
                }
            }
        }
    }    
}
