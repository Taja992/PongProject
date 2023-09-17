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
  //  private static final int STARTING_ANGLE_WIDTH = 90;
  //  private static final int DELAY_TIME = 100;
    //ball movement:
    public int ballMoveX = 1;
    public int ballMoveY = 1;
    public int randomZ = 1;
    //level:
    private int level = 0;
    private int hits = 0;
    private int delay = 10;
    
    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    //private int delay;
    private int ballY;
    private int paddleother = 0;    // Variable used to tell if bounce off or not

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        //createImage();
        init();
        
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
 /*   private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.setColor(Color.BLACK);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    } */

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            //Ball Movement:
            setLocation(getX()+(ballMoveY*randomZ), getY()+(ballMoveX*randomZ));
        
            //move(speed);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
            checkBounceOffPaddle();
            otherPaddleBehavior(); // Allows ball to pass through or bounce off other paddle
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
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }
    
    private void checkBounceOffPaddle(){    //Checks to see if ball hits paddle and adds on to paddleother/changes direction
        Actor ballPlayerPaddle = getOneIntersectingObject(PaddlePlayer.class);
        if(ballPlayerPaddle != null) {
            //revertVertically();
            ballMoveX = -ballMoveX;            
            paddleother = 1;
            hits++;
            delay--;
            if(hits % 50 == 0){
                level++;
                //ballMoveX++;
                //ballMoveY++;
                randomZ++;
                delay = 10;
            }
            else if(hits % 10 == 0){
                level++;
                randomZ++;
                delay = 10;
            }
        }
    }
    
     private void otherPaddleBehavior(){    //Checks to see if ball will bounce off otherpaddle or not
        Actor padBehav = getOneIntersectingObject(PaddleOther.class);
        if (padBehav != null && paddleother == 1) {
            revertVertically();
            ballMoveX = -ballMoveX;
            paddleother = 0;    
        }        
        }
    
    
    /*   private void otherPaddleBounce(){
        Actor ballOtherPaddle = getOneIntersectingObject(PaddleOther.class);

        if(ballOtherPaddle != null){
                ballY = getY();
                PaddleOther paddleother = (PaddleOther) ballOtherPaddle;
                int otherPaddleLocation = paddleother.paddleY;
            if(otherPaddleLocation > ballY){
                 revertVertically();
            }
        }
    } */
    
    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())       //If ball hits roof it sets paddleother to 0 and will go through paddleother
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                paddleother = 0;
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
            //init();
            //setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.setWorld(new IntroWorld());
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
         if (getX() <10 || getX() > 490)
        {
            ballMoveY = -ballMoveY;
            //Greenfoot.playSound("bounce2.wav");
            hasBouncedHorizontally = true;
        }      
        /* int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((170 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true; */
    }

    
    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
          if (getY() <10 || getY() > 690)
        {
            ballMoveX = -ballMoveX;
            //Greenfoot.playSound("bounce2.wav");
            hasBouncedVertically = true;
        }      
        /*int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((350 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;*/
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
     //   speed = 2;
     //   delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
     //  setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
    
    public int getLevel(){
        return level;
    }
}
