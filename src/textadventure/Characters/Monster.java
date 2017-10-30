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
class Monster {

    protected String decription;
    protected Room currentRoom;
    protected int penalty;
    protected Item neutralizingItem;
    protected Item dropItem;
    private ArrayList<Monster> monsters;

    public Monster(String decription, int penalty, Item neutralizingItem, Item dropItem) {
        this.decription = decription;
        this.penalty = penalty;
        this.neutralizingItem = neutralizingItem;
        this.dropItem = dropItem;
    }

    public String getDecription() {
        return decription;
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

    @Override
    public String toString() {
        return "Monster{" + "decription=" + decription + '}';
    }  
    
    public ArrayList<Monster> createMonsters(){
        
    return monsters;
    }
}
