package textadventure.Characters;

import textadventure.Room;
/**
 * Interface for player and boss
 * 
 * @author Ionsight
 */
interface MainCharacter {

    public Room getCurrentRoom();

    public void walk(String direction);

}
