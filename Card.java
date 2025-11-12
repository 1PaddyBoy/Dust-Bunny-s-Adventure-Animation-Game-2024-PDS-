import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int counter = 0;
    int flipCount = 0;
    int hideCount = 0;
    
    boolean finishedHide = false;
    boolean increase = false;
    boolean turn = false;
    boolean turned = false;
    boolean Rturned = false;
    boolean start = true;
    
    public static int cardsFound = 0;
    int clock = 200;
    int height = 0;
    String card = "";
    boolean isCorrect;
    int wrongCard = 0;
    String back = "Game2_back.png";
    
    double Imagescalar = 1;
    public Card(boolean correct)
    {
        if(correct == true)
        {
            card = "Game2_correctCarrot.png";
        }
        if(correct == false)
        {
            card = "Game2_wrongX.png";
        }
        isCorrect = correct;
        height = getImage().getHeight();
    }
    public void act()
    {
        
        if(start == true)
        {
            showCards();
        }
        if(start == false)
        {
            ////////////
            hide();
            if(finishedHide == true)
            {
                start();
                
            }
        }
    }
    public void refresh()
    {
        
        Rturned = false;
        finishedHide = false;
    }
    public void function()
    {
        turn = true;
    }
    public void start()
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            if(Greenfoot.getMouseInfo().getButton() == 1 && isTouching(Mouse.class) || Greenfoot.mousePressed(this))
            {
                function();
            }
        }
        if(turn == true)
        {
            
            flip();
            
        }
        if(turn == false)
        {
            zoom();
        }
        height = getImage().getHeight();
    }
    public void showCards()
    {
        if(start == true)
        {
            clock--;
            setImage(card);
            getWorld().showText(""+(clock/40), 20, 20);
            ///////
            height = getImage().getHeight();
        }
        if(clock == 0)
        {
            start = false;
            refresh();
            getWorld().showText("", 20, 20);
            clock = 200;
        }
    }
    
    public void zoom()
    {
        if(isTouching(Mouse.class))
        {
            increase = true;
        }
        else
        {
            increase = false;
        }
        if(counter<2 && increase == true)
        {
            counter++;
        }
        if(counter>0 && increase != true)
        {
            counter--;
        }
        GreenfootImage image = new GreenfootImage(back);
        image.scale((int)(image.getWidth()/Imagescalar),(int)( image.getHeight()/Imagescalar));
        double x = image.getWidth()*(1 + (.1*counter));
        double y = image.getHeight()*(1 + (.1*counter));
        if(Imagescalar == 1)
        {
            image.scale((int)x, (int)y);
        }
        setImage(image);
    }
    public void flip()
    {
        flipCount ++;
        if(flipCount == 1)
        {
            
            if(height>10 && turned == false)
            {
                GreenfootImage image = new GreenfootImage(back);
                image.scale((int)(image.getWidth()/Imagescalar),(int)( image.getHeight()/Imagescalar));
                image.scale(image.getWidth(), height-10);
                setImage(image);
                flipCount = 0;
            }
            if(height <= 10)
            {
                turned = true;
            }
            if(turned == true && height < 118)
            {
                GreenfootImage image = new GreenfootImage(card);
                image.scale((int)(image.getWidth()/Imagescalar),(int)( image.getHeight()/Imagescalar));
                image.scale(image.getWidth(), height+10);
                setImage(image);
                flipCount = 0;
            }
            if(turned == true && height >=118 && isCorrect == true)
            {
                cardsFound +=1;
            }
            if(turned == true && height >=118 && isCorrect == false)
            {
                wrongCard +=1;
                //Greenfoot.stop();
                ( (MyWorld) getWorld()).fail("G2");
                //////////////
            }
        }
    }
    boolean firsthideEnd = false;
    public void hide()
    {
        hideCount ++;
        if(hideCount == 1)
        {
            if(height > 10 && Rturned == false)
            {
                GreenfootImage image = new GreenfootImage(card);
                image.scale((int)(image.getWidth()/Imagescalar),(int)( image.getHeight()/Imagescalar));
                System.out.println("hide 1");
                height -=10;
                image.scale(image.getWidth(), height);
                setImage(image);
                hideCount = 0;
            }
            if(height <= 10)
            {
                Rturned = true;
            }
            if(Rturned == true && height < (int) ((new GreenfootImage(back)).getHeight()/Imagescalar))
            {
                GreenfootImage image = new GreenfootImage(back);
                image.scale((int)(image.getWidth()/Imagescalar),(int)( image.getHeight()/Imagescalar));
                System.out.println("hide 2");
                height +=10;
                image.scale(image.getWidth(), height);

                setImage(image);
                hideCount = 0;
                firsthideEnd = true;
            }
            if(Rturned == true && height >= (int) ((new GreenfootImage(back)).getHeight()/Imagescalar))
            {
                finishedHide = true;
                //Rturned = true;
                System.out.println("hide done");
                if(firsthideEnd)
                {
                    special();
                    firsthideEnd = false;
                }
            }
        }
    }
    public void special()
    {
    
    }
    
}
