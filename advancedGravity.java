import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;
import greenfoot.Actor;
import java.util.Arrays;
import greenfoot.MouseInfo;

/**
 * some gravity mechanics for whoever wants them 
 * 
 * Patrick aka PiFlavoredPi
 * last update:
 * 2-2-24
 */
public abstract class advancedGravity extends SmoothMover
{
    /**
     * all images must be defined in subclasses 
     * 
     * I will put a capital c after each variable which can be saftly changed. like this C
     * any that don't have that might break if changed 
     * list of all variables which can be changed:
     * 
     * there are a few styles I have done, for exaple mario which makes it more like that style. I plan to make more. 
     * styles like mario don't do everything, there are still alot of things to change with it. 
     * 
     * there are currently two different ways this can be used, one where it is just the gravity and one where it has gravity and jump commands.
     * 
     *  to make sprites pull sprites initilize this. some number should be same as move speed for best results 
     *  speedpulls = (some number); // this is the speed it pulls this if it moves things that are on top, this will look most realistic as the same as the movmeent speed in the array below but if its a tread mill or something it can be higher 
        movesthing = true; // this is if it moves things with it, again change this in the array below too but this helps a bit 
        col = true; //this doesn't do as much any more its more of a back up but this should be here as well as the class name in the array below 
        movesthingspeed = (some number); // speed it moves things, similar to the top one. 
     *  
     *  
     *   Recent change log:
     *   3-9-23
     *  Publishment date today, 
     * 
     *  Changes in the works:
     *  
     */
    //charles rosenburg. 
    
    //The below is all the things that can be changed to change the physics
        //String input = Greenfoot.ask("Please input a value for "+ getClass() +" jump height");
        //public int jumpheight = Integer.parseInt(input); 
        double jumpheight = 20; //C decides jump height uncomment and delete above code if you want u want it fixed and no prompt
        double tempjumpHeight = 40;//C real jump height
        public boolean doesPause = true;
        public double conspeed = 0; //C this is the speed of something continusly, 0 if something doesn't but 1 if you want it to keep moving with that speed. postiive values for right. negative values for left 
        public boolean wallbounce = false; //C this makes the above speed invert when touching a wall
        public boolean spriteSideBounce = false; //C this deceids if things with continues speed bounce off sprites 
        public boolean mariostyle = false; //C if true overrides some things to make the movement like mario. I don't know what kind of running mario does so this doen't change that. the running speed and type is up to you how ever.
        public boolean movesthing = false; //C code for if touching things are moved by something
        public boolean ismovedby = false; //C code for if thing touched is moved by its presence. 
        public int jumpimgdur   = 100; //C decides duration of jump image after jump, currently overrided by auto command which figures it out automaticly.
        public int groundheight = 500; //C determins where the ground that the charactor stops is
        public int maxGroundHeight = 500; //C max ground height
        public int minGroundHeight = 0; // C min ground height
        public boolean adjustableGround = true;// is their pretend 
        public double angleNum = 1;//C this is the amount that the up down ground differs from regular speed.
        public int gravityreloadspeed = 1; //C determins how quickly the gravity changing speed it put into effect. higher numbers makes gravity slower but more janky.
        public double gravityspeedchange = 1; //C determins how much the gravity acceleration is. higher numbers makes gravity stronger, will break with numbers lower than 1 so don't.
        public int gravitycounter = 0; //counts cycles for gravity refresh. not change able 
        public boolean movewhileinair = true; //C determins whether the charactor can move while in the air. right now stops charactor in its track, I'd like to keep momnetum 
        public double movespeedinair = 10; //C determins speed of charactor while in air.   CURRENT DEFAUlt for all moves is 10
        public double movespeedonground = 10; //C determins speed while on ground. make same as above if you want the values the same    
        public boolean momentumKeptWhich = false; //C if momentumKeptInAir is true then this dictates whether it takes air or ground speed. true is ground. false is air 
        public boolean bouncy = false; //C feature which makes the thing bounce 
        public boolean bouncingreset = true; // does stuff for bouncing reseting 
        public boolean run = true; // C makes you run faster if true 
        public boolean autovaluerun = true; // C if true then the variable dash multiply value works, if false then its based on the raw speed variable
        public double multiruns = 2; //C multiples the normal speed to find the speed while dashing, if the above variable is true then it takes this value 
        public double rawruns = 15; //C if the autovalue is false then it takes this value and adds it (or minus its if its going backwards) to find the new value. for example if move speed is 10 and this 5 then value moved when running is 15. 
        public boolean groundlevelcheck = true; //C checks to see if there is still ground and continues gravity if there isn't ground. could create lag or glitches.
        public boolean runinair = false; //C determins weather the charactor can run in the air, if true than the above run things run while in air, if false then they only work on ground
        public boolean airmomrun = false; //C boolean to determin weather the run effects the momentum in air. if true than the momentum from running is the new momentum for jumping momentum, if false then it just takes the value of the regular moving
        public double elasticper = 90; //C amount of momentum held each bounce based on a percetnage of original. 100 means that every bounce goes back up to the same height. 50 means half of the energy conserved. and other numbers etc
        public double elasticperside = 50; //C same as above but for side.
        public double bouncefriction = 30; // C this is the friction that surfices have, is like elsastic above but for surfaces. 
        public boolean surfaceOffDo = false; //C this is whether bounce objects get speed from bouncing off of moving objects in there direction and works with friction and stuff.
        public double bouncystopspeed = 0.001; //C what speed the bouncy stops at, 0 means it goes all the way done to one before rounding to 0, another number will do differently 
        public boolean bounceheightvspeed = true; // C this changes wheather elasticity is measured in final height or in speed.
        public boolean directovercyote = true; //C BETA this sets weather the cyote timing / spacing is controlled manually or if it is direct. direct is true. manual is false.
        public int spritelift = 90; //C this is how far above the center of a platform or characotr interacted sprite the charactor floats. i have found that 90 works and looks best however this might change for size of the sprites used or something. 
        public boolean autospirthover = true; //C feature that automatically detects how far for the charactor to hover above objects. true means that above doesn't matter. false means it uses that. Should work completely fine now. 
        public boolean fixedVGravity = false; //C change in each class for if that object has gravity or is fixed
        public final int gravCtime = 60;//C timer for the gravity changing time 
        public final int BCtime = 60;//C timer for the bouncy changing time 
        public final int ICtime = 60;//C timer for the collision/invisable changing time
        public boolean surfaceFriction = true; //C this determins if said object is subject to friction. 
        public boolean airResistance = true; //C this determins if it has surface sentions
        public boolean airResistanceAuto = true; // Cthis determins the airresistance based on the speed and not fixed 
        public double airResistanceSpeed = 99.99; //C this does airResistance as a fixed precentage. 
        public double airResistanceFullStopS = 0.01; //C this is when the airResistance completly stops the object
        public boolean sidetouchSprite = false; //C this makes a special method activate which activates a method upon actor touching side of sprite.
        public boolean sidetouchWall = false; //C this does above but also works with walls. 
        public boolean absoluteworld = true; //Cdoesn't really do anything right now, collisons work with out da way anyway. C this is weather static objects can override the world move.
        public static double worldSpeed = 0;//C this is the constant speed of all objects within below 
        public static boolean worldAroundPlay = false;//C, beta, this moves the world instead of the character keeping the character center
        boolean col; //set in each for either collision or not. 
        //some animation changing things are below
        int fallAnimationDelay = 2;//C this is how many frames per animation from 2 for 30 fps at normal speed
        int bfallAnimationDelay = 10;//Cdelay for bFalling
        boolean advancedAnimation = true;//C this turns on all the advanced animation things like falling animations and such
        boolean fallBeginningAnimation = true;//C beginning of fall animation 
        boolean waitForLand = false; //C if this is set to true than the player needs to wait for the jump animation to finish before they can jump again.
         int walkAnimationDelay = 5;//C delay for end Falling
        int walkingEndTime = 10;//C how many frames before walking has stopped, must be above one for anywalking animation. must be at least 9 or 10 for continous animation
        boolean WalkingAnimation = true; //C if true then walking animation happens. 
        int EfallAnimationDelay = 9;//C delay for end Falling
        //images below, this can be modifed but only one is here for now. these are set so image 2 is the normal image. image 1 is the image that happens when it jumps, this can be changed easily here though
        //this works well changed in each subclass as well 
        public GreenfootImage standIMGR;
        public GreenfootImage jumpIMGR;
        public GreenfootImage standIMGL;
        public GreenfootImage jumpIMGL;
        double terminalVelocity = 20;//this is the maximum speed gravity can accelerate to.
        boolean movewidth = false;
        double moveWOffX = 0;//off set from center of the objects described.
        double moveWOffy = 0;//off set from center of the objects described.
        //more animation support coming in the future 
        double moveWMspeed = 0;//maximum speed for object to move to another object, for instant speed = 0;
        String moveLeft = "left";
        String moveRight = "right";
        String jump = "space";
        
        
        
    //usually not changed things:
    double movesthingspeed = 0;//holds vaules in other classes
    int grounddrepeat = 0; //uses so ground detection doesn't repeat
    int groundDetectreStart = 0; // decides resetting of ground detection
    int jumpingimg = 0; //used for counting purposes
    int jumpingimgstart = 0; //used for timer starting 
    int jumpimgstand = 0; //used to make sure that standing img isn't repeated, makes program more effeicnt. 
    int autojumpdurnore = 0; //makes sure auto thing doesn't repeat
    boolean momentumKeptInAir = false; // makes momentum kept when jumped even if moving in air is turned off. 
    double aircontinuesSpeed = 0; // used to keep track of speed in air if above is turned on. not changeable 
    int airjumpmomconstart = 0; //used to find when to start  the air jump momentum continuation thingy, doesn't need to be played with
    boolean airmovinglogicdone = true; //just used to make air moving logic only move once
    boolean groundlevelcheckkeep = false; //used just for logic for above
    double Gravityshold = 0; // holds a value of gravity past
    boolean bouncyre = false; // tests does a thing to delay jump 
    int spritsinter = 0; // keeps track of sprite calculations 
    //button and dragging things
        boolean animationDirection = false; //false = left, true = right.
        public boolean mouseDown = false; // this holds mouse status 
        public boolean clickity = false;
        //variables for timers 
        public int clickitycount = 0; //timer for clickity 
        public int buttonpresstime = 30; // time between buttons
        public Actor actorHoveredOver = null; // holds the actor that was hovered over 
        public boolean function = false;//used for the function of the button
        //used for function calling timers
        public int buttonfde = 15; // button function 
        public int buttonfdework = 0; // reodes the button function 
        int buttonsDown = 0; //holds the buttons currently down 
        final int btnNEITHER = 0, btnLEFT = 1, btnRIGHT = 3; // holds constants of the different ways. 
        boolean released = true; //this is a variable about when the button is released
        int gravCtimeR = 0;//timer for the gravity changer that updates 
        int BCtimeR = 0;//timer for the bouncy changer that updates 
        int ICtimeR = 0;//timer for the invsiablity changer that updates. the thing that changes if collison or not. 
        boolean mouseReleasedN = false;//holds when the mouse is released 
        int prevMouseX = 0;//holds the previous mouse x before the release 
        int prevMouseY = 0; // holds the previous mouse y before release
        int mariostylere = 1; // makes above work, don't change default 1 
        double gravitys = 0; // is a counter for gravity spead. 
        int groundcheck = 0; //decides ground check, 1 is on ground, 0 is in air 
        
        
    /**
     * lists to be changed, 
     * each of these have there own general purpose but are kinda split into detection, collision in a certain way, and animation. 
     */
    List<Actor> movedwidth = new ArrayList<Actor>(){{
        
    
    }};
    
