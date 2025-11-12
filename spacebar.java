import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spacebar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spacebar extends advancedGravity
{
    /**
     * Act - do whatever the spacebar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Ankith: time system, currently being clicked and the times clicked
    boolean curClick = true;
    int timesClicked = 0;
    long lastAdded3 = System.currentTimeMillis();
    public void act()
    {
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
        //Ankith: increases the timesclicked
        if (Greenfoot.isKeyDown("space") && curClick)
        {
            timesClicked++;
            curClick = false;
        }
        //Ankith: if the space bar is clicked curClick is true
        if (!Greenfoot.isKeyDown("space"))
        {
            curClick = true;
        }
        //Ankith: this code makes it so that you have to spam the spacebar multiple times or else you lose and the game stops
        long curTime3  = System.currentTimeMillis();
        if (curTime3 >= lastAdded3 + 2000) //1000ms = 1s
        {
            if (timesClicked >= 5)
            {
                getWorld().removeObject(this);
            }
            else 
            {
                //Greenfoot.stop();
                ((MyWorld)getWorld()).fail("G6");
            }
            
            lastAdded3  = curTime3;
            //this code desplays the time the MC has been alive in seconds, I used this code that erdelf made to convert ints to strings
            //https://www.greenfoot.org/topics/1964
        }
        }
    }
    public spacebar()
    {
        //Ankith: scaling image
        GreenfootImage image = getImage();  
        image.scale(350, 100);
        setImage(image);
    }
}
