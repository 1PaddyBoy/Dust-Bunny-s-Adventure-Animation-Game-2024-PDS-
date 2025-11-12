import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

public abstract class Buttons extends advancedGravity {
    //variables 
    
    public GreenfootImage button_1 = new GreenfootImage("pausesmall.png"); // image for normal
    public GreenfootImage button_2 = new GreenfootImage("pausetrans.png"); // image for hovered / click
    
    //variables for detection 
    public boolean mouseDown = false;
    public boolean clickity = false;
    
    //variables for timers 
    public int clickitycount = 0;
    public int buttonpresstime = 30;
    public Actor actorHoveredOver = null;
    
    public boolean function = false;//used for the function of the button
    //used for function calling timers
    public int buttonfde = 15;
    public int buttonfdework = 0;
    public boolean buttonanimations = true;
    //the main method for making buttons work, put this in code for button ability 
    public void function()
    {
        System.out.println("generic pressed");
    }
    public void buttonworks()
    {
        //hover detection 
        if(mouseHoveringOver(this))
        {
            if(buttonanimations)
            {
                setImage(button_2);
            }
            //System.out.println("button works, hovered called");
        }
        
        if(!mouseHoveringOver(this) && clickity == false)
        {
            if(buttonanimations)
            {
                setImage(button_1);
            }
        }
        if (!mouseDown && Greenfoot.mousePressed(this) && buttonfdework == 0) {  
            if(buttonanimations)
            {
            setImage(button_2); 
            }
            clickity = true;
            //button functions here.
            function = true;
            function();
            buttonfdework = buttonfde;
            //System.out.println("button works, function");
        }  
        if (mouseDown && Greenfoot.mouseClicked(this)) {
            if(buttonanimations)
            {
            setImage(button_1);
            }
        }  
        if(clickity == true && !Greenfoot.mousePressed(this))
        {
            clickitycount++;
        }
        if(clickity == true && clickitycount >= buttonpresstime && !Greenfoot.mousePressed(this))
        {
            clickity = false;
            clickitycount = 0;
            if(buttonanimations)
            {
            setImage(button_1); 
            }
        }
        if(buttonfdework > 0){buttonfdework--;}
    }
    /**
     * method sees which button the mouse is hovering over.
     */
    private void hoverOwner() {
        if ((actorHoveredOver == null || actorHoveredOver.getWorld() == null) && Greenfoot.mouseMoved(this)) {
            actorHoveredOver = this;
        } else if (actorHoveredOver == this && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            actorHoveredOver = null;
        }
    }
    
    /**
     * This methods returns true if the mouse is hovering over the specified
     * button.
     * par is actor being hoved over 
     * return true, if mouse is over specified button
     */
    public boolean mouseHoveringOver(Actor actor) {
        hoverOwner();
        return actorHoveredOver == actor;
    }
    //return the button that the mouse is over
    public Actor getHoverOwner() {
        return actorHoveredOver;
    }
}
