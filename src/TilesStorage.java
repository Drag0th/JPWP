import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TilesStorage {
Tile[] Tile;
    public TilesStorage(){
        Tile = new Tile[49];
        getTileImage();
    }

    public void getTileImage(){
        try{
            //Wooden Floor -> 0
            Tile[0] = new Tile();
            Tile[0].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Wooden_Floor.png"));
            Tile[0].collision = false;
            //Brick Wall -> 1
            Tile[1] = new Tile();
            Tile[1].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Brick_Wall.png"));
            Tile[1].collision = true;
            //Wooden Door 1 -> 2
            Tile[2] = new Tile();
            Tile[2].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Door_1.png"));
            Tile[2].collision = false;
            //Wooden Door 2 -> 3
            Tile[3] = new Tile();
            Tile[3].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Door_2.png"));
            Tile[3].collision = false;
            //Grass -> 4
            Tile[4] = new Tile();
            Tile[4].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Grass.png"));
            Tile[4].collision = false;
            //Glass Window -> 5
            Tile[5] = new Tile();
            Tile[5].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Glass_Window.png"));
            Tile[5].collision = true;
            //Fence on grass -> 6
            Tile[6] = new Tile();
            Tile[6].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Grass_Fence.png"));
            Tile[6].collision = true;
            //Fence on grass 2 -> 7
            Tile[7] = new Tile();
            Tile[7].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Grass_Fence_2.png"));
            Tile[7].collision = true;
            //Fence on grass 3 -> 8
            Tile[8] = new Tile();
            Tile[8].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Grass_Fence_3.png"));
            Tile[8].collision = true;
            //Soil -> 9
            Tile[9] = new Tile();
            Tile[9].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Soil.png"));
            Tile[9].collision = false;
            //Bed 1/2 -> 10
            Tile[10] = new Tile();
            Tile[10].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Bed_Up.png"));
            Tile[10].collision = true;
            //Bed 2/2 -> 11
            Tile[11] = new Tile();
            Tile[11].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Bed_Down.png"));
            Tile[11].collision = true;
            //Wet Soil -> 12
            Tile[12] = new Tile();
            Tile[12].image = ImageIO.read(getClass().getResourceAsStream("res/titles/Wet_soil.png"));
            Tile[12].collision = false;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
