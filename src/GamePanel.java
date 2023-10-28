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

    Thread Game_Thread;

    KeyHandler Key_Handler = new KeyHandler(this);

    GUI GUI = new GUI(this);
    Player Player = new Player(this, Key_Handler);

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
            Player.draw(g2d);
        }
    }

}