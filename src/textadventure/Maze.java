package textadventure;

import java.util.ArrayList;
import textadventure.Characters.MonsterList;
import textadventure.Item.ConsumableItem;
import textadventure.Item.Item;
import textadventure.Item.UsableItem;

/**
 * Class used to create rooms and maze to tell which rooms can access which
 * other rooms
 *
 * @author thomasfritzboger
 */
public class Maze {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Room> officeRooms = new ArrayList<>();
    private ArrayList<Room> specialRooms = new ArrayList<>();
    private ArrayList<Room> copyRooms = new ArrayList<>();
    private ArrayList<Room> meetingRooms = new ArrayList<>();
    private ArrayList<Room> restRooms = new ArrayList<>();
    private ItemList itemList = new ItemList();
    private MonsterList monsterList = new MonsterList();

    /**
     * Constructs a maze
     *
     */
    public Maze() {

    }

    public ArrayList<Room> createMaze() {
        createRooms();
        createAccess(rooms);

        return rooms;
    }

    private void addOfficeRoom() {
        int removeIndex = (int) (Math.random() * officeRooms.size());
        rooms.add(officeRooms.get(removeIndex));
        officeRooms.remove(removeIndex);
    }

    private void addSpecialRoom(ArrayList<Room> rooms, ArrayList<Room> specialRooms) {
        int removeIndex = ((int) (Math.random() * specialRooms.size()));
        rooms.add(specialRooms.get(removeIndex));
        specialRooms.remove(removeIndex);
    }

    private void addCopyRoom(ArrayList<Room> rooms, ArrayList<Room> copyRooms) {
        int removeIndex = ((int) (Math.random() * copyRooms.size()));
        rooms.add(copyRooms.get(removeIndex));
        copyRooms.remove(removeIndex);
    }

    private void addMeetingRoom(ArrayList<Room> rooms, ArrayList<Room> meetingRooms) {
        int removeIndex = ((int) (Math.random() * meetingRooms.size()));
        rooms.add(meetingRooms.get(removeIndex));
        meetingRooms.remove(removeIndex);
    }

    private void addRestRoom(ArrayList<Room> rooms, ArrayList<Room> restRooms) {
        int removeIndex = ((int) (Math.random() * restRooms.size()));
        rooms.add(restRooms.get(removeIndex));
        restRooms.remove(removeIndex);
    }

