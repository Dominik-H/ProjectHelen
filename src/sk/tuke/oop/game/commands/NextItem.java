/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class NextItem implements Command {

    private BackpackImpl bckp;
    
    public NextItem(BackpackImpl backpack) {
        bckp = backpack;
    }
    
    @Override
    public void execute() {
        Item i = bckp.getLastItem();
        bckp.getStorage().pop();
        bckp.getStorage().addLast(i);
    }
    
}
