import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class PaddlePlayer extends Actor
{
    private int width;
    private int height;
    private int dx;
    
    private int speed = 4;
    
    private boolean havePressedR = false;
    private boolean havePressedL = false;
    private int countL = 0; //window to dash
    private int countR = 0; //window to dash
    private int maxCount = 15;
    private boolean canDashR = false;
    private boolean canDashL = false;
    private int dashCoolDown = 0;
    private int maxCoolDown = 240;
    private int dashDist = 200;
    /**
     * Constructs a new paddle with the given dimensions.
     */ 
    public PaddlePlayer()
    {

    } 

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        dashControl();
        dashCheck();
        dashClickTimeFrame();
        dashCooldown();
    }    
    
    private void dashControl(){
        if (Greenfoot.isKeyDown("right")){
            if (canDashR){ //dash
                countR = 0;
                canDashR = false;
                dashCoolDown = maxCoolDown;
                Greenfoot.playSound("dash.wav");
                setLocation(getX() + dashDist, getY());
            } else { //normal movement
                havePressedR = true;
                countR = maxCount;
                move(speed);
            }
        } 
        
        if(Greenfoot.isKeyDown("left")){
            if (canDashL){ //dash
                countL = 0;
                canDashL = false;
                dashCoolDown = maxCoolDown;
                Greenfoot.playSound("dash.wav");
                setLocation(getX() - dashDist, getY());
            } else { //normal movement
                havePressedL = true;
                countL = maxCount;
                move(-speed);
            }
        }    
    }
    
    private void dashCheck(){
        //check whether we can dash (to the right)
        if (!Greenfoot.isKeyDown("right") && havePressedR && dashCoolDown == 0){
            canDashR = true;
        } else {
            canDashR = false;
        }
        //check whether we can dash (to the left)
        if (!Greenfoot.isKeyDown("left") && havePressedL && dashCoolDown == 0){
            canDashL = true;
        } else {
            canDashL = false;
        }
    }
    private void dashClickTimeFrame(){
        countR--;  //decrease the time frame to double-click the movement key for dash
        if (countR == 0){ //make it so that we can't dash anymore if countdown is 0
            havePressedR = false;
        }
        if(countR < 0){
            countR = 0;
        }
        countL--;  //decrease the time frame to double-click the movement key for dash
        if (countL == 0){ //make it so that we can't dash anymore if countdown is 0
            havePressedL = false;
        }
        if(countL < 0){
            countL = 0;
        }
    }
    private void dashCooldown(){
        dashCoolDown--; //decrease cooldown every second
        if(dashCoolDown < 0){
            dashCoolDown = 0;
        }    
    }
    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }
}