    /**
     * Creates rooms with parameters
     *
     *
     * @return ArrayList of rooms
     */
    private ArrayList<Room> createRooms() {
        //Adding starting position, always rooms(index0)

        rooms.add(new Room(
                "Du sidder på dit kontor. Du kigger på uret og opdager,\n"
                + "at du er sent på den. WTF! FISKEDAG! Bare der er\n"
                + "fiskefilet tilbage, når du når kantinen.", false, null, null));

        //Adding offices to <>officerooms, randomly placed later        
        officeRooms.add(new Room(
                "Du bliver kort blændet af en kontorlampe, som peger\n"
                + "lige mod døråbningen. Du ser en gammel dame. SHHH!!\n"
                + "Det må være hende de omtaler som \"blinde, snaksaglige,\n"
                + "pensionsparate Ruth\". Forundret over hvorfor en blind\n"
                + "har lys tændt lister du dig videre.", false, null, null)); //lister videre, hører hun dig?

        officeRooms.add(new Room(
                "Rummet er tomt, men Phillipa har glemt sin håndtaske.", false, null, itemList.getItem(0))); //Du bliver nysgerrig eller !

        officeRooms.add(new Room(
                "Du kommer til at vade ind i IT-lokalet, hvor alle nørderne sidder.\n"
                + "De snakker ikke om andet end Rick & Morty og hvordan Heroes 3 var\n"
                + "det bedste i serien.", false, null, null));

        officeRooms.add(new Room(
                "Det var ikke kantinen det her, men hvorfor er der\n"
                + "så krummer på gulvet?", false, null, null));

        officeRooms.add(new Room(
                "Tine er ved at skrive en indkøbsseddel, da hun skal have gæster.\n"
                + "Hun undskylder sig dog med, at hun skal bruge det til et IT-program", false, null, null));

        officeRooms.add(new Room(
                "Du træder ind i det tekøkken, hvor Thomas plejer at opholde\n"
                + "sig. Du ved, hvad det betyder!", false, null, null));

        officeRooms.add(new Room(
                "Tobias sidder med sit seneste blad om 3d-gaming, men du ved at han burde\n"
                + "lave oplæg om et nyt TAG-koncept", false, null, null));

        //Adding copyrooms to <>copyrooms, randomly placed later 
        copyRooms.add(new Room(
                "Døren knirker som du åbner den. Et kopirum! Det burde\n "
                + "du have set komme. Især fordi det var en glasdør.", false, null, null));

        copyRooms.add(new Room(
                "Kopimaskinen summer stadig. Den er åbenbart lige blevet færdig.\n"
                + "Du går nysgerrigt over og kigger på alle de udskrevne papirer.", false, null, null));

        //Adding restrooms to <>restrooms, randomly placed later 
        restRooms.add(new Room(
                "Ups! Dametoilettet. Der hænger en klam stank i luften.\n"
                + "Det må være Ruth, som har været i gang.", false, null, null)); //boolean om der er nogen derude

        restRooms.add(new Room(
                "Pedersen er på vej ud fra toilettet. Han vasker ikke fingre!\n"
                + "Slut med at give ham hånden.", false, null, null));

        restRooms.add(new Room(
                "Du kommer ind på herretoilettet. Du skal simpelthen tisse så meget,\n"
                + "at fiskefileterne må vente lidt. Du åbner toiletdøren, men ser at Ronnie\n"
                + "har glemt at låse døren!", false, null, null));

        restRooms.add(new Room(
                "Lisette står og pudrer næse på dametoilettet. Hun opdager dig og langer dig\n"
                + "en syngende lussing.", false, null, null));

        //Adding meetingrooms to<>meetingrooms, randomly placed later
        meetingRooms.add(new Room(
                "Du træder ind i et lokale, hvor et vigtigt møde med en potentiel\n"
                + "kunde er i gang. Du bliver nødt til at lade som om, at du er en sekretær.", false, null, null));

        meetingRooms.add(new Room(
                "Mødelokalet er tomt, men der står kopper og service fra sidste møde.\n"
                + "Sikke et rod!", false, null, null)); //boolean med oprydning. der kommer en ind, skal hun have hjælp eller ej

        meetingRooms.add(new Room(
                "Projektgruppen sidder i mødelokalet. Vil du forsøge at forsinke dem i at\n"
                + "nå fiskefileterne i kantinen?", false, null, null)); //mulige actions

        //Adding specialrooms to<>specialrooms, randomly placed later
        specialRooms.add(new Room(
                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren\n"
                + "Phillipa.", false, null, null)); //bliver sur, flov ect

        specialRooms.add(new Room(
                "Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med\n"
                + "hende Alice fra regnskabsafdelingen?\"", false, null, null)); //hans reaktion

        specialRooms.add(new Room(
                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen\n"
                + "lige foran ham den arrogante fra din afdeling. Da du når frem til fadet\n"
                + "er der kun 4 fiskefileter tilbage. Du snupper alle 4!", true, null, null));

        //Adding rooms(Inde1-5)
        addOfficeRoom();
        addRestRoom(rooms, restRooms);
        addMeetingRoom(rooms, meetingRooms);
        addOfficeRoom();
        addRestRoom(rooms, restRooms);

        //Adding rooms(Inde6-10)
        addMeetingRoom(rooms, meetingRooms);
        addCopyRoom(rooms, copyRooms);
        addRestRoom(rooms, restRooms);
        addOfficeRoom();
        addCopyRoom(rooms, copyRooms);

        //Adding rooms(Inde11-15)
        addOfficeRoom();
        addSpecialRoom(rooms, specialRooms);
        addOfficeRoom();
        addRestRoom(rooms, restRooms);
        addOfficeRoom();

        //Adding rooms(Inde16-19)
        addOfficeRoom();
        addSpecialRoom(rooms, specialRooms);
        addSpecialRoom(rooms, specialRooms);
        addMeetingRoom(rooms, meetingRooms);

        return rooms;
    }

    /**
     * Creates maze by setting which rooms can be accessed by which other rooms
     *
     * @param rooms
     */
    private void createAccess(ArrayList<Room> rooms) {

        rooms.get(0).setNorth(rooms.get(1));

        rooms.get(1).setEast(rooms.get(2));
        rooms.get(1).setWest(rooms.get(4));
        rooms.get(1).setSouth(rooms.get(0));

        rooms.get(2).setWest(rooms.get(1));
        rooms.get(2).setNorth(rooms.get(10));
        rooms.get(2).setEast(rooms.get(3));

        rooms.get(3).setWest(rooms.get(2));

        rooms.get(4).setWest(rooms.get(5));
        rooms.get(4).setNorth(rooms.get(8));
        rooms.get(4).setEast(rooms.get(1));

        rooms.get(5).setNorth(rooms.get(7));
        rooms.get(5).setSouth(rooms.get(6));
        rooms.get(5).setEast(rooms.get(4));

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
        rooms.get(15).setSouth(rooms.get(9));

        rooms.get(16).setWest(rooms.get(15));
        rooms.get(16).setEast(rooms.get(17));

        rooms.get(17).setWest(rooms.get(16));

        rooms.get(18).setSouth(rooms.get(14));

        rooms.get(19).setSouth(rooms.get(13));

    }

}
