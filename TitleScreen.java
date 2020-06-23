import mayflower.*;
public class TitleScreen extends Stage
{
    
    public TitleScreen()
    {
        setBackground("img/maycraftlogo" + (int)(Math.random()*4) + ".jpg"); //set background
        Button singleplayer = new Button("img/single.png","img/singlehovered.jpg",null, //adds the button for singleplayer
        "snd/click.wav",new Area1(),600,60); // button can be hovered and produces a sound when clicked
        addActor(singleplayer,640,343); //add the button to the screen
         
    }
    public void update()
    {
    }
}