import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{

    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        GreenfootImage background = getBackground();
        background.setFont(new Font("Comic Sans MS", true, false, 40));
        background.setColor(Color.WHITE);
        background.drawString("G A M E  O V E R", 175, 200);
        background.setFont(new Font("Comic Sans MS", true, false, 15));
        background.drawString("Better luck next time!\nPress <enter> to start another game", 225, 300);
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
