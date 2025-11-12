import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rpausebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sandbox extends Buttons
{
    /**
     * Act - do whatever the Rpausebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //explanation for most in infinate button 
    int x = 0;
    int y = 0;
    boolean firstAfter = false;
    String name = "";
    String functionN = "";
    boolean linearG = false;
    public sandbox(int x, int y,String name, String functionN)
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        
    }
    public sandbox(int x, int y,String name, String functionN, GreenfootImage img)
    {
        button_1 = img;
        button_2 = img;
        setImage(button_1);
        mouseDown = false;
        
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        if(functionN.equals("none"))
        {
            hasFunction = false;
        }
    }
    boolean physics = false;
    public sandbox(int x, int y,String name, String functionN, int a)
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        if(a == 1)
        {
            physics = true;
            advancedAnimation = false;
            colAdd.add(StickMan2.class);
            
            bouncy = true;
            wallbounce = true;
            elasticper = 90;
            conspeed = 3;
            elasticperside = 50;
            bouncefriction = 100;
            spriteSideBounce = true;
            fixedVGravity = true;
        }
    }
    public sandbox(int x, int y,String name, String functionN, int a, GreenfootImage img)
    {
        setImage(img);
        getImage().scale(75,(int)(((double) 75/getImage().getWidth())) * 50);
        mouseDown = false;
        img.scale(75,(int)(((double) 75/getImage().getWidth())) * 50);
        button_1 = img;
        button_2 = img;
        System.out.println("img is doing " + img);
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        if(a == 1)
        {
            physics = true;
            advancedAnimation = false;
            colAdd.add(StickMan2.class);
            
            bouncy = true;
            wallbounce = true;
            elasticper = 90;
            conspeed = 3;
            elasticperside = 50;
            bouncefriction = 100;
            spriteSideBounce = true;
            fixedVGravity = true;
        }
        
    }
    public sandbox(int x, int y,String name, String functionN, int a,boolean linearG)
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        if(a == 1)
        {
            physics = true;
            advancedAnimation = false;
            colAdd.add(StickMan2.class);
            
            bouncy = true;
            wallbounce = true;
            elasticper = 90;
            conspeed = 3;
            elasticperside = 50;
            bouncefriction = 100;
            spriteSideBounce = true;
            fixedVGravity = true;
        }
        this.linearG = linearG;
    }
    public sandbox(int x, int y,String name, String functionN, int a,boolean linearG, GreenfootImage img)
    {
        
        mouseDown = false;
        button_1 = img;
        button_1.scale(75,(int)(((double)75/button_1.getWidth())*50));
        button_2 = img;
        button_2.scale(75,(int)(((double)75/button_2.getWidth())*50));
        setImage(button_1);
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        if(a == 1)
        {
            physics = true;
            advancedAnimation = false;
            colAdd.add(StickMan2.class);
            
            bouncy = true;
            wallbounce = true;
            elasticper = 90;
            conspeed = 3;
            elasticperside = 50;
            bouncefriction = 100;
            spriteSideBounce = true;
            fixedVGravity = true;
        }
        this.linearG = linearG;
    }
    public GreenfootImage getImage()
    {
        return button_1;
    }
    public sandbox(int x, int y,String name, String functionN,boolean linearG)
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        this.name = name;
        this.functionN = functionN;
        this.linearG = linearG;
    }
    public sandbox(int x, int y)
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        this.x = x;
        this.y = y;
        firstAfter = true;
        name = "sandbox";
        functionN = "sandbox";
    }
    public sandbox()
    {
        setImage(button_1);
        mouseDown = false;
        button_1 = new GreenfootImage("pausesmall.png");
        button_2 = new GreenfootImage("pausetrans.png");
        advancedAnimation = false;
        firstAfter = true;
        name = "sandbox";
        functionN = "sandbox";
    }
    public void firstafter()
    {
        if(firstAfter)
        {
            firstAfter = false;
            //body
            getWorld().showText(name,x,y);
            System.out.println("new sandbox is here, x = " + getX() + " y=" + getY());
        }
    }
    public void act()
    {
        if(physics == true)
        {
            gravityNoMove();
        }
        movS();
        
        firstafter();
        buttonworks();
        function();
        
    }
    public void movS()
    {
        actAfterSetUp();
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
            if(fixedVGravity == true)
            {
                gravityNoMove();
            }
            //movingWorld();
        }
        buttonworks();
    }
    boolean hasFunction = true;
    public void function()
    {
        // in this case starts pause screen
        if(function == true)
        {
            if(hasFunction)
            {
                MyWorld myworld = (MyWorld)getWorld();
                function = false;
                //below switches between unpauseing and pauseing as well as changing the image for when either is.
                getWorld().showText("",x,y);
                try{
                    ((MyWorld)getWorld()).linearG = linearG;
                    myworld.reflectBS(functionN);
                }catch(Exception E)
                {
                    
                }
                
            }
        }
    }
}