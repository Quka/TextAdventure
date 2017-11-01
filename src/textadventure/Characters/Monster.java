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
 *
 * @author Ionsight
 */
public class Monster {

    private final String name;
    private String description;
    private int penalty;
    private final Item neutralizingItem;
    private Item dropItem;

    public Monster(String name, int penalty, Item neutralizingItem, Item dropItem, String description) {
        this.name = name;
        this.penalty = penalty;
        this.neutralizingItem = neutralizingItem;
        this.dropItem = dropItem;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPenalty() {
        return penalty;
    }

    public Item getNeutralizingItem() {
        return neutralizingItem;
    }

    public Item getDropItem() {
        return dropItem;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    
    public void setDropItemToNull()
    {
        this.dropItem = null;
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + '}';
    }  
    
    // Kunne det være en ide, at lave en getDesription, og når vi går ind i et 
    // rum, kunne der i getRoomDescription, indgå noget getMonsterDescription??
    // Arraylisten med Item skal jo sættes ind, men da den ikke er lavet, er alle
    // items bare sat til index1!
}
