import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hand extends advancedGravity
{
    /**
     * Act - do whatever the hand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Ankith: time system
    long lastAdded = System.currentTimeMillis();
    long lastAdded2 = System.currentTimeMillis();
    int minusNumber = 1;
    public hand()
    {
        setImage(new GreenfootImage("openhand.png"));
    }
    public void act()
    {
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
        long curTime  = System.currentTimeMillis();
        long curTime2  = System.currentTimeMillis();
        //Ankith: this code makes the hand move left and down by a certain amount every second, the amount it moves increases with time
        if (curTime >= lastAdded + 1500) //3500ms = 3.5s
        {
            minusNumber++;
            int x = getX();
            int y = getY();
            setLocation(x - minusNumber, y + minusNumber);
            lastAdded  = curTime;
            if (x == 840)
            {
                //Ankith: if the hand reaches a certain X, it will spawn in the spacebar and reset itself
                spacebar space1 = new spacebar();
                getWorld().addObject(space1, 480, 150);
                minusNumber = 1;
                setLocation(960, 150);
            } 
            
        }
        
        
       
    }
}
    
}
