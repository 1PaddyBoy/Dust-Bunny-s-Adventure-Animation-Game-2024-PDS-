import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class goal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class goal extends advancedGravity
{
    /**
     * Act - do whatever the goal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int w,h;
    String use;
    
    public goal()
    {
        w=getImage().getWidth();
        h=getImage().getHeight();
        // Add your action code here.
        colAdd.add(StickMan2.class);
    }
    public goal(String use)
    {
        this.use = use;
        w=getImage().getWidth();
        h=getImage().getHeight();
        // Add your action code here.
        colAdd.add(StickMan2.class);
    }
    /*public goal(GreenfootImage img, String use)
    {
        this.use = use;
        w=getImage().getWidth();
        h=getImage().getHeight();
        // Add your action code here.
        //colAdd.add(StickMan2.class);
    }*/
    public void act()
    {
        //System.out.println("goal act, use = " + use + " null =" + use != null);
        if(use != null && use.equals("movingB"))
        {
            if(getX() - getImage().getWidth()/2 < 0)
            {
                setLocation(getExactX() + ((MyWorld) getWorld()).movementspeed, (double) getExactY());
                System.out.println("slider" +Math.abs((double)(0 - getX() - getImage().getWidth()/2)/(getImage().getWidth() - 750)));
                ((MyWorld) getWorld()).sliderUpdate(1 - Math.abs((getX() - getImage().getWidth()/2)/((double)750-getImage().getWidth())));
            }
        }
    }
}
