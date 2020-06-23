import mayflower.*;
public class YouWinWorld extends Stage
{
    
    public YouWinWorld()
    {
        setBackground("img/youwin.jpg");
        Button titlescreen = new Button("img/titlescreen.jpg","img/titlescreenhovered.jpg",
         null,"snd/click.wav",new TitleScreen(),600,60);
        addActor(titlescreen,640,343); //add the button to the screen
         
    }
    public void update()
    {
    }
}