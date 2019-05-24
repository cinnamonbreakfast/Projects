import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
public class foodbox extends Etaj2_Room1
{
    public boolean lookingAtLock = false, stickyNoteRead = false, keyFound = false;
    public int mx, my;
    public int[] cifre = new int[3];
    
    public foodbox()
    {
        cifre[0]=5; cifre[1]=1; cifre[2]=7;
    }
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-89);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mouseClicked(this) && lookingAtLock == false && stickyNoteRead == false)
            deschideLacatFaraNumere();
        if(Greenfoot.mouseClicked(this) && lookingAtLock == false && stickyNoteRead == true)
            deschideLacatCuNumere();
            
        if(lookingAtLock == true) {
            if(stickyNoteRead) {
                if(getWorld().getObjects(Numar.class).get(0).getNumar() == 3 &&
                   getWorld().getObjects(Numar.class).get(1).getNumar() == 3 &&
                   getWorld().getObjects(Numar.class).get(2).getNumar() == 0) 
                {
                      getWorld().getObjects(Lacat.class).get(0).setImage("UI/lock_open.png");
                      keyFound = true;
                }
            }
            InchideLacat();
        }
                                
        if(Greenfoot.mouseClicked(getWorld().getObjects(stickynote.class).get(2)))
        {
            stickyNoteRead = true;
        }
        
    }
    
    public void deschideLacatFaraNumere()
    {
        getWorld().addObject(new Lacat(), 400, 300);
        getWorld().getObjects(Lacat.class).get(0).setImage("UI/locked.png");
        lookingAtLock = true;
    }
    
    public void deschideLacatCuNumere()
    {
        getWorld().addObject(new Lacat(), 400, 300);
        getWorld().addObject(new Numar(cifre[0]), 370, 384);
        getWorld().addObject(new Numar(cifre[1]), 402, 384);
        getWorld().addObject(new Numar(cifre[2]), 434, 384);
            
        getWorld().getObjects(Lacat.class).get(0).setImage("UI/lock.png");
        lookingAtLock = true;
    }

    public void InchideLacat()
    { 
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null) { mx = mouse.getX(); my = mouse.getY(); }
        
        if(lookingAtLock == true) 
        {
            Lacat lock = (Lacat) getWorld().getObjects(Lacat.class).get(0);
            if(Greenfoot.mouseClicked(lock)) 
            {
                if( mx<lock.getX()-100 || mx>lock.getX()+100 || my<lock.getY()-150 || my>lock.getY()+150)
                {   
                    if(keyFound)
                    {
                        test player = getWorld().getObjects(test.class).get(0);
                        getWorld().addObject(new key(1), player.getX(), player.getY()-90);
                        //Bezna 2 down -> panou
                        Bezna bzn = (Bezna) getWorld().getObjects(Bezna.class).get(0);
                        getWorld().removeObject(bzn);
                    }
                    if(stickyNoteRead)
                    {
                        cifre[0]=getWorld().getObjects(Numar.class).get(0).getNumar();
                        cifre[1]=getWorld().getObjects(Numar.class).get(1).getNumar();
                        cifre[2]=getWorld().getObjects(Numar.class).get(2).getNumar();
                        Numar nr0 = (Numar)getWorld().getObjects(Numar.class).get(0);
                        getWorld().removeObject(nr0);
                        Numar nr1 = (Numar)getWorld().getObjects(Numar.class).get(0);
                        getWorld().removeObject(nr1);
                        Numar nr2 = (Numar)getWorld().getObjects(Numar.class).get(0);
                        getWorld().removeObject(nr2);
                    }
                    getWorld().removeObject(lock);
                    lookingAtLock = false;
                }
            }
        }
    }
        
    public boolean isLookingAtLock() {
        return lookingAtLock;
    }
    
    public boolean isKey1Found() {
        return keyFound;
    }
    
}
