public class DayCounter {

    GamePanel Game_Panel;
    GUI GUI;
    Player Player;
    MapStorageAndRender Map_Storage_And_Render;
    KeyHandler Key_Handler;
    public DayCounter(GamePanel Game_Panel, GUI GUI, Player Player, MapStorageAndRender Map_Storage_And_Render, KeyHandler Key_Handler){
        this.Game_Panel = Game_Panel;
        this.GUI = GUI;
        this.Player = Player;
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Key_Handler = Key_Handler;
    }

    public void bedChecker(){
        if((Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 10 || Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 11) && Key_Handler.e_pressed == true ){
            Game_Panel.game_state = 6;
            Game_Panel.day_number++;
            Player.x = 624;
            Player.y = 69;
            Player.energy = 100;
        }
    }

}
