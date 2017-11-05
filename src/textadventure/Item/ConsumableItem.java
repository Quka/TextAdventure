package textadventure.Item;

import textadventure.Characters.Player;

/**
 * An item that can be eaten or drank
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ConsumableItem extends Item {

    private final String descriptionUsed;
    private int roundsModifier;

    /**
     * Constructs a consumable item
     *
     * @param name
     * @param description
     * @param roundsModifier
     * @param descriptionUsed
     */
    public ConsumableItem(String name, String description, int roundsModifier, String descriptionUsed) {
        super(name, description);
        this.descriptionUsed = descriptionUsed;
        this.roundsModifier = roundsModifier;
    }

    /**
     * Changes round for player p!
     *
     * @param p
     */
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsModifier);
    }

    /**
     * Returns the description for when the consumed item is (automatically)used
     *
     * @return
     */
    public String getDescriptionUsed() {
        return this.descriptionUsed;
    }

    /**
     * Returns the number of rounds the item either adds or subtracts from
     * player
     *
     * @return
     */
    public int getRoundsModifier() {
        return roundsModifier;
    }
}
