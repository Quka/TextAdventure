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

    private String decription;
    private Room currentRoom;
    private int penalty;
    private Item neutralizingItem;
    private Item dropItem;
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
    
    // Kunne det være en ide, at lave en getDesription, og når vi går ind i et 
    // rum, kunne der i getRoomDescription, indgå noget getMonsterDescription??
    // Arraylisten med Item skal jo sættes ind, men da den ikke er lavet, er alle
    // items bare sat til index1!
    
//    public ArrayList<Monster> createMonsters(ArrayList<Item> items){
//        
//        monsters.add(new Monster("Tine", -3, items.get(1), items.get(1)));
//        monsters.add(new Monster("Tobias", -3, items.get(1), items.get(1)));
//        monsters.add(new Monster("Ronnie", -4, items.get(1), items.get(1)));
//        monsters.add(new Monster("Viceværten", -5, items.get(1), items.get(1)));
//        monsters.add(new Monster("Ruth", -2, items.get(1), items.get(1)));
//        monsters.add(new Monster("Phillipa", -4, items.get(1), items.get(1)));
//        monsters.add(new Monster("IT Nørderne", -7, items.get(1), items.get(1)));
//        monsters.add(new Monster("Pedersen", -5, items.get(1), items.get(1)));
//        monsters.add(new Monster("Pedersen", -3, items.get(1), items.get(1)));
//        monsters.add(new Monster("Lisette", -3, items.get(1), items.get(1)));
//        monsters.add(new Monster("Potentiel Kunde", -7, items.get(1), items.get(1)));
//        monsters.add(new Monster("Projektgruppen", -5, null, items.get(1)));
//        
//    return monsters;
//    }
}
