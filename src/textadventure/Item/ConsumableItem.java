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
    private String descriptionUsed;
    
    /**
     * Contructs and item
     * 
     * @param name
     * @param description
     * @param roundsLeftModifier 
     */
    public ConsumableItem(String name, String description, int roundsLeftModifier, String descriptionUsed) {
        super(name, description, roundsLeftModifier);
        this.descriptionUsed = descriptionUsed;
    }
    
    /**
     * Changes round for player p!
     * 
     * @param p 
     */
    
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsLeftModifier);
    }
    
    public String getDescriptionUsed() {
        return this.descriptionUsed;
    }
}
