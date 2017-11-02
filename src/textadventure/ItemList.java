/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.ArrayList;
import textadventure.Item.*;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ItemList {

    private ArrayList<Item> itemList = new ArrayList<>();

    public ItemList() {
        itemList.add(new ConsumableItem(
                "Redbull",
                "Du spotter en 25cl. blå dåse, med to røde tyre der støder hinanden, markeret udenpå.",
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
                "Du opdager en 12x18 cm. mørk romantisk plade.",
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
                "To hydrogen og ét oxygen i en kovalent binding omringent af glas.",
                5,
                "Mhmm vand (+5)")
        );
        itemList.add(new ConsumableItem(
                "Nødder.",
                "Deez?",
                7,
                "Nutz. (+7)")
        );
        itemList.add(new ConsumableItem(
                "Mælk",
                "Cremet, blegt, og drikkeligt?",
                -4,
                "Det var surt... mælk... (-4)")
        );
        itemList.add(new ConsumableItem(
                "Snickers",
                "Du føler dig sulten og ikke helt som dig selv.",
                9,
                "Her, tag en snickers! (+9)")
        );
        itemList.add(new UsableItem(
                "Tilbudsavis",
                "På trods af 'Nej Tak' klistermærket, ligger den her stadig."
        ));
        itemList.add(new UsableItem(
                "3D Gamerblad",
                "Firkantet hovede og pickaxe? Er det om 3D og gaming?"
        ));
        itemList.add(new UsableItem(
                "Rulle toiletpapir",
                "Dejlig blødt og i 3-lag."
        ));
        itemList.add(new UsableItem(
                "Konsulentrapport",
                "Dette executive summary indeholder et kortfattet resumé af en række konklusioner og anbefalinger i ... zzzZZZzzz.."
        ));
        itemList.add(new UsableItem(
                "Telefonoplader",
                "En oplader, men er det mini, micro, nano, USB C eller lightning stik?"
        ));
        itemList.add(new UsableItem(
                "Stok",
                "Anvendes når man står, eller går, eller at partere med hvis man fjerner hylsteret."
        ));
        itemList.add(new UsableItem(
                "Håndtaske",
                "En taske man holder på med hænderne. Er det et 'P' indgraveret på?"
        ));
        itemList.add(new UsableItem(
                "Kaffe",
                "Mmm, en duft af roasted, bitre, malet, stemplede, bønner!"
        ));
        itemList.add(new UsableItem(
                "Håndsæbe",
                "Holder dine hænder rene."
        ));
        itemList.add(new UsableItem(
                "Mascara",
                "Påfør sminken på øjnene så de træder mere ud."
        ));
        itemList.add(new UsableItem(
                "Salgspræsentation",
                "Find ud af hvad der er det centrale budskab, som du vil have lytterne til at huske. Fokuser altid på kundens behov. Hvis du... vent, hvad prøver jeg at sælge?"
        ));
    }

    public Item getItem(int index) {
        return itemList.get(index);
    }
}
