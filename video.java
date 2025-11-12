import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//import java.io*;
/**
 * Write a description of class video here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class video extends advancedGravity
{
    /**
     * Act - do whatever the video wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean stop = false;
    int frame = 0;
    String brak = ")";
    long lastTime  = System.currentTimeMillis();
    long curTime  = System.currentTimeMillis();
    boolean efficency = false;
    boolean fullarray = false;
    ArrayList<String> frames = new ArrayList<String>();
    boolean fullImageSave = false;
    boolean actAfter = true;
    public void actAfterSetUp()
    {
        if(audio != null && actAfter)
        {
            audio.playLoop();
            actAfter = false;
        }
        super.actAfterSetUp();
    }
    public void act()
    {
        //interacting
        actAfterSetUp();
        if(/*!efficency*/false)
        {
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
        
        curTime  = System.currentTimeMillis();
        while(curTime < lastTime + framerate - 10 * (23.943 - 23.809523809))
        {
            curTime  = System.currentTimeMillis();
        }
        if(curTime >= lastTime + framerate - 10 * (23.943 - 23.809523809))
        {
            System.out.println("target FPS is " + (1000 / framerate) + " current frameRate is " + ((double)1000/ (curTime - lastTime) + "    frame = " + frame));
            //System.out.println("frame test jpg, new pic = "+name+formatNumber(frame,forceDigit)+brak+".jpg");
                lastTime = System.currentTimeMillis();
            if(audio != null && !audio.isPlaying())
            {
                audio.playLoop();
                //System.out.println("audio replaying, audio = " + audio);
            }
            //framerateC = 0;
            
            if(!efficency && !preloadB)
            {
                if(!stop)
                {
                    //System.out.println("nonefficent part");
                    
                    try
                    {
                        //Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]\
                        setImage(name+formatNumber(frame,forceDigit)+brak+".jpg"); 
                        //System.out.println("picture changed png, new pic = "+name+formatNumber(frame,forceDigit)+brak+".jpg");
                        
                        frame ++;
                    }
                    catch (java.lang.IllegalArgumentException iae)
                    {
                        try
                        {
                            setImage(name+formatNumber(frame,forceDigit)+brak+".png"); 
                             
                            //System.out.println("picture changed png, new pic = "+name+formatNumber(frame,forceDigit)+brak+".png");
                            frame ++;
                        }catch(java.lang.IllegalArgumentException iaee)
                        {
                            try
                            {
                                setImage(name+formatNumber(frame,forceDigit)+brak+".GIF"); 
                                frame ++;
                            }catch(java.lang.IllegalArgumentException iaeee)
                            {
                                
                                ending();
                                return;
                            }
                        }
                        
                    }
                }
                
                if(forceS)
                {
                    getImage().scale(xsize, ysize);
                    //System.out.println("resized");
                }
                if(scaleBpercentage)
                {
                    getImage().scale(getImage().getWidth() * percentage,getImage().getHeight() * percentage);
                    //System.out.println("resized");
                }
                if(fillScreen)
                {
                    getImage().scale(getWorld().getWidth(), getWorld().getHeight());
                    //System.out.println("resized");
                }
                
            } else
            {
                if(frame < frames.size())
                {
                    if(fullImageSave && !preloadB)
                    {
                        setImage(fullImage.get(frame));
                    }else if (preloadB)
                    {
                        setImage(preload.get(frame));
                    }else{
                        setImage(new GreenfootImage(frames.get(frame)));
                    }
                    
                    frame++;
                    
                }else
                {
                    ending();
                }
            }
            framerateC ++;
            
            //System.out.println("stop is :" + stop + " loop is: " + loop + " frame is:" + frame);
        }else
        {
            //System.out.println("video, non max utilization");
        }
    }
    public void videoEnd()
    {
        //System.out.println("auio stop attempted first" + audio);
        if(audio != null && audio.isPlaying())
        {
            audio.stop();
            //System.out.println("auio stop attempted " + audio);
        }
    }
    //afterV syntax, [(video name),(after change usually 0), (after),(force digit Num)]
    private void ending()
    {
                    //this part does repeat
                    if(audio != null)
                    {
                        audio.stop();
                        audio = null;
                    }
                    if(!loop)
                    {
                        preload = new ArrayList<GreenfootImage>();
                        fullImage = new ArrayList<GreenfootImage>();
                        frames = new ArrayList<String>();
                        stop = true;
                        
                        if(world)
                        {
                            if(!afterVideo)
                            { 
                                ((MyWorld)getWorld()).videoEnd(after);
                            }else
                            {
                                ((MyWorld)getWorld()).playVideo(afterV[0],afterV[1],afterV[2],23.943,Integer.parseInt(afterV[3]),false);
                                //"video\\1 Opening Animated Sequence-20240422T200952Z-001Resize\\OpeningAnimatedSequence","","menu1",23.943,3,false);
                            }
                        }
                           //getWorld().removeObject(this); 
                        
                    }
                    //System.out.println("no picture found");
                    if(loop)
                    {
                        frame = 1;
                    }else
                    {
                        // other ending other goes here
                        //getWorld().videoEndcode(uponEnd);
                        
                        
                        
                        
                        
                    }
    }
    public int x; // pos x
    public int y; //pos y 
    int xsize;//size x 
    int ysize;//size y
    boolean forceS = true; // forces image to specified size
    boolean fillScreen = false; //fills screen with image
    double framerate; // frame rate as divider of 60 
    int framerateC; //counter for framerate
    String name;//name of the string.
    boolean loop = false;
    int percentage = 100;
    boolean scaleBpercentage;
    String uponEnd = "";
    //frame rate is FPS
    //brak = ")"
    GreenfootSound audio;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage)
    {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000 / framerate;
        this.name = name + " (";
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
    }
    public void setAudio(GreenfootSound audio)
    {
        this.audio = audio;
    }
    public boolean world;
    public String after;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after)
    {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name + " (";
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
    }
    //boolean forceDigitB;
    int forceDigit = -1;
    public static String formatNumber(int number, int forceDigit) {
        if(forceDigit != -1)
        {
            // Create a format string with the specified number of zeros
            String format = "%0" + forceDigit + "d";
            // Return the formatted string
            return String.format(format, number);
        }else
        {
            return "" + number;
        }
    }
    GreenfootImage test = new GreenfootImage("download(6).jpeg");
    public void insertFrames()
    {
        boolean errored = false;
        if(efficency && !preloadB)
        {
            while(!errored)
            {
                GreenfootImage a = new GreenfootImage("smiley5.png");
                    System.out.println("frames inserting" + ((double)frame/(963))*100 + "%");
                    try{
                        a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".png");
                        frames.add(name+formatNumber(frame,forceDigit)+brak+".png");
                    }catch(java.lang.IllegalArgumentException iae)
                    {
                        try{
                            a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".jpg");
                            frames.add(name+formatNumber(frame,forceDigit)+brak+".jpg");
                        }catch(java.lang.IllegalArgumentException iaee )
                        {
                            errored = true;
                                System.out.println("frames done, size frames = " + frames.size());
                            try
                            {
                                a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".jpeg");
                                frames.add(name+formatNumber(frame,forceDigit)+brak+".jpeg");
                            }catch(java.lang.IllegalArgumentException iaeee)
                            {
                                errored = true;
                                System.out.println("frames done, size frames = " + frames.size());
                                //break;
                                
                            }
                        }
                    }
                    try{
                        if(fullImageSave && !preloadB)
                        {
                            fullImage.add(a);
                        }else
                        {
                            
                        }
                    }catch(Exception e)
                    {
                        fullImageSave = false;
                    }
                    a = null;
                    /*if(!a.equals(test))
                    {
                        if(forceS)
                        {
                            a.scale(xsize, ysize);
                            System.out.println("resized");
                        }
                        if(scaleBpercentage)
                        {
                            //a.scale(a.getWidth() * percentage,a.getHeight() * percentage);
                            System.out.println("resized");
                        }
                        if(fillScreen)
                        {
                            a.scale(750, 500);
                            System.out.println("resized");
                        }
                        //frames.add(a);
                    }*/
                frame++;
            }
            System.out.println("frames adding done, outside while");
        }
        frame = 0;
        
    }
    ArrayList<GreenfootImage> fullImage = new ArrayList<GreenfootImage>();
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after,String brak, int forceDigit)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
       insertFrames();
    }
    boolean afterVideo = false;
    String[] afterV;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String[] after,String brak, int forceDigit)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       //this.after = after;
       afterVideo = true;
       afterV = after;
       insertFrames();
    }
    ArrayList<GreenfootImage> preload;
    boolean preloadB = false;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after,String brak, int forceDigit, ArrayList<GreenfootImage> preload)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
       insertFrames();
       this.preload = preload;
       this.preloadB = !preload.equals("-1");
       if(preloadB)
       {
            fullImageSave = true;
        }
    }
    public video(String name)
    {
        //this.x = getWorld().getWidth()/2;
        //this.y = getWorld().getHeight()/2;
        this.xsize = 200;
        this.ysize = 200;
        this.framerate = 1000/ 60;
        this.name = name + " (";
        this.forceS = true;
        this.fillScreen = false;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = false;
       this.percentage = 0;
       this.scaleBpercentage = false;
       colAdd.add(StickMan2.class);
       insertFrames();
    }
}
