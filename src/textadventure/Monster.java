/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

/**
 *
 * @author Ionsight
 */
public class Monster implements MainCharacter {

    private String name;
    private Room currentRoom;

    public Monster(String name, Room startingRoom) {
        this.name = name;
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
}
