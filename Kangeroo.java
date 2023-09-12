import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kangeroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kangeroo extends Actor
{
    private int speed = 10;
 //   private int xCord;
    
    
    public void act()
    {
       finishLine();
       
    }
    
    private void finishLine(){ 
        if(getX() <= 1000){
        move(speed);       
        if(getX() >= 1000){
            move(0);
        }
        }
    }
    
/*    private int xlocation(){
        getX();
        return xCord;
    } */
    }

