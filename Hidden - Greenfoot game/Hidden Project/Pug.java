import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.*;

public class Pug extends Actors
{    
    GifImage idle_right = new GifImage("pug/pug_i_r.gif");
    GifImage idle_left = new GifImage("pug/pug_i_l.gif");
    GifImage sit_right = new GifImage("pug/pug_sit_right.gif");
    GifImage sit_left = new GifImage("pug/pug_sit_left.gif");
    
    public GreenfootSound dog1 = new GreenfootSound("pug/dog1.mp3");
    public GreenfootSound dog2 = new GreenfootSound("pug/dog2.mp3");
    public GreenfootSound dog3 = new GreenfootSound("pug/dog3.mp3");
    public GreenfootSound dog4 = new GreenfootSound("pug/dog4.mp3");
        
    public int followPug = 1;
    public long barkTime;
    public long spriteActive, pugSS, pugFS;
    
    private int speed = 5;
    private int sens = 1; // 0=stanga 1=dreapta
    private int setSpriteIndex = 1;
    private long currentTime;
    
    public boolean foundPug=false;

    public void act() 
    {    
        test player = (test) getWorld().getObjects(test.class).get(0);
        
        barkInterval();
        setSprite();
        
        if(foundPug) {
            if(Greenfoot.isKeyDown("E")){
               pugSS = System.currentTimeMillis();
               if(pugSS>=pugFS){
                   if(followPug == 0) {
                       toggleSit(1);
                   }
                   else
                   {
                       toggleSit(0);
                   }
                   pugFS = pugSS+350;
               }
           }
        }
        
        if(followPug==1 && foundPug)
            setPetPos(player.getX(), player.getY(), player.getFace());
    }
    
    public void faceChar(int direction){
        if(direction==3){ // 3= auto
            if(sens==1){ // daca e cu fata in dreapta
                sens=0;
            } else {
                sens=1;
            }
        } else if(direction==1){
            if(sens==0){ // daca e cu fata in dreapta
                setImage(idle_right.getCurrentImage());
                sens=1;
                
            }
        } else if(direction==0){
            if(sens==1){ // daca e cu fata in dreapta
                setImage(idle_left.getCurrentImage());
                sens=0;
            }
        }   
    }
    
    public void setPetPos(int x, int y, int face) {
            if(followPug==1) {
                if(face==0)
                    if(sens==0){
                        if(x<getX()-45){
                            setLocation(x+50, y+60-17);
                        }
                    }
                if(face==1)
                    if(sens==1){
                        if(x>getX()+45){
                            setLocation(x-50, y+60-17);
                        }
                    }
             }
                    
                    
                
            if(face==0) {
                if(sens==1 && x<getX()){ // daca e cu fata in dreapta
                    faceChar(0);
                }
            }
            else if(face==1) {
                if(sens==0 && x>getX()){ // daca e cu fata in dreapta
                    faceChar(1);
                }
            }
    }
 
    
    public int getFace(){
        return sens;
        
    }
    
    public void toggleSit(int tog){
        
        if(tog==0){    
            playASound(4);
            
            setSpriteIndex = 3;
            followPug = 0;
            
            
        } else {
                   playASound(2);
                   
                   setSpriteIndex = 1;
                   followPug = 1;
                }
    }
    
    public void barkInterval(){
        
        if(currentTime>=barkTime){
            int sound = Greenfoot.getRandomNumber(2)+1;
            setSpriteIndex = 2;
            spriteActive=currentTime+300;
            setSprite();
            playASound(sound);
            
            //barkTime = currentTime + toBark;
        }
        
        if(barkTime<currentTime){
            barkTime = currentTime + 13000;
        }
        
        currentTime = System.currentTimeMillis();
    }
    
    public void playASound(int sound){
        /*
         * 1, 2, 3 = latrat
         * 4 = plans
         * 
         */
        dog1.setVolume(30);
        dog2.setVolume(30);
        dog3.setVolume(30);
        dog4.setVolume(30);
        
        if(sound==1)
            dog1.play();
        if(sound==2)
            dog2.play();
        if(sound==3)
            dog3.play();
        if(sound==4)
            dog4.play();
    }
    
    public void setSprite(){
        if(setSpriteIndex==1){ // idle sau basic
            if(sens==0) setImage(idle_left.getCurrentImage());
            else if(sens==1) setImage(idle_right.getCurrentImage());
        }
        
        if(setSpriteIndex==2){ // latrat
            if(followPug==1) {
                if(currentTime>=spriteActive) {
                    setSpriteIndex = 1;
                } else {
                    setImage("pug/pug_bark.png");
                    if(sens==0) getImage().mirrorHorizontally();
                }
            } else {
                if(currentTime>=spriteActive) {
                    setSpriteIndex = 3;
                } else {
                    setImage("pug/pug_sit_bark.png");
                    if(sens==0) getImage().mirrorHorizontally();
                }
            }
        }
        
        if(setSpriteIndex==3){ // sezut
            if(sens==0) { setImage(sit_left.getCurrentImage()); }
            else if(sens==1) setImage(sit_right.getCurrentImage());
        }
    }
   
}
