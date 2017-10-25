package textadventure;

import textadventure.Item.Item;
import textio.*;

public class Room {

    private int id; // Not necessary for the code to function
    private TextIO io = new TextIO(new SysTextIO());
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private Item item;

    private boolean winGame;
    private String description;

    public Room(String description, boolean winGame, Item item) {
        this.id = id;
        this.description = description;
        this.winGame = winGame;
        this.item=item;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public boolean isWinGame() {
        return winGame;
    }

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

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Game{" + description + '}';
    }

    
}
