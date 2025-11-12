import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * The Stickman world. Very simple; just place a stickman.
 * 
 * @author mik
 * @version 1.0
 */
public class MyWorld extends World
{
    public boolean paused = false;
    public static boolean running = true;
    boolean alreadyrunf = false;
    long lastAdded = System.currentTimeMillis();
    long lastAdded2 = System.currentTimeMillis();
    long curTime = System.currentTimeMillis();
    long endtime = 3600;//how long the acheivments stay on screen.
    long endtime2 = 10000;//how long the acheivments stay on screen.
    private boolean heightA = false;
    String acheiveD = "";
    private boolean heightRe = false;
    private boolean heightAHold = false;
    public static double movementspeed = 1; 
    boolean linearG = false;
    
    boolean advancedAn = true;
    
    boolean[] achievements = new boolean[7];
    int earnedA = 0;
    
    //game 1 stuff 
    boolean oneactive = false;
    boolean game1startExplain = false;
    boolean G1directions = false;
    double speedOb = 5000; // one average how many miliseconds an obstacle spawns. 
    long G1lastTime = System.currentTimeMillis();
    long G1firstTime = System.currentTimeMillis();
    long G1curTime = System.currentTimeMillis();
    int G1randomElement = 10; // this is how much random there is. 
    double G1graveSpeed = 1; //speed of graves 
    
    //game 2 stuff
    int cycle = 3;
    int maxcycle = 3;
    boolean twoactive = false;
    
    
    //game 3 stuff
        boolean threeactive = false;
    
    //game 4 stuff
    boolean fouractive = false;
    int delay = 0, thresh=25+Greenfoot.getRandomNumber(25), level=1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    String line1="Use the arrow keys to move";
    String line2="the bunny across the road";
    String line3="while avoiding the cars.";
    String line4="Press space to start.";
    boolean start=false;
    
    
    //game 5 stuff 
        boolean fiveactive = false;
    
    
    
        //game 6 stuff:
    boolean sixactive = false;
    long lastAdded3 = System.currentTimeMillis();
    int timeDiff = 1000;
    int arrowNumber1;
    int arrowNumber2;
    
    public static int score = 0;
    
    int formationType;
    private String[] imageArrow = {"left", "down", "right", "up"};
    private int[] xArrow = {150, 250, 350, 450};
    private String[] soundArrow = {"", "", "", ""};
    
    //game 7 stuff 
    boolean sevenactive = false;
    boolean G7directions = false;
    
