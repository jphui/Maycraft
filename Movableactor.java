import mayflower.*;

public class Movableactor extends AnimatedActor
{
   private Animation walkright;
   private Animation idle;
   private Animation walkleft;
   private String currentaction; //stores what Mr May is doing
   private String wasAction; //stores what Mr May was doing
   private Animation fallright;
   private Animation fallleft;
     int leftEdge;
     int topEdge;
     int rightEdge;
     int bottomEdge;
         private Timer Timer;
         private int jumpFrames; //stores how fast and at what position Mr. May should be jumping at
   public Movableactor()
   {
    walkright= null;
    walkleft= null;
    idle = null; 
    currentaction = "idle";
    fallright = null;
    fallleft = null;
    wasAction = "fallleft";
    Timer = new Timer();
    jumpFrames = 0; ///adaadadawd CHANGED LINE
  }
  public void update()
  { super.update();
     Keyboard kb = getKeyboard();
    jump();//check to see if mr may should be jumping
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
         leftEdge = w / 2;
         topEdge = h / 2;
         rightEdge = 800 - w / 2;
         bottomEdge = 600 - h / 2 - 28;
        String press = null;
        //press = null+ kb;
        if(currentaction == null)
        {
            setAnimation(idle);
        }
        
        String newaction = null;
  
     
      
       /* if(kb.isKeyPressed("down") && y < bottomEdge)
        {
            move(7, "South");
        }
      */if(isBlocked())move(5,"West");
          if(kb.isKeyPressed("left") && isGrounded()) //if MR MAY is on the ground and the player wants to go left
        {
             newaction = "walkl"; //set the animation to left
             move(5,"West"); //move left
        }
        else if(kb.isKeyPressed("right") && isGrounded()) // if mr may is on the ground and the player wants to go right
        {
           newaction = "walkr"; //set the animation to right
           if(!isBlocked()) move(3,"East"); //move slower if in the air (better gameplay)
           else move(8,"East"); //move faster if on the ground
         }   
        
        // this is where the error is probably is
        else if(isFalling()  )
            {
                newaction = "fallleft"; //set the animation to fall
                
            }
          //if(isFalling() && wasCurrentAction("fallright") )
           // {
               //  newaction = "fallright";
           // }
            else
            newaction = "idle";
             if(kb.isKeyPressed("up")&&this.isBlocked())
        {
            newaction = "idle";
            jumpFrames=80; ///a/dada=adadCHANGED LINE
        }
        
        if( newaction!= null && !(newaction.equals(currentaction))) //if there is a newaction waiting to change the animation frames
        {
           if(newaction.equals("idle"))
           {
            setAnimation(walkleft);
            currentaction = "idle";
           }
           if (newaction.equals("walkr"))
           { 
            setAnimation(walkright);
            currentaction = newaction;
           }
           if (newaction.equals("walkl"))
           { 
            setAnimation(idle); 
            currentaction = newaction;
           }
           if(newaction.equals("fallleft"))
           {
            setAnimation(fallleft);
            currentaction = "fallleft";
           }
           if(newaction.equals("fallright"))
           {
            setAnimation(fallright);
            currentaction = "fallright";
           }
        }
    wasAction = currentaction;
  }
  public void setWalkRightAni(Animation ani)
  {
      walkright = ani;
     
  }
  public void setIdleAni(Animation ani)
  {
    idle = ani;
  }
  public void setWalkLeftAni(Animation ani)
  {  
      walkleft = ani;
     
  }
  public void setFalls(Animation l,Animation r)
  {  
      fallright = r;
      fallleft = l;
  }
  public String getCurrentAction()
  {
    return currentaction;
  }
  public boolean isCurrentAction(String action) //check if a certain action matches what MR MAY is currently doing
  {
    if (currentaction.equals(action))
    return true;
    else 
    return false;
    
  }
  public boolean wasCurrentAction(String action)//check if a certain action matches what MR MAY was currently doing
  {
    if (wasAction.equals(action))
    return true;
    else 
    return false;
  }
  public boolean isFalling()//check if mr may is falling
  { 
    boolean ret = false;
    move(1, "South"); //move 1 up, it shouldn't be touching the ground now
    if (!isBlocked()) //if it's still touching a block then that means that the block is to the right or left, not the ground
    ret= true;
    move(1, "North");//move it back down so as not to change the position
    return ret;
    
  }
  public boolean isGrounded()
  {
      if(isBlocked())
      {
          move(1,"North");//move 1 up, it shouldn't be touching the ground now
          if(isBlocked()) return false;//if it's still touching a block then that means that the block is to the right or left, not the ground
          move(1,"South");//move it back down so as not to change the position
       }
       return true;
  }
  public void jump()//simulates a rough parabola for jumping
  {
      if(jumpFrames>=60) //if low jump really fast
      {
          move(9,"North");
          jumpFrames--;
      }
      else if(jumpFrames>=45)//if medium slow down
      {
          move(8,"North");
          jumpFrames--;
      }
      else if(jumpFrames>=40)//nearing the peak, slow down, almost 0 gravity
      {
          move(7,"North");
          jumpFrames--;
      }
      else if(jumpFrames>=35)//now move down very slowly, still zero gravity-esque
      {
          move(3,"North");
          jumpFrames--;
      }
      else if(jumpFrames>=20)//speed up
      {
          move(2,"North");
          jumpFrames--;
      }
      else if(jumpFrames>0)//move at terminal velocity until you hit the ground and complete the jump
      {
          move(1,"North");
          jumpFrames--;
      }
  }
  public boolean isJumping() //checks if mr may is currently jumping
  {
      if(jumpFrames>0) return true;
      return false;
  }
}
