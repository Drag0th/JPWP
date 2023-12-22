import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class Cooking {
    GamePanel Game_Panel;
    Player Player;
    MapStorageAndRender Map_Storage_And_Render;
    KeyHandler Key_Handler;
    ItemList Item_List;
    BufferedImage[] Item_Frames;
    int  inventory_y = 0;
    boolean button_pressed = false;
    public Cooking(GamePanel Game_Panel, Player Player, MapStorageAndRender Map_Storage_And_Render, KeyHandler Key_Handler , ItemList Item_List){
        this.Game_Panel = Game_Panel;
        this.Player = Player;
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Key_Handler = Key_Handler;
        this.Item_List = Item_List;
        Item_Frames = new BufferedImage[2];
        getItemFrames();
    }

    public void getItemFrames(){
        try{
            Item_Frames[0] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/selected_item_frame.png"));
            Item_Frames[1] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/item_frame.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void stoveChecker(){
        if((Map_Storage_And_Render.Map[Game_Panel.map_number][Player.map_y][Player.map_x] == 13 ) && Key_Handler.e_pressed == true ){
            Game_Panel.game_state = Game_Panel.cooking_state;
        }
    }
    public void drawRecipeFrames(Graphics2D g2d){
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 96));
        g2d.setColor(Color.BLACK);
        int x = 100, y = 78;
        for(int j = 0 ; j < 3 ; j++) {
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            g2d.drawString("+", x + 80, y + 57);
            x = x + 168;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            g2d.drawString("+", x + 80, y + 57);
            x = x + 168;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            g2d.drawString("=", x + 80, y + 57);
            x = x + 168;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            x = 100;
            y = y + 120;
        }
        if(inventory_y == 0){
            g2d.drawImage(Item_Frames[0], 604, 78, 48, 48, null);
        }
        if(inventory_y == 1){
            g2d.drawImage(Item_Frames[0], 604, 198, 48, 48, null);
        }
        if(inventory_y == 2){
            g2d.drawImage(Item_Frames[0], 604, 318, 48, 48, null);
        }
    }
    public void stoveCursorHandler(){
        if((inventory_y >= 0) && (inventory_y < 2) && (button_pressed == false)) {
            if(Key_Handler.s_pressed == true){
                inventory_y++;
                button_pressed = true;
            }
        }
        if((inventory_y > 0) && (inventory_y <= 2) && (button_pressed == false) ) {
            if(Key_Handler.w_pressed == true){
                inventory_y--;
                button_pressed = true;
            }
        }
        if((inventory_y >= 0) && (inventory_y <= 2) && (button_pressed == false) ) {
            if(Key_Handler.enter_pressed == true){
                if(inventory_y == 0 && Item_List.Item[3].amount > 0 && (button_pressed == false)){
                    Item_List.Item[3].amount--;
                    Item_List.Item[11].amount++;

                }
                if(inventory_y == 1 && Item_List.Item[3].amount > 0 && Item_List.Item[6].amount > 0 && (button_pressed == false)){
                    Item_List.Item[3].amount--;
                    Item_List.Item[6].amount--;
                    Item_List.Item[10].amount++;
                }
                if(inventory_y == 2 && Item_List.Item[6].amount > 0 && Item_List.Item[8].amount > 0 && (button_pressed == false)){
                    Item_List.Item[6].amount--;
                    Item_List.Item[8].amount--;
                    Item_List.Item[9].amount++;
                }
                button_pressed = true;
            }
        }
        if(Key_Handler.w_pressed == false && Key_Handler.s_pressed == false && Key_Handler.enter_pressed == false ){
            button_pressed = false;
        }
    }
    public void drawRecipeItems(Graphics2D g2d) {
        g2d.drawImage(Item_List.Item[3].image, 100, 78, 48, 48, null);
        g2d.drawImage(Item_List.Item[0].image, 268, 78, 48, 48, null);
        g2d.drawImage(Item_List.Item[0].image, 436, 78, 48, 48, null);
        g2d.drawImage(Item_List.Item[11].image, 604, 78, 48, 48, null);
        //
        g2d.drawImage(Item_List.Item[3].image, 100, 198, 48, 48, null);
        g2d.drawImage(Item_List.Item[6].image, 268, 198, 48, 48, null);
        g2d.drawImage(Item_List.Item[0].image, 436, 198, 48, 48, null);
        g2d.drawImage(Item_List.Item[10].image, 604, 198, 48, 48, null);
        //
        g2d.drawImage(Item_List.Item[6].image, 100, 318, 48, 48, null);
        g2d.drawImage(Item_List.Item[8].image, 268, 318, 48, 48, null);
        g2d.drawImage(Item_List.Item[0].image, 436, 318, 48, 48, null);
        g2d.drawImage(Item_List.Item[9].image, 604, 318, 48, 48, null);
    }
}


