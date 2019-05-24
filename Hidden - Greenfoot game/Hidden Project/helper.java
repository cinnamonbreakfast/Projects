import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class helper extends Actor
{
    
    boolean once = false;
    int rand = 0;
    int p;
    
    public void act() 
    {
        test player = (test) getWorld().getObjects(test.class).get(0);
        panou panoul = (panou)getWorld().getObjects(panou.class).get(0);
        
        p = player.getCamera();
        
        if(player.etajCurent == 2){
            if(player.keys[3]==0)
                setImage("replici/h7.png");
                else setImage("replici/h0.png");
        }
        
        if(player.getCamera()==1 && player.etajCurent == 2){
            if(once==false){
                setImage("replici/h"+Greenfoot.getRandomNumber(3)+".png");
                once = true;
            }
            
            if (Greenfoot.mouseClicked(this)){
                setImage("replici/h"+Greenfoot.getRandomNumber(3)+".png");
            }
        }
        
        
        
        if(player.getCamera()==2 && player.etajCurent == 2){
            rand = Greenfoot.getRandomNumber(1);
            if(once==false && panoul.panouOn==false){
                if(rand==0)
                setImage("replici/h5.png");
                once = true;
            } 
            if(panoul.panouOn==false){
                setImage("replici/h0.png");
            }
            
            if (Greenfoot.mouseClicked(this)){
                rand = Greenfoot.getRandomNumber(1);
                if(rand==1)
                setImage("replici/h0.png");
            }
        }
        
        
        
        if(player.etajCurent == 1){
            if(player.keys[3]==0)
                setImage("replici/h7.png");
                else setImage("replici/h0.png");
        }
    }    
}
