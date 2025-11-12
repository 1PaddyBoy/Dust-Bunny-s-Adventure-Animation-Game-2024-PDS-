import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dog extends advancedGravity
{
    /**
     * Act - do whatever the dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Gspecialactafter()
    {
        getImage().scale( (int) (( ((double)getY()/500) + 3)/4 * getImage().getWidth()),(int) (( ((double)getY()/500) + 3)/4 * getImage().getHeight()));
        super.specialactafter();
    }
    boolean actAfterstuff = true;
    public void asdfer()
    {
        if(actAfterstuff == true)
        {
            Gspecialactafter();
            actAfterstuff = false;
        }
    }
    public void act()
    {
        actAfterSetUp();
        asdfer();
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
            //System.out.println(fixedVGravity);
            if(fixedVGravity == true)
            {
                //System.out.println("dog conspeed move attempt");
                gravityNoMove();
            }
            setLocation(getExactX() + conSpeedv2, getExactY());
                //edge();
                movenear();
                //move(fixedmove.get(1));
        }
    }
    private int conSpeedv2;
    public void setSpeed(int conSpeedv2)
    {
        this.conSpeedv2 = conSpeedv2;
    }
    public dog()
    {
        speedpulls = fixedmove.get(1);
        //movesthing = true;
        //col = true; // Not utilized as much anymore. determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
        //movesthing = true;
        movesthingspeed = fixedmove.get(0);
        //standIMGR = new GreenfootImage("alligator.png");
        //jumpIMGR = new GreenfootImage("alligator.png");
        //standIMGL = new GreenfootImage("alligator.png");
        //jumpIMGL = new GreenfootImage("alligator.png");
        advancedAnimation = false;
        fixedVGravity = false;
    }
    
}
