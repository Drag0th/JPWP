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
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
