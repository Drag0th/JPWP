import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Plants {
    MapStorageAndRender Map_Storage_And_Render;
    int[][] farming_plot_0, farming_plot_1, farming_plot_2;
    BufferedImage[] plants_image;

    public Plants(MapStorageAndRender Map_Storage_And_Render){
        this.Map_Storage_And_Render = Map_Storage_And_Render;
        plants_image = new BufferedImage[20];
        farming_plot_0 = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        farming_plot_1 = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        farming_plot_2 = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        getTileImage();
    }

    public void getTileImage() {
        try {
            //Wheat_stage 0 -> 1
            plants_image[1] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Wheat/wheat_stage0.png"));
            //Wheat_stage 2 -> 2
            plants_image[2] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Wheat/wheat_stage1.png"));
            //Wheat_stage 3 -> 3
            plants_image[3] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Wheat/wheat_stage2.png"));
            //Wheat_stage 4 -> 4
            plants_image[4] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Wheat/wheat_stage3.png"));
            //Tomato_stage 0 -> 5
            plants_image[5] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage0.png"));
            //Tomato_stage 1 -> 6
            plants_image[6] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage1.png"));
            //Tomato_stage 2 -> 6
            plants_image[7] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage2.png"));
            //Tomato_stage 3 -> 8
            plants_image[8] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage3.png"));
            //Tomato_stage 4 -> 9
            plants_image[9] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage4.png"));
            //Tomato_stage 5 -> 10
            plants_image[10] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage5.png"));
            //Tomato_stage 6 -> 11
            plants_image[11] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Tomato/tomato_stage6.png"));
            //Cabbage_stage 0 -> 12
            plants_image[12] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Cabbage/cabbage_stage0.png"));
            //Cabbage_stage 1 -> 13
            plants_image[13] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Cabbage/cabbage_stage1.png"));
            //Cabbage_stage 2 -> 14
            plants_image[14] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Cabbage/cabbage_stage2.png"));
            //Cabbage_stage 3 -> 15
            plants_image[15] = ImageIO.read(getClass().getResourceAsStream("res/Plants/Cabbage/cabbage_stage3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkPlants(){
        for(int j = 0 ; j < 3; j++){
            for(int i = 0 ; i < 3 ; i++){
                if(farming_plot_0[i][j] != 0){
                        //Wheat
                        if(farming_plot_0[i][j] == 1 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 2;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 2 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12 ){
                            farming_plot_0[i][j] = 3;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 3 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 4;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        //Tomato
                        if(farming_plot_0[i][j] == 5 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 6;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 6 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12 ){
                            farming_plot_0[i][j] = 7;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 7 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 8;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 8 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 9;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 9 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 10;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 10 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 11;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        //Cabbage
                        if(farming_plot_0[i][j] == 12 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 13;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 13 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 14;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                        if(farming_plot_0[i][j] == 14 && Map_Storage_And_Render.Map[1][j+5][i+2] == 12){
                            farming_plot_0[i][j] = 15;
                            Map_Storage_And_Render.Map[1][j+5][i+2] = 9;
                        }
                    else{

                    }
                }
                if(farming_plot_1[i][j] != 0){
                    //Wheat
                    if(farming_plot_1[i][j] == 1 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 2;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 2 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12 ){
                        farming_plot_1[i][j] = 3;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 3 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 4;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    //Tomato
                    if(farming_plot_1[i][j] == 5 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 6;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 6 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12 ){
                        farming_plot_1[i][j] = 7;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 7 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 8;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 8 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12 ){
                        farming_plot_1[i][j] = 9;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 9 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 10;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] ==10 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 11;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    //Cabbage
                    if(farming_plot_1[i][j] == 12 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12 ){
                        farming_plot_1[i][j] = 13;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] == 13 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 14;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    if(farming_plot_1[i][j] ==14 && Map_Storage_And_Render.Map[1][j+5][i+6] == 12){
                        farming_plot_1[i][j] = 15;
                        Map_Storage_And_Render.Map[1][j+5][i+6] = 9;
                    }
                    else{

                    }
                }
                if(farming_plot_2[i][j] != 0){
                    //Wheat
                    if(farming_plot_2[i][j] == 1 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 2;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 2 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12 ){
                        farming_plot_2[i][j] = 3;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 3 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 4;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    //Tomato
                    if(farming_plot_2[i][j] == 5 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 6;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 6 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12 ){
                        farming_plot_2[i][j] = 7;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 7 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 8;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 8 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12 ){
                        farming_plot_2[i][j] = 9;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 9 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 10;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 10 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 11;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    //Cabbage
                    if(farming_plot_2[i][j] == 12 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12 ){
                        farming_plot_2[i][j] = 13;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 13 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 14;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    if(farming_plot_2[i][j] == 14 && Map_Storage_And_Render.Map[1][j+5][i+10] == 12){
                        farming_plot_2[i][j] = 15;
                        Map_Storage_And_Render.Map[1][j+5][i+10] = 9;
                    }
                    else{

                    }
                }

            }
        }
    }

    public void drawPlants(Graphics2D g2d){
        for(int j = 0 ; j < 3; j++){
            for(int i = 0 ; i < 3 ; i++){
                if(farming_plot_0[i][j] != 0){
                    g2d.drawImage(plants_image[farming_plot_0[i][j]], (i+2)*48, (j+5)*48, 48, 48, null);
                }
                if(farming_plot_1[i][j] != 0){
                    g2d.drawImage(plants_image[farming_plot_1[i][j]], (i+6)*48, (j+5)*48, 48, 48, null);
                }
                if(farming_plot_2[i][j] != 0){
                    g2d.drawImage(plants_image[farming_plot_2[i][j]], (i+10)*48, (j+5)*48, 48, 48, null);
                }
            }
        }
    }
}
