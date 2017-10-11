package textadventure;

public class Player {
    
    private String name;
    private int health;
    private Room inRoom;
    
    public Player(String name, Room startingRoom) {
        this.name = name;
        this.health = 100;
        this.inRoom = startingRoom;
    }
    
    public void walk(String direction) {
        // inRoom = getRoom(direction);
    }
}
