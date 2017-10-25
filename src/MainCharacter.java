
import textadventure.Room;



public interface MainCharacter {

    
Room getCurrentRoom();

void walk(String direction);

boolean canWalk(String direction);

}
