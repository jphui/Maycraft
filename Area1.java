import mayflower.*;
public class Area1 extends Area
{ private Cat cat;
  Text scoreText; 
  //Text scorelives;
  private Timer Timer;
  private Lives one;
  private Lives two;
  private Lives three;
  
  private Coin coin;
  
    public Area1()
    {
        super(100);//set the length of the world
        randomlyGenerateArea(1);
        setBackground("img/sky.jpg");//background image
        render();
        cat = new Cat();
          scoreText = new Text("Score: " + cat.returnscore()); //updates the score on screen to the score that the cat has
          //scorelives = new Text("Lives: " + cat.returnlives());
        addActor(cat, 100, 100);
        addActor(scoreText, 0, 0);
        //addActor(scorelives, 0, 25);
        Timer = new Timer();
        coin = new Coin();
        addActor(coin, 400, 400);
        one = new Lives();
        two = new Lives();
        three = new Lives();
        addActor(three, 20, 40); //add the first life to the screen
        addActor(two, 50, 40);//add the second life to the screen
        addActor(one,80,40);//add the third life to the screen
    }
    public void update()
    {
        try{
        render();
        if(Timer.hasTimePassed(100)) //every time .1 seconds passes add a point to the cat's score, 10 pts a second
        {   cat.increaseScore(1);
            this.removeActor(scoreText);//remove the old score
            scoreText = new Text("Score: " + cat.returnscore()); //update the score on screen
            addActor(scoreText, 0, 0);//add the new score
            Timer.reset(); 
        }
       this.Death(); //check if the cat is dead or has lost a life
       spawnMemeMan(); //spawn the herobrines
       }
       catch(IndexOutOfBoundsException i){} //catch the errors, doesn't really work
          if(cat.returnscore()>30000)getMayflower().setStage(new Area2()); //if the score is enough set the game to level 2
      
    }
    public void spawnMemeMan() //spawns Meme Man randomly, constantly
    {
        int edwin = (int)(Math.random()*175); //1 out of 150 chance to spawn during each iteration of the game loop
        int rx = (int)(Math.random()*1281); //random x coord
        if(edwin==69)
        {
            addActor(new Missile(cat),rx,0); //add a Herobrine to the sky if conditions are met
        }
    }
    public void Death()
    {
        //this.removeActor(scorelives);
        //scorelives = new Text("Lives: " + cat.returnlives());
        //addActor(scorelives, 0, 25);
        int life = cat.returnlives();
        if(life==0) three.lose();
        else if(life == 1) two.lose();
        else if(life ==2) one.lose();
        else if(life==3){one.gain();two.gain();three.gain();}
        if (cat.getY() > 720 ||cat.getX() < -50) //if cat is off screen
        {//this.removeActor(scorelives);
            cat.decreaselives(1); //-1 life
     
         
         this.removeActor(cat);//spawn the cat back at the top corner of the world
         addActor(cat, 50, 100);
        }
       if ( cat.returnlives() == 0) //if cat is dead
       {    
           this.removeActor(cat);//get rid of the cat
           getMayflower().setStage(new endScreen(cat.returnscore())); //set GAME OVER screen
       
       }
    
    }
}