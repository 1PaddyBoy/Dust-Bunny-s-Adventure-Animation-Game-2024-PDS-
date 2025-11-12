import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class deathBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deathBall extends advancedGravity
{
    /**
     * Act - do whatever the deathBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean firstAfter = false;
    public deathBall()
    {
        bouncy = true;
        wallbounce = true;
        elasticper = 90;
        conspeed = 3;
        elasticperside = 50;
        bouncefriction = 100;
        spriteSideBounce = true;
        standIMGR = new GreenfootImage("button-red.png");
        jumpIMGR = new GreenfootImage("button-red.png");
        standIMGL = new GreenfootImage("button-red.png");
        jumpIMGL = new GreenfootImage("button-red.png");
        fixedVGravity = true;
        advancedAnimation = false;
        movewidth = true;
        moveWOffX = 0;
        moveWOffy = -100;
        moveWMspeed = 0;
    }
    public void act()
    {
        if(firstAfter == false)
        {
            firstAfter = true;
            movedwidth.addAll(getWorld().getObjects(StickMan2.class));
            for(int i = 0; i < 1000; i++)
            {
                System.out.println("startmovedwidth");
            }
            for(int i = 0; i < movedwidth.size();i++)
            {
                System.out.println(movedwidth.get(i));
            }
        }
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
