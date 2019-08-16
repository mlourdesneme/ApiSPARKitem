import clases.Item;

import java.util.Collection;

public interface IItemService {

    public Collection<Item> getItems();
    public Collection<Item> getItemsByUser(String username);
    public Item getItem (String id);
    public String addItem(String id, Item item);

}
