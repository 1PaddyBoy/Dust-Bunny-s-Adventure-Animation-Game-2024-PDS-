import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class question2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class question2 extends Actor
{
    /**
     * Act - do whatever the question2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    }
}
