package textadventure;

import java.util.ArrayList;
import textio.*;

public class Game
{

    private TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();

    public Game()
    {

    }

    public void play()
    {
        io.put(startGame());
        io.put("Indtast navn:");
        String name = io.get();
        io.put("Hej " + name + ", velkommen til Firma & Fiskefilet\n");

        createRooms();
        
        Player p = new Player(name, rooms.get(0));
        
        boolean gameEnded = false;
        
        while(!gameEnded){
        io.put(p.getCurrentRoom().getDescription() + "\n");
        io.put("Skriv retning (e/s/w/n) eller h for hjælp");
        boolean walkSuccess = p.walk(io.get());
        if(!walkSuccess){
            System.out.println("Der er ingen dør i den retning. Prøv igen!");
        }
         if(p.getCurrentRoom().isWinGame()== true) gameEnded=true;
        
        
        
        }
        io.put("Game ended");
    }

    public String startGame()
    {
        return "****************************************************************\n"
                + "** Det er lige blevet frokost, og det er fiskedag.\n"
                + "** Du skal finde vej til kantinen inden alle fiskefileterne er udsolgt.\n"
                + "** Alt det andet fisk lugter, derfor er det vigtigt du får fiskefilet\n"
                + "** til frokost i dag\n"
                + "****************************************************************\n";
    }

    public void createRooms()
    {

        rooms.add(new Room("Du sidder på dit kontor. Du kigger på uret og opdager, at du er sent på den. WTF! FISKEDAG!! Bare der er en fiskefilet tilbage, når du når kantinen", false, 0));
        rooms.add(new Room("Du bliver kort blændet af en kontorlampe, som peger lige mod døråbningen. Du "
                + "ser en gammel dame. SHHH!! Det må være hende de omtaler som \"blinde, snaksaglige, pensionsparate Ruth\". Forundret over "
                + "hvorfor en blind har lys tændt, (((lister du videre for at undgå at hun hører dig)))", false, 1));
        rooms.add(new Room("Døren knirker som du åbner den. Et kopirum! Det burde du have set komme. Især fordi det var en glasdør.", false, 2));
        rooms.add(new Room("Ups! Dametoilettet. Der hænger en klam stank i luften. Det må være Ruth, som har været i gang. (((Boolean om der er nogen derude)))", false, 3));
        rooms.add(new Room("Employee office4", false, 4));
        rooms.add(new Room("Du træder ind i et lokale, hvor et vigtigt møde med en potentiel kunde er i gang. Du bliver nødt til at lade "
                + "som om, at du er en sekretær", false, 5));
        rooms.add(new Room("Employee office6", false, 6));
        rooms.add(new Room("Employee office7", false, 7));
        rooms.add(new Room("Kopimaskinen summer stadig. Den er åbenbart lige blevet færdig. Du går nysgerrigt over og kigger i de udskrevne papirer. Det er chefens oplæg til spareforslag :o Du er nødt til at se om dit navn står på listen. Det koster en runde ekstra", false, 8));
        rooms.add(new Room("Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren Line. Chefen ser, at du opdager dem flirte. (((bliver han sur, flov ect)))", false, 9));
        rooms.add(new Room("Employee office8", false, 10));
        rooms.add(new Room("Pedersen er på vej ud fra toilettet. Han vasker ikke fingre! Slut med at give ham hånden.", false, 11));
        rooms.add(new Room("Employee office3", false, 12));
        rooms.add(new Room("Du kommer ind på herretoilettet. Du skal simpelthen tisse så meget, at fiskefileterne må vente lidt. Du åbner toiletdøren, men ser at Ronnie har glemt at låse døren! Du mister en runde", false, 13));
        rooms.add(new Room("Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med hende Alice fra regnskabsafdelingen?\"(((hans reaktion))) ", false, 14));
        rooms.add(new Room("Mødelokalet er tomt, men der står kopper og service fra sidste møde. Sikke et rod!(((boolean med oprydning. der kommer en ind, skal hun have hjælp eller ej)))", false, 15));
        rooms.add(new Room("Employee office2", false, 16));
        rooms.add(new Room("OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen lige foran ham den arrogante fra din "
                + "afdeling. Da du når frem til fadet er der kun 4 (((dependant on rounds left))) fiskefileter tilbage. Du snupper alle 4!", true, 17));
        rooms.add(new Room("Womens restroom1", false, 18));
        rooms.add(new Room("Meetingroom1 bla bla", false, 19));

        for (Room room : rooms)
        {
            System.out.println(room);
        }

        rooms.get(0).setNorth(rooms.get(1));

        rooms.get(1).setEast(rooms.get(2));
        rooms.get(1).setWest(rooms.get(4));

        rooms.get(2).setWest(rooms.get(1));
        rooms.get(2).setNorth(rooms.get(10));
        rooms.get(2).setEast(rooms.get(3));

        rooms.get(3).setWest(rooms.get(2));

        rooms.get(4).setWest(rooms.get(5));
        rooms.get(4).setNorth(rooms.get(8));
        rooms.get(4).setEast(rooms.get(1));

        rooms.get(5).setNorth(rooms.get(7));
        rooms.get(5).setSouth(rooms.get(6));

        rooms.get(6).setNorth(rooms.get(5));

        rooms.get(7).setNorth(rooms.get(13));
        rooms.get(7).setSouth(rooms.get(5));

        rooms.get(8).setEast(rooms.get(9));
        rooms.get(8).setSouth(rooms.get(4));

        rooms.get(9).setWest(rooms.get(8));
        rooms.get(9).setNorth(rooms.get(15));
        rooms.get(9).setEast(rooms.get(10));

        rooms.get(10).setWest(rooms.get(9));
        rooms.get(10).setEast(rooms.get(11));
        rooms.get(10).setSouth(rooms.get(2));

        rooms.get(11).setWest(rooms.get(10));

        rooms.get(12).setEast(rooms.get(13));

        rooms.get(13).setWest(rooms.get(12));
        rooms.get(13).setEast(rooms.get(14));
        rooms.get(13).setSouth(rooms.get(7));

        rooms.get(14).setWest(rooms.get(13));
        rooms.get(14).setNorth(rooms.get(18));
        rooms.get(14).setEast(rooms.get(15));

        rooms.get(15).setWest(rooms.get(14));
        rooms.get(15).setNorth(rooms.get(19));
        rooms.get(15).setEast(rooms.get(16));

        rooms.get(16).setWest(rooms.get(15));
        rooms.get(16).setEast(rooms.get(17));

        rooms.get(17).setWest(rooms.get(16));

        rooms.get(18).setSouth(rooms.get(14));

        rooms.get(19).setSouth(rooms.get(13));
    }
}
