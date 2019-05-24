import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Replici extends Actor
{
    public long currentTime, replicaTime;
    public int re;
    
    public Replici(int r)
    {
        currentTime = System.currentTimeMillis();
        replicaTime = currentTime + 3000;
        re=r;
        
        if( r <= 4 )
            switch( Greenfoot.getRandomNumber(r) )
            {
                case 1: setImage("replici/ciudat.png"); break;
                case 2: setImage("replici/ce.png"); break;
                case 3: setImage("replici/hmm.png"); break;
                case 4: setImage("replici/ok.png"); break;
            }
        if(r==5) setImage("replici/int.png");
    }
    
    public void act() 
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
    
        if(currentTime >= replicaTime) {
            getWorld().removeObject(this);
        }
        currentTime = System.currentTimeMillis();
        if(re<=4)
            setLocation( player.getX()+70, player.getY()-65 );
        if(re==5) setLocation( player.getX()-110, player.getY()-65 );
    }    
}
