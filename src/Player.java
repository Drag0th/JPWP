import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;

public class Player extends Entity {
    int speed, map_x, map_y, energy = 100;
    String direction;
    BufferedImage player_up_1, player_up_2, player_down_1, player_down_2, player_left_1, player_left_2, player_right_1, player_right_2;
    GamePanel Game_Panel;
    KeyHandler Key_Handler;
    MapStorageAndRender Map_Storage_And_Render;
    TilesStorage Tiles_Storage;

    public Player(GamePanel Game_Panel, KeyHandler Key_Handler, MapStorageAndRender Map_Storage_And_Render, TilesStorage Tiles_Storage){
        this.Game_Panel = Game_Panel;
        this.Key_Handler = Key_Handler;
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        this.Tiles_Storage = Tiles_Storage;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 48;
        y = 48;
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

    public void calculateMapGrid(){
        boolean check_x = true, check_y = true;
        int i = 0, j = 0;

        while(check_x){
            //X
            if(direction == "right") {
                if ((x + 42) >= 48 * (i) && (x + 42) <= 48 * (i + 1)) {
                    map_x = i;
                    check_x = false;
                } else {
                    i++;
                }
            }
            else{
                if ((x+2) >= 48 * (i) && (x+2) <= 48 * (i + 1)) {
                    map_x = i;
                    check_x = false;
                } else {
                    i++;
                }
            }
        }
        while(check_y){
            //Y
            if(direction == "up") {
                if ((y + 2) >= 48 * (j) && (y + 2) <= 48 * (j + 1)) {
                    map_y = j;
                    check_y = false;
                } else {
                    j++;
                }
            }
            else{
                if ((y+48) >= 48 * (j) && (y+48) <= 48 * (j + 1)) {
                    map_y = j;
                    check_y = false;
                } else {
                    j++;
                }
            }
        }

    }

    public void update(){
        calculateMapGrid();
        if(Key_Handler.w_pressed && (Key_Handler.a_pressed == false) && (Key_Handler.d_pressed == false) && (Key_Handler.s_pressed == false)){
            if(Tiles_Storage.Tile[Map_Storage_And_Render.Map[Game_Panel.map_number][map_y][map_x]].collision){
                if(direction == "up")
                    y = y + 4;

            }else{
                direction = "up";
                y -= speed;
            }
        }
        if(Key_Handler.s_pressed && (Key_Handler.a_pressed == false) && (Key_Handler.d_pressed == false) && (Key_Handler.w_pressed == false)){
            if(Tiles_Storage.Tile[Map_Storage_And_Render.Map[Game_Panel.map_number][map_y][map_x]].collision ){
                if(direction == "down")
                    y = y - 4;
            }
            else{
                direction = "down";
                y += speed;
            }

        }
        if(Key_Handler.a_pressed && (Key_Handler.w_pressed == false) && (Key_Handler.d_pressed == false) && (Key_Handler.s_pressed == false)){
            if(Tiles_Storage.Tile[Map_Storage_And_Render.Map[Game_Panel.map_number][map_y][map_x]].collision){
                if(direction == "left")
                    x = x + 4;
            }
            else{
                direction = "left";
                x -= speed;
            }

        }
        if(Key_Handler.d_pressed && (Key_Handler.a_pressed == false) && (Key_Handler.w_pressed == false) && (Key_Handler.s_pressed == false)){
            if(Tiles_Storage.Tile[Map_Storage_And_Render.Map[Game_Panel.map_number][map_y][map_x]].collision){
                if(direction == "right")
                    x = x - 4;
            }
            else {
                direction = "right";
                x += speed;
            }
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
