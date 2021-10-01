import java.util.ArrayList;
import java.util.List;

public class MyItem implements IDedObject
{
    private int itemID;
    private int itemPrice;
    private List <Integer> itemDescription;

    // initialize item with provided values
    public MyItem(int itemID, int itemPrice, List <Integer> itemDescription)
    {
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        //itemDescription.clear();
        this.itemDescription = new ArrayList<>(itemDescription);
    }

    // get item ID
    public int getID()
    {
        return itemID;
    }

    // print the item data from ID
    public String printID()
    {
        String item = "";

        item += (itemID + " " + itemPrice + " "); // append item values to string

        for (int number: itemDescription)
        {
            item += number + " ";
        }

        return item;
    }
}