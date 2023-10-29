import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TilesStorage {

    BufferedImage[] Tile;

    public TilesStorage(){
        Tile = new BufferedImage[49];
        getTileImage();
    }

    public void getTileImage(){
        try{
            //Wooden Floor -> 0
            Tile[0] = ImageIO.read(getClass().getResourceAsStream("res/titles/Wooden_Floor.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
