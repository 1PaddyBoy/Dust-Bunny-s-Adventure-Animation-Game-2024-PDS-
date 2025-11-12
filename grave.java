import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class grave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class grave extends advancedGravity
{
    GreenfootImage one = new GreenfootImage("Game1\\Game1_Grave1.png");
    GreenfootImage two = new GreenfootImage("Game1\\Game1_Grave2.png");
    GreenfootImage three = new GreenfootImage("Game1\\Game1_Grave3.png");
    GreenfootImage four = new GreenfootImage("Game1\\Game1_Grave4.png");
    GreenfootImage five = new GreenfootImage("Game1\\Game1_Log1.png");
    GreenfootImage six = new GreenfootImage("Game1\\Game1_Log2.png");
    public double movespeedX;
    public double movespeedY;
    /**
     * Act - do whatever the grave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean first = false;
    public void act()
    {
        // Add your action code here.
        if(first == false)
        {
            groundheight = getY();
            setImage(scale(true,0,getImage()));
            first = true;
        }
        move();
        
        //System.out.println(this + "grave position = " + getX() + "   " + getY());
        if(isG3)
        {
            if(isTouching(dog.class) && off == false)
            {
                groundcheck = 1;
                jumpDelayer = 0;
                off = true;
                (new GreenfootSound("bark.mp3")).play();
                jumpheight = 20;
                System.out.println("grave touching dog");
                jump();
                conspeed = ((MyWorld) getWorld()).left ? 10 : -10;
            }
        }
        off();
        bin();
    }
    public boolean off;
    public boolean isG3;
    public void rudcollde(Actor z)
    {
        if(this.getClass().equals(z.getClass()))
        {
            if(off == false)
            {
                off = true;
                (new GreenfootSound("bark.mp3")).play();
                jumpheight = 20;
                System.out.println("grave touching dog rud col");
                groundcheck = 1;
                jumpDelayer = 0;
                jump();
                System.out.println(this + " gravity speed = " + gravitys + " ground check = " + groundcheck);
                conspeed = ((MyWorld) getWorld()).left ? 10 : -10;
            }
        }
    }
    boolean rehit = true;
    public void off()
    {
        if(off)
        {
            if(((MyWorld) getWorld()).left)
            {
                if(groundcheck == 0)
                {
                    setRotation(getRotation() + 20);
                }else
                {
                    if(rehit)
                        off = false;
                }
                
                //setLocation(getX() + 10, getY() - 10);
                System.out.println(this + " gravity speed = " + gravitys + " ground check = " + groundcheck);
                gravityNoMove();
            }else
            {
                //setRotation(getRotation() - 20);
                if(groundcheck == 0){
                    setRotation(getRotation() - 20);
                }  else
                {
                    if(rehit)
                        off = false;
                }
                System.out.println(this + " gravity speed = " + gravitys + " ground check = " + groundcheck);
                //setLocation(getX() - 10, getY() - 10);
                gravityNoMove();
            }
        }
    }
    public void move()
    {
        if(!(((MyWorld)getWorld()).backImageFinished(0)))
        {
            setLocation(getExactX() + movespeedX, getExactY() + movespeedY);
        }
    }
    public void bin()
    {
        if(getExactX()  - getImage().getWidth()/2 - 1> 750)
        {
            getWorld().removeObject(this);
            return;
        }
    }
    public grave(int image, double movespeedX, double movespeedY, int pixelComp,double imageSize)
    {
        bouncy = false;
        this.movespeedX = movespeedX;
        this.movespeedY = movespeedY;        
        this.pixelComp = pixelComp;
        switch (image)
        {
            case 1: 
                setImage(scale(true,0,one));
                defaultX = one.getWidth();
                defaultY = one.getHeight();
                break;
                
            case 2: 
                                setImage(scale(true,0,two));  
                defaultX = two.getWidth();
                defaultY = two.getHeight();
                break;
                
            case 3: 
                                                setImage(scale(true,0,three));
                                defaultX = three.getWidth();
                defaultY = three.getHeight();
                break;
                
            case 4: 
                                            setImage(scale(true,0,four));
                                defaultX = four.getWidth();
                defaultY = four.getHeight();
                break;
                
            case 5: 
                                                setImage(scale(true,0,five));
                                defaultX = five.getWidth();
                defaultY = five.getHeight();
                break;
                
            case 6: 
                                               setImage(scale(true,0,six));
                                defaultX = six.getWidth();
                defaultY = six.getHeight();
                break;
        }
        advancedAnimation = false;
        colAdd.add(StickMan2.class);
        defaultX = (int) (getImage().getWidth()*imageSize);
        defaultY = (int) (getImage().getHeight()*imageSize);
    }
}
