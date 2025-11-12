import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pathBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pathBox extends Card
{
    GreenfootImage back1 = new GreenfootImage("Bunny_right.png");
    GreenfootImage backL = new GreenfootImage("Bunny_right.png");//same string as above 
    GreenfootImage card1 = new GreenfootImage("Bunny_right.png");
    boolean isGreen = false;
    /*int counter = 0;
    int hideCount = 0;*/
    
    
    
    //public static int cardsFound = 0;
    //int wrongCard = 0;
    /**
     * Act - do whatever the pathBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public pathBox(boolean isGreen, boolean[][] spaces, int x, int y)
    {
        
        super(true);
        Imagescalar = 1.93;
        this.isGreen = isGreen;
        back1 = new GreenfootImage("Game 7\\Game7_graysquare.png");
        backL = new GreenfootImage("Game 7\\Game7_graysquare.png");
        if(isGreen)
        {
            card1 = new GreenfootImage("Game 7\\Game7_greensquare.png");
            //card.getImage().scale(c.getImage().getWidth()/2,c.getImage().getHeight()/2);
        }else
        {
            card1 = new GreenfootImage("Game 7\\Game7_redsquare.png");
            //card.getImage().scale(c.getImage().getWidth()/2,c.getImage().getHeight()/2);
        }
        //back.scale(25,25);
               // card.scale(25,25);
                       // backL.scale(25,25);
                       card1.scale((int) (card1.getWidth()/Imagescalar),(int)(card1.getHeight()/Imagescalar));
                       back1.scale((int) (back1.getWidth()/Imagescalar),(int) (back1.getHeight()/Imagescalar));
                       backL.scale(backL.getWidth()/2,backL.getHeight()/2);
                       back = "Game 7\\Game7_graysquare.png";
        if(isGreen == true)
        {
            card = "Game 7\\Game7_greensquare.png";
        }
        if(isGreen == false)
        {
            card = "Game 7\\Game7_redsquare.png";
        }
        //mouseDown = false;
       // button_1 = back;
        //button_2 = backL;
        this.x = x;
        this.y = y;
        //buttonanimations  = false;
        finishedHide = true;
    }
    int x;
    int y;
    private static final int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
private static final int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

public static boolean hasPath(boolean[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        if (searchPath(grid, row, 0)) {
            return true;
        }
    }
    return false;
}

private static boolean searchPath(boolean[][] grid, int row, int col) {
    if (col == grid[0].length - 1 && grid[row][col]) { // Check if it's the last column and the cell is part of the path
        return true;
    }

    if (grid[row][col]) {
        grid[row][col] = false; // Mark as visited

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (isValid(grid, newRow, newCol) && searchPath(grid, newRow, newCol)) {
                return true;
            }
        }

        grid[row][col] = true; // Unmark for other paths
    }

    return false;
}

private static boolean isValid(boolean[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
}
    public void howMany(boolean[][] a)
    {
        for(int i = 0; i < a[0].length; i++)
        {
            for(int j =0; j < a.length; j++)
            {
                
            }
        }
    }
    public void function()
    {
        //System.out.println("path pressed" + x +" " + y);
        int[] pos = ((MyWorld) getWorld()).G7getPos();
        if((pos[0] == -1 && y == 0) || (Math.abs(pos[0] - x) <= 1 && Math.abs(pos[1] - y) <= 1))
        {
            
        
            if(isGreen)
            {
                //flip();
                //special();
                //System.out.println("was green");
                turn = true;
                turned = false;
                flipCount = 0;
                special();
                ((MyWorld) getWorld()).G7setPos(x,y);
                boolean[][] a = ((MyWorld)getWorld()).getG7Cor();
                a[x][y] = true;
                ((MyWorld)getWorld()).setG7Cor(a);
                if(hasPath(((MyWorld)getWorld()).getG7Cor()))
                {
                    ((MyWorld) getWorld()).succeed("G7");
                }
                
                
            }else
            {
                boolean[][] a = ((MyWorld)getWorld()).getG7Cor();
                for(int b = 0; b < a.length; b++)
                {
                    for(int c = 0; c < a[0].length;c++)
                    {
                    
                        a[b][c] = false;
                    }
                }
                special();
                ((MyWorld) getWorld()).G7Fail();
                turn = true;
                turned = false;
                flipCount = 0;
                //System.out.println("was red");
                ((MyWorld) getWorld()).G7setPos(-1,-1);
                                
                //flip();
            }
        }
    }
    public void special()
    {
        if(isGreen)
        {
            card = "Game 7\\Game7_greensquare.png";
            //card.getImage().scale(c.getImage().getWidth()/2,c.getImage().getHeight()/2);
        }else
        {
            card = "Game 7\\Game7_redsquare.png";
            //card.getImage().scale(c.getImage().getWidth()/2,c.getImage().getHeight()/2);
        }
        //System.out.println("special done in pathbox");
    }
    public void act()
    {
        //getWorld().showText(x + "" + y,getX(),getY());
        //buttonworks();
        
            ////////////
            hide();
            if(finishedHide == true)
            {
                start();
                
            }
        
    }
    
    
}
