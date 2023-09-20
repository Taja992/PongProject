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
    private int prevLvl = 0; //Used for spawning more paddles

    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
            if (gameStarted)
            {
                ball = new Ball();
                addObject(levelCounter, 657, 13);
                addObject(ball, WORLD_WIDTH/3, WORLD_HEIGHT/3);
                addObject(new PaddlePlayer(), 60, WORLD_HEIGHT - 50);
                addObject(new PaddleOther(Greenfoot.getRandomNumber(100) + 50, 10), Greenfoot.getRandomNumber(350)+1,Greenfoot.getRandomNumber(250)+1);
            }
            else
            {
            Greenfoot.setWorld(new IntroWorld());
            }
    }
    
    public void act(){
        levelCheck();
        spawnPaddle();
        }
            
    private void levelCheck(){
        levelCounter.setValue(ball.getLevel() + 1);
    }

    private void spawnPaddle(){ //Every level spawns new enemy paddle 
        if(ball.getLevel() != prevLvl){
            addObject(new PaddleOther(Greenfoot.getRandomNumber(100) + 70, 10), Greenfoot.getRandomNumber(350)+1,Greenfoot.getRandomNumber(250)+1);
            prevLvl = ball.getLevel();
        }
    }
}
