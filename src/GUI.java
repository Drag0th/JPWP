import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Klasa odpowiedzialna za wyswietlanie GUI.
 */
public class GUI {
    int frames_state = 0;
    GamePanel Game_Panel;
    int[][] gui_background;
    Tile[] Tile;
    BufferedImage[] Energy_Bar;
    BufferedImage[] Item_Frames;
    Player Player;
    KeyHandler Key_Handler;

    /**
     * Konstruktor
     * @param Game_Panel obiekt
     * @param Player obiekt
     * @param Key_Handler obiekt
     */
    public GUI(GamePanel Game_Panel, Player Player, KeyHandler Key_Handler){
        this.Key_Handler = Key_Handler;
        this.Game_Panel = Game_Panel;
        this.Player = Player;
        gui_background = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
        };
        Tile = new Tile[6];
        getGUIImage();
        Energy_Bar = new BufferedImage[22];
        getEnergyBarImage();
        Item_Frames = new BufferedImage[2];
        getItemFrames();

    }

    /**
     * Metoda pobierajaca grafike
     */
    public void getGUIImage(){
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
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda pobierajaca grafike paska energii
     */
    public void getEnergyBarImage(){
        try{
            Energy_Bar[0] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/0.png"));
            Energy_Bar[1] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/1.png"));
            Energy_Bar[2] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/2.png"));
            Energy_Bar[3] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/3.png"));
            Energy_Bar[4] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/4.png"));
            Energy_Bar[5] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/5.png"));
            Energy_Bar[6] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/6.png"));
            Energy_Bar[7] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/7.png"));
            Energy_Bar[8] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/8.png"));
            Energy_Bar[9] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/9.png"));
            Energy_Bar[10] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/00.png"));
            Energy_Bar[11] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/01.png"));
            Energy_Bar[12] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/02.png"));
            Energy_Bar[13] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/03.png"));
            Energy_Bar[14] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/04.png"));
            Energy_Bar[15] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/05.png"));
            Energy_Bar[16] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/06.png"));
            Energy_Bar[17] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/07.png"));
            Energy_Bar[18] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/08.png"));
            Energy_Bar[19] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/09.png"));
            Energy_Bar[20] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/010.png"));
            Energy_Bar[21] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Energy_Bar/011.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda pobierajaca grafike ramek
     */
    public void getItemFrames(){
        try{
            Item_Frames[0] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/selected_item_frame.png"));
            Item_Frames[1] = ImageIO.read(getClass().getResourceAsStream("res/Player_GUI/Item_Frame/item_frame.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda wyswietlajaca menu_0
     * @param g2d obiekt
     */
    public void drawMainMenu_0(Graphics2D g2d){
        //Background
        g2d.setColor(new Color(0,71,171));
        g2d.fillRect(0,0, Game_Panel.screen_width, Game_Panel.screen_height);
        //Title
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 96));
        int x = 220;
        int y = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawString("FARMA", x, y);
        //Options
        Font Bold = new Font("Bold", Font.BOLD, 60);
        //
        g2d.setFont(Bold);
        x = 290;
        y = 220;
        g2d.setColor(Color.RED);
        g2d.drawString(">Start", x, y);
        //
        g2d.setFont(Bold);
        x = 320;
        y = 320;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Dane", x, y);
        //
        g2d.setFont(Bold);
        x = 310;
        y = 420;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Wyjdz", x, y);
    }

    /**
     * Metoda wyswiietlajaca menu_1
     * @param g2d obiekt
     */
    public void drawMainMenu_1(Graphics2D g2d){
        //Background
        g2d.setColor(new Color(0,71,171));
        g2d.fillRect(0,0, Game_Panel.screen_width, Game_Panel.screen_height);
        //Title
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 96));
        int x = 220;
        int y = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawString("FARMA", x, y);
        //Options
        Font Bold = new Font("Bold", Font.BOLD, 60);
        //
        g2d.setFont(Bold);
        x = 320;
        y = 220;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Start", x, y);
        //
        g2d.setFont(Bold);
        x = 290;
        y = 320;
        g2d.setColor(Color.RED);
        g2d.drawString(">Dane", x, y);
        //
        g2d.setFont(Bold);
        x = 310;
        y = 420;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Wyjdz", x, y);
    }

    /**
     * Metoda wyswieitlajaca menu_2
     * @param g2d obiekt
     */
    public void drawMainMenu_2(Graphics2D g2d){
        //Background
        g2d.setColor(new Color(0,71,171));
        g2d.fillRect(0,0, Game_Panel.screen_width, Game_Panel.screen_height);
        //Title
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 96));
        int x = 220;
        int y = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawString("FARMA", x, y);
        //Options
        Font Bold = new Font("Bold", Font.BOLD, 60);
        //
        g2d.setFont(Bold);
        x = 320;
        y = 220;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Start", x, y);
        //
        g2d.setFont(Bold);
        x = 320;
        y = 320;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Dane", x, y);
        //
        g2d.setFont(Bold);
        x = 280;
        y = 420;
        g2d.setColor(Color.RED);
        g2d.drawString(">Wyjdz", x, y);
    }

    /**
     * Metoda wyswietlajaca odpowiednie menu
     * @param g2d obiekt
     */
    public void drawMainMenu(Graphics2D g2d){
        if(Game_Panel.game_state == 0)
            drawMainMenu_0(g2d);
        if(Game_Panel.game_state == 1)
            drawMainMenu_1(g2d);
        if(Game_Panel.game_state == 2)
            drawMainMenu_2(g2d);
    }

    /**
     * Metoda rysujaca tlo GUI
     * @param g2d obiekt
     */
    public void drawPlayerGUIBackground(Graphics2D g2d){
        int x = 0, y = 480;

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 16 ; j++){
                g2d.drawImage(Tile[gui_background[i][j]].image, x, y, 48, 48, null);
                x = x + 48;
            }
            x = 0;
            y = y + 48;
        }
    }

    /**
     * Metoda rysujaca pasek energii
     * @param g2d obiekt
     */
    public void drawPlayerEnergyBar(Graphics2D g2d){
        int x = 48, y = 504;
        if(Player.energy == 100){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[21], x, y, 48, 48, null);
        }
        if(Player.energy == 95){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[20], x, y, 48, 48, null);
        }
        if(Player.energy == 90){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[18], x, y, 48, 48, null);
        }
        if(Player.energy == 85){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[17], x, y, 48, 48, null);
        }
        if(Player.energy == 80){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[16], x, y, 48, 48, null);
        }
        if(Player.energy == 75){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[15], x, y, 48, 48, null);
        }
        if(Player.energy == 70){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[14], x, y, 48, 48, null);
        }
        if(Player.energy == 65){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[13], x, y, 48, 48, null);
        }
        if(Player.energy == 60){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[12], x, y, 48, 48, null);
        }
        if(Player.energy == 55){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[11], x, y, 48, 48, null);
        }
        if(Player.energy == 50){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 45){
            g2d.drawImage(Energy_Bar[9], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 40){
            g2d.drawImage(Energy_Bar[8], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 35){
            g2d.drawImage(Energy_Bar[7], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 30){
            g2d.drawImage(Energy_Bar[6], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 25){
            g2d.drawImage(Energy_Bar[5], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 20){
            g2d.drawImage(Energy_Bar[4], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 15){
            g2d.drawImage(Energy_Bar[3], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 10){
            g2d.drawImage(Energy_Bar[2], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 5){
            g2d.drawImage(Energy_Bar[1], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }
        if(Player.energy == 0){
            g2d.drawImage(Energy_Bar[2], x, y, 48, 48, null);
            x= x + 48;
            g2d.drawImage(Energy_Bar[10], x, y, 48, 48, null);
        }

    }

    /**
     * Metoda wyswietlajaca ramki na przedmioty
     * @param g2d obiekt
     */
    public void drwaPlayerItemFrames(Graphics2D g2d) {

        if(Key_Handler.one_pressed == true){
            frames_state = 0;
        } else if (Key_Handler.two_pressed == true) {
            frames_state = 1;
        } else if (Key_Handler.three_pressed == true) {
            frames_state = 2;
        }

        if (frames_state == 0) {
            int x = 248, y = 504;
            g2d.drawImage(Item_Frames[0], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
        }
        if (frames_state == 1) {
            int x = 248, y = 504;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[0], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
        }
        if (frames_state == 2) {
            int x = 248, y = 504;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[1], x, y, 48, 48, null);
            x = x + 70;
            g2d.drawImage(Item_Frames[0], x, y, 48, 48, null);
        }
    }

    /**
     * Metoda zbiorcza rozpoczyna inne metody
     * @param g2d obiekt
     */
    public void drawPlayerGUI(Graphics2D g2d){
        drawPlayerGUIBackground(g2d);
        drawPlayerEnergyBar(g2d);
        drwaPlayerItemFrames(g2d);
    }

    /**
     * Metoda wyswietlajaca menu snu
     * @param g2d obiekt
     */
    public void drawSleepMenu(Graphics2D g2d){
        //Background
        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0,0, Game_Panel.screen_width, Game_Panel.screen_height);
        //Title
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 96));
        int x = 220;
        int y = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Dzień: " + Game_Panel.day_number, x, y);
        x = 105;
        y = 220;
        g2d.drawString("Zakończono", x, y);
        //Options
        Font Bold = new Font("Bold", Font.BOLD, 60);
        //
        g2d.setFont(Bold);
        x = 225;
        y = 320;
        g2d.setColor(Color.RED);
        g2d.drawString(">Kontynuuj", x, y);
    }

    /**
     * Metoda rysujaca dane
     * @param g2d obiekt
     */
    public void drawDataMenu(Graphics2D g2d){
        //Background
        g2d.setColor(new Color(0,71,171));
        g2d.fillRect(0,0, Game_Panel.screen_width, Game_Panel.screen_height);
        //Title
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 60));
        int x = 160;
        int y = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Ilosc zjedzonych:", x, y);
        //Options
        Font Bold = new Font("Bold", Font.BOLD, 60);
        //
        g2d.setFont(Bold);
        x = 225;
        y = 520;
        g2d.setColor(Color.RED);
        g2d.drawString(">Kontynuuj", x, y);
    }

}
