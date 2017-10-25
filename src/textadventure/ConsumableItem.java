/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ConsumableItem extends Item {
    
    private int roundsLeftModifier;
    
    public ConsumableItem(String name, String description, int roundsLeftModifier) {
        super(name, description);
        this.roundsLeftModifier = roundsLeftModifier;
    }
    
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsLeftModifier);
    }
}
