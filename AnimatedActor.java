/**
 * @(#)AnimatedActor.java
 *
 *  Lab 5 Starter Code
 *
 *
 * @author Mr May
 * @version 1.00 2016/7/21
 */
import mayflower.*;

public class AnimatedActor extends GravityActor 
{
    private Animation animation; //stores the animation for this actor
    private Timer animationTimer; //times the changing of the animation frames so that animation doesn't play too fast

    public AnimatedActor() 
    {
        animation = null;
        animationTimer = new Timer(); //start timer
    }
    
    public void setAnimation(Animation a) //sets animation of this player to a new animation
    {
        animation = a;
        animationTimer.reset(); //restarts the timer
    }
    
    public void update()
    {   super.update();
        if(animation != null) //prevents NullPointerException
        {
            if(animationTimer.hasTimePassed(animation.getFrameRate())) //if enough time has passed
            {   
                animationTimer.reset(); 
                setPicture(animation.getNextFrame()); //set the animation to the next frame on the list
            }
        }
    }
    
    
    
}