package textadventure;

import textadventure.Item.ItemList;
import java.util.ArrayList;
import textadventure.Characters.MonsterList;

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
    private ItemList itemList;
    private MonsterList monsterList;

    /**
     * Constructs a maze
     *
     * @param itemList
     */
    public Maze(ItemList itemList) {
        this.itemList = itemList;
        this.monsterList = new MonsterList(itemList);

    }

    /**
     * Methos used to create a maze. Calls private methods createRoom() and
     * createAccess(rooms)
     *
     * @return
     */
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
                "Du sidder på dit kontor. Du kigger på uret og opdager, at du er sent på den. WTF! FISKEDAG! Bare der er fiskefilet tilbage, når du når kantinen. Du må hellere finde en vej ud herfra og hen til kantinen.",
                false,
                null,
                null
        ));

        //Adding offices to <>officerooms, randomly placed later        
        officeRooms.add(new Room(
                "Du bliver kort blændet af en kontorlampe, som peger lige mod døråbningen. Du ser en gammel dame.",
                false,
                monsterList.getMonster(4),
                itemList.getItem(13)
        ));

        officeRooms.add(new Room(
                "Der er ingen i rummet, men rodet afslører, at det nok er Phillipas kontor.",
                false,
                null,
                itemList.getItem(15)
        ));

        officeRooms.add(new Room(
                "Du vader ind i et lokale, som er dunkelt oplyst af små, blinkende lamper og har en stank, der siger så meget spar fem, at det kun kan være IT-lokalet. Du når lige at høre ordene \"Rick & Morty\".",
                false,
                monsterList.getMonster(6),
                itemList.getItem(7)
        ));

        officeRooms.add(new Room(
                "Det var ikke kantinen det her, men hvorfor er der så krummer på gulvet?",
                false,
                null,
                itemList.getItem(1)
        ));

        officeRooms.add(new Room(
                "Tine sidder ved sit skrivebord. Du kan se, at hun er ved at skrive en lang indkøbsseddel. Hun skal nok have gæster i aften.",
                false,
                monsterList.getMonster(0),
                itemList.getItem(18)
        ));

        officeRooms.add(new Room(
                "Du træder ind i det tekøkken, hvor Thomas plejer at opholde sig. Du ved, hvad det betyder!",
                false,
                null,
                itemList.getItem(0)
        ));

        officeRooms.add(new Room(
                "Du går ind i det nok mest intetsigende rum, som du nogensinde har set. Det er så intetsigende, at der faktisk ikke er mere at sige om det.",
                false,
                monsterList.getMonster(1),
                itemList.getItem(9)
        ));

        //Adding copyrooms to <>copyrooms, randomly placed later 
        copyRooms.add(new Room(
                "Døren knirker, som du åbner den. Et kopirum! Det burde du have set komme. Især fordi det var en glasdør.",
                false,
                null,
                itemList.getItem(19)
        ));

        copyRooms.add(new Room(
                "Kopimaskinen summer stadig. Den er åbenbart lige blevet færdig. Du går nysgerrigt over og kigger på alle de udskrevne papirer.",
                false,
                null,
                itemList.getItem(12)
        ));

        //Adding restrooms to <>restrooms, randomly placed later 
        restRooms.add(new Room(
                "Ups! Dametoilettet. Der hænger en klam stank i luften. Det må være Ruth, som har været i gang.",
                false,
                null,
                itemList.getItem(5)
        ));

        restRooms.add(new Room(
                "Pedersen er på vej ud fra toilettet. Han vasker ikke fingre! Slut med at give ham hånden.",
                false,
                monsterList.getMonster(7),
                itemList.getItem(11)
        ));

        restRooms.add(new Room(
                "Du kommer ind på herretoilettet. Du skal simpelthen tisse så meget, at fiskefileterne må vente lidt. Du åbner toiletdøren.",
                false,
                monsterList.getMonster(2),
                null
        ));

        restRooms.add(new Room(
                "Lisette står og pudrer næse på dametoilettet. Hvorfor gik du herud?",
                false,
                monsterList.getMonster(8),
                itemList.getItem(14)
        ));

        //Adding meetingrooms to<>meetingrooms, randomly placed later
        meetingRooms.add(new Room(
                "Du træder ind i et lokale, hvor et vigtigt møde med en potentiel kunde er i gang. Du bliver nødt til at lade som om, at du er en sekretær.",
                false,
                monsterList.getMonster(9),
                itemList.getItem(6)
        ));

        meetingRooms.add(new Room(
                "Mødelokalet er tomt, men der står kopper og service fra sidste møde. Sikke et rod!",
                false,
                null,
                itemList.getItem(3)
        ));

        meetingRooms.add(new Room(
                "Projektgruppen sidder i mødelokalet. Vil du forsøge at forsinke dem i at nå fiskefileterne i kantinen?",
                false,
                monsterList.getMonster(10),
                itemList.getItem(2)
        ));

        //Adding specialrooms to<>specialrooms, randomly placed later
        specialRooms.add(new Room(
                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren Phillipa.",
                false,
                monsterList.getMonster(5),
                itemList.getItem(8)
        ));

        specialRooms.add(new Room(
                "Det her ligner øjensynligt det kosteskab, Harry Potter boede i.",
                false,
                monsterList.getMonster(3),
                itemList.getItem(4)
        ));

        specialRooms.add(new Room(
                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen lige foran ham den arrogante fra din afdeling. Da du når frem til fadet er der kun 4 fiskefileter tilbage. Du snupper alle 4!",
                true,
                null,
                null
        ));

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
