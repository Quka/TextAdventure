/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure;

import java.util.ArrayList;
import textadventure.Item.ConsumableItem;
import textadventure.Item.Item;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ItemList {
    
    private ArrayList<Item> itemList = new ArrayList<>();
    
    public ItemList() {
        itemList.add(new ConsumableItem(
                "Redbull", 
                "Du spotter en 33cl. blå dåse, med to røde tyre der støder hinanden markeret udenpå.", 
                5, 
                "Du føler dig rig på energi (+5)")
        );
        itemList.add(new ConsumableItem(
                "Kiks",
                "Du synes her lugter lidt af noget Marie som du kan samle op.",
                3,
                "Du fandt nogen kiks og nipper lidt til dem (+3)")
        );
        itemList.add(new ConsumableItem(
                "Cola",
                "En sødet læskedrik. Drikken indeholder ofte kulsyre, koffein, fosforsyre (E338) og karamel (E-150d).",
                3,
                "Forfriskende! Du tænker tilbage på sidst du fik en cola, ah minder. (+3)")
        );
        itemList.add(new ConsumableItem(
                "Chokolade",
                "Du nænner en 12x18 cm. mørke plade ",
                3,
                "Forfriskende! Du tænker tilbage på sidst du fik en cola, ah minder. (+3)")
        );
    }
    
    public Item getItem(int index) {
        return itemList.get(index);
    }
}
