package textadventure;

import java.util.ArrayList;
import textio.*;

public class Game {

    private TextIO io = new TextIO(new SysTextIO());
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
                    p.removeRounds(3);
                    io.put(p.getCurrentRoom().getDescription());
                } else {
                    io.put("Der er ingen dør i den retning. Prøv igen!\n");
                    p.removeRounds(1);
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
}
