package textadventure.Characters;

import textadventure.Characters.MainCharacter;
import textadventure.Inventory;
import textadventure.Room;

public class Player implements MainCharacter {

    private String name;
    private int roundsLeft;
    private Room currentRoom;
    private Inventory inventory;

    /**
     * Creates and initilizes a human player with "health" and inventory
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

}
