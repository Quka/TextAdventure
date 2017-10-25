package textadventure;

import textadventure.Characters.Monster;
import textadventure.Characters.Player;
import java.util.ArrayList;
import textio.*;

public class Game {

    private TextIO io = new TextIO(new SysTextIO());
    private Player p;
    private Monster monster;
    private Maze m;

    public Game() {

    }

    public void play() {
        io.put(startGame());
        io.put("Hvad hedder du, arbejdstager?");
        String name = io.get();
        io.clear();
        io.put("Hej " + name + ", velkommen til Firma & Fiskefilet\n"
                + "Husk at du altid kan skrive h for hjælp\n"
                + "-----------------------------------------\n");
        
        // Setup rooms for the maze
        m = new Maze();
        ArrayList<Room> rooms = m.createRooms();
        
        // Initialize characters
        p = new Player(name, rooms.get(0));
        monster = new Monster("Chefen", rooms.get(11));

        io.put(p.getCurrentRoom().getDescription() + "\n");
        boolean gameEnded = false;
        while (!gameEnded) {

            // Get a command from user
            command();
            
            // Move monster
            

            if (p.getCurrentRoom().isWinGame() == true) {
                //io.put(p.getCurrentRoom().getDescription());
                gameEnded = true;
            }
            if (p.getRoundsLeft() < 1) {
                gameEnded = true;
                io.clear();
                io.put("\nDu var for langsom. Alle fiskefiletterne er væk.\n"
                        + "Du må hjem og se om mor har fiskefiletter i fryseren :(\n");
            }
        }
        io.clear();
        io.put("Spillet er slut! ");
    }

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
                    p.changeRounds(-3);
                    io.clear();
                    io.put(p.getCurrentRoom().getDescription());
                } else {
                    io.put("Der er ingen dør i den retning. Prøv igen!\n");
                    p.changeRounds(-1);
                }
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                io.put("Du har afsluttet spillet");
                System.exit(0);
                break;
            case "T":
                io.put("" + p.getRoundsLeft());
                break;
            case "PICK UP":
                break;
            default:
                io.put("Det er ikke en gyldig kommando!\n"
                        + "Du kan altid skrive h for hjælp.\n");
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
                + "T - for at se resterende runder\n"
                + "Q - for at afslutte spillet\n";
        io.clear();
        io.put(str);
    }
}
