import mayflower.*;
public class Sword extends Actor
{
    private Picture skin; //the picture of the actual sword
    private Sound kidscream; //sound of kid screaming "DIAMOND SWORD"
    private Sound robloxOof; //sound of herobrine dying
    private boolean hasScreamed; //has "DIAMOND SWORD"
    private Cat m; //adds Mr. May to the world
    private Sound hit; //sound for when a Herobrine is hit
    public Sword()
    {
        skin = new Picture("img/diasword.png"); //sets picture of sword
        skin.resize(75,75); //resizes image to 75,75
        hasScreamed = false;
        setPicture(skin);
        kidscream = new Sound("snd/diamondsword.wav"); //sets sound of scream
        robloxOof = new Sound("snd/uuuhh.wav"); //sets sound of hit herobrine
        hit = new Sound("snd/hit.wav"); //sets sound of sword attack
    }
    public void update()
    {
        track();
        Actor[] actors = getTouching();
        if(!hasScreamed) move(5,"West");
        for(Actor a : actors)
        {
            if(a instanceof Cat) //if actor is a cat play the scream and follow the cat
            {
                if(!hasScreamed)
                {kidscream.play(); 
                 hasScreamed = true;}
                m = (Cat)a;
                if(m.isGrounded())move(5,"West");
            }
            if(a instanceof Missile) //if actor is a missile hit the missile, play sounds and destroy the sword
            {
                if(getStage()!=null){
                    hit.play();
                    getStage().removeActor(a);
                getStage().removeActor(this);
                robloxOof.play();
                if(m!=null) m.increaseScore(1000);
            }
            }
        }
        if(getX()<-50 && getStage()!=null) getStage().removeActor(this);
    }
    public void track() //tracks the position of the player when player picks up sword
    {
       if(m!=null)setPosition(m.getX() + 40,m.getY() -10);
    }
}