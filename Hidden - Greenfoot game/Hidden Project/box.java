import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class box extends Etaj2_Room1
{
    private boolean cutieDeschisa = false, doneAlready = false;
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        background bg = (background) getWorld();
        
        if( !bg.nowYouCanMove ) setLocation(getX(), view1.getY()-34);
        
        test player = (test) getWorld().getObjects(test.class).get(0);
        panou panou = (panou) getWorld().getObjects(panou.class).get(0);
        pantofiR ptf = (pantofiR) getWorld().getObjects(pantofiR.class).get(0);
        
        if( Greenfoot.mouseClicked(this) && panou.panouOn && player.getX() >= getX()-150 && player.getX() <= getX()+150)
            if( !cutieDeschisa )
            {
                if( player.keys[3]==0 && !doneAlready) 
                {
                    player.keys[3]=1;
                    getWorld().addObject(new key(2), player.getX(), player.getY()-90);
                    //Bezna 3 down -> Next Release
                    Bezna bzn = (Bezna) getWorld().getObjects(Bezna.class).get(0);
                    getWorld().removeObject(bzn);
                    doneAlready = true;
                }
                ptf.setLocation( ptf.getX()+40, ptf.getY()+28);
                setImage("objects/box_open.png");
                cutieDeschisa = true;
            }
            else
            {
                ptf.setLocation( ptf.getX()-40, ptf.getY()-28);
                setImage("objects/cutie.png");
                cutieDeschisa = false;
            }
    }    
}
