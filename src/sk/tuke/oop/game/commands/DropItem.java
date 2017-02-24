/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class DropItem implements Command {

    private BackpackImpl bckp;
    private World world;
    private int x, y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y) {
        bckp = backpack;
        this.world = world;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void execute() {
        Item i = bckp.getLastItem();
        i.setPosition(x, y);
        world.addActor(i);
        bckp.remove(i);
    }    
}
