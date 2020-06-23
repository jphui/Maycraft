
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import mayflower.*;

public class Coin extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation spin;
    
    private boolean collected;
    
    private Timer Timer;

    /**
     * Constructor for objects of class Coin
     */
    public Coin()
    {
        collected = false;
        
        spin = new Animation(60, new String[] {
            "img/coin/Spin (1).png",
            "img/coin/Spin (2).png",
            "img/coin/Spin (3).png",
            "img/coin/Spin (4).png",
            "img/coin/Spin (5).png",
            "img/coin/Spin (6).png",
        });
        
        this.setAnimation(spin);
        
        Timer = new Timer();
    }
    
    public void collect()
    {
        Sound ding = new Sound("snd/ding.wav");
        ding.play();
        collected = true;
    }
    
    public boolean getCollected()
    {
        return collected;
    }
    
    public void update()
    {
        //super.update();
        move (5, "North");
        
        Actor[] touching = getTouching(); 
        //array of Actors, fills array with Actors touching the Actor that called the method (a Yarn)
        
        /*
         * The Actor class has a method called getTouching()which returns an array of every 
         * Actor object that is touching the Actor that called the method. 
         * As usual, every class that extends the Actorclass inherits the getTouching()method.
         * 
         * Detection in Cat class or Yarn class?
         * EITHER works, but...
         * You will write this code in the Yarn class because as you will find out in future 
         * labs, this will make it easier to maintain and upgrade your code. As you gain experience 
         * writing programs you will be able to make “more right” decisions when faced with multiple 
         * correct ways to write code.
         */
        
        if(this.getX() < -50)
        {
            Stage s = getStage();   //get this Actor's stage
                s.removeActor(this);    //remove this Actor from the Stage
                
                int x = (int)(Math.random()*700) + 500;
                int y = (int)(Math.random()*150) + 100;
                
                s.addActor(this, x, y);
            }
        
        for(Actor a : touching) 
        //for-loop, "for each actor in the array 'touching' (which we instantialized earlier)"
        {
            if( a instanceof Cat )
            {
                this.collect();
                
                Cat c = (Cat) a;
                //Now you can call Cat methods on the c variable
                //This block of code will only execute if this Yarn is
                //touching a Cat object
                
                c.increaseScore(1000);
                
                Stage s = getStage();   //get this Actor's stage
                s.removeActor(this);    //remove this Actor from the Stage
                
                int x = (int)(Math.random()*500) + 700;
                int y = (int)(Math.random()*150) + 333;
                
                s.addActor(this, x, y);
            }

        }
        
        if(Timer.hasTimePassed(4500))
          move(2,"West");
        
        super.update();
    }
}
