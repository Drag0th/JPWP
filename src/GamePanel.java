import javax.swing.*;
import java.awt.*;
import java.security.Key;

public class GamePanel extends JPanel implements Runnable {
    // Rozdzielczosc gry
    final int screen_width = 768;
    final int screen_height = 576;
    //Stan gry
    int game_state;
    final int main_menu_state = 3;
    final int gameplay_state = 4;
    final int data_state = 5;
    final int day_summary_state = 6;
    final int player_inventory_state = 7;
    //Mapa
    int map_number;
    int day_number;

    Thread Game_Thread;
    KeyHandler Key_Handler = new KeyHandler(this);
    TilesStorage Tiles_Storage = new TilesStorage();
    MapStorageAndRender Map_Storage_And_Render = new MapStorageAndRender(this, Tiles_Storage);
    Player Player = new Player(this, Key_Handler, Map_Storage_And_Render, Tiles_Storage);
    MapChange Map_Change = new MapChange(Map_Storage_And_Render, Player, this);
    ItemList Item_List = new ItemList();
    Inventory Inventory = new Inventory(Key_Handler, this, Item_List);
    GUI GUI = new GUI(this, Player, Key_Handler);
    DayCounter Day_Counter = new DayCounter(this, GUI, Player, Map_Storage_And_Render, Key_Handler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.addKeyListener(Key_Handler);
        this.setFocusable(true);
        this.setupGame();
    }
    public void startGameThread(){
        Game_Thread = new Thread(this);
        Game_Thread.start();
    }

    public void setupGame(){
        game_state = 0;
        map_number = 0;
    }

    @Override
    public void run() {

        double draw_interval = 1000000000/60;
        double delta = 0;
        long last_time = System.nanoTime();
        long current_time;

        while(Game_Thread != null){

            current_time = System.nanoTime();
            delta += (current_time - last_time) / draw_interval;
            last_time = current_time;

            if(delta >= 1) {
                Update();
                repaint();
                delta--;
            }

        }

    }

    public void Update(){
        if(game_state == gameplay_state){
            Player.update();
            Map_Change.mapChangeCheck();
            Day_Counter.bedChecker();
            Inventory.inventoryChecker();
        }
        if(game_state == player_inventory_state){
            Inventory.updateInvetory();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Main Menu
        if(game_state < main_menu_state) {
            GUI.drawMainMenu(g2d);
        }
        if(game_state == gameplay_state){
            Map_Storage_And_Render.draw(g2d);
            GUI.drawPlayerGUI(g2d);
            Player.draw(g2d);
            Inventory.drawItemOnBelt(g2d);
        }
        if(game_state == day_summary_state){
            GUI.drawSleepMenu(g2d);
        }
        if(game_state == player_inventory_state){
            Inventory.drawPlayerInventoryBackground(g2d);
            Inventory.drawInventorySlots(g2d);
            GUI.drawPlayerGUI(g2d);
            Inventory.drawInvetory(g2d);
            Inventory.drawItemOnBelt(g2d);
        }
    }

}