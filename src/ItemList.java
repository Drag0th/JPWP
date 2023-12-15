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

        }catch(
        IOException e){
            e.printStackTrace();
        }
    }

}
