package textadventure.Item;

/**
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
     * Method to see how the specific item modifies rounds left for the player
     *
     * @return
     */
    //Check if method is used
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }

    
}
