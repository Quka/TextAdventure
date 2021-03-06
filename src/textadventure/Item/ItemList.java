package textadventure.Item;

import java.util.ArrayList;

/**
 * Creates an ArrayList consisting of both consumable and usable items
 *
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ItemList {

    private ArrayList<Item> itemList = new ArrayList<>();

    public ItemList() {
        itemList.add(new ConsumableItem(
                "En Redbull",
                "Du spotter en 25cl. blå dåse, med to røde tyre der støder hinanden, markeret udenpå.",
                5,
                "Du føler dig rig på energi (+5 runder)")
        );
        itemList.add(new ConsumableItem(
                "Kiks",
                "Du synes her lugter lidt af noget Marie som du kan samle op.",
                3,
                "Du fandt nogen kiks og nipper lidt til dem (+3 runder)")
        );
        itemList.add(new ConsumableItem(
                "En cola",
                "En sødet læskedrik. Drikken indeholder ofte kulsyre, koffein, fosforsyre (E338) og karamel (E-150d).",
                3,
                "Forfriskende! Du tænker tilbage på sidst du fik en cola, ah minder. (+3 runder)")
        );
        itemList.add(new ConsumableItem(
                "Chokolade",
                "Du opdager en 12x18 cm. mørk romantisk plade.",
                6,
                "Mums! Du elsker chokolade. (+6 runder)")
        );
        itemList.add(new ConsumableItem(
                "Nogle gulerødder",
                "Hvad er det orange, kaninen sidder og nipper til?",
                4,
                "Det var Snurre Snups favorit måltid! (+4 runder)")
        );
        itemList.add(new ConsumableItem(
                "Et glas vand",
                "To hydrogen og ét oxygen i en kovalent binding omringet af glas.",
                5,
                "Mhmm vand (+5 runder)")
        );
        itemList.add(new ConsumableItem(
                "Nødder",
                "Deez?",
                7,
                "Nutz. (+7)")
        );
        itemList.add(new ConsumableItem(
                "Mælk",
                "Cremet, blegt, og drikkeligt?",
                -4,
                "Det var surt... mælk... (-4 runder)")
        );
        itemList.add(new ConsumableItem(
                "Snickers",
                "Du føler dig sulten og ikke helt som dig selv.",
                9,
                "Her, tag en Snickers! (+9 runder)")
        );
        itemList.add(new UsableItem(
                "En tilbudsavis",
                "På trods af 'Nej Tak' klistermærket, ligger den her stadig."
        ));
        itemList.add(new UsableItem(
                "et 3D Gamerblad",
                "Firkantet hovede og pickaxe? Er det om 3D og gaming?"
        ));
        itemList.add(new UsableItem(
                "En rulle toiletpapir",
                "Dejlig blødt og i 3-lag."
        ));
        itemList.add(new UsableItem(
                "En konsulentrapport",
                "Dette executive summary indeholder et kortfattet resumé af en række konklusioner og anbefalinger i ... zzzZZZzzz.."
        ));
        itemList.add(new UsableItem(
                "En telefonoplader",
                "En oplader, men er det mini, micro, USB C eller lightning stik?"
        ));
        itemList.add(new UsableItem(
                "En stok",
                "Anvendes når man står, eller går, eller at partere med hvis man fjerner hylsteret."
        ));
        itemList.add(new UsableItem(
                "En håndtaske",
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
                "Påfør sminken på øjnene, så de træder mere ud."
        ));
        itemList.add(new UsableItem(
                "En salgspræsentation",
                "Find ud af hvad der er det centrale budskab, som du vil have lytterne til at huske. Fokuser altid på kundens behov. Hvis du... vent, hvad prøver jeg at sælge?"
        ));
        itemList.add(new UsableItem(
                "En laserpointer",
                "Rød? Grøn? Blå? Gul? Vælg en farve, alle er cool."
        ));
    }

    /**
     * Returns item at specified index in the ArrayList
     *
     * @param index
     * @return
     */
    public Item getItem(int index) {
        return itemList.get(index);
    }
}
