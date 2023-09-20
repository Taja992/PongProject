import greenfoot.*;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 * 
 * @author The teachers 
 * @version 1
 */
public class Ball extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;

    //ball movement moveX and Y go up by 1 ever level up:
    public int ballMoveX = 1;
    public int ballMoveY = 1;
    public int randomZ = 1;
    
    //level up system:
    private int level = 0;
    private int hits = 0;
    private int delay = 10;
    
    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    
    // Variable used to tell if bounce off or not
    private int paddleother = 0;    

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        init();  //Used to set the boolean statements to false at the start of the program     
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            //Ball Movement:
            setLocation(getX()+(ballMoveY*randomZ), getY()+(ballMoveX*randomZ));
            
            //Checks
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
            checkBounceOffPaddle(); // Deals with the leveling system+bounces ball back
            
            // Allows ball to pass through or bounce off other paddle
            otherPaddleBehavior(); 
        }
        

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);

    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
                Greenfoot.playSound("bounce2.wav");
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }
    
    //Checks to see if ball hits paddle and adds on to paddleother/changes direction
    //Increases level and speed
    private void checkBounceOffPaddle(){    
        Actor ballPlayerPaddle = getOneIntersectingObject(PaddlePlayer.class);
        if(ballPlayerPaddle != null) {
            ballMoveX = -ballMoveX;
            Greenfoot.playSound("bounce2.wav");
            paddleother = 1;
            hits++;
            delay--;
            if(hits % 50 == 0){
                level++;
                Greenfoot.playSound("ping.wav");
                ballMoveY++;
                ballMoveX--;
                delay = 10;
            }
            else if(hits % 10 == 0){
                level++;
                Greenfoot.playSound("ping.wav");
                ballMoveY++;
                ballMoveX--;
                delay = 10;
            }
        }
    }
    
    //Checks to see if ball will bounce off otherpaddle or not 
    private void otherPaddleBehavior(){    
        Actor padBehav = getOneIntersectingObject(PaddleOther.class);
        if (padBehav != null && paddleother == 1) {
            revertVertically();
            Greenfoot.playSound("bounce2.wav");
            ballMoveX = -ballMoveX;
        }        
        }
    
    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())       
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                Greenfoot.playSound("bounce2.wav");
                paddleother = 0; //If ball hits roof it sets paddleother to 0 and will go through enemy paddle
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            Greenfoot.playSound("gameover.wav");
            Greenfoot.setWorld(new IntroWorld());
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
         if (getX() < 10 || getX() > 490)
        {
            ballMoveY = -ballMoveY;
            Greenfoot.playSound("bounce2.wav");
            hasBouncedHorizontally = true;
        }      
    }
    
    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
          if (getY() < 10 || getY() > 690)
        {
            ballMoveX = -ballMoveX;
            Greenfoot.playSound("bounce2.wav");
            hasBouncedVertically = true;
        }      
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getHits(){
        return hits;
    }
}
