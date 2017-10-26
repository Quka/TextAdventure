/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import textadventure.Item.Item;
import java.util.ArrayList;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class Inventory
{

    private ArrayList<Item> items = new ArrayList<>();
    private int capacity;
    private Item item;

    public Inventory()
    {
        capacity = 10;
    }

    // add to inventory
    private void addToInventory(Item item)
    {
        this.item = item;
        items.add(item);
    }

    // show inventory
    private void showInventory(ArrayList<Item> items)
    {

        for (Item item : items)
        {
            System.out.println(items); // invokes Item.toString()
        }
    }

    // use item
    private void useItem(Item item)
    {

        this.item = item;
        items.remove(item);

    }

    // remove item
    private void removeItem(Item item)
    {
        this.item = item;
        items.remove(item);

    }

    @Override
    public String toString()
    {
        return items.toString();
    }

}
