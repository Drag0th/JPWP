public class MapChange {

    MapStorageAndRender Map_Storage_And_Render;
    Player Player;
    GamePanel Game_Panel;

    public MapChange(MapStorageAndRender Map_Storage_And_Render, Player Player, GamePanel Game_Panel){
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Player = Player;
        this.Game_Panel = Game_Panel;
    }

    public void mapChangeCheck() {
        if (Game_Panel.game_state == Game_Panel.gameplay_state) {
            if (Game_Panel.map_number == 0) {
                if (Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 2 || Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 3){
                    Game_Panel.map_number = 1;
                    Player.x = 170;
                    Player.y = 140;
                }
            }
            if (Game_Panel.map_number == 1) {
                if (Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 2 || Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 3){
                    Game_Panel.map_number = 0;
                    Player.x = 370;
                    Player.y = 380;
                }
            }
        }
    }

}
