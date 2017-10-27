
package textadventure;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest
{
    
    public GameTest()
    {
    }
    
    

    /**
     * Test of addSpecialRoom method, of class Game.
     */
    @Test
    public void testAddSpecialRoom()
    {
        Game game = new Game();
        Maze maze = new Maze();
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(
                "Du sidder på dit kontor. Du kigger på uret og opdager,\n"
                + "at du er sent på den. WTF! Bare der er fiskefilet\n"
                + "tilbage, når du når kantinen", false, 0));
        ArrayList<Room> specialrooms = new ArrayList<Room>();
        
        specialrooms.add(new Room(
                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren\n"
                + "Line. Chefen ser, at du opdager dem flirte.", false, 9));

        specialrooms.add(new Room(
                "Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med\n"
                + "hende Alice fra regnskabsafdelingen?\"", false, 14));

        specialrooms.add(new Room(
                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen\n"
                + "lige foran ham den arrogante fra din afdeling. Da du når frem til fadet\n"
                + "er der kun"+ 4 +"fiskefileter tilbage. Du snupper alle "+ 4 +"!", true, 17));
        
        
        maze.addSpecialRoom(rooms, specialrooms);
        
        int expected = 2;
        int actual = specialrooms.size();
        assertEquals(expected, actual);
        
        
    }
    
    @Test
    public void testAddSpecialRoomEmoveObject()
    {
        Game game = new Game();
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(
                "Du sidder på dit kontor. Du kigger på uret og opdager,\n"
                + "at du er sent på den. WTF! Bare der er fiskefilet\n"
                + "tilbage, når du når kantinen", false, 0));
        ArrayList<Room> specialrooms = new ArrayList<Room>();
        
        specialrooms.add(new Room(
                "Du vader ind på chefens kontor. På hans skrivebord sidder sekretæren\n"
                + "Line. Chefen ser, at du opdager dem flirte.", false, 9));

        specialrooms.add(new Room(
                "Viceværten sidder og swiper på Tinder. Du tænker \"er han ikke gift med\n"
                + "hende Alice fra regnskabsafdelingen?\"", false, 14));

        specialrooms.add(new Room(
                "OMG! Hvad er det syn?! KANTINEN!! Du klarede det! Du skynder dig op i køen\n"
                + "lige foran ham den arrogante fra din afdeling. Da du når frem til fadet\n"
                + "er der kun"+ 4 +"fiskefileter tilbage. Du snupper alle "+ 4 +"!", true, 17));
        
        
        game.addSpecialRoom(rooms, specialrooms);
        boolean expected = false;
        boolean actual = specialrooms.contains(rooms.get(1));
        assertEquals(expected, actual);
        
        
    }

//    @Test
//    public void testWalkingDirectionAllowed()
//    {
//        
//    }
    
}
