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
                "Du spotter en 33cl. blå dåse, med to røde tyre der støder hinanden, markeret udenpå.",
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
                "Hvad er det orange, kaninen sidder og nipper til?",
                4,
                "Det var Snurre Snups favorit måltid! (+4)")
        );
        itemList.add(new ConsumableItem(
                "Glas vand",
                "Et hydrogen og to oxygen i en kovalent binding omringent af glas",
                5,
                "Mhmm vand (")
        );
        itemList.add(new ConsumableItem(
                "Nødder", // Skal give minus da Pedersen som ikke vasker hænder dropper den
                "Deez?",
                7,
                "Nutz.")
        );
        itemList.add(new ConsumableItem(
                "Mælk",
                "Cremet, blegt, drikkeligt?",
                -4,
                "Det var surt... surt mælk! (-4)")
        );
        itemList.add(new ConsumableItem(
                "Snickers",
                "Du føler dig sulten og ikke helt som dig selv",
                9,
                "Her, tag en snickers! (+9)")
        );
        itemList.add(new UsableItem(
                "Tilbudsavis",
                "På trods af 'Nej Tak' klistermærket, ligger den stadig her"
        ));
        itemList.add(new UsableItem(
                "3D Gamerblad",
                ""
        ));
        itemList.add(new UsableItem(
                "Rulle toiletpapir",
                ""
        ));
        itemList.add(new UsableItem(
                "Konsulentrapport",
                ""
        ));
        itemList.add(new UsableItem(
                "Telefonlader",
                ""
        ));
        itemList.add(new UsableItem(
                "Stok",
                ""
        ));
        itemList.add(new UsableItem(
                "Håndtaske",
                ""
        ));
        itemList.add(new UsableItem(
                "Kaffe",
                ""
        ));
        itemList.add(new UsableItem(
                "Håndsæbe",
                ""
        ));
        itemList.add(new UsableItem(
                "Mascara",
                ""
        ));
        itemList.add(new UsableItem(
                "Salgspræsentation",
                ""
        ));
    }

    public Item getItem(int index) {
        return itemList.get(index);
    }
}
