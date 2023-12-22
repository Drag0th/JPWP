import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemList {

    Item[] Item;

    public  ItemList(){
        Item = new Item[20];
        getItemData();
    }

    public void getItemData(){
        try{
            //Empty Slot -> 0
            Item[0] = new Item();
            Item[0].name = "Nothing";
            Item[0].image = ImageIO.read(getClass().getResourceAsStream("res/Items/empty_slot.png"));
            Item[0].amount = 0;
            Item[0].eatable = false;
            Item[0].usable = false;
            Item[0].energy_gain = 0;
            //Watering Can -> 1
            Item[1] = new Item();
            Item[1].name = "Konewka";
            Item[1].image = ImageIO.read(getClass().getResourceAsStream("res/Items/watering_can.png"));
            Item[1].amount = 1;
            Item[1].eatable = false;
            Item[1].usable = true;
            Item[1].energy_gain = 0;
            //Wheat Seeds-> 2
            Item[2] = new Item();
            Item[2].name = "Nasiona pszenicy";
            Item[2].image = ImageIO.read(getClass().getResourceAsStream("res/Items/wheat_seeds.png"));
            Item[2].amount = 10;
            Item[2].eatable = false;
            Item[2].usable = true;
            Item[2].energy_gain = 0;
            //Wheat -> 3
            Item[3] = new Item();
            Item[3].name = "Pszenica";
            Item[3].image = ImageIO.read(getClass().getResourceAsStream("res/Items/wheat.png"));
            Item[3].amount = 0;
            Item[3].eatable = true;
            Item[3].usable = false;
            Item[3].energy_gain = 5;
            //Scythe -> 4
            Item[4] = new Item();
            Item[4].name = "Sierp";
            Item[4].image = ImageIO.read(getClass().getResourceAsStream("res/Items/scythe.png"));
            Item[4].amount = 1;
            Item[4].eatable = false;
            Item[4].usable = true;
            Item[4].energy_gain = 0;
            //Tomato seeds -> 5
            Item[5] = new Item();
            Item[5].name = "Nasiona pomidora";
            Item[5].image = ImageIO.read(getClass().getResourceAsStream("res/Items/tomato_seed.png"));
            Item[5].amount = 10;
            Item[5].eatable = false;
            Item[5].usable = true;
            Item[5].energy_gain = 0;
            //Tomato -> 6
            Item[6] = new Item();
            Item[6].name = "Pomidor";
            Item[6].image = ImageIO.read(getClass().getResourceAsStream("res/Items/tomato.png"));
            Item[6].amount = 0;
            Item[6].eatable = true;
            Item[6].usable = false;
            Item[6].energy_gain = 5;
            //Cabbage_seeds -> 7
            Item[7] = new Item();
            Item[7].name = "Nasiona kapusty";
            Item[7].image = ImageIO.read(getClass().getResourceAsStream("res/Items/cabbage_seeds.png"));
            Item[7].amount = 10;
            Item[7].eatable = false;
            Item[7].usable = true;
            Item[7].energy_gain = 0;
            //Cabbage -> 8
            Item[8] = new Item();
            Item[8].name = "Kapusta";
            Item[8].image = ImageIO.read(getClass().getResourceAsStream("res/Items/cabbage.png"));
            Item[8].amount = 0;
            Item[8].eatable = true;
            Item[8].usable = false;
            Item[8].energy_gain = 5;

        }catch(
        IOException e){
            e.printStackTrace();
        }
    }

}
