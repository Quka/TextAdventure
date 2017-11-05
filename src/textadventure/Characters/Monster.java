package textadventure.Characters;

import textadventure.Item.Item;

/**
 * Monsters which is is bound to a specific room (room parameter)
 *
 * @author Ionsight
 */
public class Monster {

    private final String name;
    private final String description;
    private int penalty;
    private final Item neutralizingItem;
    private Item dropItem;

    /**
     * Creates a monster
     *
     * @param name
     * @param penalty
     * @param neutralizingItem
     * @param dropItem
     * @param description
     */
    public Monster(String name, int penalty, Item neutralizingItem, Item dropItem, String description) {
        this.name = name;
        this.penalty = penalty;
        this.neutralizingItem = neutralizingItem;
        this.dropItem = dropItem;
        this.description = description;
    }

    /**
     * Return monsters name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns damage player takes from monster
     *
     * @return
     */
    public int getPenalty() {
        return penalty;
    }

    /**
     * Returns the item that sets monster damage to 0
     *
     * @return
     */
    public Item getNeutralizingItem() {
        return neutralizingItem;
    }

    /**
     * Returns the item monster drop if defeated
     *
     * @return
     */
    public Item getDropItem() {
        return dropItem;
    }

    /**
     * Sets damage player takes from monster
     *
     * @param penalty
     */
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    /**
     * Removes drop item from monster
     *
     */
    public void setDropItemToNull() {
        this.dropItem = null;
    }

    /**
     * Returns monster description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + '}';
    }
}
