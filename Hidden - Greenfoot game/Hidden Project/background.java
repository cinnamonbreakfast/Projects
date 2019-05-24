import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.*;

public class background extends World
{   
    public GreenfootSound song1 = new GreenfootSound("ambient/neutral2.mp3");
    public GreenfootSound rain = new GreenfootSound("ambient/rain.mp3");
    public GreenfootSound crack = new GreenfootSound("cave3cut.mp3");
    
    public GreenfootImage imgspate = new GreenfootImage("level/lev12.jpg");
    public GreenfootImage cursorImage = new GreenfootImage("32x32.png");
    
    public 
    
    test player = new test();
    Pug pug = new Pug();
    effects effect = new effects();
    SplashScreen roof = new SplashScreen();
    //Options options = new Options();
    Play play = new Play();
    //Rain rainRoof = new Rain();
    Etaj23 lvl = new Etaj23();
    
    Cursor customCursor;
    JPanel panel;
    
    public boolean startGame = false;
    public long currentTime;
    public boolean nowYouCanMove = false;
    private long nextStoryMode;
    
    private int x = 255;
    private long transpTime = 5000;
    boolean mmSpawned = false;
    boolean cursorCreated = false;
    boolean rainRemoved = false;
    boolean objMoved = false;
    boolean storyStart = true;
    boolean alreadyDoneThis = false;
    
    private int storyM = 1;
    
    public background()
    {    
        super(800, 600, 1); 

        getBackground().setColor(Color.BLACK);
        getBackground().fillRect(0, 0, 800, 600);
        
    }
    
    public void act()
    {
        enableCustomCursor();
        
        if(play.getStartGame() == false)
            {
                if(mmSpawned == false)
                {
                    mainMenu();
                    mmSpawned = true;   
                }
            }
        else {
                if(objMoved == false)
                {
                    crack.setVolume(60);
                    crack.play();
                    super.removeObject(play);
                    //super.removeObject(options);
                    objMoved = true;
             }
        }
        
        if(objMoved==true) {
            if(lvl.getY()>300){
                lvl.setLocation(lvl.getX(), lvl.getY()-2);
                roof.setLocation(roof.getX(), roof.getY()-2);
            } else getStarted();
        }
        
        if(nextStoryMode <= currentTime && storyStart == false && storyM==1){
            player.storyMode(2); storyM = 3;
        }
        
        /*
         * 
         * else if(storyM==3){
                    nextStoryMode = currentTime + 7500;
                }
            } else if(storyM==4) {
                storyM = 0;
                player.exitStorymode();
            }
         */
        
        ExitingStoryMode();
        
        currentTime = System.currentTimeMillis();
    }
    
    public void mainMenu()
    {
        getBackground().clear();
        
        super.addObject(roof, 400, 300);
        super.addObject(lvl, 400, 600);
        super.addObject(play, 398, 185);
        //super.addObject(options, 401, 240);

        super.addObject(new Lamp(), 273, 0);
        super.addObject(new Dulap(), 335, 0);
        super.addObject(new box(), 394, 0);
        super.addObject(new mosquitos(), 268, 0);
        super.addObject(new wallMonster(), 386, 0);
        super.addObject(new book(), 344, 0);
        super.addObject(new pahar(), 318, 0);
        super.addObject(new jacket(), 424, 0);
        super.addObject(new poster(), 137, 0);
        super.addObject(new pantofiR(), 389, 0);
        super.addObject(new foodbox(), 344, 0);
        super.addObject(new dor1(), 506, 0);
        super.addObject(new wallMonster2(), 697, 0);
        super.addObject(new perna(), 55, 0);
        super.addObject(new stickynote(2, 360, 160, 1), 0, 0);
        super.addObject(new stickynote(3, 100, 150, 2), 0, 0);
        super.addObject(new stickynote(3, 232, 224, 3), 0, 0);
        super.addObject(new panou(), 678, 0);
        super.addObject(new stickynote(3, 676, 168, 4), 0, 0);
        super.addObject(new tablou(), 669, 0);
        
        super.addObject(new Fireplace(), 210, 446);
        super.addObject(new Trophy(), 210, 380);
        super.addObject(new Scaun(), 100, 542);
        super.addObject(new Pickup(), 330, 543);
        super.addObject(new Disc(), 470, 570);
        super.addObject(new dor3(), 470+260, 430+75);
        
        getObjects(Fireplace.class).get(0).getImage().setTransparency(0);
        getObjects(Trophy.class).get(0).getImage().setTransparency(0);
        getObjects(Scaun.class).get(0).getImage().setTransparency(0);
        getObjects(Pickup.class).get(0).getImage().setTransparency(0);
        getObjects(Disc.class).get(0).getImage().setTransparency(0);
        getObjects(dor3.class).get(0).getImage().setTransparency(0);
        
        super.addObject(new FakeBezna(), 400, 0);
        super.addObject(new Bezna(1), 665, 0);
        
        player.storyMode(storyM);
        super.addObject(player, 75, lvl.getY()-100);
        player.keys[1]=0;
        super.addObject(effect, 0, 0);
        
        //super.addObject(pug, 80, 263);
        
        song1.setVolume(20);
        rain.setVolume(40);
       // song1.play();
        rain.playLoop();
    }
    
    public void getStarted()
    {
        if(storyStart==true){
            nextStoryMode = System.currentTimeMillis() + 1500;
            storyStart = false;
        }
    }
    
    public void ExitingStoryMode()
    {
        if(nowYouCanMove && !alreadyDoneThis)
        {
            Bezna bzn = (Bezna) getObjects(Bezna.class).get(0);
            int bznX = bzn.getX();
            int bznY = bzn.getY();
            
            getObjects(Fireplace.class).get(0).getImage().setTransparency(255);
            getObjects(Trophy.class).get(0).getImage().setTransparency(255);
            getObjects(Scaun.class).get(0).getImage().setTransparency(255);
            getObjects(Pickup.class).get(0).getImage().setTransparency(255);
            getObjects(Disc.class).get(0).getImage().setTransparency(255);
            getObjects(dor3.class).get(0).getImage().setTransparency(255);
            
            super.removeObject(bzn);
            super.addObject(new Stairs(), 640, 412);
            super.addObject(new Bezna(1), bznX, bznY);
            
            FakeBezna fkbzn = (FakeBezna) getObjects(FakeBezna.class).get(0);
            super.removeObject(fkbzn);
            super.addObject(new Bezna(2), 610, 438);
            super.addObject(new Bezna(3), 210, 444);
            
            getObjects(Bezna.class).get(0).getImage().setTransparency(200);
            getObjects(Bezna.class).get(1).getImage().setTransparency(200);
            getObjects(Bezna.class).get(2).getImage().setTransparency(200);
            
            alreadyDoneThis = true;
        }
    }
    public boolean isGameStarted() {
        return nowYouCanMove;
    }
    
    public void enableCustomCursor(){
        panel = WorldHandler.getInstance().getWorld();
        panel = WorldHandler.getInstance().
        Point cursorHotSpot = new Point(0,0);
        if(!cursorCreated) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            panel = WorldHandler.getInstance().getWorld();
            
            customCursor = toolkit.createCustomCursor(cursorImage.getAwtImage(), cursorHotSpot, "Cursor");
            cursorCreated = true;
        }
        panel.setCursor(customCursor);
    }
}


