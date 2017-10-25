package textadventure;

public class Player implements MainCharacter {

    private String name;
    private int roundsLeft;
    private Room currentRoom;
    private Inventory inventory;

    public Player(String name, Room startingRoom) {
        this.name = name;
        this.roundsLeft = 100;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void walk(String direction) {
        currentRoom = currentRoom.getRoom(direction);
    }
    
    public boolean canWalk(String direction) {
        return currentRoom.getRoom(direction) != null;
    }
    
    public void changeRounds(int rounds){
        this.roundsLeft = roundsLeft + rounds;
    }

    public int getRoundsLeft() {
        return roundsLeft;
    }
    
   
}
