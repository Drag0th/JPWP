import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean w_pressed;
    public static boolean s_pressed;
    public static boolean a_pressed;
    public static boolean d_pressed;
    public static boolean one_pressed;
    public static boolean two_pressed;
    public static boolean three_pressed;
    public static boolean e_pressed;
    public static boolean i_pressed;
    public static boolean enter_pressed;

    GamePanel Game_Panel;

    public KeyHandler(GamePanel Game_Panel){
        this.Game_Panel = Game_Panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key_check = e.getKeyCode();

        //Main Menu

        if(Game_Panel.game_state < Game_Panel.main_menu_state) {
            if (key_check == KeyEvent.VK_W) {
                if (Game_Panel.game_state > 0)
                    Game_Panel.game_state--;
                else
                    Game_Panel.game_state = 2;
            }
            if (key_check == KeyEvent.VK_S) {
                if (Game_Panel.game_state < 2)
                    Game_Panel.game_state++;
                else
                    Game_Panel.game_state = 0;
            }
            if(key_check == KeyEvent.VK_ENTER){
                if(Game_Panel.game_state == 0){
                    Game_Panel.game_state = Game_Panel.gameplay_state;
                }
                if(Game_Panel.game_state == 1){
                    Game_Panel.game_state = Game_Panel.data_state;
                }
                if(Game_Panel.game_state == 2){
                    System.exit(0);
                }

            }
        }

        if(Game_Panel.game_state == Game_Panel.gameplay_state){
            if(key_check == KeyEvent.VK_W){
                w_pressed = true;
            }
            if(key_check == KeyEvent.VK_S){
                s_pressed = true;
            }
            if(key_check == KeyEvent.VK_A){
                a_pressed = true;
            }
            if(key_check == KeyEvent.VK_D){
                d_pressed = true;
            }
            if(key_check == KeyEvent.VK_1){
                one_pressed = true;
            }
            if(key_check == KeyEvent.VK_2){
                two_pressed = true;
            }
            if(key_check == KeyEvent.VK_3){
                three_pressed = true;
            }
            if(key_check == KeyEvent.VK_E){
                e_pressed = true;
            }
            if(key_check == KeyEvent.VK_I){
                i_pressed = true;
            }
        }

        if(Game_Panel.game_state == Game_Panel.day_summary_state) {
            if(key_check == KeyEvent.VK_ENTER){
                    Game_Panel.game_state = Game_Panel.gameplay_state;
            }
        }

        if(Game_Panel.game_state == Game_Panel.player_inventory_state) {
            if(key_check == KeyEvent.VK_I){
                Game_Panel.game_state = Game_Panel.gameplay_state;
            }
            if(key_check == KeyEvent.VK_W){
                w_pressed = true;
            }
            if(key_check == KeyEvent.VK_S){
                s_pressed = true;
            }
            if(key_check == KeyEvent.VK_A){
                a_pressed = true;
            }
            if(key_check == KeyEvent.VK_D){
                d_pressed = true;
            }
            if(key_check == KeyEvent.VK_1){
                one_pressed = true;
            }
            if(key_check == KeyEvent.VK_2){
                two_pressed = true;
            }
            if(key_check == KeyEvent.VK_3){
                three_pressed = true;
            }
        }
        if(Game_Panel.game_state == Game_Panel.cooking_state) {
            if(key_check == KeyEvent.VK_ESCAPE){
                Game_Panel.game_state = Game_Panel.gameplay_state;
            }
            if(key_check == KeyEvent.VK_W){
                w_pressed = true;
            }
            if(key_check == KeyEvent.VK_S){
                s_pressed = true;
            }
            if(key_check == KeyEvent.VK_ENTER){
                enter_pressed = true;
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key_check = e.getKeyCode();


            if(key_check == KeyEvent.VK_W){
                w_pressed = false;
            }
            if(key_check == KeyEvent.VK_S){
                s_pressed = false;
            }
            if(key_check == KeyEvent.VK_A){
                a_pressed = false;
            }
            if(key_check == KeyEvent.VK_D){
                d_pressed = false;
            }
            if(key_check == KeyEvent.VK_1){
                one_pressed = false;
            }
            if(key_check == KeyEvent.VK_2){
                two_pressed = false;
            }
            if(key_check == KeyEvent.VK_3){
                three_pressed = false;
            }
            if(key_check == KeyEvent.VK_E){
                e_pressed = false;
            }
            if(key_check == KeyEvent.VK_I){
                i_pressed = false;
            }
            if(key_check == KeyEvent.VK_ENTER){
                enter_pressed = false;
            }


    }
}