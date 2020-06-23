import mayflower.*;

public class GravityActor extends Actor 
{
    private boolean landed;
    int bottomEdge;
    int rightEdge;
    public GravityActor() 
    {
        landed = false;
        
    }
    
    public void update ()
    {
        int h = getHeight();
        int w = getWidth();
        rightEdge = this.getX() + 25 ;
          bottomEdge = this.getY() + 25  ;
            if(!this.isBlocked())
            move(5, "South");
            else if(this.isFloor())
            move(1, "North");
            
    
    }
    public boolean isBlocked()
    {
        Actor[]  actors= getTouching();
           for (Actor a: actors)
           {   
               if(a instanceof Block)
               {  if(a.getX() - 64 == this.getX())
                 this.move(7,"West");
                 landed= true;
                 return true;
                
               }
            
            }
            return false;
            
    
    }
       public boolean isFloor()//checks if player is touching floor
    {
        Actor[]  actors= getTouching();
           for (Actor a: actors)
           {
               
               if(a instanceof Block && this.getBottom() == a. getY() -64)
               {
                 return true;
               }
            
            }
            return false;
    
    }
    public boolean isSide()//checks if player is touching side of block
    { 
        Actor[]  actors= getTouching();
           for (Actor a: actors)
           {
               if(a instanceof Block )
               { if(!this.isFloor() && this.getRight() == a.getX()- 64)
                 return true;
               }
            
            }
            return false;
    
    }
    public int getBottom()
  {
    return bottomEdge;
  }
   public int getRight()
  {
    return rightEdge;
  }
}
