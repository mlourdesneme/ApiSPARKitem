public class Item {

    private String name;
    private User user;
    private Site site;
    private Category category;


    public Item() {
    }

    public Item(User user, Site site, Category category, String name) {
        this.user = user;
        this.site = site;
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", site=" + site +
                ", category=" + category +
                '}';
    }
}
