import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    
    public MyWorld()
    {    
        super(1100, 650, 1); 
        
        
        addObject(new Kangeroo(), 300, 500);
        addObject(new Kangeroo(), 300, 510);
        addObject(new Kangeroo(), 300, 520);
        addObject(new Kangeroo(), 300, 530);
        addObject(new Kangeroo(), 300, 540);
        addObject(new Kangeroo(), 300, 550);
    }
}
