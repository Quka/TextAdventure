package textadventure;

import textadventure.Item.Item;
import textadventure.Characters.Monster;
import textio.*;

/**
 * Room represents an area of the maze
 *
 * @author Group 7
 */
public class Room {

    private int id; // Not necessary for the code to function
    private TextIO io = new TextIO(new SysTextIO());
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private Monster monster;
    private Item item;

    private boolean winGame;
    private final String description;

/**
 * Constructs and initializes a room
 * 
 * @param description
 * @param winGame
 * @param monster
 * @param item 
 */
    public Room(String description, boolean winGame, Monster monster, Item item) {
        this.description = description;
        this.winGame = winGame;
        this.monster = monster;
        this.item = item;
    }

    /**
     * Sets the room to the north of room
     *
     * @param north
     */
    public void setNorth(Room north) {
        this.north = north;
    }

    /**
     * Sets the room to the east of room
     *
     * @param east
     */
    public void setEast(Room east) {
        this.east = east;
    }

    /**
     * Sets the room to the south of room
     *
     * @param south
     */
    public void setSouth(Room south) {
        this.south = south;
    }

    /**
     * Sets the room to the west of room
     *
     * @param west
     */
    public void setWest(Room west) {
        this.west = west;
    }

    /**
     * Checks to see if game is won
     *
     * @return boolean
     */
    public boolean isWinGame() {
        return winGame;
    }

    /**
     * Returns the room in the direction the Character wants to move or null
     * if there is no room in that direction
     * 
     * @param direction
     * @return 
     */
    public Room getRoom(String direction) {
        Room returnRoom = null;

        switch (direction) {
            case "N":
                returnRoom = this.north;
                break;
            case "E":
                returnRoom = this.east;
                break;
            case "S":
                returnRoom = this.south;
                break;
            case "W":
                returnRoom = this.west;
                break;
        }

        return returnRoom;
    }

    /**
     * Removes item from the room
     * 
     */
    public void removeItemFromRoom(){
       this.item=null;
    }
    
    /**
     * Adds item to the room
     * 
     */
    public void addItemToRoom(){
        this.item = item;
    }

    /**
     * Returns item in room
     * 
     * @return 
     */
    public Item getItem()
    {
        return item;
    }
    
    public Monster getMonster()
    {
        return monster;
    }
    
    /**
     * Shows room description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Game{" + description + '}';
    }

}
