import java.awt.*;

public class MapStorageAndRender {

    GamePanel Game_Panel;
    TilesStorage Tiles_Storage;
    int[][][] Map;

    public MapStorageAndRender(GamePanel Game_Panel, TilesStorage Tiles_Storage){

        this.Tiles_Storage = Tiles_Storage;
        this.Game_Panel = Game_Panel;

        Map = new int[][][]{
         //Map 0
        {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}
         //Map 1
         ,{{1, 2, 3},
           {4, 5, 6}}};
    }

    public void draw(Graphics2D title){

    int x = 0, y = 0;

        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 16 ; j++){
                title.drawImage(Tiles_Storage.Tile[Map[Game_Panel.map_number][i][j]].image, x, y, 48, 48, null);
                x = x + 48;
            }
            x = 0;
            y = y + 48;
        }
    }

}
