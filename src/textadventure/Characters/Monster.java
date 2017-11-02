package textadventure.Characters;

import textadventure.Item.Item;

/**
 *
 * @author Ionsight
 */
public class Monster {

    private final String name;
    private String description;
    private int penalty;
    private final Item neutralizingItem;
    private Item dropItem;
    private boolean happy;

    public Monster(String name, int penalty, Item neutralizingItem, Item dropItem, String description, boolean happy) {
        this.name = name;
        this.penalty = penalty;
        this.neutralizingItem = neutralizingItem;
        this.dropItem = dropItem;
        this.description = description;
        this.happy = happy;
    }

    public String getName() {
        return name;
    }

    public int getPenalty() {
        return penalty;
    }

    public Item getNeutralizingItem() {
        return neutralizingItem;
    }

    public Item getDropItem() {
        return dropItem;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    
    public void setDropItemToNull()
    {
        this.dropItem = null;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + '}';
    }  
    
    public boolean isHappy() {
        return happy;
    }
}
