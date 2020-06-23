import mayflower.*;
public class Area extends Stage //template class for all the different stages
{  
    private Block[][] blocks;//the world map
    private int length;
    public Area(int ln)
    {
        blocks = new Block[5][ln];//map is 5*100 blocks
        length = ln;
    }
    public void update()
    {
    }
    public Block[][] getBlocks()//get the 2d array
    {
        return blocks;
    }
    public void setBlock(int r, int c, Block b)//set this block into this spot in the 2d array
    {
        blocks[r][c] = b;
    }
    public void randomlyGenerateArea(int type)//creates each block inside the 2d array
    {
        
        for(int i = 0; i<blocks[4].length; i++) //generate row 5 (bottom)(index 4)
        {
            int ra = (int)(Math.random()*10);
            if((ra>2)&&type==1) setBlock(4,i,new Block("img/stone.jpg",1));
            if((ra>2)&&type==2) setBlock(4,i,new Block("img/netherrack.jpg",2));
            if((ra>2)&&type==3) setBlock(4,i,new Block("img/endstone.jpg",3));
        }
        for(int i = 0; i<blocks[3].length; i++)//generate row 4 (one above bottom)(index 3)
        {
            int ra = (int)(Math.random()*10);
            if(ra>3 && i!=0 && blocks[4][i-1]!=null&&type==1) setBlock(3,i,new Block("img/grassBlock.jpg",1)); //make sure that there are not unjumpable stacks of 2 blocks, entire world is traversable
             if(ra>3 && i!=0 && blocks[4][i-1]!=null&&type==2) setBlock(3,i,new Block("img/soulsand.png",2)); //make sure that there are not unjumpable stacks of 2 blocks, entire world is traversable
        if(ra>3 && i!=0 && blocks[4][i-1]!=null&&type==3) setBlock(3,i,new Block("img/endstone.jpg",3));
            }
    }

  
    public void render()//adds each block to the world
    {
        for(int r = 0; r<blocks.length; r++)
        {
            for(int c = 0; c<blocks[0].length; c++)
            {
                Block b = blocks[r][c]; //get block
                if(blocks[r][c]!=null && r==4) addActor(blocks[r][c], c*128,(r*144)+70);//add blocks to bottom row
                else if(blocks[r][c]!=null) addActor(blocks[r][c], c*128,(r*144)+87);//add blocks to one before bottom row
            }
        }
    }
}