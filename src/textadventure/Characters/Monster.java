/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import textadventure.Characters.MainCharacter;
import java.util.ArrayList;
import textadventure.Room;

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

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public void walk(String direction) {
        currentRoom = currentRoom.getRoom(direction);
    }
    
    public void moveMonster() {
        ArrayList<Room> availableRooms = new ArrayList<>();
        // random fra 1 - 4
        
        walk("direction");
    }
}
