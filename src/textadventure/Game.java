package textadventure;

import java.util.ArrayList;
import textio.*;

public class Game {

    private TextIO io = new TextIO(new SysTextIO());
//    private ArrayList<Room> rooms = new ArrayList<>();
//    private ArrayList<Room> officerooms = new ArrayList<>();
//    private ArrayList<Room> specialrooms = new ArrayList<>();
//    private ArrayList<Room> copyrooms = new ArrayList<>();
//    private ArrayList<Room> meetingrooms = new ArrayList<>();
//    private ArrayList<Room> restrooms = new ArrayList<>();
    private Player p;
    private Maze m;

    public Game() {

    }

    public void play() {
        io.put(startGame());
        io.put("Hvad hedder du, arbejdstager?");
        String name = io.get();
        io.put("Hej " + name + ", velkommen til Firma & Fiskefilet\n"
                + "Husk at du altid kan skrive h for hjælp\n"
                + "-----------------------------------------\n");

//        createRooms();
        m = new Maze();

        ArrayList<Room> rooms = m.createRooms();
        p = new Player(name, rooms.get(0));
        boolean gameEnded = false;

        io.put(p.getCurrentRoom().getDescription() + "\n");

        while (!gameEnded) {
            // io.put(p.getCurrentRoom().getDescription() + "\n");

            // Get a command from user
            command();

            if (p.getCurrentRoom().isWinGame() == true) {
                //io.put(p.getCurrentRoom().getDescription());
                gameEnded = true;
            }
        }
        io.put("Spillet er slut! ");
    }

//    public void addOfficeRoom(ArrayList<Room> rooms, ArrayList<Room> officerooms)
//    {
//        int removeIndex = ((int) (Math.random() * officerooms.size()));
//        rooms.add(officerooms.get(removeIndex));
//        officerooms.remove(removeIndex);
//    }
//
//    public void addSpecialRoom(ArrayList<Room> rooms, ArrayList<Room> specialrooms)
//    {
//        int removeIndex = ((int) (Math.random() * specialrooms.size()));
//        rooms.add(specialrooms.get(removeIndex));
//        specialrooms.remove(removeIndex);
//    }
//
//    public void addCopyRoom(ArrayList<Room> rooms, ArrayList<Room> copyrooms)
//    {
//        int removeIndex = ((int) (Math.random() * copyrooms.size()));
//        rooms.add(copyrooms.get(removeIndex));
//        copyrooms.remove(removeIndex);
//    }
//
//    public void addMeetingRoom(ArrayList<Room> rooms, ArrayList<Room> meetingrooms)
//    {
//        int removeIndex = ((int) (Math.random() * meetingrooms.size()));
//        rooms.add(meetingrooms.get(removeIndex));
//        meetingrooms.remove(removeIndex);
//    }
//
//    public void addRestRoom(ArrayList<Room> rooms, ArrayList<Room> meetingrooms)
//    {
//        int removeIndex = ((int) (Math.random() * restrooms.size()));
//        rooms.add(restrooms.get(removeIndex));
//        restrooms.remove(removeIndex);
//    }
//    
    //Text shown when starting the game
    public String startGame() {
        return "********************************************************\n"
                + "***************    FIRMA & FISKEFILET    ***************\n"
                + "********************************************************\n\n"
                + "********************************************************\n"
                + "** Det er lige blevet frokost, og det er fiskedag.    **\n"
                + "** Du skal finde vej til kantinen inden alle fiske-   **\n"
                + "** fileterne er udsolgt. Alt det andet fisk lugter og **\n"
                + "** smager dårligt. Derfor er det vigtigt, at du gør   **\n"
                + "** dit bedste for at få fiskefilet til frokost i dag  **\n"
                + "********************************************************\n";
    }

    public void command() {
        String command = io.get().toUpperCase();

        switch (command) {
            case "N":
            case "E":
            case "S":
            case "W":
                if (p.canWalk(command)) {
                    p.walk(command);
                    io.put(p.getCurrentRoom().getDescription());
                } else {
                    io.put("Der er ingen dør i den retning. Prøv igen!\n");
                }
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                io.put("Du har afsluttet spillet");
                System.exit(0);
                break;
            default:
                io.put("Det er ikke en gyldig kommando! Du kan altid"
                        + " skrive h for hjælp.\n");
                break;
        }
    }

