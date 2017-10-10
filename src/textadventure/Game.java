package textadventure;

import java.util.ArrayList;
import textio.*;

public class Game {
    private TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();
            
    public Game() {
        
    }

    public void play() {
        io.put(startGame());
        io.put("Indtast navn:");
        String name = io.get();
        io.put("Hej " + name + ", velkommen til Firma & Fiskefilet\n");
        
        createRooms();
    }
    
    public String startGame() {
        return "****************************************************************\n"
                + "** Det er lige blevet frokost, og det er fiskedag.\n"
                + "** Du skal finde vej til kantinen inden alle fiskefileterne er udsolgt.\n"
                + "** Alt det andet fisk lugter, derfor er det vigtigt du får fiskefilet\n"
                + "** til frokost i dag\n"
                + "****************************************************************\n";
    }
    
    public void createRooms() {
        
        for (int i = 0; i < 20; i++) {
            rooms.add(new Room());
        }
        
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
