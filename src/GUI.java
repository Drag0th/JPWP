import java.awt.*;

public class GUI {
    GamePanel Game_Panel;

    public GUI(GamePanel Game_Panel){

        this.Game_Panel = Game_Panel;

    }

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

    public void drawMainMenu(Graphics2D g2d){
        if(Game_Panel.game_state == 0)
            drawMainMenu_0(g2d);
        if(Game_Panel.game_state == 1)
            drawMainMenu_1(g2d);
        if(Game_Panel.game_state == 2)
            drawMainMenu_2(g2d);
    }

}
