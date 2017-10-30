/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure.Item;

import textadventure.Item.Item;
import textadventure.Characters.Boss;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class UsableItem extends Item {
    
    private Boss usableOn;
    
    /**
     * Contructs an item (that can be used against (specific) monsters)
     * 
     * @param name
     * @param description
     * @param roundsLeftModifier 
     */
    
    public UsableItem(String name, String description, int roundsLeftModifier) {
        super(name, description, roundsLeftModifier);
    }
    
    /**
     * Checks if the item is usable on the specific monster
     * 
     * @return 
     */
    public boolean isUsable() {
        // not done
        return false;
    }
}
