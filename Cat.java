/**
 * @(#)Cat.java
 *
 *  Lab 5 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends Movableactor 
{
    Animation walk;
    Animation idle;
    Animation walkl;
    Animation fallL;
    Animation fallR;
    int score;
    int lives;
    public Cat() 
    {
       score = 0;
       lives = 3;
        
        walk = new Animation(50, new String[] {
            "img/cat/Walk (1).png",
            "img/cat/Walk (2).png",
            "img/cat/Walk (3).png",
            "img/cat/Walk (4).png",
            "img/cat/Walk (5).png",
            "img/cat/Walk (6).png",
            "img/cat/Walk (7).png",
            "img/cat/Walk (8).png",
            "img/cat/Walk (9).png",
            "img/cat/Walk (10).png",
            "img/cat/Walk (11).png",
            "img/cat/Walk (12).png",
        });
        
        walkl = new Animation(50, new String[] {
            "img/cat/Walk (1).png",
            "img/cat/Walk (2).png",
            "img/cat/Walk (3).png",
            "img/cat/Walk (4).png",
            "img/cat/Walk (5).png",
            "img/cat/Walk (6).png",
            "img/cat/Walk (7).png",
            "img/cat/Walk (8).png",
            "img/cat/Walk (9).png",
            "img/cat/Walk (10).png",
            "img/cat/Walk (11).png",
            "img/cat/Walk (12).png",
        });
        idle = new Animation(50, new String[] {
            "img/cat/Idle (1).png",   
            "img/cat/Idle (2).png",
            "img/cat/Idle (3).png",
            "img/cat/Idle (4).png",
            "img/cat/Idle (5).png",
            "img/cat/Idle (6).png",
            "img/cat/Idle (7).png",
            "img/cat/Idle (8).png",
            "img/cat/Idle (9).png",
            "img/cat/Idle (10).png"
        });
        fallR = new Animation(50, new String[] {
            "img/cat/Fall (1).png",   
            "img/cat/Fall (2).png",
            "img/cat/Fall (3).png",
            "img/cat/Fall (4).png",
            "img/cat/Fall (5).png",
            "img/cat/Fall (6).png",
            "img/cat/Fall (7).png",
            "img/cat/Fall (8).png",
            
        });
       fallL = new Animation(50, new String[] {
            "img/cat/Fall (1).png",   
            "img/cat/Fall (2).png",
            "img/cat/Fall (3).png",
            "img/cat/Fall (4).png",
            "img/cat/Fall (5).png",
            "img/cat/Fall (6).png",
            "img/cat/Fall (7).png",
            "img/cat/Fall (8).png",
            
        });
        walk.resize(130, 111);
        idle.resize(130, 111);
        walkl.resize(130, 111);
        this.setWalkRightAni(walk);
        this.setIdleAni(idle);
        walkl.fliphor();
        fallL.fliphor();
        fallR.resize(130, 111);
        fallR.setBounds(28,5,54,80);
        this.setIdleAni(walkl);
        this.setFalls(fallR,fallL);
        walk.setBounds(18,5,54,80); 
        walkl.setBounds(18,5,54,80);
        idle.setBounds(28,5,54,80);
        
    }
    public void increaseScore( int amount )
    {
        score= score + amount;
        //System.out.println(score);
    }
     public void decreaselives( int amount )
     {
         Sound oof = new Sound("snd/OOF.wav");
         oof.play();
         lives = lives - amount;
     }
     public int returnlives()
    {
        return lives;
    }
    public int returnscore()
    {
        return score;
    }
    public void update()
    {
        super.update();
        Keyboard kb = getKeyboard();
         if (kb.isKeyPressed("1"))//cheat codes
        {
            getMayflower().setStage(new Area1());
        }
        if(kb.isKeyPressed("2"))
        {
            getMayflower().setStage(new Area2());
        }
       if(kb.isKeyPressed("3"))
        {
            getMayflower().setStage(new Area3());
        }
        if(kb.isKeyPressed("4"))
        {
            increaseScore(100);
        }
        if(kb.isKeyPressed("5"))
        {
            lives=3;
        }
        if(kb.isKeyPressed("s"))
        {
            if(getStage()!=null)
            {
                getStage().addActor(new Sword(),getX(),getY());
            }
        }
        if(kb.isKeyPressed("l"))
        {
        lives = lives -1 ;
       }
    }
    
    
}