    boolean beginanimation = true;
    long curTimet; 
    long lastTimet = System.currentTimeMillis();
    long framerateT = 1000/40;
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public void act()
    {
            
            if(running)
            {
                curTimet = System.currentTimeMillis();
                while(curTimet < lastTimet + framerateT)
                {
                    curTimet = System.currentTimeMillis();
                }
                //System.out.println("action target FPS is " + (1000 / framerateT) + " current frameRate is " + ((double)1000/ (curTimet - lastTimet) ));
                lastTimet = System.currentTimeMillis();
                
                curTime = System.currentTimeMillis();
                if(lastAdded + 30 < curTime)
                {
                    if(heightB() == true && heightAHold == false)
                    {
                        heightA = true;
                        heightAHold = true;
                    }
                }
                if(heightA == true)
                {
                    lastAdded = System.currentTimeMillis();
                    acheiveD = "Acheivement Unlocked: Threw object very very high";
                    heightRe = true;
                    heightA = false;
                    
                }
                if(heightRe == true)
                {
                    if(lastAdded + endtime2 < curTime)
                    {
                        heightRe = false;
                        acheiveD = "";
                    }
                }
                showText(acheiveD,300,200);
                //System.out.println(sevenactive);
                //System.out.println(fouractive + " " + running);
                if(oneactive && running)
                {
                    G1act();
                }else if(twoactive && running)
                {
                    G2failwait();
                    G2act();
                }else if(threeactive && running)
                {
                    G3act();
                } else if(fouractive && running)
                {
                    G4act();
                }else if(fiveactive && running)
                {
                    G5act();
                }else if(sixactive && running)
                {
                    G6act();
                }else if(sevenactive && running)
                {
                    //System.out.println("G7 act is run or something");
                    G7act();
                }
                 
                
                
                
                if((oneactive || twoactive || threeactive || fouractive || fiveactive || sixactive || sevenactive) && getObjects(slider.class).size() <= 0)
                {
                    //sliderAdd();
                    sliderUpdate(0);
                }
                
                for(sandbox b : getObjects(sandbox.class))
                {
                    //System.out.println("length = " + getObjects(sandbox.class).size() + " this " + b + "  pic = " + b.getImage() + " X = "+ b.getX() + " Y=" + b.getY() + " scale = " + b.getImage().getWidth() + " " + b.getImage().getHeight());
                }
            }
            videoPlay();
            if(getObjects(home.class).size() <= 0)
                {
                    addObject(new home(50,50,"home","menu"),50,40);
                    
                    setPaintOrder(video.class,Buttons.class);
                    //System.out.println("make new home");
                    makeCoin();
                }
    }
    public void makeCoin()
    {
        removeObjects(getObjects(achievement.class));
        GreenfootImage a = new GreenfootImage("coins\\TopBar_coinbag_plain.png");
                    switch(earnedA)
       {

                        case 1:
                            a = new GreenfootImage("coins\\TopBar_coinbag_1.png");
                            break;
                        case 2:
                            a = new GreenfootImage("coins\\TopBar_coinbag_2.png");
                            break;
                        case 3:
                            a = new GreenfootImage("coins\\TopBar_coinbag_3.png");
                            break;
                        case 4:
                            a = new GreenfootImage("coins\\TopBar_coinbag_4.png");
                            break;
                        case 5:
                            a = new GreenfootImage("coins\\TopBar_coinbag_5.png");
                            break; 
                        case 6:
                            a = new GreenfootImage("coins\\TopBar_coinbag_6.png");
                            break;
                        case 7:
                            a = new GreenfootImage("coins\\TopBar_coinbag_7.png");
                            break;
                    }
                    achievement ach =  new achievement(50,50,"","achievements",a);
                    addObject(ach,625,40);
    }
    boolean animationplaying = false;
    public void videoPlay()
    {
        if(animationplaying = true)
        {
        
        }
    }
    String videofileName;
    String after; 
    double framerate; 
    String audio;
    boolean animationSaved;
    int forceDigit;
    public void animationSave(String fileName, String after, double framerate,int forceDigit, String audio)
    {
        animationSaved = true;
        this.videofileName = fileName;
        this.after = after;
        this.framerate = framerate;
        this.audio = audio;
        this.forceDigit = forceDigit;
    }
    public void animationLoad()
    {
        animationSaved = false;
        //System.out.println("loaded animation now playing, = " + videofileName);
        playVideo(videofileName,"",after,framerate,forceDigit,false,audio);
    }
    public void playVideo(String fileName, String after, double framerate)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World)
        //System.out.println("video play start");
        pause();
        
        video video = new video(750/2,500/2, 0, 0, framerate, fileName, false, true,false,false,1,true,after);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, true,false,false,1,true,after);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, true,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        
    }
    public void playVideo(String fileName,String NameBack, String[] after, double framerate, int forceDigit, boolean fillScreen)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        //addObject(new home(50,40,"home","menu"),50,40);
    }
   public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, GreenfootSound audio)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        video.setAudio(audio);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        //addObject(new home(50,40,"home","menu"),50,40);
    }
    boolean bunnyFinished = false;
    public void bunnyEnd()
    {
        bunnyFinished = true;
    }
     
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, String audio)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        if(after.substring(after.length() -1).equals("C"))
            {
                //playVideo("video\\achievement\\GameAchievement","",after.substring(0,after.length()-2) + "A",23.976,2,false,"GameAchievement_sound.mp3");
                animationSave(fileName,after.substring(0,after.length()-1),framerate,forceDigit,audio);
                videobackgroundOverRide = true;
                playVideo("video\\achievement\\GameAchievement","","asdfasdf",23.947,2,false,"GameAchievement_sound.mp3");
                setPaintOrder(home.class,achievement.class,goal.class,video.class);
                videobackgroundOverRide = false;
                GreenfootImage a = new GreenfootImage("video\\achievement\\GameAchievement00.png");
                a.scale(750,500);
                setBackground(a);
                makeCoin();
            }else
            {
                video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
                addObject(video,750/2,500/2);
                video.setAudio(new GreenfootSound(audio));
                animationplaying = true;
                plaVideo2();
                Greenfoot.playSound(audio);
            }
        //addObject(new home(50,40,"home","menu"),50,40);
    }
    boolean videobackgroundOverRide;
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, ArrayList<GreenfootImage> a)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit,a);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    
    public void plaVideo2()
    {
        //goal c = new goal("idkman");
        //c.setImage("video\\1 Opening Animated Sequence-20240422T200952Z-001Resize\\OpeningAnimatedSequence000.jpg");
        //c.getImage().scale(750,500);
        //addObject(c,750/2,500/2);
        if(videobackgroundOverRide == false)
        {
            setBackground("video\\1 Opening Animated Sequence-20240422T200952Z-001Resize\\OpeningAnimatedSequence000.jpg");
            setPaintOrder(goal.class,video.class);
        }else
        {
            setPaintOrder(home.class,achievement.class,sandbox.class,goal.class,video.class);
        }
    }
    //playVideo("D:\greenfoot\animation project\animation project 3-11-24\images\video\1 Opening Animated Sequence-20240422T200952Z-001\1 Opening Animated Sequence\OpeningAnimatedSequence000.jpg")
    public void videoEnd(String after)
    {
        unpause();
        animationplaying = false;
        if(animationSaved)
        {
            animationLoad();
        }else
        {
            if(after.equals("vid2G1"))
            {
                //System.out.println("attempts to play 2nd in line sequence");
                if(linearG)
                {
                    playVideo("video\\animated2\\AnimatedSequence2","","G1",23.973,3,false,"AnimatedSequence2_audio.wav");
                }
                vid2G1 = false;
                return;
            }else if(false)
            {
            
            }
             if(after.substring(after.length() -1).equals("A"))
            {
                makeCoin();
                reflectBS(after.substring(0,after.length()-2));
            }else if(!after.equals("menu1"))
            {
                reflectBS(after);
            }else
            {
                //System.out.println("menu start from video");
                reflectBS("menu");
            }
        }
    }
    
    public int addScore(int points)
    {
        score = score + points;
        return score;
    }
    int    g1instructions = 0;
    public void G1act()
    {
        /*if(Greenfoot.isKeyDown("space")&& G1directions == true)
        {
            
            G1directions = false;
            G1prepare2();
        }*/
        if(G1directions)
        {
            if(Greenfoot.isKeyDown("space") && !spaceRe)
            {
                //instructions = false;
                //G3prepare(1);
                //sliderAdd();
                //sliderUpdate(0/5);
                //showText("",750/2,420);
                g1instructions++;
                spaceRe = true;
                //System.out.println("instructions 1 away G3");
                if(g1instructions == 1)
                {
                    GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
                    back.scale((int) (750 * 1.2),(int) (500 * 1.2));
                    //setBackground(back);
                    removeObjects(getObjects(goal.class));
                    display("PlayerDirections1.png");
                }else if(g1instructions == 2)
                {
                    GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
                    back.scale((int) (750 * 1.2),(int) (500 * 1.2));
                    //setBackground(back);
                    removeObjects(getObjects(goal.class));
                    display("PlayerDirections2.png");
                }else if(g1instructions == 3)
                {
                    showText("",750/2,420);
                    //G3prepare(1);
                    sliderAdd();
                    sliderUpdate(0/5);
                    //G3Binstructions = false;
                    G1directions = false;
                    G1prepare2();
                }
            }else
            {
                spaceRe = false;
            }
        }
        if(G1directions == false)
        {
            for(StickMan2 a : getObjects(StickMan2.class))
            {
                //System.out.println(a + " at pos, " + a.getX() + "  " + a.getY() + " back image fin =" + backImageFinished(0));
                if(a.getExactX() <= 50 && backImageFinished(0))
                {
                    succeed("G1");
                }
            }
            
            //where actual stuff happens 
            G1curTime = System.currentTimeMillis();
            if(G1curTime > G1lastTime + speedOb +Math.random()*G1randomElement - G1randomElement/2 && !backImageFinished(200))
            {
                G1lastTime = System.currentTimeMillis();
                grave a = new grave((int) (Math.random()*6 + 1),G1graveSpeed,0,-500,2);
                addObject(a,0 - a.getImage().getWidth()/2,(int) (Math.random()*(300-a.getImage().getHeight()/2) + 201));
                setPaintOrder(video.class,grave.class,StickMan2.class,Buttons.class,slider.class,goal.class);
                //System.out.println("grave spawned");
            }
            
        }
    }
    public void G1indivspawns(long curTime)
    {
        if(G1firstTime > curTime + 1000)
        {
            grave a = new grave(1,G1graveSpeed,0,-500,2);
            addObject(a,0-a.getImage().getWidth()/2,200);
        }
    }
    public boolean backImageFinished(int offset)
    {
        for(goal a : getObjects(goal.class))
        {
            if(!(a.getExactX() - a.getImage().getWidth()/2 < 0))
            {
                return true;
            }
        }
        return false;
    }
    public void G2act()
    {
        //System.out.println("G2cycle " + cycle + " " + cycle +" "+Card.cardsFound);
        
        if(cycle == 3)
        {
            cycle --;
            sliderUpdate(1 - cycle / (double)(maxcycle - 1));
            add();
            
        }
        if(Card.cardsFound == 5 && cycle > 1)
        {
            Card.cardsFound = 0;
            add();
            
            cycle --;
            sliderUpdate(1 - cycle / (double)(maxcycle - 1));
        }
        if(cycle == 1 && Card.cardsFound == 5)
        {
            removeObjects(getObjects(Actor.class));
            //addObject(new home(50,50,"home","menu"),50,50);
            cycle --;
            sliderUpdate(1 - cycle / (double)(maxcycle - 1));
            //showText("You have Won!", 280, 120);
            
            succeed("G2");

        }
    }
    int G3instruction = 0;
    boolean G3Binstructions = true;
    private int G3stage = 1;
    private int G3instructions;
    private boolean spaceRe = false;
    /*List<GreenfootImage> G3images = new ArrayList<GreenfootImage>(){{
        //add();
    }};*/
    public void G3act()
    {
        if(G3Binstructions)
        {
            /*upon reload G3Binstructions = true; G3instructions =0; */
            if(Greenfoot.isKeyDown("space") && !spaceRe)
            {
                //instructions = false;
                //G3prepare(1);
                //sliderAdd();
                //sliderUpdate(0/5);
                //showText("",750/2,420);
                G3instructions++;
                spaceRe = true;
                //System.out.println("instructions 1 away G3");
                if(G3instructions == 1)
                {
                    GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
                    back.scale((int) (750 * 1.2),(int) (500 * 1.2));
                    setBackground(back);
                    removeObjects(getObjects(goal.class));
                    display("PlayerDirections1.png");
                }else if(G3instructions == 2)
                {
                    GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
                    back.scale((int) (750 * 1.2),(int) (500 * 1.2));
                    setBackground(back);
                    removeObjects(getObjects(goal.class));
                    display("PlayerDirections2.png");
                }else if(G3instructions == 3)
                {
                    showText("",750/2,420);
                    G3prepare(1);
                    sliderAdd();
                    
                    sliderUpdate(0/5);
                    G3Binstructions = false;
                }
            }else
            {
                spaceRe = false;
            }
            
        }else
        {
            if(bunnyFinished)
            {
                for(dog b : getObjects(dog.class))
                {
                    if(left){
                        if(b.getX() > 750 + b.getImage().getWidth()/2)
                        {
                            //G3stage ++;
                            succeed("G3");
                            //System.out.println("next stage g3 left");
                            //System.out.println("left");
                        }
                    }else
                    {
                        if(b.getX() < 0 - b.getImage().getWidth()/2)
                        {
                            //G3stage ++;
                            succeed("G3");
                            //System.out.println("next stage g3 right");
                            //System.out.println("right");
                        }
                    }
                }
            }
            switch(G3stage){
            
                case 1: 
                    
                    break;
            
            
            }
            
        }
        setPaintOrder(StickMan2.class,dog.class,grave.class);
    }
    
    public static ArrayList<Integer> randomDistances() {
    final int RANGE = 600;
    final int MIN_DISTANCE = 100;
    int previousNumber = -MIN_DISTANCE; // Initialize with -MIN_DISTANCE to allow the first number to be >= 0
    int randomDistance;
    int randomNumber;
    ArrayList<Integer> re = new ArrayList<Integer>();

    while (previousNumber < (RANGE - MIN_DISTANCE)) {
        // Generate a random distance between MIN_DISTANCE and RANGE - previousNumber
        randomDistance = MIN_DISTANCE + (int)(Math.random() * (RANGE - previousNumber - MIN_DISTANCE));
        randomNumber = previousNumber + randomDistance;

        //System.out.println(randomNumber); // Print the random number
        re.add(randomNumber);
        previousNumber = randomNumber; // Update the previous number
    }

    // Ensure at least 3 numbers are returned
    while (re.size() < 3) {
        randomDistance = MIN_DISTANCE + (int)(Math.random() * (RANGE - previousNumber - MIN_DISTANCE));
        randomNumber = previousNumber + randomDistance;

        //System.out.println(randomNumber); // Print the random number
        re.add(randomNumber);
        previousNumber = randomNumber; // Update the previous number
    }

    return re;
}
    boolean left; 
    public void G3spawning(int height, boolean left)
    {
    
                removeObjects(getObjects(null));
                StickMan2 bunny = new StickMan2("bunny",45,50,49,-500);
                bunny.movespeedonground = 10;
                bunny.movespeedinair = 10;
                bunny.setIsG3(true);
                bunny.gameoverwork = false;
                bunny.setImage("Bunny_" + (left ? "left":"right") + ".png");
                bunny.getImage().scale(50,49);
                addObject(bunny,left ? 100: (750 - 100) ,height);
                bunny.groundheight = height+25;
                bunny.adjustableGround = false;
                this.left = left;
                dog dog = new dog();
                dog.conspeed = left ? 1 : -1;
                dog.setSpeed(left ? 2 : -2);
                //System.out.println("dog con speed given, now is dog speed = " + dog.conspeed);
                dog.setImage("\\Game 3\\Dog_"+(left ? "right":"left")+".png");
                dog.getImage().scale(100,(int) (dog.getImage().getHeight() * ((double) 100/dog.getImage().getWidth())));
                addObject(dog, left ? -75 : 825,height+25);
                (new GreenfootSound("bark.mp3")).play();
                this.left = left;
                for(int i = 0; i < 3; i++)
                {
                    grave b = new grave((int) (Math.random()*6 + 1),0,0,-500,1.5);
                    addObject(b,(int) (600 * Math.random()) + (left ? 100 : 0), height);
                    b.isG3 = true;
                    b.groundheight = 501;
                }
                setPaintOrder(StickMan2.class,dog.class,grave.class);
                sliderAdd();
                sliderUpdate((double)G3stage/5);
    }
    public void G3prepare(int stage)
    {
        //System.out.println("G3 prepare int with stage = " + stage);
        switch(stage)
        {
            case 1:
                int height1 =  450;
                
                G3spawning(450,false);
                break;
            case 2:
                int height2 = 350;
                bunnyFinished = false;
                G3spawning(350,true);
                break;
            case 3: 
                //int height2 = 250;
                G3spawning(250,false);
                bunnyFinished = false;

                break;
            case 4: 
                bunnyFinished = false;
                G3spawning(150,true);
                break;
        }
        setPaintOrder(StickMan2.class,dog.class,grave.class);
    }
    public void G4act()
    {
        //System.out.println("g4 act is acting");
        showText("level: "+bunnyG4.level,50,50);
        showText("lives: "+bunnyG4.lives,483,50);
        if (start==true)
        {
            //System.out.println("start == true part G4");
            setPaintOrder(video.class,bunnyG4.class,cars.class);
            delay++;
            if (delay>thresh)
            {
                thresh = 125-bunnyG4.level*10+Greenfoot.getRandomNumber(125-bunnyG4.level*10);
                if (Greenfoot.getRandomNumber(2)==0) car("1",380,400, Greenfoot.getRandomNumber(1)+1);
                else car("2",270,170, Greenfoot.getRandomNumber(1)+1);
                delay=0;
            }
        }else if (start == false && Greenfoot.isKeyDown("space"))
        {
            //n("before G4 prepareish");
            prepare();
            start = true;
        }
     
    }
        public void car(String type, int x, int y, double speed)
    {
        addObject(new cars(type, x, y, speed), x,y );
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //System.out.println("prepareing G4 final after space");
        addObject(new bunnyG4(2.5),89,351);
        car("1",380,400, 1);
        car("2",270,170, 1);
        goal goal = new goal();
        addObject(goal,403,258);
        //System.out.println("G4 after instructions");
    }
    public void redo()
    {
        
        add();
    }
    public void add()
    {
        //System.out.println("add cards started");
        removeObjects(getObjects(Actor.class));
        int correctCards = 5;
        addObject(new Mouse(), 0, 0);
        
        for(int i=0; i < 6; i++)
        {
            if((Greenfoot.getRandomNumber(100)<10)&& correctCards >0)
            {
                addObject(new Card(true), 120 + 110*i,160);
                correctCards --;
            }
            else
            {
                addObject(new Card(false), 120 + 110*i,160);
            }
        }
        for(int i=0; i < 6; i++)
        {
            if((Greenfoot.getRandomNumber(100)<10)&& correctCards >0)
            {
                addObject(new Card(true), 120 + 110*i,310);
                correctCards --;
            }
            else
            {
                addObject(new Card(false), 120 + 110*i,310);
            }
        }
        if(correctCards>0)
        {
            redo();
        }
        
        
    }
    public void G5act()
    {
        if(stage == 6)
        //mason's code + my restartButton
        {
            removeObjectsG6();
            setBackground("Game 5\\restartbackground.png");
            addObject(new restartButton(), 160, 156);
            addObject(new textbox(), 342, 213);
            addObject(new quitButton(), 527, 156);
            addObject(new quitText(), 452, 270);
            addObject(new restartText(), 225, 270);
            showText("Press 'R' to restart and Press 'Q' to quit", getWidth() / 2,350);
            setPaintOrder(video.class,restartButton.class,quitButton.class, quitText.class, restartText.class, G5textBox.class);
        }
        if(stage == 0)
        //justin did this
            {
                showText("Click to continue", getWidth() / 2,350);
                addObject(new gameDirections(), 347, 184);
                
        
            }
        
        if(stage == 0 && Greenfoot.mouseClicked(this))
        //justin did this
        {
        stage = 1;
        }
        
        
        
        String msg = new String("Press '1' for answer 1 and Press '2' for answer 2");
     if(stage == 1)
     // justin did this
     
     {
         removeObjectsG6();
         showText(null, getWidth() / 2, getHeight() / 2);
         showText(null, getWidth() / 2,350);
        setBackground("Game 5\\Game5_stage1(2).png"); 
        addObject(new question1(), 469, 203);
        questionSelection1();
        showText("Press '1' for answer 1 and Press '2' for answer 2", getWidth() / 2,40);
        addObject(new textbox(), 342, 213);
        setPaintOrder(video.class,question1answer1.class,question1answer2.class, question1.class, G5textBox.class);
    }
   
    if(stage == 2)
    // justin did this
    {
    removeObjectsG6();
    showText(null, getWidth() / 2, getHeight() / 2);
     setBackground("Game 5\\Game5_stage2.png");
     addObject(new question2(), 350, 203);
     questionSelection2();
     showText("Press 'Q' for answer 1 and Press 'W' for answer 2", getWidth() / 2,40);
     addObject(new textbox(), 342, 213);
     setPaintOrder(video.class,question2.class, G5textBox.class);
    }
    
    if(stage == 3)
    // justin did this
    {
        removeObjectsG6();
        showText(null, getWidth() / 2, getHeight() / 2);
    setBackground("Game 5\\Game5_stage3.png");
    addObject(new question3(), 400, 203);
    questionSelection3();
    showText("Press 'A' for answer 1 and Press 'S' for answer 2", getWidth() / 2,40);
    addObject(new textbox(), 342, 213);
    setPaintOrder(question3.class, G5textBox.class);
    }
    
    if(stage == 4)
    // justin did this
    {
        removeObjectsG6();
        showText(null, getWidth() / 2, getHeight() / 2);
     setBackground("Game 5\\Game5_stage4.png");
     //showText("YOU WIN!!", getWidth() / 2, getHeight()/2);
     succeed("G5");
    }
    
    }
    public void G6act()
    {
        
        if(running == true)
        {
        long curTime  = System.currentTimeMillis();
        formationType = Greenfoot.getRandomNumber(10);
        if (curTime >= lastAdded3 + timeDiff)
        {
            if (formationType <= 7)
            {
                arrowNumber1 = Greenfoot.getRandomNumber(4);
                Arrow arrow = new Arrow (imageArrow[arrowNumber1], soundArrow[arrowNumber1], arrowNumber1);
                addObject(arrow,xArrow[arrowNumber1],100);
                lastAdded3  = curTime;
            }
            else if (formationType >= 7)
            {
                arrowNumber1 = Greenfoot.getRandomNumber(4);
                Arrow arrow1 = new Arrow (imageArrow[arrowNumber1], soundArrow[arrowNumber1], arrowNumber1);
                addObject(arrow1, xArrow[arrowNumber1], 100);
                
                arrowNumber2 = Greenfoot.getRandomNumber(4);
                while (arrowNumber2 == arrowNumber1)
                {
                    arrowNumber2 = Greenfoot.getRandomNumber(4);
                }
                Arrow arrow2 = new Arrow (imageArrow[arrowNumber2], soundArrow[arrowNumber2], arrowNumber2);
                addObject(arrow2, xArrow[arrowNumber2], 100);
                
                lastAdded3  = curTime;
            }
            sliderUpdate((double) score/Arrow.endScore);
        }
        
        showText("Score: " + score, 100, 100);
        }
    }
    public void G7act()
    {
        //System.out.println("G7act");
        if(G7directions)
        {
            G7prepare2();
            G7directions = false;
        }else
        {
            G7failre();
            
            
            
            
        }
        G7succeedre();
    }
    public boolean heightB()
    {
        boolean re = false;
        for(advancedGravity ob : getObjects(advancedGravity.class))
        {
            if(ob.getExactY() < -4000)
            {
                re = true;
            }
        }
        return re;
    }
    boolean firstAnDone = false;
    GreenfootSound openingS = new GreenfootSound("OpeningAnimatedSequence_audio.wav");
    public MyWorld()
    {    
        super(750, 500, 1,false); 
        //addObject(new StickMan2(), 375, 325);
        //sandboxprepare();
        if(!advancedAn)
        {
            menu();
        }else
        {
            playVideo("video\\1 Opening Animated Sequence-20240422T200952Z-001Resize\\OpeningAnimatedSequence","","menu1",23.943,3,false,openingS);
            //reflectBS("menu");
            firstAnDone = false;
            //System.out.println("playvideo called");
        }
        running = true;
        
    }
    public void menu()
    {
        for(video a : getObjects(video.class))
        {
            a.videoEnd();
        }
        //setBackground(backgroundImage());
        //sets what games to play. 
        //abcd
        for(int i = 0; i < 4; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            showText("",150*i + 50, 200);
        }
        for(int i = 4; i < 7; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            showText("",150*i + 50 - 600, 400);
        }
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
        goal a = new goal("menu");
        unpause();
        GreenfootImage skfjdn = new GreenfootImage("StartScreen_landingpage.png");
        skfjdn.scale(750,500);
        a.setImage(skfjdn);
        //a.getImage().scale(1343,500);
        addObject(a,750/2,500/2);
        addObject(new home(50,40,"home","menu"),50,40);
        makeCoin();
        addObject(new sandbox(50,90,"sandbox","sandbox",0,new GreenfootImage("genericblank_button.png")),50,100);      
        //System.out.println("imgstuffs");
        addObject(new sandbox(150,70,"","G1",0,new GreenfootImage("Game1_GenericButton.png")),150,100);
        addObject(new sandbox(250,70,"","G2",0,new GreenfootImage("Game2_GenericButton.png")),250,100);
        addObject(new sandbox(350,70,"","G3",0,new GreenfootImage("Game3_GenericButton.png")),350,100);
        addObject(new sandbox(450,70,"","G4test",0,new GreenfootImage("Game4_GenericButton.png")),450,100);
        addObject(new sandbox(550,70,"","G5",0,new GreenfootImage("Game5_GenericButton.png")),550,100);
        addObject(new sandbox(650,70,"","G6",0,new GreenfootImage("Game6_GenericButton.png")),650,100);
        addObject(new sandbox(50,170,"","G7",0,new GreenfootImage("Game7_GenericButton.png")),50,200);
         addObject(new sandbox(250,190,"Start Story","story",0,true,new GreenfootImage("genericblank_button.png")),250,200);
         
        /*StickMan2 bunny = new StickMan2("bunny",45,50,49,-500);
        bunny.setImage("Bunny_left.png");
        bunny.getImage().scale(50,49);
        addObject(bunny,750/2,500/2);
         */
         
         
    }
    public void reflectBS(String functionN)
    {
        if(functionN != null)
        {
            for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            clearText();
            removeObjects(getObjects(null));
            addObject(new home(50,40,"home","menu"),50,40);
            makeCoin();
        }
        if (functionN.equals("sandbox"))
        {
            sandboxprepare();
            clearText();
        }else if(functionN.equals("story"))
        {
                    playVideo("video\\animated1\\AnimatedSeuqence1","","vid2G1",23.973,3,false,"AnimatedSequence1_audio.wav");
                    //playVideo("video\\animated5\\SMansour_GameCharacterFINAL_","","G4",29.97,3,false,"animation4.mp3");
                    //reflectBS("G1");
                    vid2G1 = true;
                    
        }else if(functionN.equals("G1"))
        {
            G1prepare();
            oneactive = true;
        }else if (functionN.equals("G2"))
        {
            //System.out.println("G2 set up");
            cycle = 3;
            G2prepare();
            twoactive = true;
        }else if(functionN.equals("G3"))
        {
            //System.out.println("G3 in reflectBS");
            G3prepare();
            threeactive = true;
        }else if (functionN.equals("G4"))
        {
            //System.out.println("G4");
            G4prepare();
            fouractive = true;
        }else if (functionN.equals("G4test"))
        {
            //n("G4test");
            playVideo("video\\animated5\\SMansour_GameCharacterFINAL_","","G4",29.97,3,false,"animation4.mp3");
        }else if(functionN.equals("G5"))
        {
            //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","menu",30);
            G5prepare();
            fiveactive = true;
        }else        if (functionN.equals("G6"))
        {
            G6prepare();
            sixactive = true;
            clearText();
        }else  if (functionN.equals("G7"))
        {
            //clearText();
            G7prepare();
            //sevenactive = true;
            //System.out.println("instatement" + sevenactive);
        }else if(functionN.equals("achievements"))
        {
                for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            achievementsPrepare();
            achievementsActive = true;
        }else if(functionN.equals("finalD"))
        {
            finalDprepare();
            finalDactive = true;
        }else  if (functionN.equals("menu"))
        {
            //System.out.println("audio stop attempted in menu" + getObjects(video.class).size());
            for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            menu();
            //for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
            //setPaintOrder(home.class,achievement.class,sandbox.class);
        }else if(functionN.equals("menuE")){
             for(video a : getObjects(video.class))
        {
            a.videoEnd();
        }
            menu();
            setPaintOrder(home.class,achievement.class,sandbox.class,goal.class);
        }else if (functionN.equals("end"))
        {
            playVideo("video\\final\\Game_Endscene","","menuE",23.937,2,false,"Game_Endscene_audio.mp3");
        }
    }
    boolean achievementsActive;
    GreenfootImage done = new GreenfootImage("checkmark_button.png");
    GreenfootImage notDone = new GreenfootImage("x_button.png");
    public void widthScale(int width,GreenfootImage a)
    {
        a.scale(width, (int)(((double)width/a.getWidth()) * a.getHeight()));
    }
    public void achievementsPrepare()
    {
        //GreenfootImage one = new GreenfootImage("");
        //addObject()
        GreenfootImage skfjdn = new GreenfootImage("StartScreen_landingpage.png");
        skfjdn.scale(750,500);
        setBackground(skfjdn);
        widthScale(75,done);
        widthScale(75,notDone);
        for(int i = 0; i < 4; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            addObject(new sandbox(150*i + 50, 200,"Game " + (i+1),"none",achievements[i] ? done : notDone),150*i + 50, 200);
        }
        for(int i = 4; i < 7; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            addObject(new sandbox(150*i + 50 - 600, 400,"Game " + (i+1),"none",achievements[i] ? done : notDone),150*i + 50 - 600, 400);
        }
        
    }
    public void G3preapare2()
    {
        
        
    }
    public void G3prepare()
    {
        //System.out.println("G3 prepare");
        advancedGravity.colexcept.add(grave.class);
        advancedGravity.colexcept.add(dog.class);
        GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
        back.scale((int) (750 * 1.2),(int) (500 * 1.2));
        setBackground(back);
        
            G3Binstructions = true;
        
        G3stage = 1;
        //System.out.println("G3stage reset");
         G3instructions =0;
        //System.out.println("G3 prepare end");
        showText("press space to continue",750/2,420);
        /*GreenfootImage back = new GreenfootImage("Game 3\\Game3_background.png");
        back.scale((int) (750 * 1.2),(int) (500 * 1.2));
        setBackground(back);*/
        display("\\Game 3\\Game3_GameDirections.png");
        sliderAdd();
        sliderUpdate(G3stage/5);
        advancedGravity.colexcept.add(grave.class);
    }
    public void display(String a )
    {
        GreenfootImage instructions = new GreenfootImage(a);
        instructions.scale(750,500);
        goal b = new goal();
        b.setImage(instructions);
        //b.getImage().scale(750,500);
        addObject(b,750/2,500/2);
    }
    private boolean finalDactive = false;
    public void finalDprepare()
    {
        GreenfootImage b = new GreenfootImage("final\\FinalDecision_Background.png");
        b.scale((int)(750*1.2),(int)(500*1.2));
        setBackground(b);
        //getBackground().scale(750, (int) ((double) 750/getBackground().getWidth()) * getBackground().getHeight());
        goal a = new goal("");
        a.setImage(new GreenfootImage("final\\FinalDecision_text.png"));
        a.getImage().scale(750,500);
        addObject(a,750/2,500/2);
        addObject(new sandbox(150,80,"","menu",new GreenfootImage("final\\FinalDecision_dustbutton.png")),200,350);
        addObject(new sandbox(150,80,"","end",new GreenfootImage("final\\FinalDecision_bunnybutton.png")),500,350);
        addObject(new textbox(),750/2,500/2);
        setPaintOrder(sandbox.class,goal.class,textbox.class);
    }
    public int numberRight = 0;
    /* add if statements for numberRight and numberWrong saying if it is greater than or equal to 2
    you either get win or lose. */
    public int numberWrong = 0;
    public static int stage = 0;
    public void G5prepare()
    {
        numberRight = 0;
        numberWrong = 0;
        stage = 0;
        setBackground("Game 5\\background.jpg");
        //no other prep?
    }
    public void questionSelection1()
    //mason did this
    {
        if (stage == 1 && Greenfoot.isKeyDown("1")) 
        {
        stage++;
        }
        
        if (stage == 1 && Greenfoot.isKeyDown("2")) 
        {
        stage = 6;
        }
    }
        public void questionSelection2()
        //mason did this
        {
        if (stage == 2 && Greenfoot.isKeyDown("q")) 
        {
        stage = 6;
        }
        if (stage == 2 && Greenfoot.isKeyDown("w")) 
        {
        stage++;    
        }
    }
        public void questionSelection3()
        //mason did this
        {
        if (stage == 3 && Greenfoot.isKeyDown("a")) 
        {
        stage++;    
        }
        if (stage == 3 && Greenfoot.isKeyDown("s")) 
        {
        stage = 6;          
        }
    }
    public void removeObjectsG6()//justin did this
    {
         //ArrayList<Objects> objects = getObjects(null);
        showText(null, getWidth()/2, 40);
        removeObjects(getObjects(null));   
    }
    public void gameOver()
    //mason did this; code moved over to if stage == 6
    {
        //removeObjectsG6();
        //setBackground("Game 5\\restartbackground.png");
        //showText("WRONG!!!", getWidth() / 2,getHeight() / 2);
        fail("G5");
    }
    /**
     * does stuff for pausing the game in the event of a pausescreen
     */
    public void pausescreen() //
    {
        pause();
        setBackground("Game 5\\gamepause.png");
        paused = true;
    }
    /**
     * //unpauses from the pause screen
     */
    public void unpausescreen()
    {
        unpause();
        paused = false;
    }
    /**
     * main pause function called for all pause types
     */
    public void pause() // 
    {
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(0);
        for (Object obj : getObjects(pausebutton.class)) ((Actor)obj).getImage().setTransparency(255);
        if(running == true){alreadyrunf = true;}
        running = false;
        paused = true;
    }
    /**
     * is used for general pause ending
     */
    public void unpause() // 
    {
        setBackground("background2.jpg");
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
        if(alreadyrunf == true)
        {
            running = true;
        } 
        paused = false;
    }
    /**
     * main pause function called for all pause types
     */
    public void Rpause() // 
    {
        if(running == true){alreadyrunf = true;}
        running = false;
        paused = true;
    }
    /**
     *  is used for general pause ending
     */
    public void Runpause() //
    {
        setBackground("background2.jpg");
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
        if(alreadyrunf == true)
        {
            running = true;
        } 
        paused = false;
    }
    public void clearText()
    {
        
        showText("",50,90);
        showText("",150,70);
        showText("",250,70);
        showText("",350,70);
        showText("",450,70);
        showText("",550,70);
        showText("",650,70);
        showText("",50,170);
                showText("",250,190);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void sandboxprepare()
    {
        //addObject(new video(getWidth()/2,getHeight()/2,100,100,1,"Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]\\yes",true,false,false,true,0),getWidth()/2,getHeight()/2);
        showText("Pause",100,25);
        showText("Pause Physics",120,110);
        addObject(new StickMan2(), 375, 325);
        alligatgor alligatgor = new alligatgor();
        //alligatgor.setImage( new GreenfootImage("TopBar_Homebutton.png"));
        addObject(alligatgor,70,465);
        platform platform = new platform();
        addObject(platform,567,243);
        bigplat bigplat = new bigplat();
        addObject(bigplat,636,385);
        bigplat bigplat2 = new bigplat();
        addObject(bigplat2,108,398);
        deathBall deathBall = new deathBall();
        addObject(deathBall,507,51);
        bouncyball bouncyball = new bouncyball();
        addObject(bouncyball,235,73);
        bouncyball bouncyball2 = new bouncyball();
        addObject(bouncyball2,615,50);
        pausebutton pausebutton = new pausebutton();
        addObject(pausebutton,25,34);
        Rpausebutton rpausebutton = new Rpausebutton();
        addObject(rpausebutton,29,109);
    }
    public void G1prepare()
    {
        setBackground("textbox.png");
        goal b = new goal();
        b.setImage(new GreenfootImage("textbox.png"));
        b.getImage().scale(750,500);
        addObject(b,750/2,500/2);
        goal a = new goal();
        a.setImage(new GreenfootImage("Game1\\Game1_GameDirections_resize.png"));
        a.getImage().scale(750,500);
        addObject(a,750/2,500/2);
        oneactive = true;
        G1directions = true;
        advancedGravity.anyRemove(grave.class,advancedGravity.colexcept);
        try{
            advancedGravity.colexcept.remove(advancedGravity.anyfindpos(grave.class,advancedGravity.colexcept) - 2);
        }catch(Exception e)
        {
            System.out.println("grave collision failed");
        }
        //System.out.println(advancedGravity.anyfindpos(grave.class,advancedGravity.colexcept));
        //System.out.println("col except" + advancedGravity.colexcept.toString());
        showText("press space to continue",750/2,420);
    }
    public void G1prepare2()
    {
        setBackground("Game1\\Game1_Background.png");
        removeObjects(getObjects(null));
        goal a = new goal("movingB");
        a.setImage(new GreenfootImage("Game1\\Game1_Background.png"));
        a.getImage().scale(1343,500);
        addObject(a,750-672,500/2);
        
        StickMan2 bunny = new StickMan2("bunny",45,50,49,-500);
        bunny.modifiedJumpHeight = true;
        bunny.setImage("Bunny_left.png");
        bunny.getImage().scale(50,49);
        bunny.scaling = true;
        addObject(bunny,750 - 100,400);
        //System.out.println("items = +" + ((500/(movementspeed * 60))/(speedOb / 1000)) + " speed");
        for(int i = 0; i < (500/(movementspeed*60))/(speedOb /1000); i++)
        {
            grave b = new grave((int) (Math.random()*6 + 1),G1graveSpeed,0,-500,2);
            addObject(b,(int) (500 * Math.random()), (int) (Math.random()*(500-a.getImage().getHeight()/2) + 201));
            
        }
        //System.out.println("G1prepareG2");
        setPaintOrder(video.class,grave.class,StickMan2.class,Buttons.class,slider.class,goal.class);
    }
    public void G2prepare()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //System.out.println("G2 prepare");
        setBackground("Game2_background.png");
        addObject(new Directions(), 450, 250);
        addObject(new home(50,40,"home","menu"),50,40);
        makeCoin();
        twoactive = true;
        int cycle = 3;
        Card.cardsFound = 0;
    }
    public void G4prepare()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //System.out.println("G4prepare start");
        threeactive = false;
        running = true;
        setBackground("game4_background.png");
        //System.out.println("gr prepare shit");
        textbox textbox = new textbox();
        addObject(textbox,267,160);
        
        Label label1 = new Label(line1);
        addObject(label1,440,140);
        
        Label label2 = new Label(line2);
        addObject(label2,440,170); 
        
        Label label3 = new Label(line3);
        addObject(label3,440,200); 
        
        Label label4 = new Label(line4);
        addObject(label4,420,230);
        bunnyG4.level = 0;
        bunnyG4.lives = 3;
        //System.out.println("g3 prepare shit");
        start=  false;
        fouractive = true;
        
    }
    public void G6prepare()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        //Arrow arrow = new Arrow (imageArrow[0], soundArrow[0], 0);
        //addObject(arrow, xArrow[0], 100);
        showText("Pause",100,25);
        pausebutton pausebutton = new pausebutton();
        addObject(pausebutton,25,34);
        Rpausebutton rpausebutton = new Rpausebutton();
        addObject(rpausebutton,29,109);
        timeDiff = 1000;
        setBackground("bunnyBackground (1).png");
        long curTime  = System.currentTimeMillis();
        for (int i = 0; i < 4; i++)
        {
            playerArrow player = new playerArrow (imageArrow[i], soundArrow[i], i);
            addObject(player, xArrow[i], 460);
        }
        bunny bunny1 = new bunny();
        addObject(bunny1, 710, 410);
        hand handy = new hand();
        addObject(handy, 930, 150);
        score = 0;
    }
    public void G7prepare()
    {
        //System.out.println("seven prepared");
        GreenfootImage a = new GreenfootImage("Game 7\\Game7_LayoutWithDirections.jpg");
        a.scale(750,500);
        setBackground(a);
        sevenactive = true;
        G7directions = true;
        //System.out.println("seven prepared 1 finished");
        //boolean sevenactive = false;
        //boolean G7directions = false;
        
         beginanimation = true;
         G7curTime = 0;
     G7lastTime = 0;
     G7failre = false;
     G7failDelay = 1000;
     //G7failre = false;
    }
    int G7rows = 3;
    int G7col = 4;
    int G7x = -1;
    int G7y = -1;
    public void G7setPos(int x, int y)
    {
        this.G7x = x;
        this.G7y = y;
    }
    public int[] G7getPos()
    {
        return new int[]{G7x,G7y};
    }
    long G7curTime;
    long G7lastTime;
    boolean G7failre;
    int G7failDelay = 1000;
    public void G7Fail()
    {
        G7lastTime = System.currentTimeMillis();
        G7failre = true; 
    }
    public void G7failre()
    {
        if(G7failre )
        {
            //System.out.println("waiting");
            if(G7lastTime + G7failDelay <= System.currentTimeMillis())
            {
                
                for(pathBox a : getObjects(pathBox.class))
                {
                    a.card = a.back;
                    a.refresh();
                    a.hideCount = 0;
                    //System.out.println("path hidden");
                    //a.special();
                    
                }
                G7failre = false;
                //System.out.,println("refreshed");
                G7setPos(-1,-1);
            }
        }
    }
    
    public void G7succeed()
    {
        G7succeedlastTime = System.currentTimeMillis();
        G7succeedre = true; 
    }
    boolean G7succeedre;
    long G7succeedlastTime;
    int G7succeedDelay = 1000;
    public void G7succeedre()
    {
        if(G7succeedre )
        {
            //System.out.println("waiting succeed");
            if(G7succeedlastTime + G7succeedDelay <= System.currentTimeMillis())
            {
                sevenactive = false;
                //System.out.println("G7 ended");
                if(!linearG)
                {
                    reflectBS("menu");
                
                }else
                {
                    succeed("G7");
                }
            }
        }
    }
    public boolean[][] getG7Cor()
    {
        return G7cor;
    }
