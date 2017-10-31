/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import java.util.ArrayList;
import textadventure.Item.Item;
import textadventure.ItemList;

/**
 *
 * @author thomasfritzboger
 */
public class MonsterList
{

    private ArrayList<Monster> monsters = new ArrayList<>();
    private ItemList itemList = new ItemList();
    
    public MonsterList()
    {
        
    }
    
     public ArrayList<Monster> createMonsters(){
        
         
         
        monsters.add(new Monster("Tine", -3, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Tobias", -3, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Ronnie", -4, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Viceværten", -5, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Ruth", -2, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Phillipa", -4, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("IT Nørderne", -7, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Pedersen", -5, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Pedersen", -3, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Lisette", -3, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Potentiel Kunde", -7, itemList.getItem(0), itemList.getItem(0)));
        monsters.add(new Monster("Projektgruppen", -5, itemList.getItem(0), itemList.getItem(0)));
        
    return monsters;
    }
    
}
