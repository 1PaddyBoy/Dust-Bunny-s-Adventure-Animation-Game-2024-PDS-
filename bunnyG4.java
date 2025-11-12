import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class bunny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bunnyG4 extends advancedGravity
{
    /**
     * Act - do whatever the bunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double truex=75, truey=351, px=89;
    private double spe=3;
    int size;
    public static int level=1, lives=3;
    public static int lastLevel = 10;
    boolean leftLast = false;
    public bunnyG4(double speed)
    {
        spe = speed;
    }
    public void act()
    {
        if(((MyWorld) getWorld()).running)
        {
        if (level==lastLevel) { /*Greenfoot.stop(); getWorld().showText("you win!",267,200);*/ ((MyWorld) getWorld()).succeed("G4"); System.out.println("G4 succeed in bunnyG4 ");
        }else if (lives==0){ /*Greenfoot.stop(); getWorld().showText("you lose!",267,200);*/ ((MyWorld) getWorld()).fail("G4");
        }else
        {
            // Add your action code here.
            custom_scale((getY()-150), 150);
            if (Greenfoot.isKeyDown("up") && getY()>200)
            {
                truex+=(0.95*(278-px)/189); truey--;
            }
            if (Greenfoot.isKeyDown("down") && getY()<395)
            {
                truex-=(0.95*(278-px)/189); truey++;
            }
            if (Greenfoot.isKeyDown("right")&&px<520)
            {
                truex+=(spe*getY()/320);
                px+=(spe/getY()*400);
                leftLast = false;
                custom_scale((getY()-150), 150);
            }
            if (Greenfoot.isKeyDown("left")&&px>84)
            {
                truex-=(spe*getY()/320);
                px-=(spe/getY()*400);
                leftLast = true;
                custom_scale((getY()-150), 150);
            }
            if (px>520)
            {
                px=520;
            }
            if (px<84)
            {
                px=84;
            }
            setLocation((int)truex,(int)truey);
            
            List<cars> carObjs = getWorld().getObjects(cars.class);
            for (cars carit: carObjs)
            {
                if (Math.abs(carit.getX()-getX())<=(carit.size/2+size))
                {
                    if (Math.abs(carit.getY()-getY())<=(10))
                    {
                    MyWorld world = (MyWorld) getWorld();
                    setLocation(89,351);truex=89; truey=351; px=89;
                    lives--;
                    }
                    else if (Math.abs(carit.getY()-getY())<=carit.h)
                    {
                        if (carit.type=="1") getWorld().setPaintOrder(moverS.class,slider.class,cars.class,bunnyG4.class);
                        else getWorld().setPaintOrder(moverS.class,slider.class,bunnyG4.class,cars.class);
                    }
                }
            }
            List<goal> goalObjs=getWorld().getObjects(goal.class);
             for (goal goalit: goalObjs)
            {
                if (Math.abs(goalit.getX()-getX())<=(goalit.w/2+size))
                {
                    if (Math.abs(goalit.getY()-getY())<=10)
                    {
                        level++;
                        ((MyWorld) getWorld()).sliderUpdate((double)level/10);
                        setLocation(89,351);truex=89; truey=351; px=89;
                    }
                }
            }
        }
    }
    }
    
    public void custom_scale(int num, int denom)
    {
        if(leftLast)
        {
            
          setImage("Bunny_left.png");  
            getImage().scale(50,49);
        }else
        {
            setImage("Bunny_right.png");
        }
        size = (getImage().getWidth()*num/denom)/2;
        getImage().scale(getImage().getWidth()*num/denom, getImage().getHeight()*num/denom);
    }
}
