import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kangeroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kangeroo extends Actor
{
    private int speed = Greenfoot.getRandomNumber(5)+1;
    private long countActs = 0;
    private int pylon1 = 0;
    private int pylon2 = 0;
    private int pylon3 = 0;
    private int pylon4 = 0;
    
    public void act()
    {
        finishLine();
        countActs++;
       
    }

    private void finishLine(){
         int xLoc = getX();
         int yLoc = getY();        
        if(pylon1 == 0){
            move(speed);
            turnTowards(974, 474);
            speed = Greenfoot.getRandomNumber(4)+1;
                if(xLoc == 974 || yLoc == 474){
                    pylon1++;
                    }
                }
        if(pylon1 == 1){
            move(speed);
            turnTowards(957, 111);
            speed = Greenfoot.getRandomNumber(7)+1;
                if(xLoc == 957 || yLoc == 111){
                    pylon1++;
                    }
        }
        if(pylon1 == 2){
            move(speed);
            turnTowards(159, 108);
            speed = Greenfoot.getRandomNumber(8)+1;
                if(xLoc == 159 || yLoc == 108){
                    pylon1++;
                }
        }
        if(pylon1 == 3){
            move(speed);
            turnTowards(118, 470);
            speed = Greenfoot.getRandomNumber(10)+1;
                if(xLoc == 118 || yLoc == 470){
                    pylon1++;
                }
        }
        if(pylon1 == 4){
            move(speed);
            turnTowards(476, 554);
            speed = Greenfoot.getRandomNumber(15)+1;
        }
        if(xLoc == 476 && yLoc == 554){
        GameOver end = new GameOver();
        Greenfoot.setWorld(end);
        }
    }
}