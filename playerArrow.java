import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerArrow extends advancedGravity
{
    /**
     * Act - do whatever the arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Jake: The player arrow object. It doesn't do anything on its own
    int speed = 1;
    
    public playerArrow (String image, String soundArrow, int type)
    {
        GreenfootImage currImage = new GreenfootImage("g"+image+"arrow.PNG");  
        currImage.scale(50, 50);
        setImage(currImage);
    }
    
    public playerArrow()
    {    
        GreenfootImage image = getImage();  
        image.scale(50, 50);
        setImage(image);
    }
    
    public void act()
    {
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
        long curTime  = System.currentTimeMillis();
        }
    }
    
}
