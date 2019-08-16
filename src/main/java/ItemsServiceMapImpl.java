import clases.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemsServiceMapImpl implements IItemService {

    private Map<String, Item> itemsMap;

    public ItemsServiceMapImpl() {
        itemsMap = new HashMap<String, Item>();

        User u1 = new User(1, "lula", "password1", null);
        User u2 = new User(2, "Pablo", "password2", null);
        User u3 = new User(3, "Juli", "password3", null);

        Site site = new Site("MLA","Argentina");
        Site site1 = new Site("MLC","Chile");
        Site site2 = new Site("MLU","Uruguay");

        Category cat = new Category("MLA5725","Accesorios para Vehículos");
        Category cat1 = new Category("MLA1403","Alimentos y Bebidas");
        Category cat2 = new Category("MLA1071","Animales y Mascotas");


        Site[] sites = new Site[]{site, site1, site2};
        Category[] categories = new Category[]{cat,cat1,cat2};

        Item i1 = new Item("item1" , "comida", u1, site, cat);
        Item i2 = new Item("item2", "computadora" , u1, site, cat2);
        Item i3 = new Item("item3" , "heladera", u1, site1, cat);
        Item i4 = new Item("item4", "celular", u2, site1, cat1);

         itemsMap.put("item1", i1);
         itemsMap.put("idem2", i2);
         itemsMap.put("idem3", i3);
         itemsMap.put("idem4", i4);

    }

    public Collection<Item> getItems() {
        return itemsMap.values();
    }

    public Collection<Item> getItemsByUser(String username) {
        Collection<Item> items1 = itemsMap.values();
        Map<String, Item> itemfiltered = new HashMap<String, Item>();

        items1.forEach(it -> {
            if (it.getUser().getUsername().equalsIgnoreCase(username)) {
                itemfiltered.put(it.getId(), it);
            }
        });
        return itemfiltered.values();

    }

    public Item getItem (String id){
        return this.itemsMap.get(id);
    }

    public String addItem(String id, Item item) {
        itemsMap.put(id, item);
        return id;
    }


}

