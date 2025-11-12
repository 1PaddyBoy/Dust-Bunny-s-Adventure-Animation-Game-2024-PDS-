import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class platform extends advancedGravity
{
    /**
     * Act - do whatever the platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
            if(fixedVGravity == true)
            {
                gravityNoMove();
            }
                edge();
                movenear();
                //move2();
                move(fixedmove.get(0));
        }
        buttonworks();
    }
    //public int 
    public platform()
    {
        movesthing = true;
        col = true; // determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
        movesthing = true;
        movesthingspeed = fixedmove.get(0);
        speedpulls = fixedmove.get(0);
        standIMGR = new GreenfootImage("ambulance-n.png");
        jumpIMGR = new GreenfootImage("ambulance-n.png");
        standIMGL = new GreenfootImage("ambulance-n.png");
        jumpIMGL = new GreenfootImage("ambulance-n.png");
        advancedAnimation = false;
    }
    public int speedreturn()
    {
        int x =0;
        return x;
    }
    public void edge()
    {
        if(getX() + 50 >= 750 )
        {
            setLocation​(0, getY());
        }
    }
    /*public void move2()
    {
        boolean starttouch;
        if(isTouching(StickMan2.class) == true)
        {
            starttouch = true;
        } else
        {
            starttouch = false;
        }
        move(1);
        if(isTouching(StickMan2.class) == true && starttouch == false)
        {
            
             if(isTouching(null) && getOneIntersectingObject(StickMan2.class).getY() <= getY() + getImage().getHeight()/2 && getOneIntersectingObject(StickMan2.class).getY() >= getY() - getImage().getHeight()/2 && getOneIntersectingObject(StickMan2.class).getX() > getX() - getImage().getWidth()/2 && getOneIntersectingObject(StickMan2.class).getX() < getX() + getImage().getWidth()/2)
                      {
                          if(getOneIntersectingObject(StickMan2.class).getX() < getX())
                          {
                                getOneIntersectingObject(StickMan2.class).setLocation(getOneIntersectingObject(StickMan2.class).getX() - 1, getY());
                            }
                            if(getOneIntersectingObject(StickMan2.class).getX() > getX())
                          {
                              getOneIntersectingObject(StickMan2.class).setLocation(getOneIntersectingObject(StickMan2.class).getX() + 1, getY());
                            }
                        }else
                        {
                            
                        }
        }
    }*/
}
