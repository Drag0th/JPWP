import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class GameWindow {
    public GameWindow() {

        JFrame Game_Window = new JFrame();
        Game_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Game_Window.setResizable(false);
        Game_Window.setTitle("Farma");
        GamePanel Game_Panel = new GamePanel();
        Game_Window.add(Game_Panel);
        Game_Window.pack();
        Game_Window.setVisible(true);
        Game_Panel.startGameThread();


        try {
            Game_Window.setIconImage(ImageIO.read(getClass().getResourceAsStream("res/icon/Game_icon.png")));;
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}
