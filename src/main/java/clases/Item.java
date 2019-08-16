package clases;

import clases.Category;
import clases.Site;
import clases.User;

public class Item {

    private String id;
    private String name;
    private User user;
    private Site site;
    private Category category;


    public Item() {
    }

    public Item(String id, String name, User user, Site site, Category category) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.site = site;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", site=" + site +
                ", category=" + category +
                '}';
    }
}
