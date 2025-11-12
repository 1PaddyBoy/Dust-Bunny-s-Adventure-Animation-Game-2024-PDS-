import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bigplat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bigplat extends advancedGravity
{
    /**
     * Act - do whatever the bigplat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean col = true; // determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
    public bigplat()
    {
        advancedAnimation = false;
        standIMGR = new GreenfootImage("download(6).jpeg");
        jumpIMGR = new GreenfootImage("download(6).jpeg");
        standIMGL = new GreenfootImage("download(6).jpeg");
        jumpIMGL = new GreenfootImage("download(6).jpeg");
        colAdd.add(StickMan2.class);
    }
    public void act()
    {
        actAfterSetUp();
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
            if(fixedVGravity == true)
            {
                gravityNoMove();
            }
            //movingWorld();
        }
        buttonworks();
    }
}
