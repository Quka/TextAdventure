/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Characters;

import java.util.ArrayList;
import textadventure.ItemList;

/**
 *
 * @author thomasfritzboger
 */
public class MonsterList {

    private ArrayList<Monster> monsterList = new ArrayList<>();
    private ItemList itemList = new ItemList();

    public MonsterList() {
        monsterList.add(new Monster("Tine", -3, itemList.getItem(9), itemList.getItem(16), ""));//
        monsterList.add(new Monster("Tobias", -3, itemList.getItem(10), itemList.getItem(14), ""));
        monsterList.add(new Monster("Ronnie", -4, itemList.getItem(11), itemList.getItem(2), ""));
        monsterList.add(new Monster("Viceværten", -5, itemList.getItem(13), itemList.getItem(13), ""));
        monsterList.add(new Monster("Ruth", -2, itemList.getItem(14), itemList.getItem(11), ""));
        monsterList.add(new Monster("Phillipa", -4, itemList.getItem(15), itemList.getItem(18), ""));
        monsterList.add(new Monster("IT Nørderne", -7, itemList.getItem(16), itemList.getItem(10), ""));
        monsterList.add(new Monster("Pedersen", -5, itemList.getItem(17), itemList.getItem(6), ""));
        monsterList.add(new Monster("Lisette", -3, itemList.getItem(18), itemList.getItem(17), ""));
        monsterList.add(new Monster("Potentiel Kunde", -7, itemList.getItem(19), itemList.getItem(3), ""));
        monsterList.add(new Monster("Projektgruppen", -5, null, null, ""));
    }

    public Monster getMonster(int index) {
        return monsterList.get(index);
    }

    
    
}
