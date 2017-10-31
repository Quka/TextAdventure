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
public class MonsterList {

    private ArrayList<Monster> monsterList = new ArrayList<>();
    private ItemList itemList = new ItemList();

    public MonsterList() {
        monsterList.add(new Monster("Tine", -3, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Tobias", -3, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Ronnie", -4, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Viceværten", -5, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Ruth", -2, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Phillipa", -4, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("IT Nørderne", -7, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Pedersen", -5, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Pedersen", -3, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Lisette", -3, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Potentiel Kunde", -7, itemList.getItem(0), itemList.getItem(0)));
        monsterList.add(new Monster("Projektgruppen", -5, itemList.getItem(0), itemList.getItem(0)));
    }

    public Monster getMonster(int index) {
        return monsterList.get(index);
    }

}
