import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Label(String text)
    {
        GreenfootImage img = new GreenfootImage(text.length()*20,90);
        img.drawString(text,2,20);
        setImage(img);
    }
    
    public void setText(String text)
    {
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text,2,20);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            getWorld().removeObject(this);
        }
    }
}
