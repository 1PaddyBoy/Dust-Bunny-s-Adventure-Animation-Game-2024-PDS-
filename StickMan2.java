import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList; //makes lists for some things
/**
 * Write a description of class StickMan2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StickMan2 extends advancedGravity
{
    /**
     * Act - do whatever the StickMan2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     */
    long lastAdded = System.currentTimeMillis();
    public static boolean col = true; // determins if it has collision, true means that things can touch and stand on it. false means they can't like used for bullets and things that do other things on impact.
    boolean gameoverwork = false; //turn off to turn off gameover things
    //remember to change the speed of which the charactor moves out the way.
    
    public StickMan2()
    {
        deleted = false;
        //make any variable exceptions here, like if you want any to be different from default 
        standIMGR = new GreenfootImage("standR.png");
        jumpIMGR = new GreenfootImage("JumpR.png");
        standIMGL = new GreenfootImage("standL.png");
        jumpIMGL = new GreenfootImage("JumpL.png");
        elasticper = 10;
        wallbounce = true;
        conspeed = 0;
        elasticperside = 10;
        bouncefriction = 10;
        ismovedby = true;
        spriteSideBounce = false;
        fixedVGravity = true;
        colAdd.add(bigplat.class);
        moveWOffX = 0;
        moveWOffy = 100;
    }
    public StickMan2(String use,double imgper)
    {
        if(use.equals("bunny"))
        {
            GreenfootImage right = new GreenfootImage("Bunny_right.png");
            right.scale(50,49);
            GreenfootImage left = new GreenfootImage("Bunny_left.png");
            left.scale(50,49);
            GreenfootImage left_hop1 = new GreenfootImage("Bunny_left_hop1.png");
            GreenfootImage left_hop2 = new GreenfootImage("Bunny_left_hop2.png");
            GreenfootImage left_hop3 = new GreenfootImage("Bunny_left_hop3.png");
            GreenfootImage right_hop1 = new GreenfootImage("Bunny_left_hop1.png");
            GreenfootImage right_hop2 = new GreenfootImage("Bunny_left_hop2.png");
            GreenfootImage right_hop3 = new GreenfootImage("Bunny_left_hop3.png");
            left_hop1.scale(50,49);
            left_hop2.scale(50,49);
            left_hop3.scale(50,49);
            right_hop1.scale(50,49);
            right_hop2.scale(50,49);
            right_hop3.scale(50,49);
            standIMGR = right;
            jumpIMGR = right;
            standIMGL = left;
            jumpIMGL = left;
            
            elasticper = 10;
            wallbounce = true;
            conspeed = 0;
            elasticperside = 10;
            bouncefriction = 10;
            ismovedby = true;
            spriteSideBounce = false;
            fixedVGravity = true;
            moveWOffX = 0;
            moveWOffy = 100;
            
            falling.clear();
            //falling.add(new GreenfootImage("Bunny_left.png"));
            falling.add(right);
            
            bFalling.clear();
                      //  bFalling.add(new GreenfootImage("Bunny_left.png"));
                      bFalling.add(right);
            EFalling.clear();
                     //   EFalling.add(new GreenfootImage("Bunny_left.png"));
                     EFalling.add(right);
            RWalking.clear();
                        RWalking.add(right_hop1);
                        RWalking.add(right_hop2);
                        RWalking.add(right_hop3);
            LWalking.clear();
                        LWalking.add(left_hop1);
                        LWalking.add(left_hop2);
                        LWalking.add(left_hop3);
            //System.out.println("bunny prep done");
            setLocation(750/2,500/2);
            minGroundHeight = 200;
            pixelComp = 0;
            this.active = true;
            movespeedonground = 5;
            movespeedinair = 5;
            this.imgper = imgper;
            fallBeginningAnimation = false;
            
        }
    }

    GreenfootImage right = new GreenfootImage("Bunny_right.png");
    GreenfootImage left = new GreenfootImage("Bunny_left.png");
    String imgright = "Bunny_right.png";
    String imgleft = "Bunny_left.png";
    //double imgper = 1;
    private boolean isG3;
    public StickMan2(String use,double cameraAngle, int X, int Y,int pixelcomp)
    {
        deleted = false;
        if(use.equals("bunny"))
        {
            this.pixelComp = pixelcomp;
            GreenfootImage right = new GreenfootImage("Bunny_right.png");
            right.scale(50,49);
            GreenfootImage left = new GreenfootImage("Bunny_left.png");
            GreenfootImage left_hop1 = new GreenfootImage("Bunny_left_hop1.png");
            GreenfootImage left_hop2 = new GreenfootImage("Bunny_left_hop2.png");
            GreenfootImage left_hop3 = new GreenfootImage("Bunny_left_hop3.png");
            GreenfootImage right_hop1 = new GreenfootImage("Bunny_left_hop1.png");
            GreenfootImage right_hop2 = new GreenfootImage("Bunny_left_hop2.png");
            GreenfootImage right_hop3 = new GreenfootImage("Bunny_left_hop3.png");
            left.scale(50,49);
            standIMGR = right;
            jumpIMGR = right;
            standIMGL = left;
            jumpIMGL = left;
            
            elasticper = 10;
            wallbounce = true;
            conspeed = 0;
            elasticperside = 10;
            bouncefriction = 10;
            ismovedby = true;
            spriteSideBounce = false;
            fixedVGravity = true;
            moveWOffX = 0;
            moveWOffy = 100;
            
            falling.clear();
            //falling.add(new GreenfootImage("Bunny_left.png"));
            falling.add(right);
            
            bFalling.clear();
                      //  bFalling.add(new GreenfootImage("Bunny_left.png"));
                      bFalling.add(right);
            EFalling.clear();
                     //   EFalling.add(new GreenfootImage("Bunny_left.png"));
                     EFalling.add(right);
            RWalking.clear();
                        RWalking.add(right_hop1);
                        RWalking.add(right_hop2);
                        RWalking.add(right_hop3);
            LWalking.clear();
                        LWalking.add(left_hop1);
                        LWalking.add(left_hop2);
                        LWalking.add(left_hop3);
            //System.out.println("bunny prep done");
            setLocation(750/2,500/2);
            minGroundHeight = 200;
            pixelComp = 0;
            this.active = true;
            //System.out.println("bunny prep done");
            
            movespeedonground = 5;
            movespeedinair = 5;
            this.imgper = imgper;
            defaultX = X;
            defaultY = Y;
        }else
        {
        
        }
        angleNum = - Math.cos(90-(45/2)-cameraAngle);
    }
    public void setIsG3(boolean a)
    {
        isG3 = a;
    }
    boolean firstAfter = false;
    // active = false;
    //int pixelComp = 0;
    long lastscaleT = System.currentTimeMillis();
    long curscaleT = System.currentTimeMillis();
    int scaleDiffT = 100;
    
    public void scale(boolean active, int pixelComp)
    {
        curscaleT = System.currentTimeMillis();
        if(active && curscaleT > lastscaleT + scaleDiffT)
        {
            lastscaleT = System.currentTimeMillis();
            double a = (((double)groundheight / (500-pixelComp)));
            try{
                GreenfootImage b;
                if(direction == 0)
                {
                    //left.scale((int) (50 * a), (int) (49 * a)); 
                    b = new GreenfootImage(imgleft);
                }else if (direction == 1)
                {
                    //right.scale((int) (50 * a), (int) (49 * a));
                    b = new GreenfootImage(imgright);
                }else
                {
                    b = new GreenfootImage(imgleft);
                    //System.out.println("direction image not found");
                }
                b.scale((int) ((defaultX * imgper * a)), (int) ((defaultY * imgper * a)));
                if(b.getWidth() < 5 || b.getHeight() < 5)
                {
                    
                }else
                {
                    setImage(b);
                }
                //getImage().scale((int) (50 * a), (int) (49 * a)); 
                
            }catch(Exception e)
            {
                //System.out.println(e);
            }
        }
    }
    public boolean scaling;
    private static boolean deleted;
    public void act()
    {
                //System.out.println("before" + getImage() + " width " + getImage().getWidth() + " Height" + getImage().getHeight());
        //System.out.println("detection check, col except video" + colexceptcheck(new video("a")));
        actAfterSetUp();
        MyWorld myworld = (MyWorld)getWorld();
        if(myworld.running == true)
        {
            if(fixedVGravity == true)
            {
                gravityandjump();
            }
            if(gameoverwork == true)
            {
                gameoverfind();
            }
            //outway();
            //deathballdeath();
        }
        animationParent();
        buttonworks();
        /*if(isTouching(deathBall.class))
        {
            Greenfoot.stop();
        }*/
        if(scaling)
        {
            scale(active,pixelComp);
        }
        //System.out.println("after" + getImage() + " width " + getImage().getWidth() + " Height" + getImage().getHeight());
        double a = (((double)groundheight / (500-pixelComp)));
        if(isG3)
        {
            if(getX() < 70 && getX() + getImage().getWidth()/2 < 0)
            {
                
                    
                
                //((MyWorld) getWorld()).succeed("G3");
                ((MyWorld) getWorld()).bunnyEnd();
                /*if(this != null)*/
                setLocation(-300,-500);
                    getWorld().removeObject(this);
                
                
            }else if (getX() > 730 && getX() - getImage().getWidth()/2 >= 750)
            {
                //((MyWorld) getWorld()).succeed("G3");
                ((MyWorld) getWorld()).bunnyEnd();
                getWorld().removeObject(this);
                deleted = true;
            }else if(isTouching(dog.class) && deleted == false)
            {
                ((MyWorld) getWorld()).G3fail("G3","dog");
            }else if(isTouching(grave.class) && deleted == false)
            {
                ((MyWorld) getWorld()).G3fail("G3","grave");
            }
        }
        
        //System.out.println("width" + (new GreenfootImage(imgleft)).getWidth() * imgper * a + " a = " + a + "   imgper = " +imgper);
        //System.out.println("width" + (new GreenfootImage(imgright)).getWidth() * imgper * a + " a = " + a + "   imgper = " +imgper);
    }
    /*public void rudcollde(Actor z) //
    {
        //put if statments in here to see if the thing touched was a specific thing, z is the thing and its an actor so do as you will.
            //System.out.println(getClass() + "is touching" + z.getClass());
        
    }*/
    public boolean isTouching(Class a, int off)
    {
        /*//boolean re;
        for(Object b : getWorld().getObjects(a))
        {
            Actor c = (Actor) b;
            int cWidth = c.getImage().getWidth();
            int cHeight = c.getImage().getHeight();
            
            int cBottom = c.getY() + cHeight/2 - off;
            int cTop = c.getY() - cHeight/2 + off;
            int cRight = c.getX() + cWidth/2 - off; 
            int cLeft = c.getX() - cWidth/2 + off;
            
            int Width = getImage().getWidth();
            int Height = getImage().getHeight();
            
            int Bottom = getY() + Height/2 - off;
            int Top = getY() - Height/2 + off;
            int Right = getX() + Width/2 - off; 
            int Left = getX() - Width/2 + off;
            
            if(((Bottom > cTop && Top > cTop) || (Top < cBottom && Bottom > cBottom)) && ( (Right > cLeft && Left < cLeft) || (Left < cRight && Right > cRight) ))
            {
                return true;
            }
        }
        
        return false;*/
        return isTouching(a);
    }
    public void deathballdeath()
    {
        deathBall a = (deathBall) getOneIntersectingObject(deathBall.class);
        if (a != null) {
            gameover();
        }
    }
    public void gameover()
    {
        getWorld().showText("Game Over", 200, 200);
            List objects = getWorld().getObjects(null);
            getWorld().removeObjects(objects);
    }
    public void gameoverfind()
    {
        if(isAtEdge())
        {
            gameover();
        }
        gameoverfind2();
        
    }
    public void gameoverfind2()
    {
         alligatgor a = (alligatgor) getOneIntersectingObject(alligatgor.class);
        if (a != null) {
            gameover();
        }
    }
     public void rudcollde(Actor z) //
    {
        //put if statments in here to see if the thing touched was a specific thing, z is the thing and its an actor so do as you will.
            //System.out.println(getClass() + "is touching" + z.getClass());
            if(z.getClass().equals(deathBall.class))
                getWorld().setBackground("smiley5.png");
                
           /*if(isG3 && (z.getClass().equals(grave.class) || z.getClass().equals(grave.class)))
        {
            ((MyWorld) getWorld()).G3fail("G3","grave");
            //((MyWorld) getWorld()).G3fail("G3","dog");
        }*/
    }       
}
        
