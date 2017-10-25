/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

/**
 * @author Arlind U. <arlind.u at cph-au53@cphbusiness.dk>
 */
abstract public class Item {

    protected String name;
    protected String description;
    protected int roundsLeftModifier;
    
    public Item (String name, String description, int roundsLeftModifier) {
        this.name = name;
        this.description = description;
        this.roundsLeftModifier = roundsLeftModifier;
    }

}