    static List<Class> colexcept = new ArrayList<Class>() {{
            //add each new exception as inside the add thingy. kinda often needed if you want special detection.
            //add(deathBall.class);
            //add(pausebutton.class);
            add(Rpausebutton.class);
            //add(StickMan2.class);
            add(video.class);
            add(goal.class);
            //add(bigplat.class);
            add(dog.class);
            add(achievement.class);
            
        }};
        /**
         * this col Add is bascily the opposite of above, any collision you do want add in here.
         */
    List<Class> colAdd = new ArrayList<Class>() {{
            //add each new exception as inside the add thingy. kinda often needed if you want special detection.
            //add(deathBall.class);
            //add(StickMan2.class);
            //add(bigplat.class);
            
        }};
        /**
         * this adds more indeviual object exceptions. 
         */
    List<Object> inColex = new ArrayList<Object>(){{
            
    }};
    /**
     * this adds collison of preticular objects back in.
     */
    List<Object> inColAdd = new ArrayList<Object>(){{
            
    }};
    List<Class> spriteside = new ArrayList<Class>() {{ //this is stuff that does stuff with the side of sprites, add all things that move in here that arent constant and are effected by bumping things
            //add each new exception as inside the add thingy. kinda often needed if you want special detection.
            add(StickMan2.class);
            add(bouncyball.class);
            //add(bigplat.class);
            
        }};
        //this list dictates which sprites are moved when standing on top of a moving sprite. 
    List<Class> movedbyexcept = new ArrayList<Class>() {{
            //add each new exception as inside the add thingy. kinda often needed if you want special detection.
            add(StickMan2.class);
            //add(bigplat.class);
            
        }};
        // below is all the pushers in the game, these are the objects that arent effected by things pushing it.  
    List<Class> pushers = new ArrayList<Class>() {{ 
            //add each new exception as inside the add thingy. kinda often needed if you want special bouncing movement.
            add(platform.class);
            add(alligatgor.class);
            add(grave.class);
            //add(bigplat.class);
            
        }};
        double speedpulls = 0; // changed in each object that things on top of it move as the speed they move, could be same as movement speed or more if say a tread mill. 
        //below is list of that which ends game.
        List<Class> endtrigger = new ArrayList<Class>(){{
        //add(); //add all objects you want to trigger ending/ death or something when touched
        add(StickMan2.class);
    }};
        List<Class> endtouchy = new ArrayList<Class>(){{
         //
    }};    
    //list of classes that have side  
    /** continuous moving code, for this turn the main charactor may move or not or have constant speed backwards up to you. every object in list will move with world speed    
       */
    //below is the sister of pushers list and it holds the speed that corrasponds to the pusher. same order 1 goes with 1 2 with 2 
    List<Double> fixedmove = new ArrayList<Double>(){{ 
        add((double) 0.1);
        add((double)1);//this is the speed of the first item in pushers list 
        add(1.0);
    }}; // to make actors move at speeds listed here get from list 
    //double[] fixedmove = /*new int[pushers.size()]*/{1,1};//must be size of pushers
    List<Class> movingWorld = new ArrayList<Class>(){{
        //add(); add all objects you want moving with the world, could even be actor and then actor also moved with arrows. 
        add(StickMan2.class);
        add(bigplat.class);
    }};
    //while falling animation 
    List<GreenfootImage> falling = new ArrayList<GreenfootImage>(){{
        add(new GreenfootImage("FallR.png"));
    }};
    int fallCounter = 0; //this just does things with animation 
    int bFallingcounter = 0;//counts stuff
    int fallAnimationDelaycounter = 0;//this just works with above 
    int bfallAnimationDelaycounter = 0;//same with speeding up bfalling 
    int bfallCounter = 0;//coutner for keeping track.
    boolean fallingend = false; //idk man figure it out
    List<GreenfootImage> bFalling = new ArrayList<GreenfootImage>(){{ //this is for the animation snippet as falling is beginning, runs as long as the list is.
        add(new GreenfootImage("BFallL.png"));
    }};
    int EfallAnimationDelaycounter = 0;//same with speeding up endfalling 
    int EfallCounter = 0;//coutner for keeping track.
    int EFallingcounter = 0;//counts stuff
    List<GreenfootImage> EFalling = new ArrayList<GreenfootImage>(){{ //this is a snippet of animation for after it lands, this plays just when it lands.
        add(new GreenfootImage("LandR.png"));
        add(new GreenfootImage("LandR.png"));
    }};
    int jumpDelayer = 0; //only can jump while this equals 0;
    boolean waitForLandRe = false; //just detects if change is started.
    int walkCounter = 0;//coutner for keeping track.
    int walkAnimationDelaycounter = 0;//counts stuff.
    int walkingEnd = 0;//this detects when the walking has stopped.
    int walkDelaycounter = 0;//same with speeding up endfalling 
    List<GreenfootImage> RWalking = new ArrayList<GreenfootImage>(){{ //frames of walking animation, when walking right
        add(new GreenfootImage("1WalkR.png"));
        add(new GreenfootImage("2WalkR.png"));
        add(new GreenfootImage("3WalkR.png"));
        add(new GreenfootImage("4WalkR.png"));
        add(new GreenfootImage("5WalkR.png"));
        add(new GreenfootImage("6WalkR.png"));
        add(new GreenfootImage("7WalkR.png"));
        add(new GreenfootImage("8WalkR.png"));
    }};
    int direction = 0; //0 = left, 1 = right, others others.
    List<GreenfootImage> LWalking = new ArrayList<GreenfootImage>(){{ //frames of walking animation, when walking left.
        add(new GreenfootImage("1WalkL.png"));
        add(new GreenfootImage("2WalkL.png"));
        add(new GreenfootImage("3WalkL.png"));
        add(new GreenfootImage("4WalkL.png"));
        add(new GreenfootImage("5WalkL.png"));
        add(new GreenfootImage("6WalkL.png"));
        add(new GreenfootImage("7WalkL.png"));
        add(new GreenfootImage("8WalkL.png"));
    }};
    private boolean actAfterS = false;
    /**
     * removes one list by another, it goes second - first. 
     */
    public List collexceptobb()
    {
        List<Object> ObRe = new ArrayList<Object>();
        for(Class c : colexcept)
        {
            ObRe.addAll(getWorld().getObjects(c));
        }
        ObRe.addAll(inColex);
        for(Class b : colAdd)
        {
            anyRemoveL(getWorld().getObjects(b),ObRe);
        }
        for(Object v : inColAdd)
        {
            if(anyfind(v,ObRe))
            {
                anyRemove(v,ObRe);
            }
        }
        return ObRe;
    }
    public List anyRemoveL(List m, List I)
    {
        if(m.size() > 0 && I.size() > 0)
        {
            if(m.get(0).getClass().equals(I.get(0).getClass()))
            {
                for(int i = 0; i < m.size(); i++)
                {
                    anyRemove(m.get(i), I);
                }
            }
        }
        return I;
    }
    /**
     * finds if anything of any type is in any list of any type. 
    */
    public static <T> boolean anyfind(T z, List a)//
        {
            int s = a.size();
            boolean isThere = false;
            if(z != null)
            {
                for(int i = 0; i < s; i++)
                {
                    if(z.equals(a.get(i)))
                    {
                        isThere = true;
                    }
                }
            }
            else
            {
                isThere = false;
            }
            return isThere;
        }
        /**
         * removes anything from any list.
         */
    public static void anyRemove(Class c, List l)
        {
            if(anyfind(c,l))
            {
               int z = anyfindpos(c,l);
               if(z == -1)
               {
                    System.out.println("no part found");
                }
                System.out.println("z --->   " + z);
                l.remove(z);
            }
        }
    public static <T> void anyRemove(T c, List l)
        {
            if(anyfind(c,l))
            {
               int z = anyfindpos(c,l);
                l.remove(z);
            }else
            {
                //System.out.println("generalized not in list");
            }
        }
        /**
         * this finds the posistion of any thing of any class in any list 
         */
    public static <T> int anyfindpos(T z,List a)//
    {
            int s = a.size();
            int pos = -1;
            for(int i = 0; i < s; i++)
            {
                if(z.equals(a.get(i)))
                {
                    pos = i;
                }
            }
            return pos;
    }
    /**
     * is used for setting up the act after, set up for post set up.  
     */
    public void actAfterSetUp()
    {
        if(actAfterS = true)
        {
            actAfter();
             
            
        }
        actAfterS = true;
    }
    public void specialactafter()
    {
    
    }
    /**
     * false = left, true = right special because it is bound to walk not animation parent
     */
    public void walkinganimation(boolean side)//
    {
        if(advancedAnimation == true && groundcheck == 1)
        {
            if(side == false)
            {
                animationDirection = false;
                if(walkDelaycounter < walkAnimationDelay)
                            {
                                walkDelaycounter++;
                            }else {
                                walkDelaycounter = 0;
                                if(walkCounter < LWalking.size())
                                {
                                    //setImage(LWalking.get(walkCounter));
                                    //System.out.println("walking animation stuff done + " + walkCounter);
                                    setImage(scale(active,pixelComp,LWalking.get(walkCounter)));
                                    walkingEnd = walkingEndTime;
                                    direction = 0;
                                    walkCounter++;
                                }else
                                {
                                    walkCounter = 0;
                                }
                            }
                        } else
                        {
                            animationDirection = true;
                            if(walkDelaycounter < walkAnimationDelay)
                                {
                                    walkDelaycounter++;
                                }else {
                                    walkDelaycounter = 0;
                                    if(walkCounter < RWalking.size())
                                    {
                                        setImage(scale(active,pixelComp,RWalking.get(walkCounter)));
                                        walkingEnd = walkingEndTime;
                                        direction = 1;
                                        walkCounter++;
                                    }else
                                    {
                                        walkCounter = 0;
                                    }
                                }
                        }
        }
    }
    boolean active = false;
    int pixelComp = 0;
    double imgper = 1;
    int defaultX = 50;
    int defaultY = 50;
    public GreenfootImage scale(boolean active, int pixelComp, GreenfootImage c)
    {
        if(active && pixelComp <= 500)
        {
            double a = (((double)groundheight / (500-pixelComp)) + 0)/1;
            try{
                GreenfootImage b;
                if(direction == 0)
                {
                    //left.scale((int) (50 * a), (int) (49 * a)); 
                    b = c;
                }else if (direction == 1)
                {
                    //right.scale((int) (50 * a), (int) (49 * a));
                    b = c;
                }else
                {
                    b = c;
                    //System.out.println("direction image not found");
                }
                
                b.scale((int) (defaultX * imgper * a), (int) (defaultY * imgper * a));
                //getImage().scale((int) (50 * a), (int) (49 * a)); 
                return b;
            }catch(Exception e)
            {
                
            }
            if(c == null)
            {
                //System.out.println(this + " image = null");
            }
            return c;
        }else
        {
            return getImage();
        }
        
        
    }
    /**
     * ends the walking animation.
     */
    public void walkingEnd()//
    {
        if(walkingEnd != 0)
        {
            walkingEnd--;
        }else
        {
            if( animationDirection == false)
            {
                //setImage(standIMGL);
                setImage(scale(active,pixelComp,standIMGL));
            }else
            {
                //setImage(standIMGR);
                setImage(scale(active,pixelComp,standIMGR));
            }
            walkingEnd = -1;
        }
    }
    /**
     * used for advanced animation, contains all other animations, put this in act of any sub class you want to animate, then adjust variables.
     */
    public void animationParent()//
    {
        if(advancedAnimation == true)
        {
            fallingAnimation();
        }
        walkingEnd();
    }
    
