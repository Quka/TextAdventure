/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import textadventure.Item.Item;
import java.util.ArrayList;

/**
 * Inventory is used to hold items that i picked up during gameplay
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class Inventory {

    private ArrayList<Item> items;
    private int capacity;

    /**
     * Constructs an inventory and initializes with a capacity of 10
     *
     */
    public Inventory() {
        items = new ArrayList<>();
        capacity = 10;

    }

    /**
     * Add an item to the inventory
     *
     * @param item
     */
    public void addToInventory(Item item) {
        items.add(item);

    }

    /**
     * Returns how many items there are in the inventory
     *
     * @return
     */
    public int getInventorySize() {
        return items.size();
    }

    /**
     * Returns how many items inventory can hold at maximum capacity
     *
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Creates a string showing the items in the inventory
     *
     * @return
     */
    public String showInventory() {

        String res = "===================== Inventory =====================\n";
        for (int i = 0; i < items.size(); i++) {
            res += "[" + i + "] " + items.get(i).getName() + "\n";
        }
        res += "=====================================================";
        return res;
    }

    /**
     * Removes item from inventory
     *
     * @param itemIndex
     */
    public void removeItemFromInventory(int itemIndex) {
        items.remove(itemIndex);

    }

    public Item getItem(int itemIndex) {
        return items.get(itemIndex);
    }

    @Override
    public String toString() {
        return items.toString();
    }

}
