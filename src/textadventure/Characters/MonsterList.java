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
        monsterList.add(new Monster("Ronnie", -4, itemList.getItem(11), itemList.getItem(2), 
                  "Hvis han ikke så presset ud før, så gør han det i hvert fald, da han ser dig!\n"
                + "Han ligner en, som ikke ved om han skal spørge efter noget eller skrige\n"
                + "af sine lungers fulde kraft."));
        monsterList.add(new Monster("Viceværten", -5, itemList.getItem(13), itemList.getItem(13), ""));
        monsterList.add(new Monster("Ruth", -2, itemList.getItem(14), itemList.getItem(11), 
                  "Det må være hende, som de omtaler som den \"blinde, for-altid-snakkende,\n"
                + "pensionistparate sæk\". Du er forundret over hvorfor hun\n"
                + "har lys tændt. Du prøver at liste forbi hende, men hun hører dig."));
        monsterList.add(new Monster("Phillipa", -4, itemList.getItem(15), itemList.getItem(18), ""));
        monsterList.add(new Monster("IT Nørderne", -7, itemList.getItem(16), itemList.getItem(10), 
                  "Lyset fra døren lyser fanger alles øjne og blænder dem kortvarigt. Det ligner\n"
                + "ikke, at de havde forventet besøg. Og de ser ikke glade ud!"));
        monsterList.add(new Monster("Pedersen", -5, itemList.getItem(17), itemList.getItem(6), ""));
        monsterList.add(new Monster("Lisette", -3, itemList.getItem(18), itemList.getItem(17), ""));
        monsterList.add(new Monster("Potentiel Kunde", -7, itemList.getItem(19), itemList.getItem(3), ""));
        monsterList.add(new Monster("Projektgruppen", -5, null, null, ""));
    }

    public Monster getMonster(int index) {
        return monsterList.get(index);
    }
    
}
