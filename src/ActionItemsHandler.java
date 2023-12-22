import javax.management.relation.InvalidRoleInfoException;
import java.awt.*;

public class ActionItemsHandler {

    Inventory Inventory;
    ItemList Item_List;
    GamePanel Game_Panel;
    MapStorageAndRender Map_Storage_And_Render;
    Player Player;
    GUI GUI;
    KeyHandler Key_Handler;
    Plants Plants;
    boolean button_pressed = false;

    public ActionItemsHandler(Inventory Inventory, ItemList Item_List, GamePanel Game_Panel, MapStorageAndRender Map_Storage_And_Render, Player Player, GUI GUI, KeyHandler Key_Handler, Plants Plants){
        this.Inventory = Inventory;
        this.Item_List = Item_List;
        this.Game_Panel = Game_Panel;
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Player = Player;
        this.GUI = GUI;
        this.Key_Handler = Key_Handler;
        this.Plants = Plants;
    }

    public void useItem(Graphics2D g2d){
        if(Key_Handler.e_pressed == true && button_pressed == false) {
            button_pressed = true;
            int item_id = 0;
            if (GUI.frames_state == 0) {
                item_id = Inventory.item_id_0;
            } else if (GUI.frames_state == 1) {
                item_id = Inventory.item_id_1;
            } else if (GUI.frames_state == 2) {
                item_id = Inventory.item_id_2;
            }

            if(item_id == 1 && Player.energy > 0){
                wateringCanUse(g2d);
            }
            if(item_id == 4 && Player.energy > 0){
                scytheUse(g2d);
            }
            if(item_id == 2 && Player.energy > 0){
                wheatSeedsUse(g2d);
            }
            if(item_id == 5 && Player.energy > 0){
                tomatoSeedsUse(g2d);
            }
            if(Item_List.Item[item_id].eatable == true && Player.energy < 100 && Item_List.Item[item_id].amount > 0 ){
                eatItem(item_id);
            }
            if(item_id == 7 && Player.energy > 0){
                cabbageSeedsUse(g2d);
            }

        }
        if(Key_Handler.e_pressed == false){
            button_pressed = false;
        }
    }

    public void wateringCanUse(Graphics2D g2d){
        Player.energy -= 10;
        if(Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 9){
            Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] = 12;
        }
    }
    public void scytheUse(Graphics2D g2d){
        Player.energy -= 10;
        if(Player.map_x >= 2 && Player.map_y >= 5) {
            if(Player.map_x < 5) {
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 4) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 0;
                    Item_List.Item[3].amount++;
                }
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 11) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 0;
                    Item_List.Item[6].amount = Item_List.Item[6].amount + 5;
                }
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 15) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 0;
                    Item_List.Item[8].amount = Item_List.Item[8].amount + 5;
                }
            }
            if(Player.map_x > 5 && Player.map_x < 10) {
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 4 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 0;
                    Item_List.Item[3].amount++;
                }
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 11 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 0;
                    Item_List.Item[6].amount = Item_List.Item[6].amount + 5;
                }
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 15 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 0;
                    Item_List.Item[8].amount = Item_List.Item[8].amount + 5;
                }
            }
            if(Player.map_x > 9 && Player.map_x < 14) {
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 4 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 0;
                    Item_List.Item[3].amount++;
                }
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 11 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 0;
                    Item_List.Item[6].amount = Item_List.Item[6].amount + 5;
                }
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 15 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 0;
                    Item_List.Item[8].amount = Item_List.Item[8].amount + 5;
                }
            }
        }
    }
    public void wheatSeedsUse(Graphics2D g2d){
        Player.energy -= 10;
        if(Player.map_x >= 2 && Player.map_y >= 5) {
            if(Player.map_x < 5) {
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 0) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 1;
                    Item_List.Item[2].amount--;
                }

            }
            if(Player.map_x > 5 && Player.map_x < 10) {
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 1;
                    Item_List.Item[2].amount--;
                }
            }
            if(Player.map_x > 9 && Player.map_x < 14) {
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 1;
                    Item_List.Item[2].amount--;
                }
            }
        }
    }
    public void tomatoSeedsUse(Graphics2D g2d){
        Player.energy -= 10;
        if(Player.map_x >= 2 && Player.map_y >= 5) {
            if(Player.map_x < 5) {
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 0) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 5;
                    Item_List.Item[5].amount--;
                }

            }
            if(Player.map_x > 5 && Player.map_x < 10) {
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 5;
                    Item_List.Item[5].amount--;
                }
            }
            if(Player.map_x > 9 && Player.map_x < 14) {
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 5;
                    Item_List.Item[5].amount--;
                }
            }
        }
    }
    public void eatItem(int item_id){
        Player.energy = Player.energy + Item_List.Item[item_id].energy_gain;
        Item_List.Item[item_id].amount--;
    }
    public void cabbageSeedsUse(Graphics2D g2d){
        Player.energy -= 10;
        if(Player.map_x >= 2 && Player.map_y >= 5) {
            if(Player.map_x < 5) {
                if (Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] == 0) {
                    Plants.farming_plot_0[Player.map_x - 2][Player.map_y - 5] = 12;
                    Item_List.Item[7].amount--;
                }

            }
            if(Player.map_x > 5 && Player.map_x < 10) {
                if (Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_1[Player.map_x - 6][Player.map_y - 5] = 12;
                    Item_List.Item[7].amount--;
                }
            }
            if(Player.map_x > 9 && Player.map_x < 14) {
                if (Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] == 0 ) {
                    Plants.farming_plot_2[Player.map_x - 10][Player.map_y - 5] = 12;
                    Item_List.Item[7].amount--;
                }
            }
        }
    }

}
