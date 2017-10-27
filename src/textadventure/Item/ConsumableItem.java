/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure.Item;

import textadventure.Item.Item;
import textadventure.Characters.Player;

/**
 * An item that can be eaten or drank
 * 
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ConsumableItem extends Item {
    
    /**
     * Contructs and item
     * 
     * @param name
     * @param description
     * @param roundsLeftModifier 
     */
    public ConsumableItem(String name, String description, int roundsLeftModifier) {
        super(name, description, roundsLeftModifier);
    }
    
    /**
     * Changes round the for player p!
     * 
     * @param p 
     */
    
    //Shouldn't this be for what/whoever you call this method with, not specifically player p?
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsLeftModifier);
    }
}
