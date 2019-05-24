import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class test extends Actors
{
    public GreenfootSound pop1 = new GreenfootSound("pop.mp3");
    public GreenfootSound pop2 = new GreenfootSound("plop.mp3");
    
    // Sprites
    GifImage phone_idle_right = new GifImage("phone.gif");
    GifImage phone_idle_left = new GifImage("phone_left.gif");
    GifImage idle_right = new GifImage("idle_right.gif");
    GifImage idle_left = new GifImage("idle_left.gif");
    GifImage walk_right = new GifImage("walk_right.gif");
    GifImage walk_left = new GifImage("walk_left.gif");
    GifImage rest = new GifImage("rest.gif");
    GreenfootImage shocked = new GreenfootImage("shocked.png");
    GifImage sit = new GifImage("sit.gif");

    background bg = (background) getWorld();
    long phoneS;
    long phoneE;
    
    public int cameraCurenta = 1;
    public int etajCurent = 2;
    
    private int rightLimit = 760;
    private int leftLimit = 40;
    private int y = 220;
    private int speed = 5;
    private int sens = 1; // 0=stanga 1=dreapta
    private int psens = 1; // 0=stanga 1=dreapta
    private int run = 0;
    private int followPug = 1;
    private long currentTime, moveTime;
    private boolean onPhone = false;
    private boolean iswalking = false;
    private boolean dor1open = false;
    private boolean dor2open = false;
    public boolean instorymode = false;
    public boolean coboram = false, suntemSus = true;
    public boolean move;
    public int[] keys = new int[5];
    
    int asa;
    
    boolean next = true;
    
    private int storym = 0;
    private int msj = 1;
    
    boolean SB = false;
    boolean SB2 = false;
    boolean nupot = false;
    boolean canmove = true;
    boolean thunder = false;
    
    public void act() 
    {
        dor1 door1 = (dor1)getWorld().getObjects(dor1.class).get(0);
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        background bg = (background) getWorld();
        panou panoul = (panou)getWorld().getObjects(panou.class).get(0);
       
        iswalking = false;
       
        if(dor1open==false){
           door1.getImage().setTransparency(0);
        } else {
           door1.getImage().setTransparency(255);
        }
       
        if(bg.isGameStarted() == true && instorymode==false && !coboram && canmove==true) {
            if(etajCurent==2) y = view1.getY()-80;
            else if(etajCurent==1) y = view1.getY()+218;
           
            if(Greenfoot.isKeyDown("D")){
               if(getX()<rightLimit) {
                        doTheWalk(1);
                }
            }
           
            if(Greenfoot.isKeyDown("A")){
               if(getX()>leftLimit) {
                   doTheWalk(0);
                }
            }
           
            if(Greenfoot.isKeyDown("P")){
               phoneS = System.currentTimeMillis();
               if(phoneS>=phoneE){
                   phoneE = phoneS+150;
                   if(onPhone==false) {
                       onPhone=true;
                       pop1.setVolume(30); pop1.play();
                       getWorld().addObject(new helper(), 400, 300);
                    }
                   else {
                       pop2.setVolume(30); pop1.play();
                       resetCharSprite();
                    }
               }
            }
           
                
            
            if( getX() < 800 && getX() > 720 && etajCurent == 2){
                if(SB==false){
                    getWorld().addObject(new SB(1), 790, 200);
                    SB=true;
                }
                
                if(Greenfoot.isKeyDown("S")) {
                    if(panoul.panouOn==true) {
                        if(etajCurent==2) setLocation(500, view1.getY()+218);
                        faceChar(0);
                    } else {
                        getWorld().addObject(new Replici(5), getX()+70, getY()-65);
                    }
                }
            } else {
                if(SB==true){
                    SB sbp = (SB)getWorld().getObjects(SB.class).get(0);
                    getWorld().removeObject(sbp);
                    SB = false;
                }
            }
                
            if( getX() < 540 && getX() > 490 && etajCurent == 1){
                if(SB2==false){
                    getWorld().addObject(new SB(2), 511, 590);
                    SB2=true;
                }
                
                if(Greenfoot.isKeyDown("W")) {
                    if(panoul.panouOn==true){
                        if(etajCurent==1) setLocation(750, view1.getY()-80);
                        faceChar(1);
                    } else {
                        getWorld().addObject(new Replici(5), getX()+70, getY()-65);
                    }
                }
            } else {
                if(SB2==true){
                    SB sbp = (SB)getWorld().getObjects(SB.class).get(0);
                    getWorld().removeObject(sbp);
                    SB2 = false;
                }
            }
            if(panoul.panouOn==false){
                if( getX() < 800 && getX() > 760 && etajCurent == 2){
                    if(nupot==false){
                        getWorld().addObject(new Replici(5), getX()+70, getY()-65);
                        nupot=true;
                    }
                } else {nupot=false;}
            }

            openPhone();
            
       }
       
       dorsAccess();
       inPat();
       key3();
       
       asa = getCamera();
       
       if(keys[3]==1 && etajCurent == 1) leftLimit = 20;
       else leftLimit = 446;
       if(etajCurent == 2) leftLimit = 20;
    }
    
    public void key3(){
        background bg = (background) getWorld();
        if(getX()>600 && keys[2]==1 && thunder == false){
            getWorld().addObject(new thunder(), 400, 300);
            bg.song1.setVolume(0);
            bg.song1.stop();
            canmove =false;
            thunder = true;
        }
    }
    
    public void walk(){
        if(getFace()==0) setImage(walk_left.getCurrentImage());
        else setImage(walk_right.getCurrentImage());
        
    }
    
    private void doTheWalk(int tasta){
        if(tasta==1){
            if(onPhone) resetCharSprite();
            setLocation(getX()+speed, y);
            iswalking = true; walk();
            faceChar(1);
            
        } else {
            if(onPhone) resetCharSprite();
               setLocation(getX()-speed, y);
               iswalking = true; walk();
               faceChar(0); 
            
        }
    }
    
    private void dorsAccess(){
        if(etajCurent==2) {
            if(dor1open==false && getX()>500) {
               rightLimit = 510;
               if(keys[0]==1){
                   dor1open = true;
                }
            } else {
                rightLimit = 760;
            }
            leftLimit = 40;
        }
        
        /*if(etajCurent==1) {
            if(dor2open==false && getX()>448) {
               leftLimit = 446;
               if(keys[3]==3){
                   dor2open = true;
                   Greenfoot.playSound("plop.mp3");
                }
            } else {
                leftLimit = 40;
                Greenfoot.playSound("dog1.mp3");
            }
            rightLimit = 760;
        }*/
       
       
        if( getWorld().getObjects(foodbox.class).get(0).isKey1Found() ) {
            keys[0]=1;
        }
    }

    private void openPhone(){
        if(onPhone==true){
            if(getFace()==1) {
                setImage(phone_idle_right.getCurrentImage());
                
                
            } else {
                setImage(phone_idle_left.getCurrentImage());
            }
        } else {
           if(iswalking==false){
               if(getFace()==0) {
                    setImage(idle_left.getCurrentImage());
                } else {
                    setImage(idle_right.getCurrentImage()); }
            }
        }
    }
    
    private void resetCharSprite(){
        helper tlf = (helper) getWorld().getObjects(helper.class).get(0);
        getWorld().removeObject(tlf);
        
        onPhone = false;
        if(getFace()==0) {
           setImage(idle_left.getCurrentImage());
        } else
           setImage(idle_right.getCurrentImage());
    }
    
    public void faceChar(int direction){
        if(direction==3){ // 3= auto
            if(sens==1){ // daca e cu fata in dreapta
                setImage(idle_left.getCurrentImage());
                sens=0;
            } else {
                setImage(idle_right.getCurrentImage());
                sens=1;
            }
        } else if(direction==1){
            if(sens==0){ // daca e cu fata in dreapta
                if(iswalking==false)
                    setImage(idle_right.getCurrentImage());
                sens=1;
            }
        } else if(direction==0){
            if(sens==1){ // daca e cu fata in dreapta
                if(iswalking==false)
                    setImage(idle_left.getCurrentImage());
                sens=0;
            }
        }   
    }
    
    public int getCamera() {
        if(instorymode==false) {
            if( getY() >= 300 )
            {
                if( getX() <= 540 ) cameraCurenta = 1;
                else cameraCurenta = 2;
                
                etajCurent = 1;
            }
            else
            {
                if( getX() >= 540) cameraCurenta = 2;
                else cameraCurenta = 1;
                
                etajCurent = 2;
            }
        }
        
        return cameraCurenta;
    }
    
    public int getFace(){
        return sens;
        
    }
    
    public void exitStorymode(){
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        instorymode = false;
        y = view1.getY()-80;
        setLocation(75, y);
        storym = 0;
        

    }
    
    public void storyMode(int mode){
        instorymode = true;
        storym = mode;
    }
    
    public void inPat(){
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        effects effect = (effects)getWorld().getObjects(effects.class).get(0);
        
        if(instorymode==true) {
            if(storym==1){ // intins
                setImage(rest.getCurrentImage());
                y = view1.getY()-98;
                setLocation(75, y);
                effect.addEffect(1);
                
            }
            else if(storym==2){ // socat
                setImage(shocked);
                y = view1.getY()-98;
                setLocation(75, y);
                effect.addEffect(2);
                msjOnce();
            }
            else if(storym==3){ // in fund
                setImage(sit.getCurrentImage());
                y = view1.getY()-84;
                setLocation(89, y);
                effect.addEffect(0);
            }
        }
    }
    
    public void msjOnce(){
        if(next==true) {
            getWorld().addObject(new message(msj), 400, 300);
            next = false;
        }
    }
    
    public void nextMsj(){
        msj++;
        if(msj>4){
            exitStorymode();
            background bg = (background) getWorld();
            bg.nowYouCanMove = true;
        } else {
            getWorld().addObject(new message(msj), 400, 300);
            storyMode(3);
        }
    }
    
}
