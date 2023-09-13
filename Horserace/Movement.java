import greenfoot.*;
import java.util.List;

public class Movement extends Actor
{
    private int speed = Greenfoot.getRandomNumber(5)+1;
    private int pylon1 = 0;    
    public void act()
    {
        racing();
        finishLine();      
    }

    protected void racing()
    {
         int xLoc = getX();
         int yLoc = getY();        
        if(pylon1 == 0){
            move(speed);
            turnTowards(974, 474);
            speed = Greenfoot.getRandomNumber(4)+1;
                if(xLoc == 974 && yLoc == 474){
                    pylon1++;
                    }
                }
        if(pylon1 == 1){
            move(speed);
            turnTowards(957, 111);
            speed = Greenfoot.getRandomNumber(7)+1;
                if(xLoc == 957 && yLoc == 111){
                    pylon1++;
                    }
        }
        if(pylon1 == 2){
            move(speed);
            turnTowards(159, 108);
            speed = Greenfoot.getRandomNumber(8)+1;
                if(xLoc == 159 && yLoc == 108){
                    pylon1++;
                }
        }
        if(pylon1 == 3){
            move(speed);
            turnTowards(118, 470);
            speed = Greenfoot.getRandomNumber(10)+1;
                if(xLoc == 118 && yLoc == 470){
                    pylon1++;
                }
        }
        if(pylon1 == 4){
            move(speed);
            turnTowards(476, 554);
            speed = Greenfoot.getRandomNumber(15)+1;
        }

    }
    
    protected void finishLine()
    {
        int xLoc = getX();
        int yLoc = getY();
            if(xLoc == 476 && yLoc == 554){
        GameOver end = new GameOver();
        Greenfoot.setWorld(end);
        }    
    }
    }