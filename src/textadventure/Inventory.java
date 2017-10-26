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

    private ArrayList<Item> items;
    private int capacity;

    public Inventory()
    {
        items = new ArrayList<>();
        capacity = 10;
        
    }

    // add to inventory
   public void addToInventory(Item item)
    {
        items.add(item);
          
    }
   
   public int getInventorySize(){
       return items.size();
   }

    public int getCapacity()
    {
        return capacity;
    }
   
   
    // show inventory
    public String[] showInventory()
    {

        String[] res = new String[items.size()];
        for (int i = 0; i < res.length; i++)
        {
            res[i] = items.get(i).toString();
        }
        return res;
    }

    // remove item from inventory
    public void removeItemFromInventory(Item item)
    {
        items.remove(item);

    }

    @Override
    public String toString()
    {
        return items.toString();
    }

}
