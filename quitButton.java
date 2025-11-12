import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class quitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quitButton extends Actor
{
    /**
     * Act - do whatever the quitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        isClicked();
    }
    public void isClicked()
    {
    if(Greenfoot.isKeyDown("q"))
        {
            MyWorld.stage = 0;
        }
    }
}
