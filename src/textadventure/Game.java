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

//        for (int i = 0; i < 20; i++) {
//            rooms.add(new Room());
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));
        rooms.add(new Room("descriptiont bla bla", false));

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
