package textadventure.Item;

import textadventure.Characters.Player;

/**
 * An item that can be eaten or drank
 * 
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ConsumableItem extends Item {
    private final String descriptionUsed;
    private int roundsLeftModifier;
    
    /**
     * Constructs a consumable item
     * 
     * @param name
     * @param description
     * @param roundsLeftModifier
     * @param descriptionUsed
     */
    public ConsumableItem(String name, String description, int roundsLeftModifier, String descriptionUsed) {
        super(name, description);
        this.descriptionUsed = descriptionUsed;
        this.roundsLeftModifier = roundsLeftModifier;
    }
    
    /**
     * Changes round for player p!
     * 
     * @param p 
     */
    
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsLeftModifier);
    }
   /**
    * Returns the description for when the consumed item is (automatically)used
    * 
    * @return 
    */
    public String getDescriptionUsed() {
        return this.descriptionUsed;
    }
    
    public int getRoundsModifier(){
        return roundsLeftModifier;
    }
}
