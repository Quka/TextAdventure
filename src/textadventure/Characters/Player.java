package textadventure.Characters;

import textadventure.Inventory;
import textadventure.Item.ConsumableItem;
import textadventure.Item.Item;
import textadventure.Room;
import textio.SysTextIO;
import textio.TextIO;

/**
 * Player represents the human player.
 *
 * @author Ionsight
 */
public class Player implements MainCharacter {

    private final String name;
    private int roundsLeft;
    private Room currentRoom;
    private Inventory inventory;
    private TextIO io = new TextIO(new SysTextIO());

    /**
     * Creates and initializes a human player with "health" and inventory
     *
     * @param name
     * @param startingRoom
     */
    public Player(String name, Room startingRoom) {
        this.name = name;
        this.roundsLeft = 100;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
    }

    /**
     * Get which room in the maze the player is at this instant
     *
     * @return
     */
    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Check if the direction is valid, i.e. if there is a room in that
     * direction
     *
     * @param direction
     * @return
     */
    public boolean canWalk(String direction) {
        return currentRoom.getRoom(direction) != null;
    }

    /**
     * Changes current room to the room the direction requested
     *
     * @param direction
     */
    @Override
    public void walk(String direction) {
        currentRoom = currentRoom.getRoom(direction);
    }

    /**
     * Either adds or subtracts rounds from the players "health"
     *
     * @param rounds
     */
    public void changeRounds(int rounds) {
        this.roundsLeft = roundsLeft + rounds;
    }

    /**
     * Get an int with rounds left, i.e. players health
     *
     * @return
     */
    public int getRoundsLeft() {
        return roundsLeft;
    }

    /**
     * Adds item to the inventory if inventory is not at max capacity. Else it
     * explains the user that there is not enough space.
     *
     * @param item
     */
    public void pickupItem(Item item) {

        if (item instanceof ConsumableItem) {
            // # Hvis item er consumable så brug med det samme
            changeRounds(item.getRoundsModifier());
        } else {
            // # Hvis item er usable, så læg i backpack
            inventory.addToInventory(item);
        }
    }

    /**
     * Removes the item from inventory and modifies round timer(?)
     *
     * @param itemIndex
     * @return 
     */
    public Item getItem(int itemIndex) {
        inventory.removeItemFromInventory(itemIndex);
        return inventory.getItem(itemIndex);
    }

}
