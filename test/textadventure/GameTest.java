package textadventure;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import textadventure.Characters.Monster;
import textadventure.Characters.Player;
import textadventure.Item.Item;
import textadventure.Item.UsableItem;

public class GameTest {
    

    @Test
    public void testShowInventory() {
        Inventory i = new Inventory();
        ItemList il = new ItemList();
        
        i.addToInventory(il.getItem(0));
        i.addToInventory(il.getItem(1));
        i.addToInventory(il.getItem(2));
        i.addToInventory(il.getItem(3));
        
//        System.out.println(
//                i.showInventory()
//        );
    }

    @Test
    public void testPrettyMessage() {
        Game game = new Game();
        ItemList il = new ItemList();

//        System.out.println(game.prettyMessage(il.getItem(0).getDescription(), "Item"));
//        System.out.println(game.prettyMessage(il.getItem(1).getDescription(), "Monster"));
//        System.out.println(game.prettyMessage(il.getItem(2).getDescription(), "Monsterd"));
//        System.out.println(game.prettyMessage(il.getItem(3).getDescription(), "Monsterdu"));
    }

}
