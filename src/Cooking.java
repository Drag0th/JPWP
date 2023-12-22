import java.security.Key;

public class Cooking {
    GamePanel Game_Panel;
    Player Player;
    MapStorageAndRender Map_Storage_And_Render;
    KeyHandler Key_Handler;
    ItemList Item_List;
    public Cooking(GamePanel Game_Panel, Player Player, MapStorageAndRender Map_Storage_And_Render, KeyHandler Key_Handler , ItemList Item_List){
        this.Game_Panel = Game_Panel;
        this.Player = Player;
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Key_Handler = Key_Handler;
        this.Item_List = Item_List;
    }

    public void stoveChecker(){
        if((Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 13 ) && Key_Handler.e_pressed == true ){
            Game_Panel.game_state = Game_Panel.cooking_state;
        }
    }
}
