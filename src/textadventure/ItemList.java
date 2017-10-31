/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.ArrayList;
import textadventure.Item.ConsumableItem;
import textadventure.Item.Item;
import textadventure.Item.UsableItem;

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
                "Du nænner en 12x18 cm. mørk romantisk plade",
                6,
                "Mums! Du elsker chokolade. (+6)")
        );
        itemList.add(new ConsumableItem(
                "Gulerødder",
                "",
                0,
                "")
        );
        itemList.add(new ConsumableItem(
                "Vand",
                "",
                0,
                "")
        );
        itemList.add(new ConsumableItem(
                "Nødder",
                "",
                0,
                "")
        );
        itemList.add(new ConsumableItem(
                "Mælk (sur)",
                "",
                0,
                "")
        );
        itemList.add(new ConsumableItem(
                "Snickers",
                "",
                0,
                "")
        );
        itemList.add(new UsableItem(
                "Tilbudsavis",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "3D Gamerblad",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Rulle toiletpapir",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Konsulentrapport",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Telefonlader",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Stok",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Håndtaske",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Kaffe",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Håndsæbe",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Mascara",
                "",
                0
        ));
        itemList.add(new UsableItem(
                "Salgspræsentation",
                "",
                0
        ));
    }

    public Item getItem(int index) {
        return itemList.get(index);
    }
}
