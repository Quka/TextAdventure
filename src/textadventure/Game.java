package textadventure;

import textadventure.Characters.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import textio.*;

/**
 * Game class is responsible for the game
 *
 * @author Group 7
 */
public class Game {

    private TextIO io = new TextIO(new SysTextIO());
    private Player p;
    private String name;
    private Boss boss;
    private Maze m;
    private Monster monster;
    private HighScore h;
    private Inventory i;
    private int[] highScore = new int[5];
    private ItemList itemList = new ItemList();

    /**
     * Constructs a new Game
     *
     */
    public Game() {

    }

    /**
     * GameController. Is responsible for calling methods and starting and
     * ending the game
     *
     */
    public void play() {
        //Writes to console and get players name
        startGame();
        // Setup rooms for the maze
        m = new Maze();
        ArrayList<Room> rooms = m.createMaze();

        // Initialize characters
        p = new Player(name, rooms.get(0));
        boss = new Boss("Chefen", -12, itemList.getItem(12), itemList.getItem(0), "", rooms.get(12));

        h = new HighScore();
        h.loadHighScoresFromFile();
        io.put(h.getHighScores());

        i = new Inventory();

        io.put(
                prettyMessage(p.getCurrentRoom().getDescription(), "Introduktion")
        );
        boolean gameEnded = false;
        while (!gameEnded) {

            // Get a command from user
            command();

            if (p.getCurrentRoom().equals(boss.getCurrentRoom())) {
                // # Brug item her / mist liv
                System.out.println(clear() + "Monster og spiller i samme rum.");
            }
            //Delete == true?
            if (p.getCurrentRoom().isWinGame()) {
                gameEnded = true;
                h.sortHighScores(p.getRoundsLeft());
                h.saveHighScoresToFile();
                io.put(h.getHighScores());
            }
            if (p.getRoundsLeft() < 1) {
                gameEnded = true;
                io.put(clear());
                io.put("Du var for langsom. Alle fiskefiletterne er væk.\n"
                        + "Du må hjem og se om mor har fiskefiletter i fryseren :(\n");
            }
        }
        io.put(clear());
        io.put("Spillet er slut!");
    }

