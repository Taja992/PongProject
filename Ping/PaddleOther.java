import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaddleOther here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddleOther extends Actor
{
    private int width;
    private int height;
    private int dx;
    private int y;

    /**
     * Constructs a new paddle with the given dimensions.
     */ 
    public PaddleOther(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
        //createImage(); 
    } 
   
    public void act()
    {
        moving(); // Moves This paddle from one side to the other and respawns it randomly on other side
        setLocation(getX() + dx, getY());
    }

    /**
     * Moves This paddle from one side to the other and respawns it randomly on other side
     */
    private void moving(){
     if(getX() + width/2 >= getWorld().getWidth())
        {
            //Change our 'x' direction to the inverted direction:
      //    dx = dx * -1;
          y = Greenfoot.getRandomNumber(250)+1;
          setLocation(0, y);
        }
        /*             int speed = 4;       //Used for testing
         if(Greenfoot.isKeyDown("a")){
            move(-speed);
        }
         if(Greenfoot.isKeyDown("d")){
            move(speed);
        } */
    } 

   /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
   /* private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }  */
}


