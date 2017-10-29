package textadventure.Characters;

import textadventure.Inventory;
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

    private String name;
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
     * Either adds or substracts rounds from the players "health"
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
     * @param room 
     */
    public void addItemToInventory(Item item, Room room) {
        if (inventory.getInventorySize() >= inventory.getCapacity()) {
            io.put("Du har ikke plads til flere ting på dig");
        } else {
            inventory.addToInventory(item);
            room.removeItem();
        }

    }

    /**
     * Removes the item from inventory and modifies round timer(?)
     * 
     * @param item
     * @param rounds 
     */
    public void useItem(Item item, int rounds) {
        inventory.removeItemFromInventory(item);
        rounds += item.getRoundsModifier();

    }
    
    /**
     * Removes item from inventory and modifies round timer
     * 
     * @param item
     * @param rounds 
     */
    public void consumeItem(Item item, int rounds) {
        inventory.removeItemFromInventory(item);
        rounds += item.getRoundsModifier();

    }

    /**
     * Removes the item from inventory and adds it to the room
     * 
     * @param item
     * @param room 
     */
    
    // Shouldn't it remove it from the hand instead of inventory?
    public void dropItem(Item item, Room room) {
        if (room.getItem() != null) {
            io.put("Du må ikke lægge flere ting her");
        } else {
            inventory.removeItemFromInventory(item);
            room.addItemToRoom();
        }
    }

}
