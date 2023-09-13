import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends WorldSize
{
    
    
    public MyWorld()
    {        
        int y = 10;
     //   int x = 5;
        for(int i = 0; i < 6;i++){
            int newY = 490+y;
            int newX = 530;
            addObject(new Kangeroo(), newX, newY);
            y += 20;      
        }
      /*  addObject(new Pylon1(), 974, 474);
        addObject(new Pylon2(), 957, 111);
        addObject(new Pylon3(), 159, 108);
        addObject(new Pylon4(), 118, 470);
        addObject(new FinishLine(), 476, 554);*/
    }
}
