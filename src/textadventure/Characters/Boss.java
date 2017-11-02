/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import java.util.ArrayList;
import textadventure.Item.Item;
import textadventure.Room;

/**
 * "Boss" walking around in the maze
 * 
 * @author Ionsight
 */
public class Boss extends Monster implements MainCharacter {

    private Room currentRoom;

    /**
     * Constructs a monster and places it in the maze
     * @param name
     * @param penalty
     * @param neutralizingItem
     * @param dropItem
     * @param description
     * @param startingRoom 
     * @param isHappy 
     */
    public Boss(String name, int penalty, Item neutralizingItem, Item dropItem, String description, Room startingRoom, boolean isHappy) {
        super(name, penalty, neutralizingItem, dropItem, description, isHappy);
        this.currentRoom = startingRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public void walk(String direction) {
        currentRoom = currentRoom.getRoom(direction);
    }

    /**
     * Moves the monster in a random available(!) direction
     * 
     */
    public void moveMonster() {
        boolean cont = true;
        ArrayList<String> availableDirections = new ArrayList<>();
        availableDirections.add("N");
        availableDirections.add("E");
        availableDirections.add("S");
        availableDirections.add("W");

        do {
            int rand = (int) (Math.random() * availableDirections.size());
            String direction = availableDirections.get(rand);
            // try and walk
            if (currentRoom.getRoom(direction) != null) {
                this.walk(direction);
                cont = false;
            } else {
                // remove direction
                availableDirections.remove(rand);
            }
        } while (cont);
    }
}
