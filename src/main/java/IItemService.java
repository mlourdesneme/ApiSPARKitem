import java.util.Collection;

public interface IItemService {

    public Collection<Item> getItems();
    public Collection<Item> getItemsByUser(String username);
    public int addItem(Item item);

}