    /**
     * Text (String) shown when starting game and getting player name
     *
     * @return
     */
    private void startGame() {
        String introHeader = "\n*****************************************************\n"
                + "**************    FIRMA & FISKEFILET    *************\n"
                + "*****************************************************\n\n";
        String introBody = "Det er lige blevet frokost, og det er fiskedag. Du skal finde vej til kantinen inden alle fiskefileterne er udsolgt. Alt det andet fisk lugter og smager dårligt. Derfor er det vigtigt, at du gør dit bedste for at få fiskefilet til frokost i dag.";
        io.put(
                introHeader
                + prettyMessage(introBody, "Velkommen")
                + clear()
                + "Hvad hedder du, arbejdstager?"
        );

        this.name = io.get();

        io.put(
                clear()
                + "Hej " + name + ", velkommen til Firma & Fiskefilet\n"
                + "Husk at du altid kan skrive h for hjælp\n"
                + "-----------------------------------------\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Takes commands from user and reacts accordingly
     *
     */
    public void command() {
        String command = io.get().toUpperCase();

        switch (command) {
            case "N":
            case "E":
            case "S":
            case "W":
                changeRoom(command);
                break;
            case "H":
                helpMenu();
                break;
            case "I":
                io.put(Arrays.toString(i.showInventory()));
                break;
            case "U":
                useItem();
                break;
            case "Q":
                io.put("Du har afsluttet spillet");
                System.exit(0);
                break;
            case "T":
                io.put("Du har " + p.getRoundsLeft() + " runder tilbage!");
                break;
            case "P":
                pickup();
                break;
            default:
                io.put("Det er ikke en gyldig kommando!\n"
                        + "Du kan altid skrive h for hjælp.\n");
                break;
        }
    }

    /**
     * Menu showing the player which actions they can perform. Is shown when
     * user is entering "h"
     */
    private void helpMenu() {
        String str = "\nDu har følgende muligheder: \n"
                + "E - for at gå mod øst\n"
                + "S - for at gå mod syd\n"
                + "W - for at gå mod vest\n"
                + "N - for at gå mod nord\n"
                + "H - for at få hjælp\n"
                + "I - for at se dit inventory\n"
                + "U - for at bruge et item fra dit inventory\n"
                + "P - for at samle et item op fra rummet\n"
                + "T - for at se resterende runder\n"
                + "Q - for at afslutte spillet\n";
        io.put(clear());
        io.put(str);
    }

    private void changeRoom(String command) {
        if (p.canWalk(command)) {
            p.walk(command);
            p.changeRounds(-3);

            io.put(
                    clear()
                    + prettyMessage(p.getCurrentRoom().getDescription(), "Rum")
            );

            if (p.getCurrentRoom().getMonster() != null) {
                io.put(
                        clear()
                        + prettyMessage(
                                "Du støder på " + p.getCurrentRoom().getMonster().getName() + ". "
                                + p.getCurrentRoom().getMonster().getName() + " giver dig tæsk ("
                                + p.getCurrentRoom().getMonster().getPenalty() + ")", "Monster")
                );
            }

            if (p.getCurrentRoom().getItem() != null) {
                io.put(
                        clear()
                        + prettyMessage(p.getCurrentRoom().getItem().getDescription(), "Item")
                );
            }

            // Move boss, only if user also moves (issues move command)
            boss.moveMonster();
        } else {
            io.put("Der er ingen dør i den retning. Prøv igen!");
            p.changeRounds(-1);
        }

    }

    private void pickup() {
        if (p.getCurrentRoom().getItem() == null) {
            io.put("Der er ikke noget at samle op!");
            p.changeRounds(-1);
        } else {
            p.pickupItem(p.getCurrentRoom().getItem());
            p.getCurrentRoom().removeItemFromRoom();
            p.changeRounds(-1);
        }
    }

    public String clear() {
        return "\n\n\n";
    }

    public String prettyMessage(String str, String title) {
        String prettyLine = "#------------------------------------------------";
        prettyLine += title.length() % 2 == 0 ? "-#" : "#"; // tilføj ekstra "-" for at flugte teksten
        int lineBreak = 39;
        int pad;
        String[] strArr = str.split(" ");
        String line = "";

        prettyLine = prettyLine.substring(0, prettyLine.length() / 2 - title.length() / 2)
                + " " + title + " "
                + prettyLine.substring(prettyLine.length() / 2 + title.length() / 2);

        String result = prettyLine + "\n";

        for (int i = 0; i < strArr.length; i++) {
            line += strArr[i] + " ";

            if (line.length() > lineBreak || i >= strArr.length - 1) {
                pad = prettyLine.length() - line.length() - 3;
                result += "| " + line.trim();

                while (pad > 0) {
                    result += " ";
                    pad--;
                }

                result += " |\n";
                line = "";
            }
        }

        result += prettyLine + "\n";

        return result;
    }

    private void useItem() {
        io.put(Arrays.toString(i.showInventory()) + "\nHvilket item vil du bruge?\n");
        int itemIndex = Integer.parseInt(io.get());

        // Check om man er i samme rum som bossen, og om bossen er sur, når man bruger item
        if (p.getCurrentRoom().equals(boss.getCurrentRoom()) && boss.getPenalty() != 0) {
            //To be done
        }

        if (p.getCurrentRoom().getMonster() == null
                || !boss.getCurrentRoom().equals(p.getCurrentRoom())
                || p.getCurrentRoom().getMonster().getDropItem() == null
                || boss.getPenalty() != 0) {
            io.put("Der er ikke nogen, at bruge et Item imod");
            p.changeRounds(-1);
        } else if (!p.getCurrentRoom().getMonster().getNeutralizingItem().equals(i.getItem(itemIndex))) {
            io.put("Denne Item har ingen effekt!");
            p.changeRounds(p.getCurrentRoom().getMonster().getPenalty());
            io.put("Du mister " + p.getCurrentRoom().getMonster().getPenalty() + " runder");

        } else {
            io.put("Du gør " + p.getCurrentRoom().getMonster().getName()
                    + " glad! Du får " + p.getCurrentRoom().getMonster().getDropItem().toString()
                    + ", som du putter i din rygsæk");
            i.removeItemFromInventory(itemIndex);
            i.addToInventory(p.getCurrentRoom().getMonster().getDropItem());
            p.getCurrentRoom().getMonster().setDropItemToNull();
            p.getCurrentRoom().getMonster().setPenalty(0);
            p.changeRounds(-1);
        }
    }

}
