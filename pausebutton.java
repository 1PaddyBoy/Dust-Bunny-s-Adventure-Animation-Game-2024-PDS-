import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pausebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pausebutton extends Buttons
{
    /**
     * Act - do whatever the pausebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //explanation for most in infinate button 
    public pausebutton()
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        
        //for dumb 
        advancedAnimation = false;
        
        
    }
    public void act()
    {
        buttonworks();
        function();
        movS();
    }
    public void movS()
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
    public void function()
    {
        // in this case starts pause screen
        if(function == true)
        {
            MyWorld myworld = (MyWorld)getWorld();
            function = false;
            //below switches between unpauseing and pauseing as well as changing the image for when either is.
            if(myworld.paused == false)
            {
                myworld.pausescreen();
                button_1 = new GreenfootImage("playsmall.png");
                button_2 = new GreenfootImage("playpic.png");
            }else if(myworld.paused == true)
            {
                myworld.unpausescreen();
                button_1 = new GreenfootImage("pausesmall.png");
                button_2 = new GreenfootImage("pausetrans.png");
                //bloodstream.running = true;
            }
        }
    }
}
