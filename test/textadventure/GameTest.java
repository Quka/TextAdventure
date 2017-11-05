package textadventure;

import textadventure.Item.ItemList;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import textadventure.Characters.Boss;
import textadventure.Characters.Player;

public class GameTest {

    Game game;
    Inventory i;
    ItemList il;
    Maze maze;
    ArrayList<Room> rooms;

    @Before
    public void setUp() {
        game = new Game();
        il = new ItemList();
        i = new Inventory();
        maze =  new Maze(il);
        rooms = maze.createMaze();
    }

    @Test
    public void testShowInventory() {
        Inventory i = new Inventory();
        ItemList il = new ItemList();

        i.addToInventory(il.getItem(0));
        i.addToInventory(il.getItem(1));
        i.addToInventory(il.getItem(2));
        i.addToInventory(il.getItem(3));

        /*
        System.out.println(
                i.showInventory()
        );
         */
    }

    @Test
    public void testPrettyMessage() {

        /*
        System.out.println(game.prettyMessage(il.getItem(0).getDescription(), "Item"));
        System.out.println(game.prettyMessage(il.getItem(1).getDescription(), "Monster"));
        System.out.println(game.prettyMessage(il.getItem(2).getDescription(), "Monsterd"));
        System.out.println(game.prettyMessage(il.getItem(3).getDescription(), "Monsterdu"));
         */
    }

}
