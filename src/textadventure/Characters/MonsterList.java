/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import java.util.ArrayList;
import textadventure.Item.Item;

/**
 *
 * @author thomasfritzboger
 */
public class MonsterList
{

    private ArrayList<Monster> monsters = new ArrayList<>();
    
    
    public MonsterList()
    {
        
    }
    
     public ArrayList<Monster> createMonsters(ArrayList<Item> items){
        
         
        monsters.add(new Monster("Tine", -3, items.get(1), items.get(1)));
        monsters.add(new Monster("Tobias", -3, items.get(1), items.get(1)));
        monsters.add(new Monster("Ronnie", -4, items.get(1), items.get(1)));
        monsters.add(new Monster("Viceværten", -5, items.get(1), items.get(1)));
        monsters.add(new Monster("Ruth", -2, items.get(1), items.get(1)));
        monsters.add(new Monster("Phillipa", -4, items.get(1), items.get(1)));
        monsters.add(new Monster("IT Nørderne", -7, items.get(1), items.get(1)));
        monsters.add(new Monster("Pedersen", -5, items.get(1), items.get(1)));
        monsters.add(new Monster("Pedersen", -3, items.get(1), items.get(1)));
        monsters.add(new Monster("Lisette", -3, items.get(1), items.get(1)));
        monsters.add(new Monster("Potentiel Kunde", -7, items.get(1), items.get(1)));
        monsters.add(new Monster("Projektgruppen", -5, null, items.get(1)));
        
    return monsters;
    }
    
}
