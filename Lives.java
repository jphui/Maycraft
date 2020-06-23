import mayflower.*;
public class Lives extends Actor
{
    Picture heart; //red heart
    Picture noheart; //black heart
    boolean wasFull; //was the heart red before
    public Lives()
    {
        heart = new Picture("img/heart.png"); //sets picture of red heart
        noheart = new Picture("img/noheart.png"); //sets picture of black heart
        heart.resize(25,25);
        noheart.resize(25,25);
        setPicture(heart); //sets the picture to red since it is full by default
    }
    public void update()
    {
    }
    public void lose()
    {
        setPicture(noheart); //if this method is called make the heart empty or black
        wasFull=false;
    }
    public void gain()
    {
        if(!wasFull)
        setPicture(heart); //if this method is called make the heart full or red
        wasFull = true;
    }
}