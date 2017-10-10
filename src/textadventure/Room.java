package textadventure;

public class Room {

    private int id; //test for os selv indtil videre vi skal nok slette det Arlind <3
    
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    
    private boolean winGame;
    private String description;
    

    public Room(Room north, Room east, Room south, Room west) {
        id = 0; //for loop på room arraylength
        description = "blabla"; //random decription
        winGame = false;
    }
    
    public String description() {

    return "blabla";  //random description
    }
    
    public Room getRoom(String direction){
    return something;
    }
    
    public boolean winGame(){
    return id == 19; //last room in array, kantine
    }
}
    
