package textadventure;

import textadventure.Characters.*;
import java.util.ArrayList;
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
    private int[] highScore = new int[5];
    private ItemList itemList;

    public Game() {
        this.itemList = new ItemList();
    }

    /**
     * GameController. Is responsible for calling methods and starting and
     * ending the game
     *
     */
    public void play() {
        //Writes to console and get players name
        startGame();
        // Setup rooms for the maze and initializes players
        m = new Maze(itemList);
        ArrayList<Room> rooms = m.createMaze();
        p = new Player(name, rooms.get(0));
        boss = new Boss(
                "Chefen",
                -12,
                itemList.getItem(12),
                itemList.getItem(0),
                "Du kan mærke en skummel tilstedeværelse. Det er chefen der vandrer igen, "
                + "fordi han nok har glemt en rapport om angående nogle konsulenter eller noget",
                rooms.get(12)
        );

        h = new HighScore();
        io.put(("\nHighscores:\n" + h.printScores()));

        io.put(
                clear()
                + prettyMessage(p.getCurrentRoom().getDescription(), "Introduktion")
        );
        boolean gameEnded = false;
        while (!gameEnded) {

            // Get a command from user
            io.put(
                    clear()
                    + "Hvad vil jeg gøre nu: (H for hjælp)"
            );
            String command = io.get().toUpperCase();
            command(command);

            if (p.getCurrentRoom().equals(boss.getCurrentRoom())) {
                System.out.println(clear() + "Chefen og spiller i samme rum.");
            }
            if (p.getCurrentRoom().isWinGame()) {
                gameEnded = true;
                h.addScore(new Score(p.getName(), p.getRoundsLeft()));
                h.saveHighScoresToFile(5);
                io.put((h.printScores()));
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
        String introBody = "Det er lige blevet frokost, og det er fiskedag. Du skal finde vej"
                + " til kantinen inden alle fiskefileterne er udsolgt. Alt det andet fisk lugter"
                + " og smager dårligt. Derfor er det vigtigt, at du gør dit bedste for at få"
                + " fiskefilet til frokost i dag.";
        io.put(
                introHeader
                + prettyMessage(introBody, "Velkommen")
                + clear()
                + "Hvad hedder du, arbejdstager?");

        this.name = io.get();
        if (name.contains(",")) {
            name = name.replaceAll(",", "");

        }

        io.put(clear());
        io.put(
                "\u001B[30m=============================================\n"
                + "\u001B[30mHej " + name + ", velkommen til Firma & Fiskefilet\n"
                + "\u001B[30mHusk at du altid kan skrive \u001B[31mH \u001B[0mfor hjælp\n"
                + "\u001B[30m=============================================\n"
        );
    }

    /**
     * Takes commands from user and reacts accordingly
     *
     * @param command
     */
    public void command(String command) {

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
                showInventory();
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
        String str = "Du har følgende muligheder: \n"
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

    /**
     * Walks in the direction if it is possible. For now, this commans also fights the boss and monsters
     * 
     * @param command 
     */
    private void changeRoom(String command)
    {
        if (p.canWalk(command))
        {
            p.walk(command);
            p.changeRounds(-3);

            io.put(
                    clear()
                    + prettyMessage(p.getCurrentRoom().getDescription(), "Rum")
            );

            if (p.getCurrentRoom().equals(boss.getCurrentRoom())) {
                io.put(clear() + "Chefen og spiller i samme rum.");
                if (boss.getPenalty() == 0) {
                    io.put(
                            clear()
                            + prettyMessage("Du støder på " + boss.getName() + ". "
                                    + boss.getName()
                                    + " er i godt humør. Han hilser pænt på dig og lover dig en lønforhøjelse.", "Chefen")
                    );

                } else {
                    io.put(
                            clear()
                            + prettyMessage(boss.getDescription(), "BOSS: Chefen")
                            + "Vil du forsøge at brugen et item mod Chefen?\n(Tryk \"u\" for at bruge et item!)");
                    if (io.get().equalsIgnoreCase("u")) {
                        useItem();
                    } else {
                        p.changeRounds(p.getCurrentRoom().getMonster().getPenalty());
                    }
                }
            }
            if (p.getCurrentRoom().getMonster() != null) {

                if (p.getCurrentRoom().getMonster().getPenalty() == 0) {
                    io.put(
                            clear()
                            + prettyMessage("Du støder på " + p.getCurrentRoom().getMonster().getName() + ". "
                                    + p.getCurrentRoom().getMonster().getName()
                                    + " er i godt humør og hilser pænt på dig", "Monster: " + p.getCurrentRoom().getMonster().getName())
                    );
                } else {
                    io.put(
                            clear()
                            + prettyMessage(
                                    p.getCurrentRoom().getMonster().getDescription()
                                    + "(" + p.getCurrentRoom().getMonster().getPenalty() + ")",
                                    "Monster: " + p.getCurrentRoom().getMonster().getName())
                    );

                    io.put("Vil du forsøge at brugen et item mod " + p.getCurrentRoom().getMonster().getName()
                            + "? \n(Tryk \"U\" for at bruge et item, eller \"N\" for at gå videre)");
                    if (io.get().equalsIgnoreCase("u")) {
                        useItem();
                    } else {
                        p.changeRounds(p.getCurrentRoom().getMonster().getPenalty());
                    }
                }
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
/**
 * Player(should be under player?) can pick up an item from the room. If there
 * is no item, io.put message is displayed
 * 
 */
    private void pickup()
    {
        if (p.getCurrentRoom().getItem() == null)
        {
            io.put("Der er ikke noget at samle op! (-1 runde)");
            p.changeRounds(-1);
        } else {
            io.put(
                    clear()
                    + prettyMessage(
                            p.pickupItem(p.getCurrentRoom().getItem()),
                            p.getCurrentRoom().getItem().getName()
                    )
            );
            p.getCurrentRoom().removeItemFromRoom();
        }
    }
/**
 * Makes 2 lines
 * 
 * @return 
 */
    public String clear()
    {
        return "\n\n";
    }

    /**
     * Heart of the program. Surrounds text with a graphical box. Special shout-
     * out to Arlind for making this happen.
     * 
     * @param str
     * @param title
     * @return 
     */
    public String prettyMessage(String str, String title)
    {
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
/**
 * Shows user the inventory
 * 
 */
    private void showInventory()
    {
        io.put(
                p.getInventory().showInventory()
        );
    }
/**
 * Player (should be under player?) can use an item against a monster. Wholesome
 * method that also checks if it effective and removes it from inventory if true 
 * 
 */
    private void useItem()
    {
        if (p.getInventory().getInventorySize() == 0)
        {
            io.put("Lommerne er tomme kammerat, du skal finde noget, du kan gemme først");
        } else {
            io.put(p.getInventory().showInventory() + "\nHvilket item vil du bruge? Eller \"L\" for at lukke\n");
            if (io.get().equalsIgnoreCase("L")) {
                io.put("Du vælger ikke at bruge et item");
            } else {
                int itemIndex = io.getInteger(0, p.getInventory().getInventorySize() - 1);
                if (p.getCurrentRoom().equals(boss.getCurrentRoom()) && boss.getPenalty() != 0) {

                    if (p.getItem(itemIndex) == boss.getNeutralizingItem()) {
                        boss.setPenalty(0);
                        io.put("Chefen skuler, men skynder sig at tage rapporten!\n");
                        p.getInventory().removeItemFromInventory(itemIndex);
                    } else {
                        io.put("Dette item har ingen effekt!");
                        p.changeRounds(boss.getPenalty());
                        io.put("Du mister " + boss.getPenalty() + " runder!");
                    }

                }
                if (p.getCurrentRoom().getMonster() == null
                        || p.getCurrentRoom().getMonster().getPenalty() == 0) {
                    io.put("Der er ikke nogen tilbage at bruge et item imod");
                    p.changeRounds(-1);
                } else if (!p.getCurrentRoom().getMonster().getNeutralizingItem().equals(p.getInventory().getItem(itemIndex))) {
                    io.put("Dette item har ingen effekt!");
                    p.changeRounds(p.getCurrentRoom().getMonster().getPenalty());
                    io.put("Du mister " + p.getCurrentRoom().getMonster().getPenalty() + " runder");

                } else if (p.getCurrentRoom().getMonster().getNeutralizingItem().equals(p.getInventory().getItem(itemIndex))) {
                    io.put("Du gør " + p.getCurrentRoom().getMonster().getName()
                            + " glad! \n");
                    if (p.getCurrentRoom().getMonster().getDropItem() != null) {
                        io.put("Du får " + p.getCurrentRoom().getMonster().getDropItem().toString());
                        p.getInventory().addToInventory(p.getCurrentRoom().getMonster().getDropItem());
                    }
                    p.getInventory().removeItemFromInventory(itemIndex);

                    p.getCurrentRoom().getMonster().setDropItemToNull();
                    p.getCurrentRoom().getMonster().setPenalty(0);
                    p.changeRounds(-1);
                } else {
                    io.put("Hvad gør du nu?");
                }
            }
        }
    }
}
