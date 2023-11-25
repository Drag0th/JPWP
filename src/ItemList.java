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

        }catch(
        IOException e){
            e.printStackTrace();
        }
    }

}
