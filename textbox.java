import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class textbox extends advancedGravity
{
    /**
     * Act - do whatever the textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            getWorld().removeObject(this);
        }
    }
}
