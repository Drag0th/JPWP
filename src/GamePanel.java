import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Rozdzielczosc gry
    final int screen_width = 768;
    final int screen_height = 576;
    //Stan gry
    int game_state;
    final int[] main_menu_state  = {1,2,3};

    Thread Game_Thread;
    GUI GUI = new GUI(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
    }
    public void startGameThread(){
        Game_Thread = new Thread(this);
        Game_Thread.start();
    }

    public void setupGame(){
        game_state = main_menu_state[0];
    }

    @Override
    public void run() {

        while(Game_Thread != null){
            Update();
            repaint();
        }

    }

    public void Update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        if(game_state == main_menu_state[0]) {
            GUI.drawMainMenu_0(g2d);
        }
    }

}