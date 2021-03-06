package textadventure.Characters;

import java.util.ArrayList;
import textadventure.Item.ItemList;

/**
 * Creates an ArrayList of Monster objects
 *
 * @author thomasfritzboger
 */
public class MonsterList {

    private ArrayList<Monster> monsterList = new ArrayList<>();

    public MonsterList(ItemList itemList) {
        monsterList.add(new Monster("Tine", -3, itemList.getItem(9), itemList.getItem(16),
                "Hun drejer stolen 180 grader og kigger dig direkte i øjnene. Du får et koldt gys. "
                + "Hvordan opdagede hun dig?! Hvad har hun tænkt sig at gøre?! Hvilken "
                + "ret har hun tænkt sig at servere i aften?! Mens alle disse spørgsmål "
                + "suser rundt i dit hoved rejser hun sig lige pludselig op, smiler og "
                + "siger, uoverbevisende: \"Jeg skal bruge det til et IT-program\""));//
        monsterList.add(new Monster("Tobias", -3, itemList.getItem(10), itemList.getItem(14),
                "Tobias sidder med sit seneste blad om 3D-gaming, men du ved at han burde "
                + "lave oplæg om et nyt TAG-koncept. I et øjebliks hjerneafkopning påpeger "
                + "du dette overfor ham. Det skulle du aldrig have gjort"));
        monsterList.add(new Monster("Ronnie", -4, itemList.getItem(11), null,
                "Hvis han ikke så presset ud før, så gør han det i hvert fald, da han ser dig! "
                + "Han ligner en, som ikke ved om han skal spørge efter noget eller skrige "
                + "af sine lungers fulde kraft."));
        monsterList.add(new Monster("Viceværten", -5, itemList.getItem(13), null,
                "Som ordsproget lyder: \"Det er altid en god idé at være på god fod med "
                + "en vicevært\". Hvilket ordsprog spørger du? Dette ordsprog. "
                + "Han sidder og swiper på Tinder, men han er jo gift?"));
        monsterList.add(new Monster("Ruth", -2, itemList.getItem(14), itemList.getItem(20),
                "Det må være hende, som de omtaler som den \"blinde, for-altid-snakkende, "
                + "pensionistparate sæk\". Du er forundret over, hvorfor hun "
                + "har lys tændt. Du prøver at liste forbi hende, men hun hører dig."));
        monsterList.add(new Monster("Phillipa", -4, itemList.getItem(15), null,
                "Hun begynder at flirte med dig. Hvis bare hun havde sin mobil, så "
                + "hun ikke forstyrrer dig. Hvor mon mobilen egentlig er?"));
        monsterList.add(new Monster("IT-nørderne", -7, itemList.getItem(16), itemList.getItem(10),
                "Lyset fra døren lyser fanger alles øjne og blænder dem kortvarigt. Det ligner "
                + "ikke, at de havde forventet besøg. Og de ser ikke glade ud!"));
        monsterList.add(new Monster("Pedersen", -5, itemList.getItem(17), null,
                "Han opdager, at du kigger på ham med afsky. I ren hævngerrighed over den "
                + "dårlige samvittighed, som du har givet ham, stikker han sine hænder op mod dit ansigt."));
        monsterList.add(new Monster("Lisette", -3, itemList.getItem(18), itemList.getItem(17),
                "Du når lige at høre rædselsskriget. I ren slowmo matrix-style ser du en "
                + "syngende lussing komme flyvende i mod dig. Du kigger på hendes øjne."));
        monsterList.add(new Monster("Potentiel Kunde", -7, itemList.getItem(19), null,
                "Kunden kræver at du pudser hans sko. Uforskammet. Sådane en type "
                + "har du simpelthen ikke tid til. Det eneste han tænker på er sgu da "
                + "også kun penge eller magt!"));
        monsterList.add(new Monster("Projektgruppen", -5, itemList.getItem(20), null,
                "De kigger på dig. Du kigger på dem. Akavet."));
    }

    /**
     * Gets monster at index specified
     *
     * @param index
     * @return
     */
    public Monster getMonster(int index) {
        return monsterList.get(index);
    }

}
