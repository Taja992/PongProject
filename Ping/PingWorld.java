import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 700;
    private static final int WORLD_HEIGHT = 500;
    private Counter levelCounter = new Counter("Level: ");
    private Ball ball;

    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);

        if (gameStarted)
        {
            //GreenfootImage background = getBackground();
            ball = new Ball();
            addObject(levelCounter, 657, 13);

            //background.setColor(Color.BLACK);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(ball, WORLD_WIDTH/3, WORLD_HEIGHT/3);
            //addObject(new PaddlePlayer(100,5), 60, WORLD_HEIGHT - 50);
            addObject(new PaddlePlayer(), 60, WORLD_HEIGHT - 50);
            addObject(new PaddleOther(100, 10), Greenfoot.getRandomNumber(350)+1,Greenfoot.getRandomNumber(250)+1);
            //addObject(new PaddleOther(), Greenfoot.getRandomNumber(350)+1,Greenfoot.getRandomNumber(250)+1);

        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }

    }
    
    public void act(){
        levelCheck();
        }
            
    private void levelCheck(){
        levelCounter.setValue(ball.getLevel() + 1);
    }

}
