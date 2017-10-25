/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.ArrayList;

/**
 *
 * @author thomasfritzboger
 */
public class Maze
{
     private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Room> officeRooms = new ArrayList<>();
    private ArrayList<Room> specialRooms = new ArrayList<>();
    private ArrayList<Room> copyRooms = new ArrayList<>();
    private ArrayList<Room> meetingRooms = new ArrayList<>();
    private ArrayList<Room> restRooms = new ArrayList<>();
    
    
    public Maze()
    {
        
    }
    
    private void addOfficeRoom()
    {
        int removeIndex = (int) (Math.random() * officeRooms.size());
        rooms.add(officeRooms.get(removeIndex));
        officeRooms.remove(removeIndex);
    }

    private void addSpecialRoom(ArrayList<Room> rooms, ArrayList<Room> specialRooms)
    {
        int removeIndex = ((int) (Math.random() * specialRooms.size()));
        rooms.add(specialRooms.get(removeIndex));
        specialRooms.remove(removeIndex);
    }

    private void addCopyRoom(ArrayList<Room> rooms, ArrayList<Room> copyRooms)
    {
        int removeIndex = ((int) (Math.random() * copyRooms.size()));
        rooms.add(copyRooms.get(removeIndex));
        copyRooms.remove(removeIndex);
    }

    private void addMeetingRoom(ArrayList<Room> rooms, ArrayList<Room> meetingRooms)
    {
        int removeIndex = ((int) (Math.random() * meetingRooms.size()));
        rooms.add(meetingRooms.get(removeIndex));
        meetingRooms.remove(removeIndex);
    }

    private void addRestRoom(ArrayList<Room> rooms, ArrayList<Room> restRooms)
    {
        int removeIndex = ((int) (Math.random() * restRooms.size()));
        rooms.add(restRooms.get(removeIndex));
        restRooms.remove(removeIndex);
    }

    
    public ArrayList<Room> createRooms()
    {
        //Adding starting position, always rooms(index0)
        rooms.add(new Room(
                "Du sidder på dit kontor. Du kigger på uret og opdager,\n"
                + "at du er sent på den. WTF! FISKEDAG! Bare der er\n"
                + "fiskefilet tilbage, når du når kantinen", false, 0));

        //Adding offices to <>officerooms, randomly placed later        
        officeRooms.add(new Room(
                "Du bliver kort blændet af en kontorlampe, som peger\n"
                + "lige mod døråbningen. Du ser en gammel dame. SHHH!!\n"
                + "Det må være hende de omtaler som \"blinde, snaksaglige,\n"
                + "pensionsparate Ruth\". Forundret over "
                + "hvorfor en blind har lys tændt, (((lister du videre for at undgå at hun hører dig)))", false, 1));

        officeRooms.add(new Room(
                "Rummet er tomt, men Phillipa har glemt sin håndtaske. (((Du bliver nysgerrig eller !)))", false, 6));

        officeRooms.add(new Room(
                "Du kommer til at vade ind i IT-lokalet, hvor alle nørderne sidder.\n"
                + "De snakker ikke om andet end Rick & Morty og hvordan Heroes 3 var\n"
                + "det bedste i serien.(((miste runde, energi)))", false, 7));

        officeRooms.add(new Room(
                "Det var ikke kantinen det her, men du finder tilgengæld\n"
                + "kiks og kaffe til at lette sulten lidt (((+ runder)))", false, 4));

        officeRooms.add(new Room(
                "Tine er ved at skrive en indkøbsseddel, da hun skal have gæster.\n"
                + "Hun undskylder sig dog med, at hun skal bruge det til et IT-program", false, 10));

        officeRooms.add(new Room(
                "Du kommer ind i tekøkkenet, hvor du kan se Thomas har efterladt\n"
                + "sin Red Bull. Den napper du selvfølgelig (((runde)))", false, 12));

        officeRooms.add(new Room(
                "Tobias sidder med sit seneste blad om 3d-gaming, men du ved at han burde\n"
                + "lave oplæg om et nyt TAG-koncept", false, 16));
        
         //Adding copyrooms to <>copyrooms, randomly placed later 

        copyRooms.add(new Room(
                "Døren knirker som du åbner den. Et kopirum! Det burde\n "
                + "du have set komme. Især fordi det var en glasdør.", false, 2));

        copyRooms.add(new Room(
                "Kopimaskinen summer stadig. Den er åbenbart lige blevet færdig.\n"
                + "Du går nysgerrigt over og kigger i de udskrevne papirer. Det er\n"
                + "chefens oplæg til spareforslag 😮 Du er nødt til at se om dit\n"
                + "navn står på listen. Det koster en runde ekstra", false, 8));
        
         //Adding restrooms to <>restrooms, randomly placed later 

        restRooms.add(new Room(
                "Ups! Dametoilettet. Der hænger en klam stank i luften.\n"
                + "Det må være Ruth, som har været i gang. (((Boolean om der er nogen derude)))", false, 3));

        restRooms.add(new Room(
                "Pedersen er på vej ud fra toilettet. Han vasker ikke fingre!\n"
                + "Slut med at give ham hånden.", false, 11));

        restRooms.add(new Room(
                "Du kommer ind på herretoilettet. Du skal simpelthen tisse så meget,\n"
                + "at fiskefileterne må vente lidt. Du åbner toiletdøren, men ser at Ronnie\n"
                + "har glemt at låse døren! Du mister en runde", false, 13));

        restRooms.add(new Room(
                "Lisette står og pudrer næse. Hun opdager dig og langer dig en syngende lussing (((miste runde)))", false, 18));
        
        //Adding meetingrooms to<>meetingrooms, randomly placed later

        meetingRooms.add(new Room(
                "Du træder ind i et lokale, hvor et vigtigt møde med en potentiel\n"
                + "kunde er i gang. Du bliver nødt til at lade som om, at du er en sekretær", false, 5));

        meetingRooms.add(new Room(
                "Mødelokalet er tomt, men der står kopper og service fra sidste møde.\n"
                + "Sikke et rod!(((boolean med oprydning. der kommer en ind, skal hun have hjælp eller ej)))", false, 15));

        meetingRooms.add(new Room(
                "Projektgruppen sidder i mødelokalet. Vil du forsøge at forsinke dem i at\n"
                + "nå fiskefileterne i kantinen? (((Muligheder actions))", false, 19));
        
        //Adding specialrooms to<>specialrooms, randomly placed later

        specialRooms.add(new Room(
                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren\n"
                + "Line. Chefen ser, at du opdager dem flirte. (((bliver han sur, flov ect)))", false, 9));

        specialRooms.add(new Room(
                "Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med\n"
                + "hende Alice fra regnskabsafdelingen?\"(((hans reaktion))) ", false, 14));

        specialRooms.add(new Room(
                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen\n"
                + "lige foran ham den arrogante fra din afdeling. Da du når frem til fadet\n"
                + "er der kun 4 (((dependant on rounds left))) fiskefileter tilbage. Du snupper alle 4!", true, 17));
        
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
        
    
        
        //Setting possible ways to access rooms
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
        
        return rooms;
    }
}