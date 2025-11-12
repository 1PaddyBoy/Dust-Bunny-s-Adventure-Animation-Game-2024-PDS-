import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    /**
     * Act - do whatever the arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //private String[] imageArrow = {"left", "down", "right", "up"};
    //private String[] xArrow = {"100", "125", "300", "up"};
    //private String[] soundArrow = {""};
    
    int speed = 1;
    long lastAdded = System.currentTimeMillis();
    String arrowType;
    boolean oneTime = true;
    int counter = 1;
    
    //Constructor for arrow
    public Arrow (String image, String soundArrow, int type)
    {
        GreenfootImage currImage = new GreenfootImage(image+"arrow.PNG");  
        currImage.scale(50, 50);
        setImage(currImage);
        arrowType = image;
    }
    
    //Ankith: Makes the arrows get faster and the spawnrate increases as the score goes above certain values
    //Jake: Makes the arrows fall and disappear if they hit the bottom of the screen
    static int endScore = 500;
    public void act()
    {
        if(((MyWorld) getWorld()).running)
        {
        long curTime  = System.currentTimeMillis();
        MyWorld myWorld = (MyWorld)getWorld();
                
        if (myWorld.score > 100 || myWorld.score > endScore)
        {
            if (myWorld.score > 250|| myWorld.score > endScore)
            {
                if (myWorld.score > 400|| myWorld.score > endScore)
                {
                    if (myWorld.score > 550|| myWorld.score > endScore)
                    {
                        if (myWorld.score > 650|| myWorld.score > endScore)
                        {
                            speed = 9;
                            myWorld.timeDiff = 150;
                            ((MyWorld) getWorld()).succeed("G6");
                        }
                        else
                        {
                            speed = 6;
                            myWorld.timeDiff = 250;
                        }
                    }
                    else 
                    {
                        speed = 4;
                        myWorld.timeDiff = 450;
                    }
                }
                else 
                {
                    speed =3;
                    myWorld.timeDiff = 550;
                }
            }
            else 
            {
                speed = 2;
                myWorld.timeDiff = 750;
            }
        }
        
        int x = getX();
        int y = getY();
        setLocation(x, y+speed);
        checkTouching();
        counter = counter + 1;
        if (y==539)
        {
            getWorld().removeObject(this);
        }
        }
    }
    
    /*Jake: Checks if the arrow is touching the player arrow, and if the arrow 
     key is pressed which will remove the arrow and increase the score. Also makes
     the arrow change color if it is overlapping the player arrow*/
    //Ankith: If the arrow is touching something, it will make a piano sound and also increase the score
    public void checkTouching()
    {
        boolean isOverlapped = false;
        if (isTouching(playerArrow.class))
        {
            isOverlapped = getNeighbours(20, true, playerArrow.class).size() > 0;
        }
        
        if (isOverlapped == true && Greenfoot.isKeyDown(arrowType) && !tooManyKeysDown())
        {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.addScore(10);
            int number = Greenfoot.getRandomNumber(4);
            if (number == 1)
            {
                 //Greenfoot.playSound("pianoa.mp3");
            }
            if (number == 2)
            {
                 //Greenfoot.playSound("pianoe.mp3");
            }
            if (number == 3)
            {
                 //Greenfoot.playSound("pianob.mp3");
            }
            if (number == 4)
            {
                 //Greenfoot.playSound("pianoc.mp3");
            }
            getWorld().removeObject(this);
        }
        
        if (isOverlapped)
        {
            GreenfootImage newImage = new GreenfootImage("l"+arrowType+"arrow.PNG");
            newImage.scale(50, 50);
            setImage(newImage);
        }
        else
        {
            GreenfootImage newImage = new GreenfootImage(arrowType+"arrow.PNG");
            newImage.scale(50, 50);
            setImage(newImage);
        }
    }
    
    //Jake: Checks if too many keys are down at once
    public boolean tooManyKeysDown()
    {
        int numKeysDown = 0;
        if (Greenfoot.isKeyDown("left"))
        {
            numKeysDown++;
        }
        if (Greenfoot.isKeyDown("right"))
        {
            numKeysDown++;
        }
        if (Greenfoot.isKeyDown("down"))
        {
            numKeysDown++;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            numKeysDown++;
        }
        
        if (numKeysDown >=3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