boolean[][] G7cor = new boolean[G7rows][G7col];
    public void setG7Cor(boolean[][] a)
    {
         G7cor = a;
    }
    public void G7prepare2()
    {
        GreenfootImage a = new GreenfootImage("Game 7\\Game7_Background.png");
        a.scale(750,500);
        setBackground(a);
        //setBackground();
        
        
        boolean[][] path = new boolean[G7rows][G7col];
        Random rand = new Random();
        
        // Starting point at the leftmost column
        int currentRow = rand.nextInt(G7rows);
        path[currentRow][0] = true;
        
        // Generate path
        for (int col = 1; col < G7col; col++) {
            int move;
            do {
                move = rand.nextInt(5) - 2; // -2: up, -1: diagonal up, 0: straight, 1: diagonal down, 2: down
                currentRow = currentRow + move;
            } while (currentRow < 0 || currentRow > G7rows - 1); // Repeat if move is out of bounds
            
            path[currentRow][col] = true;
            
            // If the move was straight up or down, stay in the same column
            if (move == -2 || move == 2) {
                col--;
            }
        }
        
        // Print the array
        for (boolean[] row : path) {
            for (boolean square : row) {
                System.out.print(square ? "T " : "F ");
            }
            System.out.println();
        }
        //System.out.println("\n");
        goal c = new goal("idkman");
        c.setImage("Game 7\\Game7_gameboard.png");
        c.getImage().scale(c.getImage().getWidth()/2,c.getImage().getHeight()/2);
        addObject(c,750/2,500/2);
        for(int i = 0; i < G7rows; i++)
        {
            for(int j = 0; j < G7col; j++)
            {
                pathBox b = new pathBox(path[i][j],path,i,j);
                b.setImage("Game 7\\Game7_graysquare.png");
                b.getImage().scale((int)(b.getImage().getWidth() / 1.93),(int)( b.getImage().getHeight()/1.93));
                addObject(b,160 + j*b.getImage().getWidth(), 130 + i*b.getImage().getHeight());
                
            }
        }
        resetB("G7");
    }
    
    public void resetB(String use)
    {
       sandbox pl = new sandbox(50,180,"game 7",use,0,linearG);
        GreenfootImage res = new GreenfootImage("TopBar_RestartGameButton.png");
        res.scale(50,(int)(((double)50/res.getWidth()) * res.getHeight()) );
        pl.button_1 = res;
        pl.button_2 = res;
        addObject(pl,125,40); 
    }
     
    public void sliderAdd()
    {
        
        slider frame = new slider();
        frame.setImage("progress\\ProgressSlider_bar.png");
        frame.getImage().scale(300,(int)(((double)300/frame.getImage().getWidth()) * frame.getImage().getHeight()));
        addObject(frame,750/2,40);
        
        moverS mover = new moverS();
        mover.setImage("progress\\ProgressSlider_arrow.png");
        mover.getImage().scale((int)(((double)(frame.getImage().getHeight() * 1.2)/frame.getImage().getWidth()) * mover.getImage().getWidth()),(int)(frame.getImage().getHeight() * 1.2));
        addObject(mover,750/2 - frame.getImage().getWidth()/2 + mover.getImage().getWidth()/4,40);
        
        orangeS or = new orangeS();
        or.setImage("progress\\ProgressSlider_orangefill.png");
        or.getImage().scale((int)(frame.getImage().getHeight() * 0.9),1);
        addObject(or,750/2 - frame.getImage().getWidth() + or.getImage().getWidth()/4 -1,40);
        
        setPaintOrder(video.class,moverS.class,slider.class,orangeS.class);
    }
    double lastDone;
    public void sliderUpdate(double done)
    {
        if(done != lastDone)
        {
            removeObjects(getObjects(slider.class));
            slider frame = new slider();
            frame.setImage("progress\\ProgressSlider_bar.png");
            frame.getImage().scale(300,(int)(((double)300/frame.getImage().getWidth()) * frame.getImage().getHeight()));
            addObject(frame,750/2,40);
            
            moverS mover = new moverS();
            mover.setImage("progress\\ProgressSlider_arrow.png");
            mover.getImage().scale((int)(((double)(frame.getImage().getHeight() * 1.2)/frame.getImage().getWidth()) * mover.getImage().getWidth()),(int)(frame.getImage().getHeight() * 1.2));
            addObject(mover,750/2 - frame.getImage().getWidth()/2 + mover.getImage().getWidth()/4 +(int)( frame.getImage().getWidth() * done),40);
            
            orangeS or = new orangeS();
            or.setImage("progress\\ProgressSlider_orangefill.png");
            or.getImage().scale(1+ (int)(frame.getImage().getWidth() * done) + (int)(mover.getImage().getWidth()/5),(int)(frame.getImage().getHeight() * 0.9));
            addObject(or,frame.getX() - frame.getImage().getWidth()/2 + or.getImage().getWidth()/2,40);
            
            setPaintOrder(video.class,moverS.class,slider.class,orangeS.class,Buttons.class,grave.class,StickMan2.class,cars.class);
            lastDone = done;
        }
    }
    boolean vid2G1 = false;
    //private int G3stage;
    public void G3succeed(int stage)
    {
        bunnyEnd();
    }
    public void succeed(String a)
    {
        if(linearG)
        {
                switch(a)
            {
                case "story":
                    playVideo("video\\animated1\\AnimatedSeuqence1","","vid2G1",23.973,3,false,"AnimatedSequence1_audio.wav");
                    
                    vid2G1 = true;
                    break;
                case "G1":
                    oneactive = false;
                    //reflectBS("G2");
                    //public void playVideo(String fileName, String after, double framerate)
                    removeObjects(getObjects(null));
                    addObject(new home(50,40,"home","menu"),50,40);
                    //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","G2",60);
                    makeCoin();
                    playVideo("video\\animated3\\AnimatedSequence3","",achievements[0] ?"G2":"G2C",29.97,3,false,"AnimatedSequence3_audio.wav");
                    //vid2G2 = true;
                    //System.out.println("linear G1 succeed done");
                    earnedA += achievements[0] ? 0:1;
                    achievements[0] = true;
                    
                    break;
                    
                case "G2":
                    twoactive = false;
                   
                           // reflectBS("G3");
                   
                       //Greenfoot.delay(3);
                       
                    
                       removeObjects(getObjects(null));
                       playVideo("video\\animated4\\AnimatedSequence4","",achievements[1] ?"G3":"G3C",29.97,3,false,"AnimatedSequence4_audio.wav");//modified to skip game 3
                    //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","G4",60);//m,odified to skip 3
                    //System.out.println("linear G2 succeed done");
                    earnedA += achievements[1] ? 0:1;   
                    achievements[1] = true;
                       
                    break;
                case "G3":
                    //threeactive = false;
                   // reflectBS("G2");
                   //System.out.println(G3stage);
                   
                   if(G3stage < 5)
                   {
                       if(bunnyFinished)
                       {
                           G3stage += 1;
                           
                           G3prepare(G3stage);
                           //System.out.println("next stage dumbass" + G3stage);
                        }else
                        {
                           G3succeed(G3stage);
                           
                        }
                    }else
                    {
                        //playVideo("video\\animated5\\SMansour_GameCharacterFINAL_","",achievements[2] ?"G4":"G4C",29.97,3,false,"animation4.mp3");
                        playVideo("video\\animated5\\SMansour_GameCharacterFINAL_","","G4",29.97,3,false,"animation4.mp3");
                        //System.out.println("G3 win, onto g4");
                        earnedA += achievements[2] ? 0:1;
                        achievements[2] = true;
                    }
                    
                    break;
                case "G4":
                    fouractive = false;
                    //System.out.println("G4 succeed ");
                    showText("",50,50);
                    showText("",483,50);
                    //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","G5",60);
                   playVideo("video\\animated6\\AnimatedSequence6","",achievements[3] ?"G5":"G5C",29.97,3,false,"AnimatedSequence6_audio.wav");
                   //"D:\greenfoot\animation project\animation project 3-11-24\images\video\animated6\AnimatedSequence6001.jpg"
                    // reflectBS("G2");
                    
                    earnedA += achievements[3] ? 0:1;
                    achievements[3] = true;
                    break;    
                case "G5": 
                    fiveactive = false;
                    //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","G6",60);
                    playVideo("video\\animated7\\AnimatedSequence7","",achievements[4] ?"G6":"G6C",24,3,false,"AnimatedSequence7_audio.mp3");
                    //reflectBS("G2");
                    //earnedA += achievements[4] ? 0:1;
                    earnedA += achievements[4] ? 0:1;
                    achievements[4] = true;
                    break;
                case "G6":
                    sixactive = false;
                    //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","G7",60);
                    playVideo("video\\animated8\\AnimatedSequence8","",achievements[5] ?"G7":"G7C",29.97,3,false,"AnimatedSequence8_audio.wav");
                    //reflectBS("G2");
                    //earnedA += achievements[5] ? 0:1;
                    earnedA += achievements[5] ? 0:1;
                    achievements[5] = true;
                    break;
                case "G7":
                    //sevenactive = false;
                    G7succeed();
                    //System.out.println("G7 succeed started");
                    playVideo("video\\animated9\\AnimatedSequence9","",achievements[6] ?"finalD":"finalDC",29.97,4,false,"AnimatedSequence9_audio.mp3");
                    //reflectBS("G2");
                    //do something for final win.
                    earnedA += achievements[6] ? 0:1;
                    achievements[6] = true;
                    break;
            }
            
        }else
        {
               
            
        
        //removeObjects(getObjects(null));
            switch(a)
            {
                case "G1":
                    //reflectBS("menu");
                    oneactive = false;
                    //System.out.println("nonlionear G1 animated");
                    playVideo("video\\animated3\\AnimatedSequence3","",achievements[0] ?"menu":"menuC",29.97,3,false,"AnimatedSequence3_audio.wav");
                    earnedA += achievements[0] ? 0:1;
                    achievements[0] = true;
                    break;
                case "G2":
                    reflectBS("menu");
                    twoactive = false;
                    earnedA += achievements[1] ? 0:1;
                    makeCoin();
                    achievements[1] = true;
                    break;
                case "G3":
                    //reflectBS("menu");
                    /*System.out.println(G3stage);
                    G3stage += 1;
                    G3prepare(G3stage);*/
                    //System.out.println(G3stage);
                   
                   if(G3stage < 5)
                   {
                       if(bunnyFinished)
                       {
                           G3stage +=1;
                           G3prepare(G3stage);
                           //System.out.println("G3 dumbass next thingy");
                        }else
                        {
                           G3succeed(G3stage);
                           
                        }
                    }else
                    {
                        playVideo("video\\animated5\\AnimatedSequence5","","G4C",29.97,3,false);
                        earnedA += achievements[2] ? 0:1;
                        achievements[2] = true;
                        makeCoin();
                    }
                    //threeactive = false;
                    break;
                case "G4":
                    //reflectBS("menu");
                    showText("",50,50);
                    showText("",483,50);
                    fouractive = false;
                    //System.out.println("G4 succeed ");
                    playVideo("video\\animated6\\AnimatedSequence6","","G5C",29.97,3,false,"AnimatedSequence6_audio.wav");
                    earnedA += achievements[3] ? 0:1;
                    makeCoin();
                    achievements[3] = true;
                    break;    
                case "G5":
                    reflectBS("menu");
                    fiveactive = false;
                    earnedA += achievements[4] ? 0:1;
                    makeCoin();
                    achievements[4] = true;
                    break;
                case "G6":
                    sixactive = false;
                    playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened\\yes","menu",30);
                    earnedA += achievements[5] ? 0:1;
                    makeCoin();
                    achievements[5] = true;
                    break;
                case "G7":
                    //reflectBS("menu");
                    sevenactive = false;
                    playVideo("video\\animated9\\AnimatedSequence","","finalDC",29.97,4,false,"AnimatedSequence9_audio.mp3");
                    G7succeed();
                    earnedA += achievements[6] ? 0:1;
                    makeCoin();
                    achievements[6] = true;
                    break;
            }
        }
    }
    long G2lastTime;
    int G2faildelay = 1000;
    boolean G2waiting = false;
    public void G2failwait()
    {
        if(G2waiting && G2lastTime + G2faildelay < System.currentTimeMillis())
        {
            reflectBS("G2");
            //System.out.println("G2 fail delay done");
            G2waiting = false;
        }
    }
    public void G3fail(String a, String other)
    {
        //advancedGravity.colexcept.add(grave.class);
        advancedGravity.anyRemove(grave.class,advancedGravity.colexcept);
        advancedGravity.anyRemove(dog.class,advancedGravity.colexcept);
        //System.out.println("G3 fail, " + other);
        fail(a);
    }
    public void fail(String a)
    {
        if(linearG)
        {
            switch(a)
            {
                case "G1":
                    oneactive = false;
                    reflectBS("G1");
                    break;
                case "G2":
                    //twoactive = false;
                    //reflectBS("G2");
                    //System.out.println("reflect G2");
                    removeObjects(getObjects(Card.class));
                    G2lastTime = System.currentTimeMillis();
                    G2waiting = true;
                    break;
                case "G3":
                    threeactive = false;
                    reflectBS("G3");
                    break;
                case "G4":
                    fouractive = false;
                    reflectBS("G4");
                    break;    
                case "G5":
                    fiveactive = false;
                    reflectBS("G5");
                    break;
                case "G6":
                    sixactive = false;
                    reflectBS("G6");
                    break;
                case "G7":
                    sevenactive = false;
                    reflectBS("G7");
                    
                    break;
            }
            if(a.equals("G6"))
            {
                //something special
                reflectBS("menu");
            }else
            {
                reflectBS(a);
            }
            return;
        }else
        {
            
            reflectBS("menu");
        
        switch(a)
        {
            case "G1":
                oneactive = false;
                break;
            case "G2":
                twoactive = false;
                break;
            case "G3":
                threeactive = false;
                break;
            case "G4":
                fouractive = false;
                break;    
            case "G5":
                fiveactive = false;
                break;
            case "G6":
                sixactive = false;
                break;
            case "G7":
                sevenactive = false;
                break;
        }
        }
    }
    /*
       public void eraseintrotests() //erases introduction test 
    {
        for(int i=0; i < introtextss.length; i++)
        {
            introtextss[i] = "";
        }
    }
    public void addscore(int add) //adds score by amount specified by par
    {
        score = score + add;
        showText("score:" + score, 100,20);
    }
    public void startscreensetup() //sets up the start screen 
    {
        running = false;
        startscreentext();
        addObject(new missionm() , 195 , 200);
        addObject(new infinate() , 585 , 200);
    }
    public void startscreentext() // puts some text on start scree n
    {
        showText(introtextss[0],195, 150);
        showText(introtextss[1],585,150);
        showText(introtextss[2], 390, 50);
    }
    public void missionstart() // starts mission mode and all the text and stuff that happens 
    {
        for (Object obj : getObjects(Buttons.class)) if(((Actor)obj).getClass() != pausebutton.class){removeObject(((Actor)obj));};
        running = false;
        score = 0;
        sugcoll = 1;
        showText("score:" + score, 100,20);
        showText("SugarCollect:" + sugcoll, 250, 20);
        showText("Antibodies left:"+antibodycount, 550, 20);
        gameprepare();
    }
    public void infinatestart() // starts infinate mode 
    {
        for (Object obj : getObjects(Buttons.class)) if(((Actor)obj).getClass() != pausebutton.class){removeObject(((Actor)obj));};
        running = false;
        score = 0;
        sugcoll = 1;
        showText("score:" + score, 100,20);
        showText("SugarCollect:" + sugcoll, 250, 20);
        showText("Antibodies left:"+antibodycount, 550, 20);
        gameprepare();
    }
    //string for virus explanation 
    String v0 = "Fire antibodies with b.";
    String v1 = "If enough antibodies hit a virus it will die. \n and give you a few points.";
    String v2 = "But don't let the virus hit you \nbecuase if so you will lose a lot of sugar.";
    String v3 = "You also have a limited amount of antibodies.";
    String v4 = "Run out and you may only be able to replenish later.";
    //below used for text and stuff
    //below text is for the beginning of the mission mode
    String t0 = "It seems like the body has sustained several wounds.";
    String t1 = "You must help the body fight the infection and repair the wounds.";
    String t2 = "press C to turn left, V to turn right.";
    String t3 = "Press space to direct platelets to a wound and stop it from bleeding.";
    String t4 = "Move with the arrow keys to direct the white blood cell \nto the bacteria to destroy it.";
    String t5 = "Collect different chemicals for different effects.";
    String t6 = "Sugar is a vital resource,\nit can be used to make more cells to help fight along side \nyou or repair the current ones deployed\n however, viruses touching the white blood cell \nand bacteria escaping to the rest of the body \n deminish your sugar";
    String t7 = "Run out of sugar and the cell dies ending the game.";
    String t8 = "Alcohol damages the immune system, \nslowing it down and making it less effective, avoid alcohol at all costs.";
    String t9 = "Throughout your adventure you may find cuts \nin the lining of the bloodstream";
    String t10 = "To stop the flow of foreign invaders \ndirect the platelets towards the injury";
    String t11 = "By plugging the wound the invaders are minimized \n (and a heafty amount will be added to your score and sugar as a reward.)";
    String t12 = "See how long you can survive \n or the score you can obtain during that time.";
    String t13 = "When all the cuts are plugged or you run out of platelets\nyou will return to the bonemarrow to prepare for the next mission.";
    Integer[] i = {1,0};
    List<String> begintext = new ArrayList<String>() {{
            add(t0);
            add(t1);
            add(t2);
            add(t3);
            add(t4);
            add(t5);
            add(t6);
            add(t7);
            add(t8);
            add(t9);
            add(t10);
            add(t11);
            add(v0);
            add(v1);
            add(v2);
            add(v3);
            add(v4);
        }};
    String textmovedisplay = "press the x key to continue"; // is the variable for display of continue text 
    //logic so varius repeats don't happen
    int textshow = 0;
    String tdisplayf = "0";
    boolean waspressed = false;
    boolean starttext = true;
    String begintextreal = "a";
    int sugarconsuptionrate = 600; // how often sugar is consumed by the cell naturally, divide number by 60 for approxamate time in seconds
    int sugarconsuptionhelp = 0;
    //repeat detection too 
    boolean alreadyrunf = false;
    //detects start of mission mode
    boolean missiontextstart = false;
    //strings for the welcome screen 
    String startscreentextmis = "click button to start mission mode, \n see how much score you can get \nin 1 minute(WIP)";
    String infintext = "Click this button to start infinite mode, \nsee how long you can survive \nand how much score you can obtain.";
    String introtext = "Welcome to White Blood Cell vs \na Guy Who Seems to Get Alot of Injuries";
    String[] introtextss = new String[]{startscreentextmis,infintext,introtext};
    boolean infanitetextstart = false;
    //special infinate text
    String inft1 = "In this mode the game will continue infinitely until you die. ";
    String inft2 = "See how long you can survive and how much score you can obtain.";
    //the below text controls the text for infinate mode
    boolean startcutdeadtext = false; //starts cuts initial dieing text
    List<String> infanitebegintext = new ArrayList<String>() {{
            add(inft1);
            add(inft2);
            add(t4);
            add(t5);
            add(t6);
            add(t7);
            add(t8);
            add(v0);
            add(v1);
            add(v2);
            add(v3);
            add(v4);
        }};
        
        //the below text controls text for coming across a cut. 
        String cutb1 = "Uh oh";
        String cutb2 = "It looks like you have come across a cut in the circulitory system,";
        String cutb3 = "While this is not the only one \nit is part of the reason for all these nasty \nviruses and bacteria in the body";
        String cutb4 = "Throughout your trip through the circulitory system\n you may encounter many of these cuts which will spew \nviruses and bacteria out of them";
        String cutb5 = "Use space button to direct platelets to the cut, \n the platelets will block up the cut \npreventing more nasty things from entering the body";
        String cutb6 = "(and giving you a healthy point bonance)";
        String cutb7 = "Turn the white blood cell with c and v.";
        String cutb8 = "Good luck :).";
    List<String> cuttextbegin = new ArrayList<String>() {{
            add(cutb1);
            add(cutb2);
            add(cutb3);
            add(cutb4);
            add(cutb5);
            add(cutb6);
            add(cutb7);
            add(cutb8);
        }};
        //the below text runs if you killed the cut 
        String cutf1 = "You successfully repaired the cut.";
        String cutf2 = "Good job!";
        String cutf3 = "But this will not be the only one you will find.";
    List<String> cuttextdead = new ArrayList<String>() {{
            add(cutf1);
            add(cutf2);
            add(cutf3);
        }};
        
        
        //text for if the cut passes you WIP
        String cuttd1 = "It seems like the cut survived";
        String cuttd2 = "that's ok but remember more will be coming";
        String cuttd3 = "try to block their flow for extra points";
    List<String> cuttextalivepast = new ArrayList<String>() {{
            add(cuttd1);
            add(cuttd2);
            add(cuttd3);
        }};
        //varius cut detections 
    boolean cutspawned = false;
    boolean cutdied = false;
    int cuttime = 600; // time till text after cut appears 
    boolean cutfirst = true;
    int cuttexttimer = 300;
    int cutexttimework = 0;
    boolean cutexttimestart = false;
    boolean noseccut = false;
    boolean oldcutgone = true;
    //marrow start stuff 
    boolean mismarrowready = false;
    boolean startmarrowtimer = false;
    public int antibodycount = 10;
    boolean cutallowed = false;
    boolean cutallowed2 = false;
    
    
    
    
     cutdeathtextrepeat();
        misbeginningtext(); 
        infanitebeginningtext();
        cuttext();
        //below in if all the things that happen if the world is running 
        if(running == true )
        {
            sugarconsumption();
            if( sugcoll < 1)
            {
                deathscreen();
                Greenfoot.stop();
            }
            timer();
            spawnstuff();
            
        }
       */
}
