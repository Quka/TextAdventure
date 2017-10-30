/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure.Item;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
abstract public class Item {

    protected String name;
    protected String effect;
    protected int roundsLeftModifier;
    
    /**
     * Abstract contructor of an Item
     * 
     * @param name
     * @param effect
     * @param roundsLeftModifier 
     */
    
    public Item (String name, String effect, int roundsLeftModifier) {
        this.name = name;
        this.effect = effect;
        this.roundsLeftModifier = roundsLeftModifier;
    }
    
    /**
     * Method to see how the specific item modifies rounds left for the player
     * 
     * @return 
     */
    
    //Check if method is used
    
    public int getRoundsModifier(){
        return roundsLeftModifier;
    }

}
