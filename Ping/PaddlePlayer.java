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
    private int count = 0; //window to dash
    private boolean canDashR = false;
    private boolean canDashL = false;
    private int dashCoolDown = 0;
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
                count = 0;
                canDashR = false;
                dashCoolDown = 50;
                setLocation(getX() + dashDist, getY());
            } else { //normal movement
                havePressedR = true;
                count = 10;
                move(speed);
            }
        } 
        
        if(Greenfoot.isKeyDown("left")){
            if (canDashL){ //dash
                count = 0;
                canDashL = false;
                dashCoolDown = 50;
                setLocation(getX() - dashDist, getY());
            } else { //normal movement
                havePressedL = true;
                count = 10;
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
        
        if (!Greenfoot.isKeyDown("left") && havePressedL && dashCoolDown == 0){
            canDashL = true;
        } else {
            canDashL = false;
        }
    }
    
    private void dashClickTimeFrame(){
        count--;  //time frame to double click movement key for dash
        if (count == 0){ //make it so that we can't dash anymore if countdown is 0
            havePressedR = false;
            havePressedL = false;
        }
        if(count < 0){
            count = 0;
        }
    }
    
    private void dashCooldown(){
        dashCoolDown--;
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

