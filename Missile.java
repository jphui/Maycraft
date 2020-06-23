

 import mayflower.*;
public class Missile extends Actor
{
    Picture regular;
    Picture dab;
    Picture strike;
    Timer pictureTime; //timer that handles when to alternate the image between idle and dabbing
    boolean switche; //boolean that handles what frame Herobrine is on
    boolean attacked; //boolean that keeps track of if herobrine has already attacked
    private Cat edwin; //Variable that stores player
    boolean armed;
    public Missile(Cat c) //gets cat from the game world
    {
        regular = new Picture("img/enemy.png");
        dab = new Picture("img/enemydab.png");
        strike = new Picture("img/enemystrike.png");
        regular.resize(100,200);
        dab.resize(150,200);
        strike.resize(150,200);
        setPicture(regular);
        pictureTime = new Timer();
        switche = true;
        attacked = false;
        armed = false;
        edwin=c;
    }
    public void update()
    {   move(5,"South");
        if(!attacked) //flag variable ensures that Herobrine only attacks once; if attacked is true the actor stops functioning
        {
                try{attack();} //exception catcher, doesn't really workl
                catch(Exception e){}
            if(pictureTime.hasTimePassed(250))
            {
                if(switche)
                {
                    setPicture(dab);
                    switche=false;
                }
                else 
                {
                    setPicture(regular);
                    switche = true;
                }
                pictureTime.reset();
            }
    }
    }
    public void attack() //checks to see if Herobrine can attack player
    {
        Actor[] actors;//array of actors that are touching player
        if(isTouching(edwin)) //if is touching the player
        {
            actors = edwin.getTouching();
            for(Actor a: actors) if(a instanceof Sword) armed = true; //if is touching player and player has a sword then will not attack
            if(!armed) //otherwise attack player by calling the decreaseLives method and set picture to attack image
            {edwin.decreaselives(1);
            setPicture(strike);
            attacked = true;
        }
        }   
    }
    } 
