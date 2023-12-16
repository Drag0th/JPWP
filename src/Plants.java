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
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkPlants(){
        for(int j = 0 ; j < 3; j++){
            for(int i = 0 ; i < 3 ; i++){
                if(farming_plot_0[i][j] != 0){
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
                    else{

                    }
                }
                if(farming_plot_1[i][j] != 0){
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
                    else{

                    }
                }
                if(farming_plot_2[i][j] != 0){
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
