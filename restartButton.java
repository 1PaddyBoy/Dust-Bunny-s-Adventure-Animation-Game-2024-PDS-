import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class restartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class restartButton extends Actor
{
    /**
     * Act - do whatever the restartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    isClicked();
    }
    
    public void isClicked()
    {
    if(Greenfoot.isKeyDown("r"))
        {
            MyWorld.stage = 1;
        }
    }
}
