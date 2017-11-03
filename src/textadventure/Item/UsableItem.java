package textadventure.Item;

/**
 * Usable item (extends item). Can be used against monsters
 * 
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
}
