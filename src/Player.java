import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;

public class Player extends Entity {
    int speed;
    String direction;
    BufferedImage player_up_1, player_up_2, player_down_1, player_down_2, player_left_1, player_left_2, player_right_1, player_right_2;
    GamePanel Game_Panel;
    KeyHandler Key_Handler;

    public Player(GamePanel Game_Panel, KeyHandler Key_Handler){
        this.Game_Panel = Game_Panel;
        this.Key_Handler = Key_Handler;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void  getPlayerImage(){
        try{

            player_up_1 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_up_1.png"));
            player_up_2 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_up_2.png"));
            player_down_1 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_down_1.png"));
            player_down_2 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_down_2.png"));
            player_left_1 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_left_1.png"));
            player_left_2 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_left_2.png"));
            player_right_1 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_right_1.png"));
            player_right_2 = ImageIO.read(getClass().getResourceAsStream("res/player/farmer_right_2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(Key_Handler.w_pressed){
            direction = "up";
            y -= speed;
        }
        if(Key_Handler.s_pressed){
            direction = "down";
            y += speed;
        }
        if(Key_Handler.a_pressed){
            direction = "left";
            x -= speed;
        }
        if(Key_Handler.d_pressed){
            direction = "right";
            x += speed;
        }


        animation_counter++;
        if(animation_counter > 15){
            if(animation_number == 1)
                animation_number = 2;
            else{
                animation_number = 1;
            }
            animation_counter = 0;
        }
    }
    public void draw(Graphics2D player){
        BufferedImage player_image = null;
        switch(direction){
            case "up":
                if(animation_number == 1)
                    player_image = player_up_1;
                if(animation_number == 2)
                    player_image = player_up_2;
                break;
            case "down":
                if(animation_number == 1)
                    player_image = player_down_1;
                if(animation_number == 2)
                    player_image = player_down_2;
                break;
            case "left":
                if(animation_number == 1)
                    player_image = player_left_1;
                if(animation_number == 2)
                    player_image = player_left_2;
                break;
            case "right":
                if(animation_number == 1)
                    player_image = player_right_1;
                if(animation_number == 2)
                    player_image = player_right_2;
                break;
        }
        player.drawImage(player_image, x, y, 48, 48, null);
    }

}
