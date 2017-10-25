package textadventure;

public class Player implements MainCharacter {

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
    
    public void walk(String direction) {
        currentRoom = currentRoom.getRoom(direction);
    }
    
    public boolean canWalk(String direction) {
        return currentRoom.getRoom(direction) != null;
    }
    
    public void addRounds(int bonus){
        this.roundsLeft = roundsLeft + bonus;
    }
    
    public void removeRounds(int penalty){
            this.roundsLeft = roundsLeft - penalty;
    }

    public int getRoundsLeft() {
        return roundsLeft;
    }
    
   
}
