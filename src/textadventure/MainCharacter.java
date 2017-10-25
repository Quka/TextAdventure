package textadventure;

interface MainCharacter {

    public Room getCurrentRoom();

    public void walk(String direction);

    public boolean canWalk(String direction);

}
