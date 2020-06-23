import mayflower.*;

public class endScreen extends Stage
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class endScreen
     */
    public endScreen(int finalScore)
    {
        Picture p = new Picture("img/maxresdefault.jpg");
           p.resize(1280,720);
           setBackground(p);
         Button respawn = new Button("img/respawn.png","img/respawnHovered.jpg",null,
         "snd/click.wav",new Area1(),600,60);
         Button titlescreen = new Button("img/titlescreen.jpg","img/titlescreenhovered.jpg",
         null,"snd/click.wav",new TitleScreen(),600,60);
         addActor(respawn,641,418);
         addActor(titlescreen,641,480);
         Text scoreText = new Text("" + finalScore, java.awt.Color.WHITE);
         addActor(scoreText, 685, 282);
    }
    public void update()
    {
    }

    
}
