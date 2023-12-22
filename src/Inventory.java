import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Inventory {
    int inventory_x = 0, inventory_y = 0, item_id_0, item_id_1, item_id_2;
    ItemList Item_List;
    Tile[] Tile;
    KeyHandler Key_Handler;
    GamePanel Game_Panel;
    int[][] inventory_background;
    int[][] inventory_grid;
    BufferedImage[] Item_Frames;
    boolean button_pressed = false;

    public Inventory(KeyHandler Key_Handler, GamePanel Game_Panel, ItemList Item_List){
        this.Item_List = Item_List;
        this.Key_Handler = Key_Handler;
        this.Game_Panel = Game_Panel;
        inventory_background = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8},
                {3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5}
        };
        inventory_grid = new int[][]{
                {1, 2, 4, 3},
                {5, 6, 7, 8},
                {0, 0, 0, 0},
        };
        Tile = new Tile[9];
        getInventoryImage();
        Item_Frames = new BufferedImage[2];
        getItemFrames();
    }

    public void getInventoryImage(){
        try{
            //Player_GUI
            Tile[0] = new Tile();
            Tile[0].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/top_left_corner.png"));
            Tile[1] = new Tile();
            Tile[1].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/top_mid.png"));
            Tile[2] = new Tile();
            Tile[2].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/top_right_corner.png"));
            Tile[3] = new Tile();
            Tile[3].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/bottom_left_corner.png"));
            Tile[4] = new Tile();
            Tile[4].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/bottom_mid.png"));
            Tile[5] = new Tile();
            Tile[5].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/bottom_right_corner.png"));
            Tile[6] = new Tile();
            Tile[6].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/gui_background.png"));
            Tile[7] = new Tile();
            Tile[7].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/gui_left.png"));
            Tile[8] = new Tile();
            Tile[8].image = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Background/gui_right.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void getItemFrames(){
        try{
            Item_Frames[0] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/selected_item_frame.png"));
            Item_Frames[1] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/item_frame.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void drawPlayerInventoryBackground(Graphics2D g2d){
        int x = 0, y = 0;

        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 16 ; j++){
                g2d.drawImage(Tile[inventory_background[i][j]].image, x, y, 48, 48, null);
                x = x + 48;
            }
            x = 0;
            y = y + 48;
        }
    }
    public void drawPlayerInventoryCursor(Graphics2D g2d){
        g2d.drawImage(Item_Frames[0], 168*inventory_x+100, 120*inventory_y+78, 48, 48, null);
    }

    

    public void drawInventorySlots(Graphics2D g2d){
        int x = 100, y = 78;
        for(int j = 0 ; j < 3 ; j++) {
            for (int i = 0; i < 4; i++) {
                g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
                x = x + 168;
            }
            x = 100;
            y = y + 120;
        }
    }

    public void inventoryChecker(){
        if(Key_Handler.i_pressed == true){
            Game_Panel.game_state = Game_Panel.player_inventory_state;
        }
    }

    public void inventoryCursorUpdate(){
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
        if((inventory_x >= 0) && (inventory_x < 3) && (button_pressed == false)) {
            if(Key_Handler.d_pressed == true){
                inventory_x++;
                button_pressed = true;
            }
        }
        if((inventory_x > 0) && (inventory_x <= 3) && (button_pressed == false) ) {
            if(Key_Handler.a_pressed == true){
                inventory_x--;
                button_pressed = true;
            }
        }
        if(Key_Handler.a_pressed == false && Key_Handler.d_pressed == false && Key_Handler.w_pressed == false && Key_Handler.s_pressed == false){
            button_pressed = false;
        }
    }

    public void drawInventoryItems(Graphics2D g2d){
        int x = 100, y = 78;
        for(int j = 0 ; j < 3 ; j++) {
            for (int i = 0; i < 4; i++) {
                g2d.drawImage(Item_List.Item[inventory_grid[j][i]].image, x, y, 48, 48, null);
                    int a = x+18;
                    int b = y+58;
                    g2d.setFont(new Font("Item_amount", Font.BOLD, 12));
                    g2d.setColor(Color.BLACK);
                g2d.drawString(String.valueOf(Item_List.Item[inventory_grid[j][i]].amount), a, b);
                x = x + 168;
            }
            x = 100;
            y = y + 120;
        }
    }

    public void  assignItemToBelt(){
        if(Key_Handler.one_pressed == true){
            item_id_0 = inventory_grid[inventory_y][inventory_x];
        }
        if(Key_Handler.two_pressed == true){
            item_id_1 = inventory_grid[inventory_y][inventory_x];
        }
        if(Key_Handler.three_pressed == true){
            item_id_2 = inventory_grid[inventory_y][inventory_x];
        }
    }

    public void drawItemOnBelt(Graphics2D g2d){
        int x = 248, y = 504;
        g2d.drawImage(Item_List.Item[item_id_0].image, x, y, 48, 48, null);
        x = x + 70;
        g2d.drawImage(Item_List.Item[item_id_1].image, x, y, 48, 48, null);
        x = x + 70;
        g2d.drawImage(Item_List.Item[item_id_2].image, x, y, 48, 48, null);
    }

    public void drawInvetory(Graphics2D g2d){
        drawPlayerInventoryBackground(g2d);
        drawInventorySlots(g2d);
        drawPlayerInventoryCursor(g2d);
        drawInventoryItems(g2d);
    }

    public void updateInvetory(){
        inventoryCursorUpdate();
        assignItemToBelt();
    }
}
