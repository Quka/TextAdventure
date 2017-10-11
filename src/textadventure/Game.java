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
        io.put("Write direction (e/s/w/n) or h for help");
        p.walk(io.get());
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

        rooms.add(new Room("Your office, ......", false, 0));
        rooms.add(new Room("Employee office1", false, 1));
        rooms.add(new Room("Copy room1", false, 2));
        rooms.add(new Room("Womens restroom2", false, 3));
        rooms.add(new Room("Employee office4", false, 4));
        rooms.add(new Room("Meeting3", false, 5));
        rooms.add(new Room("Employee office6", false, 6));
        rooms.add(new Room("Employee office7", false, 7));
        rooms.add(new Room("Copy room2", false, 8));
        rooms.add(new Room("Executive office", false, 9));
        rooms.add(new Room("Employee office8", false, 10));
        rooms.add(new Room("Mens restroom2", false, 11));
        rooms.add(new Room("Employee office3", false, 12));
        rooms.add(new Room("Mens restroom1 ", false, 13));
        rooms.add(new Room("Janitor room", false, 14));
        rooms.add(new Room("Meetingroom2", false, 15));
        rooms.add(new Room("Employee office2", false, 16));
        rooms.add(new Room("Canteen ....", true, 17));
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
