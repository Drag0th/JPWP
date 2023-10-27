import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean w_pressed;
    public static boolean s_pressed;
    public static boolean a_pressed;
    public static boolean d_pressed;

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

        if(Game_Panel.game_state == 0 || Game_Panel.game_state == 1 || Game_Panel.game_state == 2) {
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
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}