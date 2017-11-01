package textadventure;

import textadventure.Characters.Boss;
import textadventure.Characters.Monster;
import textadventure.Characters.Player;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Inventory i;  // Inventory oprettes
    private int[] highScore = new int[5];

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
        boss = new Boss("Chefen", rooms.get(12));

        h = new HighScore();
        h.loadHighScoresFromFile();
        io.put(h.getHighScores());
        
        i = new Inventory();
        

        io.put(p.getCurrentRoom().getDescription());
        boolean gameEnded = false;
        while (!gameEnded) {

            // Get a command from user
            command();

            if (p.getCurrentRoom().equals(boss.getCurrentRoom())) {
                // # Brug item her / mist liv
                System.out.println(clear() + "Monster og spiller i samme rum. Du dør");
                p.changeRounds(-p.getRoundsLeft()); //Sætter p spillerunder til 0, så spiller "dør"
            }
            //Delete == true?
            if (p.getCurrentRoom().isWinGame() == true) {
                //io.put(p.getCurrentRoom().getDescription());
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
     * Text (String) shown when starting game
     *
     * @return
     */
    private void startGame() {
        io.put("\n********************************************************\n"
                + "***************    FIRMA & FISKEFILET    ***************\n"
                + "********************************************************\n\n"
                + "********************************************************\n"
                + "** Det er lige blevet frokost, og det er fiskedag.    **\n"
                + "** Du skal finde vej til kantinen inden alle fiske-   **\n"
                + "** fileterne er udsolgt. Alt det andet fisk lugter og **\n"
                + "** smager dårligt. Derfor er det vigtigt, at du gør   **\n"
                + "** dit bedste for at få fiskefilet til frokost i dag  **\n"
                + "********************************************************\n");
        io.put("Hvad hedder du, arbejdstager?");
        this.name = io.get();
        io.put(clear());
        io.put("Hej " + name + ", velkommen til Firma & Fiskefilet\n"
                + "Husk at du altid kan skrive h for hjælp\n"
                + "-----------------------------------------\n");
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
             
            case "I":  // show inventory
            io.put(Arrays.toString(i.showInventory()));
             break;
             
             
            //       Her noget med consume Item         
            //                
            //case "C":
            //   p.getConsumableItem();
            //if (p.getConsumableItem == null)
            //     {
            //          io.put("Der er ikke noget, at putte i munden, du bider dig i fingrene!);
            //           p.changeRounds(-2);
            //     }
            //else 
            //     {
            //      io.put("Du putter " + p.getConsumableItem + " i munden! Du får " + p.getConsumableItem.getBonus 
            //              + " ekstra runder");
            //      items.remove(p.getConsumableItem());
            //       
            //       p.changeRounds(-1);
            //     }
            //     break;    
            // Skal nok være noget andet, da vi jo enten consumer eller user items??
             
             
            case "U":
                
                
               io.put(Arrays.toString(i.showInventory())+"\nHvilket item vil du bruge?\n");
                 int itemIndex = Integer.parseInt(io.get ());
             
            if (p.getCurrentRoom().equals(boss.getCurrentRoom()) && boss.getIfBossHappy()==false)
            {
                //To be done
            }
            
           
            if (p.getCurrentRoom().getMonster() == null 
                    || !boss.getCurrentRoom().equals(p.getCurrentRoom())
                    || p.getCurrentRoom().getMonster().getDropItem()==null
                    || boss.getIfBossHappy()==true)
                {
                      io.put("Der er ikke nogen, at bruge et Item imod");
                      p.changeRounds(-1);
                }
            
            
            else if (!p.getCurrentRoom().getMonster().getNeutralizingItem().equals(i.getItem(itemIndex)))
                {
                   io.put("Denne Item har ingen effekt!");
                   p.changeRounds(p.getCurrentRoom().getMonster().getPenalty());
                   io.put("Du mister " + p.getCurrentRoom().getMonster().getPenalty() + " runder");
                   
                }
            else 
                {
                   io.put("Du gør " + p.getCurrentRoom().getMonster().getDecription() 
                           + " glad! Du får " + p.getCurrentRoom().getMonster().getDropItem().toString() 
                         + ", som du putter i din rygsæk");
                  i.removeItemFromInventory(itemIndex);
                  i.addToInventory(p.getCurrentRoom().getMonster().getDropItem());
                  p.getCurrentRoom().getMonster().setDropItemToNull();
                  p.getCurrentRoom().getMonster().setPenalty(0);
                  p.changeRounds(-1);
                }
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
     * Menu showing the player which actions they can perform. Is shown when user
     * is entering "h"
     */
    private void helpMenu() {
        String str = "\nDu har følgende muligheder: \n"
                + "E - for at gå mod øst\n"
                + "S - for at gå mod syd\n"
                + "W - for at gå mod vest\n"
                + "N - for at gå mod nord\n"
                + "H - for hjælp\n"
                + "D - for at smide en ting i et rum\n"
                + "P - for at samle en ting op i et rum\n"
                + "T - for at se resterende runder\n"
                + "Q - for at afslutte spillet\n";
        io.put(clear());
        io.put(str);
    }

    private void changeRoom(String command) {
        if (p.canWalk(command)) {
            p.walk(command);
            p.changeRounds(-3);
            io.put(clear());
            io.put(p.getCurrentRoom().getDescription());
            // # io put boss description hvis den findes
            
            // # io put item description hvis den findes

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
            p.pickupItem( p.getCurrentRoom().getItem() );
            p.getCurrentRoom().removeItemFromRoom();
            p.changeRounds(-1);
        }
    }

    public String clear() {
        return "\n\n\n";
    }
}
