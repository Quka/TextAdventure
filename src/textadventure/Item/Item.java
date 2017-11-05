package textadventure.Item;

/**
 * Abstract class for items
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
abstract public class Item {

    protected String name;
    protected String description;

    /**
     * Abstract constructor of an Item
     *
     * @param name
     * @param description
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns item name
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return item description
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return name + "\n- " + description;
    }

}
