package textadventure;

import textio.*;

public class Room {

    private int id; //test for os selv indtil videre vi skal nok slette det Arlind <3
    private TextIO io = new TextIO(new SysTextIO());
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private boolean winGame;
    private String description;

    public Room(String description, boolean winGame, int id) {
        id = 0; //for loop på room arraylength
        this.description = description;//"blabla"; //random decription
        this.winGame = winGame;
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

    public boolean winGame() {
        return id == 19; //last room in array, kantine
    }

    @Override
    public String toString() {
        return "Game{" + description + '}';
    }

    
}
