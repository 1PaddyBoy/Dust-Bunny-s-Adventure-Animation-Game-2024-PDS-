import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class home extends sandbox
{
    /**
     * Act - do whatever the home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /*public void act()
    {
        // Add your action code here.
    }*/
    
    public home(int x, int y,String name, String functionN)
    {   
        
        super(x,y,name,functionN);
        GreenfootImage a = new GreenfootImage("TopBar_Homebutton.png");
        a.scale(50,(int)(((double)50/a.getWidth()) * a.getHeight()));
        
        button_1 = a;
        button_2 = a;
        setImage(a);
        //System.out.println("home set up");
    }
    public void firstafter()
    {
        if(firstAfter)
        {
            firstAfter = false;
            //body
            getWorld().showText(name,x,y);
            GreenfootImage a = new GreenfootImage("TopBar_Homebutton.png");
            a.scale(50,(a.getWidth()/50) * a.getHeight());
            setImage(a);
            button_1 = a;
            button_2 = a;
        }
    }
    public void act()
    {
        
        function();
        movS();
        buttonworks();
    }
    
    
}
