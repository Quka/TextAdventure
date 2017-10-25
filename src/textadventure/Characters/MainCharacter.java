package textadventure.Characters;

import textadventure.Room;

interface MainCharacter {

    public Room getCurrentRoom();

    public void walk(String direction);

}
