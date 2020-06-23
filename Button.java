import mayflower.*;
public class Button extends Actor
{
    private Picture regular; //default image of button
    private Picture hovered; //image that is set when mouse is on button
    private Picture clicked; //image that is set when button is clicked
    private Sound clickSound; //sound that is played when button is clicked
    private Stage newWorld; //world that is set when button is clicked
    private boolean wasHovered;
    public Button(String path, String hoveredPath, String clickedPath, //sets all the aforementioned variables
    String clickSnd,Stage worldSet, int xsize, int ysize)
    {
        regular = new Picture(path);
        hovered = new Picture(hoveredPath);
        regular.resize(xsize,ysize);
        hovered.resize(xsize,ysize);
        if(clickedPath != null)
        {
            clicked = new Picture(clickedPath);
            clicked.resize(xsize,ysize);
        }
        clickSound = new Sound(clickSnd);
        newWorld = worldSet;
        setPicture(path);
    }
    public void update()
    {
        if(isHovered() && !wasHovered) //if the button is hovered for the first time set button to blue hovered image
        {
            setPicture(hovered); wasHovered = true;
        }
        else setPicture(regular); wasHovered = false; //if the button is not hovered set picture to default
        if(isClicked()) // if button is clicked set image to clicked image
        {
            if(clicked!=null)setPicture(clicked);
            clickSound.play();
            if(newWorld!=null)getMayflower().setStage(newWorld);
        }
    }
    public boolean isHovered() //checks if the mouse is over the button
    {
        int x = 0,y = 0;
        if(getMouse()!=null)x = getMouse().getX(); //mouse's x coordinate
        if(getMouse()!=null)y = getMouse().getY(); //mouse's y coordinate
        if(isTouching(x,y)) return true; //if the button is making contact with the mouse's location
        return false;
    }
}