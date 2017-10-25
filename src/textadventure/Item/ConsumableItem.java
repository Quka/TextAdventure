/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textadventure.Item;

import textadventure.Item.Item;
import textadventure.Characters.Player;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
public class ConsumableItem extends Item {
    
    public ConsumableItem(String name, String description, int roundsLeftModifier) {
        super(name, description, roundsLeftModifier);
    }
    
    public void changeRoundsLeft(Player p) {
        p.changeRounds(roundsLeftModifier);
    }
}
