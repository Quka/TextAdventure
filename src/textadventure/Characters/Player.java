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
        io.put("Du går ");
         switch (direction) {
            case "N":
                io.put("nord");
                break;
            case "E":
                io.put("øst");
                break;
            case "S":
                io.put("syd");
                break;
            case "W":
                io.put("vest");
                break;
            default:
                io.put("Det er ikke en gyldig retning");
                break;
         }
         io.put(".");
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
     * Sets rounds left for player
     *
     * @param i
     */
    public void setRoundsLeft(int i) {

        this.roundsLeft = i;
    }

    /**
     * Returns player name
     *
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Returns player inventory
     * 
     * @return 
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Adds item to the inventory if inventory is not at max capacity. Else it
     * explains the user that there is not enough space.
     *
     * @param item
     * @return
     */
    // Could this just be void?
    public String pickupItem(Item item) {
        String itemUse = "";
        // Skal der være en Exceptions, hvis man prøver at samle op i et rum uden items??

        if (item instanceof ConsumableItem) {
            changeRounds(((ConsumableItem) item).getRoundsModifier());
            itemUse = ((ConsumableItem) item).getDescriptionUsed();
        } else {
            inventory.addToInventory(item);
            itemUse = "Du lægger " + item.getName().toLowerCase() + " i rygsækken.";
        }

        return itemUse;
    }

    /**
     * Removes the item from inventory and modifies round timer(?)
     *
     * @param itemIndex
     * @return
     */
    public Item getItem(int itemIndex) {
        Item item = inventory.getItem(itemIndex);
        inventory.removeItemFromInventory(itemIndex);
        return item;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", roundsLeft=" + roundsLeft + '}';
    }

}
