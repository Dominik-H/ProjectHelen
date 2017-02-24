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
public class TakeItem implements Command {

    private BackpackImpl bckp;
    private Item item;
    
    public TakeItem(BackpackImpl backpack, Item item) {
        bckp = backpack;
        this.item = item;
    }
    
    @Override
    public void execute() {
        bckp.add(item);
        item.getWorld().removeActor(item);
    }
    
}
