package textadventure;

public class Room {

    private int id; //test for os selv indtil videre vi skal nok slette det Arlind <3

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private boolean winGame;
    private String description;

    public Room() {
        id = 0; //for loop på room arraylength
        description = "blabla"; //random decription
        winGame = false;
    }

    public String description() {

        return "blabla";  //random description
    }

    /**
     * Sets the nearby rooms for this room object, params can be null
     *
     * @param north Room north for this room
     * @param east Room east for this room
     * @param south Room south for this room
     * @param west Room west for this room
     */
    public void setRooms(Room north, Room east, Room south, Room west) {

    }

    public Room getRoom(String direction) {
        Room returnRoom = null;
        
        switch (direction) {
            case "north":
                returnRoom = this.north;
                break;
            case "east":
                returnRoom = this.east;
                break;
            case "south":
                returnRoom = this.south;
                break;
            case "west":
                returnRoom = this.west;
                break;
        }

        return returnRoom;
    }

    public boolean winGame() {
        return id == 19; //last room in array, kantine
    }
}
