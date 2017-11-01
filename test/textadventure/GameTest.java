
package textadventure;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import textadventure.Characters.Monster;
import textadventure.Item.Item;
import textadventure.Item.UsableItem;


public class GameTest
{

    @Test
    public void testPlay() {
    }

    @Test
    public void testCommand() {
    }

    @Test
    public void testClear() {
    }

    @Test
    public void testPrettyMessage() {
        Game game = new Game();
        Monster monster = new Monster("test", -4, null, null, "Dette er en test beskrivelse nam nam");
        Item item = new UsableItem("Mælk", 
                "Praesent elementum tincidunt risus eget cursus. Maecenas eleifend accumsan felis, et commodo turpis vestibulum eu. Vestibulum tellus nisi, elementum nec ligula eget, congue luctus nisi. Sed ante turpis, lacinia at tortor at, semper suscipit magna."
        );
        
        System.out.println(game.prettyMessage(item.getDescription(), "Monster"));
    }
    
    
}
