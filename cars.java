import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class cars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cars extends advancedGravity
{
    /**
     * Act - do whatever the cars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String type;
    public int w,h;
    double truex, truey, spe;
    GreenfootImage img;
    public int size;
    public cars(String type, int x, int y, double speed)
    {
        setImage("game4_car"+type+".png");
        this.type = type;
        w=getImage().getWidth();
        h=getImage().getHeight();
        truex=x;
        truey=y;
        img = getImage(); spe=speed;
    }
    public void act()
    {
        if (type=="1")
        {
            custom_scale((getY()-150), 150);
            /*if (getY()<200) custom_scale(1,4);
        else if (getY()<250) custom_scale(4,7);
        else if (getY()<325) custom_scale(9,10);*/
        truex-=0.4*spe; truey-=spe;
        if(getY()>170) setLocation((int)truex,(int)truey);
        else getWorld().removeObject(this);
        }
        if (type=="2")
        {
            truex-=0.4*spe; truey+=spe;
            custom_scale((getY()-150), 150);
            /*if (getY()<200) custom_scale(1,4);
        else if (getY()<250) custom_scale(4,7);
        else if (getY()<325) custom_scale(9,10);
        else if(getY()<395)
        {
            setImage("game4_car"+type+".png");
        }*/
        if (getY()>395) getWorld().removeObject(this);
        setLocation((int)truex,(int)truey);
        }
    }
    
    public void custom_scale(int num, int denom)
    {
        setImage("game4_car"+type+".png");
        getImage().scale(w*num/denom, h*num/denom);
        size=w*num/denom;
    }
}
 