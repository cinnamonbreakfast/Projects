import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class coop_player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class coop_player extends Actors
{
    /**
     * Act - do whatever the coop_player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 5;
    private int sens = 1; // 0=stanga 1=dreapta
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void faceChar(int direction){
        if(direction==3){ // 3= auto
            if(sens==1){ // daca e cu fata in dreapta
                sens=0;
            } else {
                sens=1;
            }
            getImage().mirrorHorizontally();
        } else if(direction==1){
            if(sens==0){ // daca e cu fata in dreapta
                sens=1;
                getImage().mirrorHorizontally();
            }
        } else if(direction==0){
            if(sens==1){ // daca e cu fata in dreapta
                sens=0;
                getImage().mirrorHorizontally();
            }
        }   
    }
    
    public int getFace(){
        return sens;
        
    }
}
