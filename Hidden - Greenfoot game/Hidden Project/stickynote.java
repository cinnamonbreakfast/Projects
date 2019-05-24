import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class stickynote extends Etaj2_Room2
{
    GreenfootImage st1 = new GreenfootImage("images/objects/sticky note.png");
    GreenfootImage st2 = new GreenfootImage("images/objects/sticky note2.png");
    GreenfootImage st3 = new GreenfootImage("images/objects/sticky note3.png");
    
    public GreenfootSound paper = new GreenfootSound("objects/paper.mp3");
    
    int x;
    int y;
    int letter;
    
    public stickynote(int img, int posx, int posy, int l){
        if(img==1) setImage(st1);
        if(img==2) setImage(st2);
        if(img==3) setImage(st3);
        
        x = posx; y = posy; letter = l;
    }
    
    
    public void act() 
    {
        Etaj23 view1 = (Etaj23) getWorld().getObjects(Etaj23.class).get(0);
        test player = (test) getWorld().getObjects(test.class).get(0);
        setLocation(x, view1.getY()-300+y);
        
        if (Greenfoot.mouseClicked(this)){
            if(player.getX()>=getX()-100 && player.getX()<=getX()+100) {
                paper.setVolume(40);
                paper.play();
                
                getWorld().addObject(new stickyread(letter), 400, 300);
                //getWorld().removeObject(this);
            }
        }
    }    
}