    /**
     * this is the animation for while its falling, it is the beginning of the fall, the end of the fall and the duration of the fall all wrapped into one.
     */
    private void fallingAnimation()//
    {
        if(groundcheck == 0 && gravitys >0)
        {
            if(fallBeginningAnimation == true)
            {
                EfallAnimationDelaycounter = 0;
                if(bfallCounter < bFalling.size())//before part
                {
                    if(bfallAnimationDelaycounter < bfallAnimationDelay)
                    {
                        bfallAnimationDelaycounter++;
                    }else {
                        bfallAnimationDelaycounter = 0;
                        if(bfallCounter < bFalling.size())
                        {
                            //setImage(bFalling.get(bfallCounter));
                            setImage(scale(active,pixelComp,bFalling.get(bfallCounter)));
                            bfallCounter++;
                        }else{bfallCounter = 0;}
                    }
                } else //after above part is finished
                {
                    if(fallAnimationDelaycounter < fallAnimationDelay)
                    {
                        fallAnimationDelaycounter++;
                    }else {
                        fallAnimationDelaycounter = 0;
                        if(fallCounter < falling.size())
                        {
                            //setImage(falling.get(fallCounter));
                            setImage(scale(active,pixelComp,falling.get(fallCounter)));
                            fallCounter++;
                        }else
                        {
                            fallCounter = 0;
                        }
                    }
                }
                fallingend = true;
                waitForLandRe = true;
            }else //if there is no before animation
            {
                EfallAnimationDelaycounter = 0;
                if(fallAnimationDelaycounter < fallAnimationDelay)
                {
                    fallAnimationDelaycounter++;
                }else {
                    fallAnimationDelaycounter = 0;
                    if(fallCounter < falling.size())
                    {
                        //setImage(falling.get(fallCounter));
                        setImage(scale(active,pixelComp,falling.get(fallCounter)));
                        fallCounter++;
                    }
                }
                fallingend = true;
                waitForLandRe = true;
            }
        }else if (fallingend == true) //when it touches the ground again.
        {   if(waitForLand == true && waitForLandRe == true)
            {
                jumpDelayer = EFalling.size() * EfallAnimationDelay;
                waitForLandRe = false;
            }
            if(waitForLand == true)
            {
                if(EfallAnimationDelaycounter < EfallAnimationDelay) //this goes through a landing animation.
                        {
                            EfallAnimationDelaycounter++;
                        }else {
                            EfallAnimationDelaycounter = 0;
                            if(EfallCounter < EFalling.size())
                            {
                                setImage(EFalling.get(EfallCounter));
                                
                                EfallCounter++;
                            }else
                            {
                                fallingend = false;
                                if( animationDirection == false)
                                {
                                    //setImage(standIMGL);
                                    setImage(scale(active,pixelComp,standIMGL));
                                }else
                                {
                                    //setImage(standIMGR);
                                    setImage(scale(active,pixelComp,standIMGR));
                                } 
                                fallingend = false;
                                bfallCounter = 0;
                                EfallCounter = 0;
                                jumpDelayer = 0;
                            }
                        }
            }else
                {
                if(groundcheck == 1)
                {
                    if(EfallAnimationDelaycounter < EfallAnimationDelay) //this goes through a landing animation.
                        {
                            EfallAnimationDelaycounter++;
                        }else {
                            EfallAnimationDelaycounter = 0;
                            if(EfallCounter < EFalling.size())
                            {
                                //setImage(EFalling.get(EfallCounter));
                                setImage(scale(active,pixelComp,EFalling.get(EfallCounter)));
                                EfallCounter++;
                            }else
                            {
                                fallingend = false;
                                if( animationDirection == false)
                                {
                                    //setImage(standIMGL);
                                    setImage(scale(active,pixelComp,standIMGL));
                                }else
                                {
                                    //setImage(standIMGR);
                                    setImage(scale(active,pixelComp,standIMGR));
                                } 
                                fallingend = false;
                                bfallCounter = 0;
                                EfallCounter = 0;
                                jumpDelayer = 0;
                            }
                        }
                }else//this runs if there is another jump before the full landing animation can play, right now there is no jump delay but there could be. 
                {
                    fallingend = false;
                    if( animationDirection == false)
                    {
                        setImage(standIMGL);
                        setImage(scale(active,pixelComp,standIMGL));
                    }else
                    {
                        setImage(standIMGR);
                        setImage(scale(active,pixelComp,standIMGR));
                    }
                    fallingend = false;
                    bfallCounter = 0;
                    EfallCounter = 0;
                    jumpDelayer = 0;
                }
            }
        }
    }
    /**
     * this just makes the delayer for jumping go down. 
     */
    private void jumpDelayerDown()//
    {
        if(jumpDelayer < 0)
        {
          jumpDelayer--;  
        }
    }
    /**
     * makes actor move if in list above and in act of actor put this in if yes 
     */
    public void movingWorld()//
    {
        if(anyfind(getClass(),movingWorld))
        {
            if(absoluteworld == true)
            {
                setLocation(getExactX() + worldSpeed, getExactY());
            }else if(colexceptcheckall())
            {
                setLocation(getExactX() + worldSpeed, getExactY());
            }
        }
    }
    /**
     * finds the posistion of an actor in pusher
     */
    public double pusherdetectfinder(Actor x) //
    {
        double z = 0; //returned value
        Class y = x.getClass();
        if(anyfind(y, pushers) && colexceptcheck(x))
        {
            int positionint = pusherfindpos(y);
            if(positionint != -1)
            {
                if(x.getClass().equals(grave.class))
                {
                    fixedmove.set(positionint,(double)(((MyWorld) getWorld()).G1graveSpeed));
                }
                z = fixedmove.get(positionint);
            }
        }
        return z;
    }
    /**
     * sees if a class is in any list, first is class second is list.
     */
    /*public boolean anyfind(Class z, List a)//
    {
        int s = a.size();
        boolean isThere = false;
        if(z != null)
        {
            for(int i = 0; i < s; i++)
            {
                if(z.equals(a.get(i)))
                {
                    isThere = true;
                }
            }
        }
        else
        {
            isThere = false;
        }
        return isThere;
    }
    /**
     * sees if an actor is in any list, first is the actor, second is the list its found in. 
     */
    /*public boolean anyfind(Actor z, List a)//
    {
        int s = a.size();
        boolean isThere = false;
        for(int i = 0; i < s; i++)
        {
            if(z.equals(a.get(i)))
            {
                isThere = true;
            }
        }
        return isThere;
    }*/
    /**
     * sees if a class is in pusher, not as usful after anyfind was implemted, here mostly for legacy 
     */
    public boolean pusherfind(Class z)//
    {
        int s = pushers.size();
        boolean isThere = false;
        for(int i = 0; i < s; i++)
        {
            if(z.equals(pushers.get(i)))
            {
                isThere = true;
            }
        }
        return isThere;
    }
    /**
     * finds in moving world
     */
    public boolean movingWorldFind(Class z)// 
    {
        int s = movingWorld.size();
        boolean isThere = false;
        for(int i = 0; i < s; i++)
        {
            if(z.equals(movingWorld.get(i)))
            {
                isThere = true;
            }
        }
        return isThere;
    }
    /**
     * finds position in pusher
     */
    public int pusherfindpos(Class z)//
    {
        int s = pushers.size();
        int pos = -1;
        for(int i = 0; i < s; i++)
        {
            if(z.equals(pushers.get(i)))
            {
                pos = i;
            }
        }
        return pos;
    }
    /**
     * constructor, sets up some of the logic for the presets 
     */
    public advancedGravity()//
    {
        if(mariostyle == true)
        {
            momentumKeptInAir = false;
            bouncy = false;
            movewhileinair = true;
            run = true;
            runinair = false;
            airmomrun = false;
            mariostylere = 0;
        }
        if(movewhileinair == true && airmovinglogicdone == true)
        {
            momentumKeptInAir = false;
            airmovinglogicdone = false;
        }
        actAfterS = true;
    }
    /**
     * this all initaiates the actcycle after everything has been initated, usfull for things that need to happen after a value for like x and stuff has been assigned.
     */
    public void actAfter()
    {
        setLocation((double) getX(),(double) getY());
        specialactafter();
        actAfterS = false;
    }
    /**
     * checks if an actor is part of the collision exception
     */
    public boolean colexceptcheck(Actor z)//
    {
        boolean isThere = false;
        List<Objects> a = collexceptobb();
        
        if(anyfind(z,a))
        {
            //System.out.println("yes");
            isThere = true;
        }else
        {
            //System.out.println("no");
            //System.out.println(a);
        }
        if(anyfind(this,a))
        {
            //System.out.println(" this yes");
            isThere = true;
        }else
        {
            //System.out.println(" this no");
            //System.out.println(a);
        }
        
        /*if(selfcolexceptcheck2( a, z))
        {
            int s = a.size();
            if(anyfind(z,getIntersectingObjects(null)))
            {
                rudcollde(z,"durring check of collision exception, could have collision enabled or not.");
            }
            Class y = z.getClass();
            for(int i = 0; i < s; )
            {
                if(z.getClass().equals(advancedGravity.class))
                {
                    advancedGravity b = (advancedGravity) z;
                    if(y.equals(a.get(i)) && (!b.anyfind(this,a) || !b.anyfind(this,a)))
                    {
                        isThere = true;
                    }
                }else{
                    if(y.equals(a.get(i)) && (!anyfind(z,a)))
                    {
                        isThere = true;
                    }
                }
                i++;
            }
            if(this.getClass().equals(StickMan2.class))
            {
            }
        }else
        {
            if(z.getClass().equals(advancedGravity.class))
                {
                    advancedGravity b = (advancedGravity) z;
                    if(!anyfind(z,a) || !b.anyfind(this,a))
                    {
                        isThere = true;
                    }
                }else if(!anyfind(z,a))
            {
                isThere = true;
            }
        }*/
        return !isThere;
    }
    public boolean selfcolexceptcheck2( List a, Actor touching)//
    {
        boolean isThere2 = false;
            int s = a.size();
            if(anyfind(this,getIntersectingObjects(null)))
            {
                rudcollde(this,"durring check of collision exception, could have collision enabled or not.");
            }
            Class y = this.getClass();
                if(anyfind(y,a) && !anyfind(touching, colAdd))
                {
                        isThere2 = true;
                    
                }
            /*for(int i = 0; i < s; )
            {
                if(y.equals(a.get(i)))
                {
                    isThere2 = true;
                }
                i++;
            }*/
        return !isThere2;
    }
    public boolean colexceptcheck2(Actor z, List a, Actor touching)//
    {
        boolean isThere2 = false;
            int s = a.size();
            if(anyfind(z,getIntersectingObjects(null)))
            {
                rudcollde(z,"durring check of collision exception, could have collision enabled or not.");
            }
            Class y = z.getClass();
                if(anyfind(y,a))
                {
                    if(!anyfind(touching, colAdd))
                    {
                        isThere2 = true;
                    }
                }

            /*for(int i = 0; i < s; )
            {
                if(y.equals(a.get(i)))
                {
                    isThere2 = true;
                }
                i++;
            }*/
        return !isThere2;
    }
    /**
     * checks if any object is part of the collision exception
     */
    public boolean colexceptcheckall()//
    {
        boolean re = true;
        List<Actor> list = getIntersectingObjects(null);
        int z = list.size();
        for(int i = 0; i < z; i++  ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
        {
            //list.add(get);
            //list.get();
            Actor x = list.get(i);
            if(!anyfind(x.getClass(),colexcept) || anyfind(x.getClass(),colAdd) )
            {
                re = false;
            }
        }
        return !re;
    }
    /**
     * this is called everytime a collison is detected, put something in here to happen if for example the collison is with an object that does something other than collison.
     */
    public void rudcollde(Actor z) //
    {
        //put if statments in here to see if the thing touched was a specific thing, z is the thing and its an actor so do as you will.
            //System.out.println(getClass() + "is touching" + z.getClass());
            
    }
    /**
     * overloaded version of above, if you want you can put a string in the rudcollde to do things like detect which side something is on or idk.
     */
    public void rudcollde(Actor z, String ID) //
    {
        //put if statments in here to see if the thing touched was a specific thing, z is the thing and its an actor so do as you will.
            //System.out.println(getClass() + " Is Touching " + z.getClass() + " In way: " + ID);
            
    }
    /**
     * put this in the act of a subclass to make gravity and jumping and moving and the whole lot.
     */
    public void gravityandjump()//
    {
        if(actAfterS == true)
        {
            actAfter();
        }
        movedwidther();
        outwayparent(); //this is here to run every out way command
        groundDetect();
        wallstuff();
        bouncy();
        checkkeys();
        adjustingGround();
        gravity();
        outwayparent();
        groundDetect();
        groundDetectre();
        jumpingImgTime();
        autojumpimgdur();
        inAirMomKept();
        grounddetectcon();
        conmove();
        movingWorld();
        jumpDelayerDown();
        surfaceFriction();
        airResistance();
    }
    /**
     * makes side collison first
     */
    public void outwayparent() //
    {
        outway();
    }
    /**
     * outway version 3, stops objects from intersting forever
     */
    public void outway3(advancedGravity y)// 
    {
        List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
        for(int i = 0; i < list.size(); i++)
        {
            advancedGravity x = list.get(i);
            if(isTouching(x.getClass()) == true && (colexceptcheck(x) || anyfind(x, colAdd)))
            {
                if(y.getExactY() - y.getImage().getHeight()/2 <= x.getExactY() + x.getImage().getHeight()/2 - 2&& y.getExactY() - y.getImage().getHeight()/2 >= x.getExactY() - x.getImage().getHeight()/2 + 2) //top collison
                {
                    if( y.getExactX() > x.getExactX() - x.getImage().getWidth()/2 - 1&& y.getExactX() <= x.getExactX() + x.getImage().getWidth()/2 + 1)
                          {
                              if(y.getExactX() <= x.getExactX() + 1)
                              {
                                    y.setLocation(y.getExactX() - 1, y.getExactY());
                                    rudcollde( y);
                                }
                                if(y.getExactX() >= x.getExactX() - 1)
                              {
                                  y.setLocation(y.getExactX() + 1, y.getExactY());
                                  rudcollde( y);
                                }
                                
                            }
                }
                if(y.getExactY() + y.getImage().getHeight()/2 <= x.getExactY() + x.getImage().getHeight()/2 - 2&& y.getExactY() + y.getImage().getHeight()/2 >= x.getExactY() - x.getImage().getHeight()/2 + 2) //top collison
                {
                    if( y.getExactX() > x.getExactX() - x.getImage().getWidth()/2 - 1&& y.getExactX() <= x.getExactX() + x.getImage().getWidth()/2 + 1)
                          {
                              if(y.getExactX() <= x.getExactX() + 1)
                              {
                                    y.setLocation(y.getExactX() - 1, y.getExactY());
                                    rudcollde(y);
                                }
                                if(y.getExactX() >= x.getExactX() - 1)
                              {
                                  y.setLocation(y.getExactX() + 1, y.getExactY());
                                  rudcollde( y);
                                }
                                
                            }
                }
            }
            list = getIntersectingObjects(advancedGravity.class);
        }
    }
    //add method that makes animation happen when falling. 
    /**calculates bounce heights
     * 
     */
    public void bouncycalc()//
    {
        double x = Gravityshold;
        
        double y = ((x/2) * (x - 1))/2;
        x = 4 * ((y - 1/2) * (y - 1/2)) + 1;
        // = y
        //return y;
    }
    /**
     * fixes how sprite not the player will move into the player and do the weird things. this might cause some lag
     */
    public void spritein() //  
    {
        advancedGravity z = ((advancedGravity) getOneIntersectingObject(advancedGravity.class));
        if(isTouching(advancedGravity.class) && getExactY() + getImage().getHeight()/2 <= z.getExactY() + z.getImage().getHeight()/2 && getExactY() >= z.getExactY() - z.getImage().getHeight()/2 && getExactX() > z.getExactX() - z.getImage().getWidth()/2 && getExactX() < z.getExactX() + z.getImage().getWidth()/2)
                      {
                          if(getExactX() < ((advancedGravity) getOneIntersectingObject(advancedGravity.class)).getExactX())
                          {
                              setLocation(z.getExactX() - z.getImage().getWidth()/2 - 1, getExactY());
                              rudcollde( z);
                            }
                            if(getExactX() > z.getExactX())
                          {
                              setLocation(z.getExactX() + z.getImage().getWidth()/2 + 1 , getExactY());
                              rudcollde( z);
                            }
                          
                        }else
                        {
                            
                        }            
    }
    /**
     * does the rest of the bouncy things if the object is bouncy 
     */
    public void bouncy()//
    {
        if(bouncy == true)
        {
            //bouncycalc(); testing feautre 
            bouncejump();
        }
        
    }
    /**
     * makes the jump up if it is bouncy
     */
    public void bouncejump()//  
    {
        double z = ((-Gravityshold * elasticper) / 100)/1.05;
        if(groundcheck == 1 && -z > bouncystopspeed )
        {
            gravitys = z;
            //jumpairmomentumlogic();
            groundcheck = 0;
            grounddrepeat = 0;
            groundDetectreStart = 1;
            jumpimg();
            bouncingreset = false;
        }
    }
    /**
     * //just gravity no movment, for put in act method 
     */
    public void gravityNoMove()
    {
        if(actAfterS == true)
        {
            actAfter();
        }
        outwayparent(); //this is here to run every out way command
        groundDetect();
        
        wallstuff();
        bouncy();
        gravity();
        outwayparent();
        groundDetect();
        groundDetectre();
        jumpingImgTime();
        autojumpimgdur();
        inAirMomKept();
        grounddetectcon();
        conmove();
        movingWorld();
        surfaceFriction();
        airResistance();
        movedwidther();
    }
    /**moves the object to be at the location of another object or between the objects put in the list movedWidth. this is useful for sprites made of multiple sprites, just remember to make extra sprits invisable.
           */
    private void movedwidther()
    {
        if(movewidth)
        {
            double y = 0;
            double x = 0;
            //System.out.println(this + " moved widther");
            for(int i = 0; i <movedwidth.size(); i++)
            {
                x += movedwidth.get(i).getX();
                y += movedwidth.get(i).getY();
            }
            y /= movedwidth.size();
            x /= movedwidth.size();
            x += moveWOffX;
            y += moveWOffy;
            double distance = Math.sqrt(Math.pow((x-getX()),2) + Math.pow((y-getY()),2));
            if(distance <= moveWMspeed || moveWMspeed == 0)
            {
                setLocation(x,y);
                //System.out.println(this + " location moved width");
            }else
            {
                x = getX() + (moveWMspeed * ((x-getX())/(y-getY())))*(x-getX()/Math.abs(x-getX()));
                y = getY() + (moveWMspeed * ((x-getX())/(y-getY())))*(x-getX()/Math.abs(x-getX()));
                setLocation(x,y);
            }
        }
    }
    /**
     * calculates and does the surface friction
     */
    public void surfaceFriction()
    {
        if(groundcheck == 1)
        {
            conspeed = ((conspeed * bouncefriction)/100);
        }
    }
    /**
     * calculates the air resistance based on its variables, also does things like when the round the conspeed based on air velocity if enabeled. 
       */
    public void airResistance()
    {
        if(airResistance == true)
        {
            if(Math.abs(conspeed) <= airResistanceFullStopS)
            {
                conspeed = 0;
            }else{
                if(airResistanceAuto == true)
                {
                    conspeed = (conspeed * airResistanceSpeed)/100;
                }else
                {
                    conspeed = (conspeed * airResistanceSpeed)/100;
                }
            }
        }
    }
    /**
     * does the movment for gravity.
     */
    public void gravity()//   
    {
        if(groundcheck == 0)
        {
            setLocation​(getExactX(), getExactY() + gravitys);
            GravitySpeedChange();
        }
    }
    /**
     * changes the gravity speed for gravity every move.
     */
    public void GravitySpeedChange()//
    {
        if(gravitycounter >= gravityreloadspeed)
        {
            if(gravitys < terminalVelocity)
            {
                gravitys = gravitys + gravityspeedchange;
            }
            gravitycounter = 0;
        }
        gravitycounter++;
    }
    boolean modifiedJumpHeight;
    /**
     * is called to jump.
     */
    public void jump()//
    {
        if(groundcheck == 1 && jumpDelayer == 0)
        {
            //System.out.println(this + "  jumped");
            if(spritesidecoll(this))
            {
                if(modifiedJumpHeight)
                {
                    //System.out.println("multiplier = " + ((double) angleNum * (((double)groundheight/500 + 0)/1) ));
                    jumpheight = tempjumpHeight * ((double) angleNum * (((double)groundheight/500 + 1)/2) );
                }
                gravitys = -jumpheight;
                jumpairmomentumlogic();
                groundcheck = 0;
                grounddrepeat = 0;
                groundDetectreStart = 1;
                jumpimg();
                bouncingreset = false;
            }
        }
        if(this.getClass().equals(grave.class))
        {
            setLocation(getExactX(),getExactY() - 40);
        }
    }
    double camFov = 15;
    boolean horizonalLensOff = false;
    double lineThingLeft = 0;
    double lineThingRight = 0;
    /**
     * does logic for which speed to take
     */
    public void adjustingGround()
    {
        if(adjustableGround)
        {
            //System.out.println("controls made");
            if(Greenfoot.isKeyDown("up") && groundheight >= minGroundHeight)
            {
                if(groundcheck == 1)
                {
                    
                    //System.out.println("angleNum =" + angleNum + " groundheight = " + groundheight + " whole multiplier =" + (angleNum * ((getExactY()/500 + 0)/1)));
                    double distant = movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) );
                    groundheight -= distant;
                    
                    if(getExactX() < 750/2 && horizonalLensOff)
                    {
                        double testX =  Math.abs(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/Math.abs(750/2 - getExactX())  + 750/2;
                        //setLocation(  getExactX() + 2 * (getExactX() - (750/2 - Math.abs(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) + distant)/Math.abs(750/2 - getExactX()) )) ,getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1)));
                        //setLocation( getExactX() + 2 * (getExactX() - testX),getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1)));
                        //                        setLocation(   (750/2 - getExactX()) * ( Math.tan(Math.toRadians(camFov)) * ( Math.abs((750/2 - getExactX()))/Math.tan(Math.toRadians(camFov)) + distant)/(750/2 - getExactX())  + 750/2),getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1)));
                        double temp = getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1));
                        setLocation( (-lineThingRight) * temp + 750/2,temp);
                        //System.out.println("lineThingRight = " + lineThingRight + " now, X =" + getX() + " Y = " + getY());
                    }else if (horizonalLensOff)
                    {
                        setLocation( (750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2,getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1)));
                        lineThingLeft = ( (750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2)/(getExactY() -movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1)));
                    }
                    //System.out.println("amount = " + (-1) *  Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)  + 750/2);
                    //System.out.println("ground height increasing");
                }else if(groundcheck == 0)
                {
                    double distant = movespeedinair * (angleNum * (((double)groundheight/500 + 0)/1));
                    groundheight -= distant;
                    if(getExactX() < 750/2 && horizonalLensOff)
                    {
                                        setLocation( (750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2,getExactY());
                    }else if (horizonalLensOff)
                    {
                        setLocation(    (750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2,getExactY());
                    }
                    //System.out.println("amount = " + (-1) *  Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)  + 750/2);
                    //System.out.println("ground height increasing");
                }
            }
            if(Greenfoot.isKeyDown("down")&& groundheight <= maxGroundHeight)
            {
                if(groundcheck == 1)
                {
                    double distant = movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) );
                    groundheight += distant;
                    if(getExactX() < 750/2 && horizonalLensOff)
                    {
                            setLocation( -(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) + distant)/(750/2 - getExactX())  + 750/2,getExactY() + movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) ));
                            lineThingRight = (-(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) + distant)/(750/2 - getExactX())  + 750/2)/(getExactY() + movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) ));
                    }else if (horizonalLensOff)
                    {
                             //setLocation( -(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2,getExactY() + movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) ));
                            double temp =  getExactY() + movespeedonground * (angleNum * (((double)groundheight/500 + 0)/1) );
                             setLocation( lineThingRight * temp,temp);
                             //System.out.println("down right"+ (Math.tan(Math.toRadians(camFov)) * ( Math.abs(750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) + distant)/(750/2 - getExactX())  + 750/2));
                            }
                                        //System.out.println("ground height increasing");
                }else if(groundcheck == 0)
                {
                    double distant = movespeedinair * (angleNum * (((double)groundheight/500 + 0)/1) );
                    groundheight += distant;
                    if(getExactX() < 750/2 && horizonalLensOff)
                    {
                                        setLocation( -(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( (750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) + distant)/(750/2 - getExactX()) + 750/2, getExactY());
                    } else if(horizonalLensOff)
                    {
                        setLocation(   -(750/2 - getExactX()) * Math.tan(Math.toRadians(camFov)) * ( ( 750/2 - getExactX())/Math.tan(Math.toRadians(camFov)) - distant)/(750/2 - getExactX())  + 750/2, getExactY());
                    }
                                        //System.out.println("ground height increasing");
                }
            }
        }
    }
    public void jumpairmomentumlogic() 
    {
        if(momentumKeptInAir == true)
        {
            if(Greenfoot.isKeyDown("left"))
           {    
                if(Greenfoot.isKeyDown("x") && run == true && airmomrun == true)
                {
                    if(autovaluerun = true){
                        if(momentumKeptWhich == true)
                        {
                            aircontinuesSpeed = -movespeedonground * multiruns;
                            airjumpmomconstart = 1;
                        }
                        if(momentumKeptWhich == false)
                        {
                            aircontinuesSpeed = -movespeedinair * multiruns;
                            airjumpmomconstart = 1;
                        }
                        airjumpmomconstart = 1;
                    }else
                    {
                        if(momentumKeptWhich == true)
                        {
                            aircontinuesSpeed = -movespeedonground - rawruns;
                            airjumpmomconstart = 1;
                        }
                        if(momentumKeptWhich == false)
                        {
                            aircontinuesSpeed = -movespeedinair - rawruns;
                            airjumpmomconstart = 1;
                        }
                        airjumpmomconstart = 1;
                    }
                }else
                {
                    if(momentumKeptWhich == true)
                    {
                        aircontinuesSpeed = -movespeedonground;
                        airjumpmomconstart = 1;
                    }
                    if(momentumKeptWhich == false)
                    {
                        aircontinuesSpeed = -movespeedinair;
                        airjumpmomconstart = 1;
                    }
                    airjumpmomconstart = 1;
                }
            }
            if(Greenfoot.isKeyDown("right"))
           {
                if(Greenfoot.isKeyDown("x") && run == true && airmomrun == true)
                {
                    if(autovaluerun = true){
                        if(momentumKeptWhich == true)
                        {
                            aircontinuesSpeed = movespeedonground * multiruns;
                            airjumpmomconstart = 1;
                        }
                        if(momentumKeptWhich == false)
                        {
                            aircontinuesSpeed = movespeedinair * multiruns;
                            airjumpmomconstart = 1;
                        }
                        airjumpmomconstart = 1;
                    }else{
                        if(autovaluerun = true){
                        if(momentumKeptWhich == true)
                        {
                            aircontinuesSpeed = movespeedonground + rawruns;
                            airjumpmomconstart = 1;
                        }
                        if(momentumKeptWhich == false)
                        {
                            aircontinuesSpeed = movespeedinair + rawruns;
                            airjumpmomconstart = 1;
                        }
                        airjumpmomconstart = 1;
                        }
                    }
                }else
                {
                 if(momentumKeptWhich == true)
                {
                                aircontinuesSpeed = movespeedonground;
                                airjumpmomconstart = 1;
                }
                if(momentumKeptWhich == false)
                        {
                            aircontinuesSpeed = movespeedinair;
                            airjumpmomconstart = 1;
                        }
                airjumpmomconstart = 1;           
                }
            }
        }
            if(!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right"))
            {
                aircontinuesSpeed = 0;
            }
            if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right"))
            {
                aircontinuesSpeed = 0;
            }
    }
    /**
     * //this figures out collison with side of sprites though it could be better. 
     */
    public boolean spritesidecoll(Actor z) 
    { //might be able to add collison some where he
        boolean y = true;
        boolean x = true;
        if(colexceptcheck(z))
            {
                y = spriteColFindStick2(z);
                rudcollde( z);
                if(x == true && y == false)
                {
                    x = false;
                }
            }
        return x;
        //left off here. need to find a way that this works with side motion to. 
        
    }
    
    /**
     * this takes the normal is touching class and reworks it to except all the collision exceptions. 
     */
    public boolean isTouchingC(Class x)
    {
        boolean re;
        if(x == null)
        {
            if(getIntersectingObjectsC(null).size() > 0)
            {
                re = false;
            }
            else
            {
                re = true;
            }
        }
        if(anyfind(x,colexcept))
        {
            re = false;
        }else
        {
            re = isTouching(x);
        }
        return re;
    }
    /**
     * returns only collisionable intersecting objects
     */
    public List getIntersectingObjectsC(Class m)
    {
        List<advancedGravity> lRe = getIntersectingObjects(m);
        int s = lRe.size();
            for(int i = 0; i < s; i++)
            {
                if(anyfind(lRe.get(i).getClass(),colexcept))
                {
                    lRe.remove(i);
                }
                s = lRe.size();
            }
        return lRe;
    }
    /**second version of whats below 
    //finds teh sprite collision.
    */
    public boolean spriteColFindStick2(Actor z) 
    {
        boolean re = true;
        //below is modified outway
        List<advancedGravity> list = getIntersectingObjectsC(advancedGravity.class);
        for(int i = 0; i < list.size();  ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
        {
            //list.add(get);
            //list.get();
            
            advancedGravity x = list.get(i);
            double left = getExactX() - getImage().getWidth()/2;
            double right = getExactX() + getImage().getWidth()/2;
            double top = getExactY() - getImage().getHeight()/2;
            double bottom = getExactY() + getImage().getHeight()/2;
            double Xbottom = x.getExactY() + x.getImage().getHeight()/2;
            double Xtop = x.getExactY() - x.getImage().getHeight()/2;
            double Xright = x.getExactX() + x.getImage().getWidth()/2;
            double Xleft = x.getExactX() - x.getImage().getWidth()/2;
            //could be simiplifed, might not need to be as a class variable. 
            if(isTouching(x.getClass()) == true && colexceptcheck(x))
            {
                if(top <= Xbottom - 2 && top >= Xtop + 2) //top collison
                {
                    if(right > Xright && left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        re = false;
                        
                    }
                    if(left < Xleft +1 + pusherdetectfinder(x)&& right >= Xleft - 10) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - movecalc(x), getExactY());
                        re = false;
                    }
                }
                if(bottom <= Xbottom + 7&& bottom >= Xtop + 2) //bottom collison
                {
                    if(right > Xright +1 + pusherdetectfinder(x)&& left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        re = false;
                    }
                    if(left < Xleft + 1 + pusherdetectfinder(x)&& right >= Xleft - 20) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - movecalc(x), getExactY());
                        re = false;
                    }     
                }
                if(getExactY() <= Xbottom && getExactY() >= Xtop) //middle collison
                {
                    if(right > Xright && left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        re = false;
                    }
                    if(left < Xleft +1 + pusherdetectfinder(x) && right >= Xleft - 10) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - movecalc(x), getExactY());
                        re = false;
                    }
                }
            }
            i++;
            rudcollde( z);
            list = getIntersectingObjects(advancedGravity.class);
        }
        
        
        return re;
    }
    /**
     * //for momentum kept while in air, long jumps and such 
     */
    public void inAirMomKept()
    {
        if(airjumpmomconstart == 1 && groundcheck ==0)
        {
            if(spritesidecoll(this))
            {
                setLocation(getExactX() + aircontinuesSpeed,getExactY());
            }
        }
        if(airjumpmomconstart == 1 && groundcheck ==1)
        {
            if(spritesidecoll(this))
            {
                setLocation(getExactX() + aircontinuesSpeed,getExactY());
            }
            airjumpmomconstart = 0;
        }
    }
    /**
     * //this can be changed to make platforms as well
     */
    public void groundDetect()  
    {
        double a = getExactY() + getImage().getHeight()/2 +1;
        if( a >= groundheight && grounddrepeat == 0)
        {
            grounddrepeat = 1;
            groundcheck = 1;
            setLocation​(getExactX(), groundheight - getImage().getHeight()/2 + 1);
            if(bouncy == true && gravitys > 0){ //this one makes gravity at a ground level, can take out and replace with only sprits if you want or change the height
                bouncyre = true;
                Gravityshold = gravitys - 1;
                gravitys = 0;
                surfaceoff(null);
            } else {
            gravitys = 0;
            }
            
        } else if (bounceheightvspeed == true && grounddrepeat == 0)
        {
            List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
                for(int i = 0; i < list.size(); i++ )
                {
                    
                    advancedGravity x = list.get(i);
                    boolean t = true;
                        if(colexceptcheck(x))
                        {
                            //advancedGravity y = list.get(i);
                            double T = 1.5; //stands for tolerance make higher so that the gravity works better 
                            double Gright = getExactX() + getImage().getWidth()/2 - T;
                            double Gleft = getExactX() - getImage().getWidth()/2 + T;
                            double GXright = x.getExactX() + x.getImage().getWidth()/2 - T;
                            double GXleft = x.getExactX() - x.getImage().getWidth()/2 + T;
                            if((Gright >= GXleft && Gleft <= GXleft)/*left side*/ || (Gleft <= GXright && Gright >= GXright) /*right*/|| (Gleft >= GXleft && Gright <= GXright)/*center*/)
                            {
                                groundcheck = 1;
                            }else
                            {
                                groundcheck = 0;
                            }
                            //groundcheck = 1;
                            grounddrepeat = 1;
                                
                                //redo this 
                            double left = getExactX() - getImage().getWidth()/2;
                            double right = getExactX() + getImage().getWidth()/2;
                            double top = getExactY() - getImage().getHeight()/2;
                            double bottom = getExactY() + getImage().getHeight()/2;
                            double Xbottom = x.getExactY() + x.getImage().getHeight()/2;
                            double Xtop = x.getExactY() - x.getImage().getHeight()/2;
                            double Xright = x.getExactX() + x.getImage().getWidth()/2;
                            double Xleft = x.getExactX() - x.getImage().getWidth()/2;
                               if(bottom >= Xbottom + 2&& right > Xleft +11 && left <= Xright - 11) //bottom collision
                               {
                                    gravitys = 0;
                                    setLocation​(getExactX(), x.getExactY() + (getImage().getHeight()/2 + x.getImage().getHeight()/2 +1));
                                    groundcheck = 0;
                                    rudcollde(list.get(i),"hit, bottom");
                                } else if(right > Xleft + 11 && left < Xright- 11) // top collison
                                {
                                    rudcollde(list.get(i), "hit top");
                                    groundcheck = 1;    
                                    if(autospirthover == true)
                                    {
                                        setLocation(getExactX(),x.getExactY() - (getImage().getHeight()/2 + x.getImage().getHeight()/2 -1));
                                        surfaceoff(x);
                                    } else
                                    {
                                        setLocation(getExactX(), x.getExactY() - spritelift);
                                        surfaceoff(x);
                                    }
                                    if(bouncy == true && gravitys > 0){
                                        bouncyre = true;
                                        Gravityshold = gravitys - 1;
                                        gravitys = 0;
                                    } else {
                                        gravitys = 0;
                                    }
                                }
                                rudcollde( x);
                        }
                        list = getIntersectingObjects(advancedGravity.class);
                }
        if(groundlevelcheck == true)
        {
             groundlevelcheckkeep = true;
        }
        }else
            {
                grounddrepeat = 0;
            }
    }
    
    /**
     * //also needs to be changed if platforms are in the mix.
     */
    public void grounddetectcon() 
    {
        if(groundlevelcheckkeep == true && groundcheck == 1)
        {
            if(getExactY() + getImage().getHeight()/2 +1>= groundheight)
            {
                
            }
            else if(getIntersectingObjectsC(null).size() > 0)
            {
                List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
                for(int i = 0; i < list.size(); i++ ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
                {
                    advancedGravity x = list.get(i);
                    if(colexceptcheck(x))
                    {
                        double T = 1.5; //stands for tolerance make higher so that the gravity works better 
                        double right = getExactX() + getImage().getWidth()/2 - T;
                        double left = getExactX() - getImage().getWidth()/2 + T;
                        double Xright = x.getExactX() + x.getImage().getWidth()/2 - T;
                        double Xleft = x.getExactX() - x.getImage().getWidth()/2 + T;
                        if((right >= Xleft && left <= Xleft)/*left side*/ || (left <= Xright && right >= Xright) /*right*/|| (left >= Xleft && right <= Xright)/*center*/)
                        {
                            groundcheck = 1;
                            rudcollde(x,"durring redetection of ground");
                        }else
                        {
                            groundcheck = 0;
                        }
                    }
                    list = getIntersectingObjects(advancedGravity.class);
                }
            }else
            {
                groundcheck = 0;
            } 
            
        }
        
    }
    /**
     * //sees if all touching are in exception list.
     */
    public boolean intersectDetectReturn() 
    {
        int interAmount = 0;
        boolean interReturn = false;
        List<Actor> list = getIntersectingObjects(null);
                for(int i = 0; i < getIntersectingObjects(null).size(); i++ ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
                {
                    list = getIntersectingObjects(null);
                    Actor x = list.get(i);
                    if(!colexceptcheck(x) || anyfind(x,colAdd))
                    {
                        //list.add(get);
                        //list.get();
                        interAmount++;
                        rudcollde( x);
                    }
                }
        if(getIntersectingObjects(null).size() == interAmount)
        {
            interReturn = true;
        }
        return interReturn;
    }
    /**
     * //looks if the ground needs to be redected or not, runs the cycle after.
     */
    public void groundDetectre()
    {
        if(groundDetectreStart == 1)
        {
            grounddrepeat = 0;
            groundDetectreStart = 0;
        }
    }
    /**
     * //works on the continus movement. 
     */
    public void conmove()
    {
        if(spritesidecoll(this))
                        {
                            setLocation(getExactX() + conspeed,getExactY());
                        }
    }
    /**
     * //this does the key controls
     */
    public void movementRec(double amountX, double amountY)
    {
        
    }
    public void checkkeys() 
    {
        if(Greenfoot.isKeyDown("space"))
        {
            jump();
        }   
        if(Greenfoot.isKeyDown("right") ) 
        {
            walkinganimation(true);
            if(groundcheck == 1)
            {
                if(Greenfoot.isKeyDown("x") && run == true)
                {
                    if(autovaluerun = true){
                        if(spritesidecoll(this))
                        {
                            double x = movespeedonground * multiruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }else
                    {
                        if(spritesidecoll(this))
                        {
                            double x = movespeedonground + rawruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }
                }else
                {
                    if(spritesidecoll(this))
                    {
                        setLocation(getExactX() + movespeedonground,getExactY());
                        movementRec(getExactX() + movespeedonground,getExactY());
                    }
                }
            }
            if(groundcheck == 0 && movewhileinair == true)
            {  
                if(Greenfoot.isKeyDown("x") && runinair == true && run == true)
                {
                    if(autovaluerun = true){
                        if(spritesidecoll(this))
                        {
                            double x = (movespeedonground * multiruns);
                            setLocation(getExactX() + x,getExactY());
                        }
                        
                    }else
                    {
                        if(spritesidecoll(this))
                        {
                            double x = movespeedinair + rawruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }
                }else
                {
                    if(spritesidecoll(this))
                        {
                            setLocation(getExactX() + movespeedinair,getExactY());
                        }
                }
            }
        }
        if(Greenfoot.isKeyDown("left")) 
        {
            walkinganimation(false);
            if(groundcheck == 1)
            {   
                if(Greenfoot.isKeyDown("x") && run == true)
                {
                    if(autovaluerun = true){
                        if(spritesidecoll(this))
                        {
                            double x = -movespeedonground * multiruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                        
                    }else
                    {
                        if(spritesidecoll(this))
                        {
                            double x = -movespeedonground - rawruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }
                }else
                {
                    if(spritesidecoll(this))
                        {
                            setLocation(getExactX() -movespeedonground,getExactY());
                            movementRec(getExactX() -movespeedonground,getExactY());
                        }
                }
            }
            if(groundcheck == 0 && movewhileinair == true)
            {    
                if(Greenfoot.isKeyDown("x") && runinair == true && run == true)
                {
                    if(autovaluerun = true){
                        if(spritesidecoll(this))
                        {
                            double x =-movespeedonground * multiruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }else
                    {
                        if(spritesidecoll(this))
                        {
                            double x =-movespeedinair - rawruns;
                            setLocation(getExactX() + x,getExactY());
                            movementRec(getExactX() + x,getExactY());
                        }
                    }
                }else
                {
                    if(spritesidecoll(this))
                        {
                            double x = -movespeedinair;
                            setLocation(getExactX() + x,getExactY());
                        }
                    
                }
            }
        }
    }
    /**
     * //changes the images when jumping 
     */
    public void jumpimg()
    {
        if( animationDirection == false)
            {
                //setImage(jumpIMGL);
                setImage(scale(active,pixelComp,jumpIMGL));
            }else
            {
                //setImage(jumpIMGR);
                setImage(scale(active,pixelComp,standIMGR));
            }
        jumpingimg = jumpimgdur;
        jumpingimgstart = 1;
    }
    /**
     * //finds time for the jump image to be desplayed based on jump height a gravity. 
     */
    public void jumpingImgTime()
    {
        if(jumpingimgstart == 1 && jumpingimg > 0)
        {
            jumpingimg--; 
            jumpimgstand = 1;
        }
        if(jumpingimg == 0 && jumpimgstand == 1)
        {
            if( animationDirection == false)
            {
                //setImage(standIMGL);
                setImage(scale(active,pixelComp,standIMGL));
            }else
            {
                //setImage(standIMGR);
                setImage(scale(active,pixelComp,standIMGR));
            }       
            jumpingimgstart = 0;
            jumpimgstand = 0;
        }
    }
    /**
     * //overrides jumpimgdur to find duration automaticly
     */
    public void autojumpimgdur()  
    {
        if(autojumpdurnore == 0)
        {
            if(true)
                {
                    //System.out.println("multiplier = " + ((double) angleNum * (((double)groundheight/500 + 0)/1) ));
                    jumpheight = tempjumpHeight * ((double) angleNum * (((double)groundheight/500 + 1)/2) );
                }
            jumpimgdur = (int)(jumpheight / gravityspeedchange);
            autojumpdurnore = 1;
        }
    }
    /**
     * //is master of all the other bouncing methods 
     */
    public void bouncingparent()
    {
        if(groundcheck == 1)
        {
            gravitys = -gravitys;
            jumpairmomentumlogic();
            groundcheck = 0;
            grounddrepeat = 0;
            groundDetectreStart = 1;
            jumpimg();
            //bouncejump();
        }
    }
    /**
     * //beta to make walls work a bit better 
     */
    public void wallfind()
    {
        //first here edges, bounce off or physics of the such 
    }
    /**
     * //sprite side walls collision. 
     */
    public boolean spriteColFindStick()
    {
        boolean re = true;
        //below is modified outway
        List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
        for(int i = 0; i < list.size();  ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
        {
            //list.add(get);
            //list.get();
            advancedGravity x = list.get(i);
            double left = getExactX() - getImage().getWidth()/2;
            double right = getExactX() + getImage().getWidth()/2;
            double top = getExactY() - getImage().getHeight()/2;
            double bottom = getExactY() + getImage().getHeight()/2;
            double Xbottom = x.getExactY() + x.getImage().getHeight()/2;
            double Xtop = x.getExactY() - x.getImage().getHeight()/2;
            double Xright = x.getExactX() + x.getImage().getWidth()/2;
            double Xleft = x.getExactX() - x.getImage().getWidth()/2;
            //could be simiplifed, might not need to be as a class variable. 
            if(isTouching(x.getClass()) == true && colexceptcheck(x))
            {
                if(top <= Xbottom - 2 && top >= Xtop + 2) //top collison
                {
                    if(right > Xright && left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + 1, getExactY());
                        re = false;
                        rudcollde(x,"right");
                    }
                    if(left < Xleft && right >= Xleft - 10) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - 1, getExactY());
                        re = false;
                        rudcollde(x,"left");
                    }
                }
                if(bottom <= Xbottom + 2&& bottom >= Xtop + 2) //bottom collison
                {
                    if(right > Xright && left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + 1, getExactY());
                        re = false;
                        rudcollde(x,"right, bottom of sprite");
                    }
                    if(left < Xleft && right >= Xleft - 10) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - 1, getExactY());
                        re = false;
                        rudcollde(x,"left, bottom of sprite");
                    }     
                }
                if(getExactY() <= Xbottom && getExactY() >= Xtop) //middle collison
                {
                    if(right > Xright && left <= Xright + 10) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + 1, getExactY());
                        re = false;
                        rudcollde(x,"right Middle of sprite");
                    }
                    if(left < Xleft && right >= Xleft - 10) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - 1, getExactY());
                        re = false;
                        rudcollde(x,"left, middle of sprite");
                    }
                }
            }
            i++;
            list = getIntersectingObjects(advancedGravity.class);
        }
        return re;
    }
    /**
     * calculates movment distance.
     */
    public double movecalc(Actor x)
    {
        double re = 1;
        double a = pusherdetectfinder(x);
        if(a > 5)
        {
            re = a / 2;
        }
        if(anyfind(this,colexcept))
        {
            re = re * 16;
        }
        return re;
    }
    /**
     * 
     */
    public void outway()
    {
        List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
        for(int i = 0; i < list.size();  ) //right now the buffers work with 10 value, I set this becuase its around the move command, it may work down to about 3 though to verying extents.
        {
            advancedGravity x = list.get(i);
            try{
            
            double left = getExactX() - getImage().getWidth()/2;
            double right = getExactX() + getImage().getWidth()/2;
            double top = getExactY() - getImage().getHeight()/2;
            double bottom = getExactY() + getImage().getHeight()/2;
            double Xbottom = x.getExactY() + x.getImage().getHeight()/2;
            double Xtop = x.getExactY() - x.getImage().getHeight()/2;
            double Xright = x.getExactX() + x.getImage().getWidth()/2;
            double Xleft = x.getExactX() - x.getImage().getWidth()/2;
            //could be simiplifed, might not need to be as a class variable. 
            
            if(isTouching(x.getClass()) == true && (colexceptcheck(x) || anyfind(x,colAdd)))
            {
                if(top <= Xbottom - 2 && top >= Xtop + 2) //top collison
                {
                    if(right > Xright && left <= Xright + pusherdetectfinder(x) + 5) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        rudcollde(list.get(i), "top of sprite right");
                        //System.out.println(1);
                        wallbounceR(x);
                    }
                    //System.out.println("left side 1, left is: "+left+",right is "+right+" left of other is :" +Xleft+", calculated Xleft is as follows:" + (Xleft - pusherdetectfinder(x) - 5) +"\n, first boolean: "+(left < Xleft)+ ", second boolean: "+(right >= Xleft - pusherdetectfinder(x) - 5)+"  ");
                    //System.out.println("both booleans: " +(left < Xleft  && right >= Xleft - pusherdetectfinder(x) - 5));
                    if(left < Xleft  && right >= Xleft - pusherdetectfinder(x) - 5) // if charactor is touching left side 
                    {
                        //System.out.println(2.5);
                        setLocation( getExactX() - movecalc(x), getExactY());
                        rudcollde(list.get(i),"top of sprite left");
                        //System.out.println(2);
                        wallbounceL(x);
                    }

                }
                if(bottom <= Xbottom + 7&& bottom >= Xtop + 2) //bottom collison
                {
                    if(right > Xright && left <= Xright + 1 + pusherdetectfinder(x)) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        rudcollde(list.get(i),"bottom of sprite right");
                        //System.out.println(3);
                        wallbounceR(x);
                    }
                    if(left < Xleft + 1  && right >= Xleft - pusherdetectfinder(x) - 5) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - movecalc(x), getExactY());
                        rudcollde(list.get(i));
                        //System.out.println(4);
                        wallbounceL(x);
                    }     
                }
                if(getExactY() <= Xbottom && getExactY() >= Xtop) //middle collison
                {
                    if(right > Xright && left <= Xright + pusherdetectfinder(x)+1) // if charactor is touching right side 
                    {
                        setLocation( getExactX() + movecalc(x), getExactY());
                        rudcollde(list.get(i));
                        //System.out.println(5);
                        wallbounceR(x);
                    }
                    if(left < Xleft + 1 + pusherdetectfinder(x) +1&& right >= Xleft - 5) // if charactor is touching left side 
                    {
                        setLocation( getExactX() - movecalc(x),getExactY());
                        rudcollde(list.get(i));
                        //System.out.println(6);
                        wallbounceL(x);
                    }
                }
            }
            }catch(Exception e)
            {//System.out.println("error with outway");
            }
            i++;
            rudcollde( x);
            list = getIntersectingObjects(advancedGravity.class);
        }
    }
    /**
     * //makes things bounce off walls 
     */
    public void wallbounceL(Actor z)
    {
        //System.out.println("wallbounceL");
        //System.out.println("sprite Sidebounce =" + spriteSideBounce + " conspeed = " + conspeed);
        if(spriteSideBounce == true && conspeed > 0)
        {
            if(bounceoffspeed(z) < conspeed)
            {
                
            }
            conspeed = -((conspeed - bounceoffspeed(z)) * elasticperside)/100;
            //System.out.println(z.getClass());
        }else if (spriteSideBounce == false || bouncy == false)
        {
            conspeed = 0;
        }
    }
    /*why conspeed is inverse I have no idea*/
    public void wallbounceR(Actor z)
    {
               //System.out.println("wallbounceR");
               //System.out.println("sprite Sidebounce =" + spriteSideBounce + " conspeed = " + conspeed);
        if(spriteSideBounce == true && bouncy && conspeed < 0)
        {
            if(bounceoffspeed(z) < conspeed)
            {
                
            }
            conspeed = -((conspeed + bounceoffspeed(z)) * elasticperside)/100;
            rudcollde( z);
            //System.out.println(z.getClass());
        }else if (spriteSideBounce == false || bouncy == false)
        {
            conspeed = 0;
        }
    }
    /**
     * //need to fix this do this 
     */
    public double bounceoffspeed(Actor z) 
    {
        double speed = 0;
        Class x = z.getClass();
        speed = movesthingspeed;
        if(anyfind(x, pushers))
        {
            speed = pusherdetectfinder(z);
            
        }
        rudcollde( z);
        return speed;
    }
    /**
     * // does some of the bouncing sideways speeds for horizontal surfaces
     */
    public void surfaceoff(Actor z)
    {
        //System.out.println("sideways");
        if(surfaceOffDo == true)
        {
            int speed = 0; 
            if(z != null)
            {
                conspeed = (conspeed * bouncefriction)/100 + (pusherdetectfinder(z) * (100 -bouncefriction))/100; 
            }
            if(z == null)
            {
                conspeed = (conspeed * bouncefriction)/100;
            }
        }
        rudcollde( z);
    }
    /**
     * // helps with collison of walls and the bouncing of it 
     */
    public void wallstuff()
    {
        double xvalleft = getExactX() - getImage().getWidth();
        double xvallright = getExactX() + getImage().getWidth();
        //System.out.println("edge bounce");
        if(xvalleft < 0 + getImage().getWidth()/2 +1) //left wall buffer of 1
        {
        //stuff that happens if left wall is touched
            if(wallbounce == true)
            {
                if(conspeed < 0)
                {
                    conspeed = -(conspeed * elasticperside)/100;
                }
            }
        }
        if(xvallright > 750 - getImage().getWidth()/2 + 1) // right wall buffer of 1
        {
        //stuff that happens if right wall is touched
            if(wallbounce == true)
            {
                if(conspeed > 0)
                {
                conspeed = -(conspeed * elasticperside)/100;
                }
            }    
        }
    }
    /**
     * // moves an object when it needs  to be as it is on or to the side of something that is and moves things 
     */
    public void movenear()
    {
        if(movesthing == true)
        {
            List<advancedGravity> list = getIntersectingObjects(advancedGravity.class);
            for(int i = 0; i < list.size(); i++)
            {
                advancedGravity x = list.get(i);
                if(colexceptcheck(x) /*|| anyfind(x,colAdd)*/)
                {
                    double left = getExactX() - getImage().getWidth()/2;
                    double right = getExactX() + getImage().getWidth()/2;
                    double top = getExactY() - getImage().getHeight()/2;
                    double bottom = getExactY() + getImage().getHeight()/2;
                    double Xbottom = x.getExactY() + x.getImage().getHeight()/2;
                    double Xtop = x.getExactY() - x.getImage().getHeight()/2;
                    double Xright = x.getExactX() + x.getImage().getWidth()/2;
                    double Xleft = x.getExactX() - x.getImage().getWidth()/2;
                    if(x != null && movecheck(x.getClass()) && getExactY() + getImage().getHeight() >= x.getExactY() - getImage().getHeight() - 1 && right > Xleft + 4 && left < Xleft + 4) { //was here
                        x.setLocation( x.getExactX() + speedpulls, x.getExactY());
                    } else if(x != null && movecheck(x.getClass()) && getExactY() + getImage().getHeight() >= x.getExactY() - getImage().getHeight() - 1 && right > Xright - 4 && left < Xright - 4) { //was here
                        x.setLocation( x.getExactX() + speedpulls, x.getExactY());
                    }else if(x != null && movecheck(x.getClass()) && getExactY() + getImage().getHeight() >= x.getExactY() - getImage().getHeight() - 1 && right < Xright - 2 && left > Xleft + 2) { //was here
                        x.setLocation( x.getExactX() + speedpulls, x.getExactY());
                    }
                }
                rudcollde( x);
                list = getIntersectingObjects(advancedGravity.class);
            }
        }
    }
    /**
     * checks for movment. 
     */
    public boolean movecheck(Class z)
    {
        int s = movedbyexcept.size();
        boolean isThere = false;
        for(int i = 0; i < s; )
        {
            if(z.equals(movedbyexcept.get(i)))
            {
                isThere = true;
            }
            i++;
        }
        return isThere;
    }
    /**this stuff does much of the detection for the buttons, can detect holds and how long something is pressed and which are pressed, used now for the released varaible.
     * 
     */
    public void stuff()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (Greenfoot.mousePressed(null))
        {
            if(mi != null)
            {
                buttonsDown += mi.getButton();
            }
            if (buttonsDown == btnLEFT) released = false;;
            if (buttonsDown == btnRIGHT) ;;
            if (buttonsDown == btnLEFT + btnRIGHT) ;;
        }
        if (buttonsDown != btnNEITHER && Greenfoot.mouseClicked(null)) 
        {
            int wasDown = buttonsDown;
            if(mi != null)
            {
                buttonsDown -= mi.getButton();
            }else{ 
                buttonsDown = wasDown;
            }
            int buttonReleased = wasDown - buttonsDown;
            if (buttonReleased == btnLEFT) released = true;;
            if (buttonReleased == btnRIGHT) ;;
            if (buttonsDown == btnNEITHER) ;;
        }
    }
    /**the main method for making buttons work, put this in code for button ability 
    */
     public void buttonworks()
    {
        if(gravCtimeR > 0)
        {
                    gravCtimeR--;
        }
        if(BCtimeR > 0)
        {
                    BCtimeR--;
        }
        if(ICtimeR > 0)
        {
                    ICtimeR--;
        }
        //hover detection 
        if(mouseHoveringOver(this))
        {
        }
        stuff();
        if(!mouseHoveringOver(this) && clickity == false)
        {
        }
        if (!mouseDown && Greenfoot.mousePressed(this)) {  
            clickity = true;
            //button functions here.
            function = true;
        }  
        if (mouseDown && Greenfoot.mouseClicked(this)) {
        }  
        if(clickity == true && !Greenfoot.mousePressed(this))
        {
            clickitycount++;
        }
        if(clickity == true && clickitycount >= buttonpresstime && !Greenfoot.mousePressed(this))
        {
            clickity = false;
            clickitycount = 0;
        }
        if(buttonfdework > 0){buttonfdework--;}
        if(released == false && mouseHoveringOver(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(Greenfoot.isKeyDown("g"))
            {
                if(gravCtimeR <= 0)
                {
                    if( fixedVGravity == true)
                    {
                        fixedVGravity = false;
                    }else
                    {
                        fixedVGravity = true;    
                    }
                    gravCtimeR = gravCtime;
                }
            }
            if(Greenfoot.isKeyDown("b"))
            {
                if(BCtimeR <= 0)
                {
                    if( bouncy == true)
                    {
                        bouncy = false;
                        wallbounce = false;
                    }else
                    {
                        bouncy = true;
                        wallbounce = true;    
                    }
                    BCtimeR = BCtime;
                }
            }
            if(Greenfoot.isKeyDown("i"))//collision on off
            {
                if(ICtimeR <= 0)
                {
                    if(anyfind(this.getClass(),inColex))
                    {
                        //anyRemove(this.getClass(),colexcept);
                        anyRemove(this,inColex);
                    }else
                    {
                        //colexcept.add(this.getClass());  
                        inColex.add(this);
                    }
                    ICtimeR = ICtime;
                }
            }
            if(mouse != null)
            {
                setLocation(mouse.getX(),mouse.getY());
                gravitys = 0;
                prevMouseX = mouse.getX();
                prevMouseY = mouse.getY();
                mouseReleasedN = true;
            } else {
                gravitys = 0;
                mouseReleasedN = true;
            }
        }else if(mouseReleasedN == true)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse != null)
            {
                conspeed = (mouse.getX() - prevMouseX)/2;
                gravitys = (mouse.getY() - prevMouseY)/1;
            }else
            {
                conspeed = 0;
                gravitys = 0;
            }
            mouseReleasedN = false;
        }
        
    }
    /**
     * //finds distance bewtween two points to exact
     */
    public double findDistanceBetween(double x, double y,double Px, double Py) 
    {
        return Math.sqrt(Math.pow(x - Px, 2) + Math.pow(y - Py, 2));
    }
    /**
     * method sees which button the mouse is hovering over.
     */
    private void hoverOwner() {
        if ((actorHoveredOver == null || actorHoveredOver.getWorld() == null) && Greenfoot.mouseMoved(this)) 
        {
            actorHoveredOver = this;
        } else if (actorHoveredOver == this && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) 
        {
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
    /**return the button that the mouse is over
    this just returns the one that hovered 
    */
    public Actor getHoverOwner() 
    {//
        return actorHoveredOver;
    }
}