    // Menu you see when pressing h 
    private void helpMenu() {
        String str = "\nDu har følgende muligheder: \n"
                + "E - for at gå mod øst\n"
                + "S - for at gå mod syd\n"
                + "W - for at gå mod vest\n"
                + "N - for at gå mod nord\n"
                + "H - for hjælp\n"
                + "Q - for at afslutte spillet\n";
        io.put(str);
    }

//    public void createRooms()
//    {
//        //Adding starting position, always rooms(index0)
//        rooms.add(new Room(
//                "Du sidder på dit kontor. Du kigger på uret og opdager,\n"
//                + "at du er sent på den. WTF! Bare der er fiskefilet\n"
//                + "tilbage, når du når kantinen!", false, 0));
//
//        //Adding offices to <>officerooms, randomly placed later        
//        officerooms.add(new Room(
//                "Du bliver kort blændet af en kontorlampe, som peger\n"
//                + "lige mod døråbningen. Du ser en gammel dame. SHHH!!\n"
//                + "Det må være hende de omtaler som \"blinde, snaksaglige,\n"
//                + "pensionsparate Ruth\". Forundret over "
//                + "hvorfor en blind har lys tændt.", false, 1)); //lister du videre for at undgå at hun hører dig
//
//        officerooms.add(new Room(
//                "Der er ingen i rummet, men Phillipa har glemt sin håndtaske.", false, 6)); //nysgerrig eller !
//
//        officerooms.add(new Room(
//                "Du kommer til at vade ind i IT-lokalet, hvor alle nørderne sidder.\n"
//                + "De snakker ikke om andet end Rick & Morty og hvordan Heroes 3 var\n"
//                + "det bedste i serien.", false, 7)); //miste runde
//
//        officerooms.add(new Room(
//                "Det var ikke kantinen det her, men du finder tilgengæld\n"
//                + "kiks og kaffe til at lette sulten lidt.", false, 4)); //+ runde
//
//        officerooms.add(new Room(
//                "Tine er ved at skrive en indkøbsseddel, da hun skal have gæster.\n"
//                + "Hun undskylder sig dog med, at hun skal bruge det til et IT-program.", false, 10));
//
//        officerooms.add(new Room(
//                "Du kommer ind i tekøkkenet, hvor du kan se Thomas har efterladt\n"
//                + "sin Red Bull. Den napper du selvfølgelig!", false, 12)); // + runde
//
//        officerooms.add(new Room(
//                "Tobias sidder med sit seneste blad om 3d-gaming, men du ved at han burde\n"
//                + "lave oplæg om et nyt TAG-koncept.", false, 16));
//        
//         //Adding copyrooms to <>copyrooms, randomly placed later 
//
//        copyrooms.add(new Room(
//                "Døren knirker som du åbner den. Et kopirum! Det burde\n "
//                + "du have set komme. Især fordi det var en glasdør.", false, 2));
//
//        copyrooms.add(new Room(
//                "Kopimaskinen summer stadig. Den er åbenbart lige blevet færdig.\n"
//                + "Du går nysgerrigt over og kigger i de udskrevne papirer. Det er\n"
//                + "chefens oplæg til spareforslag :o Du er nødt til at se om dit\n"
//                + "navn står på listen. Det koster en runde ekstra.", false, 8));
//        
//         //Adding restrooms to <>restrooms, randomly placed later 
//
//        restrooms.add(new Room(
//                "Ups! Dametoilettet. Der hænger en klam stank i luften.\n"
//                + "Det må være Ruth, som har været i gang.", false, 3)); //nogen derude?
//
//        restrooms.add(new Room(
//                "Pedersen er på vej ud fra toilettet. Han vasker ikke fingre!\n"
//                + "Slut med at give ham hånden.", false, 11));
//
//        restrooms.add(new Room(
//                "Du kommer ind på herretoilettet. Du skal simpelthen tisse så meget,\n"
//                + "at fiskefileterne må vente lidt. Du åbner toiletdøren, men ser at Ronnie\n"
//                + "har glemt at låse døren! Du mister en runde.", false, 13));
//
//        restrooms.add(new Room(
//                "Lisette står og pudrer næse. Hun opdager dig og langer dig en syngende lussing.", false, 18)); //miste runde
//        
//        //Adding meetingrooms to<>meetingrooms, randomly placed later
//
//        meetingrooms.add(new Room(
//                "Du træder ind i et lokale, hvor et vigtigt møde med en potentiel\n"
//                + "kunde er i gang. Du bliver nødt til at lade som om, at du er en sekretær.", false, 5));
//
//        meetingrooms.add(new Room(
//                "Mødelokalet er tomt, men der står kopper og service fra sidste møde.\n"
//                + "Sikke et rod!", false, 15)); //der kommer en ind, skal hun have hjælp eller ej
//
//        meetingrooms.add(new Room(
//                "Projektgruppen sidder i mødelokalet. Vil du forsøge at forsinke dem i at\n"
//                + "nå fiskefileterne i kantinen?", false, 19)); //muligheder
//        
//        //Adding specialrooms to<>specialrooms, randomly placed later
//
//        specialrooms.add(new Room(
//                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren\n"
//                + "Line. Chefen ser, at du opdager dem flirte.", false, 9)); //bliver sur, flov ect
//
//        specialrooms.add(new Room(
//                "Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med\n"
//                + "hende Alice fra regnskabsafdelingen?\"", false, 14)); //hans reaktion
//
//        specialrooms.add(new Room(
//                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen\n"
//                + "lige foran ham den arrogante fra din afdeling. Da du når frem til fadet\n"
//                + "er der kun "+ 4 +" fiskefileter tilbage. Du snupper alle "+ 4 +"!\n", true, 17)); // x antal fiskefiletter alt efter runder
//        
//        //Adding rooms(Inde1-5)
//        addOfficeRoom(rooms, officerooms);
//        addRestRoom(rooms, meetingrooms);
//        addMeetingRoom(rooms, meetingrooms);
//        addOfficeRoom(rooms, officerooms);
//        addRestRoom(rooms, meetingrooms);
//
//        //Adding rooms(Inde6-10)
//        addMeetingRoom(rooms, meetingrooms);
//        addCopyRoom(rooms, copyrooms);
//        addRestRoom(rooms, meetingrooms);
//        addOfficeRoom(rooms, officerooms);
//        addCopyRoom(rooms, copyrooms);
//
//        //Adding rooms(Inde11-15)
//        addOfficeRoom(rooms, officerooms);
//        addSpecialRoom(rooms, specialrooms);
//        addOfficeRoom(rooms, officerooms);
//        addRestRoom(rooms, meetingrooms);
//        addOfficeRoom(rooms, officerooms);
//
//        //Adding rooms(Inde16-19)
//        addOfficeRoom(rooms, officerooms);
//        addSpecialRoom(rooms, specialrooms);
//        addSpecialRoom(rooms, specialrooms);
//        addMeetingRoom(rooms, meetingrooms);
//        
//        //Setting possible ways to access rooms
//        rooms.get(0).setNorth(rooms.get(1));
//
//        rooms.get(1).setSouth(rooms.get(0));
//        rooms.get(1).setEast(rooms.get(2));
//        rooms.get(1).setWest(rooms.get(4));
//
//        rooms.get(2).setWest(rooms.get(1));
//        rooms.get(2).setNorth(rooms.get(10));
//        rooms.get(2).setEast(rooms.get(3));
//
//        rooms.get(3).setWest(rooms.get(2));
//
//        rooms.get(4).setWest(rooms.get(5));
//        rooms.get(4).setNorth(rooms.get(8));
//        rooms.get(4).setEast(rooms.get(1));
//
//        rooms.get(5).setEast(rooms.get(4));
//        rooms.get(5).setNorth(rooms.get(7));
//        rooms.get(5).setSouth(rooms.get(6));
//
//        rooms.get(6).setNorth(rooms.get(5));
//
//        rooms.get(7).setNorth(rooms.get(13));
//        rooms.get(7).setSouth(rooms.get(5));
//
//        rooms.get(8).setEast(rooms.get(9));
//        rooms.get(8).setSouth(rooms.get(4));
//
//        rooms.get(9).setWest(rooms.get(8));
//        rooms.get(9).setNorth(rooms.get(15));
//        rooms.get(9).setEast(rooms.get(10));
//
//        rooms.get(10).setWest(rooms.get(9));
//        rooms.get(10).setEast(rooms.get(11));
//        rooms.get(10).setSouth(rooms.get(2));
//
//        rooms.get(11).setWest(rooms.get(10));
//
//        rooms.get(12).setEast(rooms.get(13));
//
//        rooms.get(13).setWest(rooms.get(12));
//        rooms.get(13).setEast(rooms.get(14));
//        rooms.get(13).setSouth(rooms.get(7));
//
//        rooms.get(14).setWest(rooms.get(13));
//        rooms.get(14).setNorth(rooms.get(18));
//        rooms.get(14).setEast(rooms.get(15));
//
//        rooms.get(15).setSouth(rooms.get(9));
//        rooms.get(15).setWest(rooms.get(14));
//        rooms.get(15).setNorth(rooms.get(19));
//        rooms.get(15).setEast(rooms.get(16));
//
//        rooms.get(16).setWest(rooms.get(15));
//        rooms.get(16).setEast(rooms.get(17));
//
//        rooms.get(17).setWest(rooms.get(16));
//
//        rooms.get(18).setSouth(rooms.get(14));
//
//        rooms.get(19).setSouth(rooms.get(13));
}
