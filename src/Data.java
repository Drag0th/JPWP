import java.awt.*;

/**
 * Klasa zbierajaca dane
 */
public class Data {
    int Spaghetti_counter = 0, Salad_counter = 0, Bread_counter = 0, Tomato_Counter = 0, Cabbage_counter = 0, Wheat_counter = 0;
    GamePanel Game_Panel;

    /**
     * Konsturkotr
     * @param Game_Panel obiekt
     */
    public Data(GamePanel Game_Panel){
        this.Game_Panel = Game_Panel;
    }

    /**
     * Metoda odpowiadajaca za wyswietlanie informacji zebranych podczas gry.
     * @param g2d obiekt
     */
    public void drawData(Graphics2D g2d){
        g2d.setFont(new Font("Large_Bold", Font.BOLD, 40));
        int x = 160;
        int y = 140;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Pszenicy: " + Wheat_counter, x, y);
        y = y + 40;
        g2d.drawString("Pomidorow: " + Tomato_Counter, x, y);
        y = y + 40;
        g2d.drawString("Salaty: " + Cabbage_counter, x, y);
        y = y + 40;
        g2d.drawString("Chleba: " + Bread_counter, x, y);
        y = y + 40;
        g2d.drawString("Spaghetti: " + Spaghetti_counter, x, y);
        y = y + 40;
        g2d.drawString("Salatek: " + Salad_counter, x, y);
    }
}
