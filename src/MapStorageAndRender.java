import java.awt.*;

/**
 * Klasa odpowiedzialna za wyswietlanie i przetrzymywanie map
 */
public class MapStorageAndRender {

    GamePanel Game_Panel;
    TilesStorage Tiles_Storage;
    int[][][] Map;

    /**
     * Konsturktor
     * @param Game_Panel obiekt
     * @param Tiles_Storage obiekt
     */
    public MapStorageAndRender(GamePanel Game_Panel, TilesStorage Tiles_Storage){

        this.Tiles_Storage = Tiles_Storage;
        this.Game_Panel = Game_Panel;

        Map = new int[][][]{
         //Map 0
        {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 1, 0, 0, 10, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 11, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
         {1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1}}
         //Map 1
         ,{{6, 6, 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 6},
           {7, 4, 1, 1, 5, 5, 1, 4, 4, 4, 4, 4, 4, 4, 4, 8},
           {7, 4, 1, 3, 2, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 8},
           {7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8},
           {7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8},
           {7, 4, 9, 9, 9, 4, 9, 9, 9, 4, 9, 9, 9, 4, 4, 8},
           {7, 4, 9, 9, 9, 4, 9, 9, 9, 4, 9, 9, 9, 4, 4, 8},
           {7, 4, 9, 9, 9, 4, 9, 9, 9, 4, 9, 9, 9, 4, 4, 8},
           {7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8},
           {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}}};
    }

    /**
     * Metoda odpowiedzialna za rysowanie mapy
     * @param title obiekt
     */
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
