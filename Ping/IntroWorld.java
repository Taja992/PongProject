import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 700;
    private static final int WORLD_HEIGHT = 500;

    

    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        GreenfootImage background = getBackground();
        background.setFont(new Font("Arial", true, false, 15));
        background.setColor(Color.WHITE);
        background.drawString("Hit <enter> to start game...", 230, 200);
        background.drawString("Use arrow keys to control player paddle", 190, 300);
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
}