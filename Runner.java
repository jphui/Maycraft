import mayflower.*;
public class Runner extends Mayflower
{
    private Sound music;
    public Runner()
    {
        super("Maycraft",1280,720,new TitleScreen());
        music = new Sound("snd/music.wav");
        music.play(); //play minecraft music
    }
    public static void main(String[]args)
    {
        new Runner();
    }
}