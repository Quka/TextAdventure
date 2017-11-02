/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textadventure.Inventory;
import textadventure.ItemList;
import textadventure.Maze;
import textadventure.Room;

/**
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class PlayerTest {

    @Test
    public void testPickupItem() {
        Maze m = new Maze();
        ArrayList<Room> rooms = m.createMaze();
        ItemList il = new ItemList();
        Inventory i = new Inventory();
        Player p = new Player("test", rooms.get(0));
        
        p.pickupItem(il.getItem(11));
        i.addToInventory(il.getItem(11));
        
        assertEquals(p.getInventory().showInventory(), i.showInventory());
    }
    
}
