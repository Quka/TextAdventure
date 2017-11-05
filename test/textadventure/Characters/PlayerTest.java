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
import textadventure.Item.ItemList;
import textadventure.Maze;
import textadventure.Room;

/**
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class PlayerTest {

    Maze m;
    ArrayList<Room> rooms;
    ItemList il;
    Inventory i;
    Player p;

    @Before
    public void setUp() {
        this.il = new ItemList();
        this.m = new Maze(il);
        this.rooms = m.createMaze();
        this.i = new Inventory();
        this.p = new Player("test", rooms.get(0));
    }

    @Test
    public void testPickupPositiveConsumableItem() {
        // Pickup mælk item (+6)
        p.pickupItem(il.getItem(3));

        int exptected = 106;
        int actual = p.getRoundsLeft();

        assertEquals(exptected, actual);
    }

    @Test
    public void testPickupNegativeConsumableItem() {
        // Pickup mælk item (-4)
        p.pickupItem(il.getItem(7));

        int exptected = 96;
        int actual = p.getRoundsLeft();

        assertEquals(exptected, actual);
    }

    @Test
    public void testPickupItem() {

        p.pickupItem(il.getItem(11));
        i.addToInventory(il.getItem(11));

        assertEquals(p.getInventory().showInventory(), i.showInventory());
    }

}
