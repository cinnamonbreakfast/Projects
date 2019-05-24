import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class wallMonster2 extends Etaj2_Room1
{
    GifImage monster = new GifImage("objects/wall_monster2.gif");
    public GreenfootImage monsterN = new GreenfootImage("objects/wall_monster2.png");
    public GreenfootSound mistery = new GreenfootSound("objects/monster.mp3");
    
    private long currentTime, currentTime2;
    private long resetTime, replicaTime;
    
    public boolean scared = false;
    
    public void act() 
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
        Etaj23 view1 = (Etaj23)getWorld().getObjects(Etaj23.class).get(0);
        setLocation(getX(), view1.getY()-217);
             
        if(currentTime >= resetTime){
            scared = false;
        }
  
        currentTime = System.currentTimeMillis();
        
        if(player.getCamera()==2 && player.etajCurent==2){
            if(scared == false){
                setImage(monster.getCurrentImage());
                if (Greenfoot.mouseClicked(this)){
                    getWorld().addObject(new Replici(4), player.getX()+70, player.getY()-65);
                    mistery.setVolume(35);
                    mistery.play();
                    scared = true;
                    resetTime = currentTime + 5000;
                }
            } else {
                setImage(monsterN);
            }
        } else {
            setImage(monsterN);
            scared = false;
        }
    }    
    
    public boolean isScared() {
        return scared;
    }
}
