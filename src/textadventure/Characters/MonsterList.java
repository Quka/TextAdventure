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
        monsterList.add(new Monster("Tine", -3, itemList.getItem(9), itemList.getItem(16), 
                "Hun drejer stolen 180 grader og kigger dig direkte i øjnene. Du får et koldt gys.\n"
                + "Hvordan opdagede hun dig?! Hvad har hun tænkt sig at gøre?! Hvilken\n"
                + "ret har hun tænkt sig at servere i aften?! Mens alle disse spørgsmål\n"
                + "suser rundt i dit hoved rejser hun sig lige pludselig op, smiler og\n"
                + "siger, uoverbevisende: \"Jeg skal bruge det til et IT-program\""));//
        monsterList.add(new Monster("Tobias", -3, itemList.getItem(10), itemList.getItem(14), 
                "Tobias sidder med sit seneste blad om 3D-gaming, men du ved at han burde\n"
                + "lave oplæg om et nyt TAG-koncept. I et øjebliks hjerneafkopning påpeger\n"
                + "du dette overfor ham. Det skulle du aldrig have gjort"));
        monsterList.add(new Monster("Ronnie", -4, itemList.getItem(11), itemList.getItem(2), 
                  "Hvis han ikke så presset ud før, så gør han det i hvert fald, da han ser dig!\n"
                + "Han ligner en, som ikke ved om han skal spørge efter noget eller skrige\n"
                + "af sine lungers fulde kraft."));
        monsterList.add(new Monster("Viceværten", -5, itemList.getItem(13), itemList.getItem(13),
                "Som ordsproget lyder: \"Det er altid en god idé at være på god fod med\n"
                + "en vicevært\". Hvilket ordsprog spørger du? Dette ordsprog."));
        monsterList.add(new Monster("Ruth", -2, itemList.getItem(14), itemList.getItem(11), 
                  "Det må være hende, som de omtaler som den \"blinde, for-altid-snakkende,\n"
                + "pensionistparate sæk\". Du er forundret over hvorfor hun\n"
                + "har lys tændt. Du prøver at liste forbi hende, men hun hører dig."));
        monsterList.add(new Monster("Phillipa", -4, itemList.getItem(15), itemList.getItem(18),
                "Hun begynder at flirte med dig. Hvis bare hun havde sin mobil, så \n"
                + "hun ikke forstyrrer dig. Hvor mon mobilen egentlig er?"));
        monsterList.add(new Monster("IT Nørderne", -7, itemList.getItem(16), itemList.getItem(10), 
                  "Lyset fra døren lyser fanger alles øjne og blænder dem kortvarigt. Det ligner\n"
                + "ikke, at de havde forventet besøg. Og de ser ikke glade ud!"));
        monsterList.add(new Monster("Pedersen", -5, itemList.getItem(17), itemList.getItem(6), 
                "Han opdager, at du kigger på ham med afsky. I ren hævngerrighed over den\n"
                + "dårlige samvittighed, som du har givet ham, stikker hansine hænder op mod dit ansigt"));
        monsterList.add(new Monster("Lisette", -3, itemList.getItem(18), itemList.getItem(17),
                "Du når lige at høre rædselsskriget. I ren slowmo matrix-style ser du en\n"
                + "syngende lussing komme flyvende i mod dig. Du kigger på hendes øjne."));
        monsterList.add(new Monster("Potentiel Kunde", -7, itemList.getItem(19), itemList.getItem(3), 
                "Kunden beder dig om at pudse hans sko. Uforskammet. Sådane en type\n"
                + "har du simpelthen ikke tid til. Det eneste han tænker på er sgu da\n"
                + "også kun penge eller magt!"));
        monsterList.add(new Monster("Projektgruppen", -5, null, null, 
                "De kigger på dig. Du kigger på dem. Akavet."));
    }

    public Monster getMonster(int index) {
        return monsterList.get(index);
    }
    
}
