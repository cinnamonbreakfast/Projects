import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class thunder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class thunder extends Actor
{
    public GreenfootSound thunder1 = new GreenfootSound("ambient/thunder1.mp3");
    public GreenfootSound thunder2 = new GreenfootSound("ambient/thunder2.mp3");
    public GreenfootSound thunder3 = new GreenfootSound("objects/monster.mp3");
    boolean playOnce = false, play = false;
    
    private long currentTime, end;
    private int step = 0;
    
    public thunder(){
        if(playOnce==false){
                thunder1.setVolume(40);
                thunder1.play();
                
                end = currentTime + 500;
                play = true;
                playOnce = true;
            }
        
        
    }
    
    public void act() 
    {
        currentTime = System.currentTimeMillis();
        test player = (test) getWorld().getObjects(test.class).get(0);

        
        if(end<=currentTime && play==true){
            step++;
            if(step==1){
                setImage("level/gh2.png");
                end = currentTime + 100;
            }
            if(step==2){
                setImage("level/gh1.png");
                thunder3.setVolume(30);
                thunder3.play();
                end = currentTime + 1000;
            }
            if(step==3){
                setImage("level/gh2.png");
                end = currentTime + 2000;
            }
            if(step==4){
                setImage("level/gh3.png");
                end = currentTime + 200;
            }
            if(step==5){
                getImage().clear();
                
                player.canmove = true;
                
                end = currentTime + 1000;
            }
            if(step==6){
                dor3 dr = (dor3) getWorld().getObjects(dor3.class).get(0);
                dr.play=true;
                getImage().clear();
                getWorld().addObject(new coop_player(), player.getX()+100, player.getY());
                end = currentTime + 2000;
            }
            if(step==7){
                coop_player cp = (coop_player) getWorld().getObjects(coop_player.class).get(0);
                getWorld().removeObject(cp);
                setImage("level/tc.png");
                dor3 dr = (dor3) getWorld().getObjects(dor3.class).get(0);
            }
        }
    }    
}
