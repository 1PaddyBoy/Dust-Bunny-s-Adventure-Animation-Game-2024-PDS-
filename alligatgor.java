import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class alligatgor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class alligatgor extends advancedGravity
{
    /**
     * Act - do whatever the alligatgor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean col = true; // determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
    public alligatgor()
    {
        speedpulls = fixedmove.get(1);
        movesthing = true;
        col = true; // Not utilized as much anymore. determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
        movesthing = true;
        movesthingspeed = fixedmove.get(0);
        standIMGR = new GreenfootImage("alligator.png");
        jumpIMGR = new GreenfootImage("alligator.png");
        standIMGL = new GreenfootImage("alligator.png");
        jumpIMGL = new GreenfootImage("alligator.png");
        advancedAnimation = false;
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
                edge();
                movenear();
                move(fixedmove.get(1));
        }
        buttonworks();
    }
    public void edge()
    {
        if(getX() + 50 >= 750 )
        {
            setLocation​(0, getY());
        }
    }
}
