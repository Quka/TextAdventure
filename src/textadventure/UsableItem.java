/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class UsableItem extends Item {
    
    private Monster usableOn;
    
    public UsableItem(String name, String description, int roundsLeftModifier) {
        super(name, description, roundsLeftModifier);
    }
    
    public boolean isUsable() {
        // not done
        return false;
    }
}
