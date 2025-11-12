import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bunny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bunny extends advancedGravity
{
    /**
     * Act - do whatever the bunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //Ankith: just a bunny
    }
    public bunny()
    {
        //Ankith: scaling the image
        GreenfootImage image = new GreenfootImage("bunny.png");  
        image.scale(300, 150);
        setImage(image);
    }
}
