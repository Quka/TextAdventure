package textadventure;

public class Player {

    private String name;
    private int roundsLeft;
    private Room currentRoom;

    public Player(String name, Room startingRoom) {
        this.name = name;
        this.roundsLeft = 100;
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    

    public boolean walk(String direction) {
        if (currentRoom.getRoom(direction) != null) {
            currentRoom = currentRoom.getRoom(direction);
            return true;
        } else {
            return false;
        }
        // inRoom = getRoom(direction);
    }
}
