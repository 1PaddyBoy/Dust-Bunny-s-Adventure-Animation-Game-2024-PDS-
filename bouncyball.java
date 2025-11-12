import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bouncyball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bouncyball extends advancedGravity
{
    /**
     * Act - do whatever the bouncyball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bouncyball()
    {
        bouncy = true;
        wallbounce = true;
        elasticper = 90;
        conspeed = 3;
        elasticperside = 50;
        bouncefriction = 100;
        spriteSideBounce = true;
        standIMGR = new GreenfootImage("button-blue.png");
        jumpIMGR = new GreenfootImage("button-blue.png");
        standIMGL = new GreenfootImage("button-blue.png");
        jumpIMGL = new GreenfootImage("button-blue.png");
        fixedVGravity = true;
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
        }
        buttonworks();
    }
}
