import mayflower.*;
public class Block extends Actor
{
    private Picture blockImg;
     private Timer Timer;
     private int count;
     private String path;
     private int typ;
    public Block(String imgPath,int type)
    {
        path = imgPath;
        blockImg = new Picture(imgPath);
        blockImg.resize(128,128);
        setPicture(blockImg);
        Timer = new Timer();
        count = 0;
        typ = type;
    }
    public void update()
    {
        if(count==1) spawnSword();
       if(Timer.hasTimePassed(1000))
       move(5,"West");
       if(getX()<=-128)
       {
       move(12800,"East");
               spawnSword();
       }
       count++;
    }
      public void spawnSword()
    { boolean bottom = false;
        Block b;
        int rand =0;
        for(Actor a : getTouching())
        {
            if(a instanceof Block)
            {
                b = (Block)a;
                if(b.getPath().equals("img/grassBlock.jpg")) {bottom = true;System.out.println("bot");}
            }
        }
        if(getY()<575||!bottom)
        {
        if(typ==1)rand = (int)(Math.random()*30); //1 out of 30 chance
        else if(typ==2)rand = (int)(Math.random()*25); //1 out of 25 chance
        else if(typ==3)rand = (int)(Math.random()*20); //1 out of 20 chance
        if(rand==15) if(getStage()!=null)getStage().addActor(new Sword(),getX()+45,getY()-75);
    }
    }
    public String getPath()
    {
        return path;
    }
}