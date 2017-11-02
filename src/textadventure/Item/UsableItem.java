package textadventure.Item;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class UsableItem extends Item {
    
    /**
     * Constructs an item (that can be used against (specific) monsters)
     * 
     * @param name
     * @param description
     */
    
    public UsableItem(String name, String description) {
        super(name, description);
    }
    
    /**
     * Checks if the item is usable on the specific monster
     * 
     */
    //Does this do anything? At all?
    public void useItem() {
        // not done
    }
}
